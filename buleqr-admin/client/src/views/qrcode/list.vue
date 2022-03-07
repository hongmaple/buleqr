<template>
  <div class="staff">
    <div class="staff-top">
      <!-- <div class="search-box">
          <el-form
            :inline="true"
            ref="search_data"
            :rules="rules"
            :model="search_data"
          >
            <el-form-item label="状态:">
              <el-input type="text" v-model="search_data.title" placeholder="请输入关键词"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="search" @click='onScreeoutMoney()'>筛选</el-button>
            </el-form-item>
          </el-form>
      </div> -->
        <el-form :inline="true">
            <el-form-item class="btnRight">
                 <el-input type="number" v-model="num" placeholder="请输入个数"></el-input>
                <el-button type="primary" size ="small" icon="el-icon-edit-outline" @click='onAddMoney()'>生成并下载二维码</el-button>
            </el-form-item>
        </el-form>
    </div>
      <div class="tables">
           <el-table
            :data="newsList.list"
            border
            style="width: 100%">
            <el-table-column
                label="二维码id"
                align="center"
                width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.id }}</span>
                </template>
            </el-table-column>
            <el-table-column
                label="二维码uuid"
                align="center"
                width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.qrUuid }}</span>
                </template>
            </el-table-column>
            <el-table-column
                label="二维码"
                align="center"
                width="180">
                <template slot-scope="scope">
                    <img alt="二维码" style="width:100px;height=80px;" :src="'api/'+scope.row.qrUrl"/>
                </template>
            </el-table-column>
           <el-table-column
                label="二维码状态"
                align="center"
                width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.qrCodeState=='NOT_BOUND'?'未绑定':'已绑定'}}</span>
                </template>
            </el-table-column>
            <el-table-column
                label="创建时间"
                align="center"
                width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.createTime | moment }}</span>
                </template>
            </el-table-column>
             <el-table-column
                label="最后一次扫码时间"
                align="center"
                width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.lastScanTime | moment }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" fixed="right">
                <template slot-scope="scope">
                    <el-button
                    size="mini"
                    @click="handleEdit(scope.$index, scope.row.qrUuid)">下载</el-button>
                    <!-- <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)">删除</el-button> -->
                </template>
            </el-table-column>
        </el-table>
      </div>
      <newsDialong :dialong="dialong" :form="form" :parameter="parameter" @newsList="loadCurrentPageUserList"></newsDialong>
      <div class="page">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="newsList.pageNum"
          :page-sizes="newsList.page_sizes"
          :page-size="newsList.pageSize"
          :layout="newsList.layout"
          :total="newsList.total">
        </el-pagination>
	 	  </div>
  </div>
</template>

<script>
// @ is an alias to /src
import newsDialong from "../../components/newsDialong";
export default {
  name: "Staff",
  data() {
    return {
      newsList: {
        list: [],
        pageNum: 0,
        pageSize: 3,
        pages: 0,
        total: 0,
        page_sizes:[5,10,15,20], //每页显示多少条
				layout:'total, sizes, prev, pager, next, jumper'
      }, //数据存储
      dialong: {
        //弹出框
        show: false,
        title: "",
        option: "edit"
      },
      dialong2: {
        //弹出框
        show: false,
        title: "",
        option: "edit"
      },
      form: {   //添加和删除需要传递的字段名
        newsId: null,
        newsTitle: null,
        newsContent: null,
        coverImage: null
      },
      num: 1,
      newsId: 0,
      parameter: {
        options: [{
            id: null,
            name: null
        }],
        newsId: 0
      },
      search_data: {
         title: null
      },
      rules:{
         search_data:  [{ required: true, message: "文章标题不能为空", trigger: "blur" }],
      }
    };
  },
  methods: {
    queryNewsList(formData) {
      this.$axios
        .post("/api/QrCode/list",formData,{headers: {"token": localStorage.getItem("eleToken")}})
        .then(res => {
          this.newsList = res.data.data;
        }).catch(err => console.log(err));
    },
    loadCurrentPageUserList() {
	      let pageSize = this.newsList.pageSize;
        let page = this.newsList.pageNum;
				const formData = {
                "isAsc": "asc",
                "orderBy": null,
                "orderByColumn": "updateTime",
                "pageNum": page,
                "pageSize": pageSize,
                "newsTitle": this.search_data.title==''?null:this.search_data.title
        }
        this.queryNewsList(formData);
    },
    handleEdit(index, qrUuid) {
      console.log(qrUuid);
        window.location.href="/api/QrCode/downLoad?qrUuid="+qrUuid+"&Authorization="+localStorage.eleToken;
        // var urls = row.qrUrl.split("/");
        // console.log(urls);
        // window.location.href = "api/common/download?fileName=" + encodeURI(urls[urls.length-1]);
    },
    handleDelete(index, row) {
      //删除数据
      this.$confirm("此操作将永久删除该数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$axios.delete(`/api/news/${row.newsId}`)
          .then(res => {
            this.$message({
              type: "success",
              message: "删除成功!"
            });
            this.loadCurrentPageUserList();
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    onAddMoney() {
       window.location.href="/api/QrCode/createQrCodeFile?num="+this.num+"&delete=true"+"&Authorization="+localStorage.eleToken;
       const formData = {
                "isAsc": "asc",
                "orderBy": null,
                "orderByColumn": "updateTime",
                "pageNum": 0,
                "pageSize": 3,
                "newsTitle": this.search_data.title==''?null:this.search_data.title
        }
        this.queryNewsList(formData);
    },
		handleSizeChange(page_size) {
				this.newsList.pageNum = 0; //第一页
				this.newsList.pageSize = page_size; //每页先显示多少数据
		},
		handleCurrentChange(page){
				// 跳转页数
				//获取每行数
				let pageSize = this.newsList.pageSize;
				const formData = {
                "isAsc": "asc",
                "orderBy": null,
                "orderByColumn": null,
                "pageNum": page,
                "pageSize": pageSize
        }
        this.queryNewsList(formData);
		},
    onScreeoutMoney(){
			// if(this.search_data.title === '') {
			// 	 this.$message({
			// 		message: '关键词不能为空',
			// 		type: 'warning'
			// 	});
			// }
      this.newsList.pageNum = 0;
      const formData = {
                "isAsc": "asc",
                "orderBy": null,
                "orderByColumn": "updateTime",
                "pageNum": 0,
                "pageSize": this.newsList.pageSize,
                "newsTitle": this.search_data.title==''?null:this.search_data.title
      }
      console.log(formData);
      this.queryNewsList(formData);
		}
  },
  created() {
     const formData = {
                "isAsc": "asc",
                "orderBy": null,
                "orderByColumn": "updateTime",
                "pageNum": 0,
                "pageSize": 3,
                "newsTitle": this.search_data.title==''?null:this.search_data.title
    }
    this.queryNewsList(formData);
  },
  components: {
    newsDialong
  }
};
</script>
<style scoped>
.staff {
  margin: 10px;
}
.btnRight {
  float: right;
}
</style>
