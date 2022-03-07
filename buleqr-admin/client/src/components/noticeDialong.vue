<template>
  <div class="nofind">
    <el-dialog
      :title="dialong.title"
      type="primary"
      size="small"
      :close-on-press-escape="false"
      :modal-append-to-body="false"
      :close-on-click-modal="false"
      :visible.sync="dialong.show"
    >
      <el-form :model="form" ref="formdoalog" :rules="formdialog" label-width="80px">
        <el-form-item label="公告标题" prop="noticeTitle">
          <el-input v-model="form.noticeTitle"></el-input>
        </el-form-item>
        <el-form-item label="公告内容" prop="noticeContent">
          <quill-editor ref="myTextEditor" v-model="form.noticeContent" :options="editorOption"></quill-editor>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialong.show = false">取 消</el-button>
        <el-button type="primary" @click="addHandle('formdoalog')">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
	import { quillEditor } from 'vue-quill-editor'
	import 'quill/dist/quill.core.css'
    import 'quill/dist/quill.snow.css'
    import 'quill/dist/quill.bubble.css'
// @ is an alias to /src
export default {
  name: "noticeDialong",
  data() {
    return {
      formdialog: {
        noticeTitle:  [{ required: true, message: "公告标题不能为空", trigger: "blur" }],
        noticeContent: [{ required: true, message: "公告内容不能为空", trigger: "blur" }]
      },
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
	  editorOption: {
		placeholder: '请编辑相关内容'
	  }
    };
  },
  props: {
    dialong: Object,
    form: {
         noticeId: null,
         noticeTitle: null,
         noticeContent: null
    },
    parameter: {
        options: [{
            id: null,
            name: null
        }],
        noticeId: 0
    },
  },
  components: {
	quillEditor
  },
  methods: {
     onEditorReady(editor) { // 准备编辑器
 
     },
    onEditorBlur(){}, // 失去焦点事件
    onEditorFocus(){}, // 获得焦点事件  
    onEditorChange({
				editor,
				html,
				text
	}) {
				 this.form.newsContent = text;
	},
    addHandle(formdoalog) {
      this.$refs[formdoalog].validate(valid => {
        if (valid) {
          if(this.dialong.option == "add") {
            this.$axios.post("/api/notice", this.form).then(res => {
                this.$message({
                  type: "success",
                  message: "数据添加成功"
                });
                (this.dialong.show = false);
                this.$emit("newsList");
                //清空内容
                this.form = "";
            });
          }else {
            const formData = this.form;
            formData.noticeId = this.parameter.noticeId;
            this.$axios.put("/api/notice", formData,{headers: {"token": localStorage.getItem("eleToken")}}).then(res => {
                this.$message({
                  type: "success",
                  message: "数据修改成功"
                });
                (this.dialong.show = false);
                this.$emit("newsList");
                //清空内容
                this.form = "";
            });
          }
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    handleAvatarSuccess(res, file) {
            //URL.createObjectURL(file.raw);
            this.form.coverImage = res.fileName;
    },
    beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg' || file.type === 'image/jpg' || file.type === 'image/png' ||  file.type === 'image/svg';
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!isJPG) {
            this.$message.error('上传头像图片只能是 jpeg，JPG，png，svg格式!');
            }
            if (!isLt2M) {
            this.$message.error('上传图片大小不能超过 2MB!');
            }
            return isJPG && isLt2M;
    },
    handleAvatarSuccessList(res,file) {
        this.dialogImageUrl = res.fileName;
        let urlArr = this.parameter.dialogImageUrls;
        urlArr.push({name: urlArr.length+1,url: "api"+res.fileName});
        this.parameter.dialogImageUrls=urlArr;
        console.log(this.parameter.dialogImageUrls)
    },
    handleRemove(file) {
      console.log(file.url);
      let urlArr = this.parameter.dialogImageUrls;
      urlArr.forEach((item,index,arr) => {
        if(item.url === file.url){
            arr.splice(index,1)
        }
      });
      this.parameter.dialogImageUrls = urlArr;
      console.log(this.parameter.dialogImageUrls)
    },
    handlePictureCardPreview(file) {
        console.log(file.url);
        this.dialogVisible = true;
    },
    handleDownload(file) {
        console.log(file);
    },
    created() {
       
    }
  }
};
</script>
<style scoped>
	.cantainer {
		padding: 30px;
		background: #ffffff;
		border-radius: 5px;
		margin-top: 20px;
	}

	.quill-editor {
		height: 500px;
	}

	.editor-btn {
		margin-top: 50px;
	}

    .dialog-footer {
        margin-top: 50px;
    }

    .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
