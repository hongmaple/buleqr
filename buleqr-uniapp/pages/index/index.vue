<template>
<!--index.wxml-->
<view class="container">
<!--  <view class="bg-sear">
    <view class="scrolltop">
      <view class="section" @tap="toSearchPage">
        <image src="/static/images/icon/search.png" class="search-img"></image>
        <text class="placeholder">搜索</text>
      </view>
    </view>
  </view> -->
    <view class="top-user-info">
		<view style="width: 100%;padding-top: 40rpx;">日历 {{timestr}}</view>
		<view style="width: 50%;float: left;margin-top: 20rpx;">昵称 {{HomeUserInfoVo.username}}</view>
		<view style="width: 50%;float: left;margin-top: 20rpx;">入驻天数 {{HomeUserInfoVo.inNumberOfDays}}</view>
		<view style="width: 50%;float: left;margin-top: 20rpx;">称号 {{HomeUserInfoVo.designation}}</view>
	</view>

	<view class="content">
		<!-- 消息播放 -->
		<view class="message-play" @tap="onNewsPage">
		  <image src="/static/images/icon/horn.png" class="hornpng"></image>
		  <swiper vertical="true" autoplay="true" duration="1000" class="swiper-cont">
		   <block v-for="(item, index) in notice" :key="index">
			  <swiper-item class="items">{{item.noticeTitle}}</swiper-item>
			</block>
		  </swiper>
		  <text class="arrow"></text>
		</view>
	</view>
		
	<view class="updata" v-if="updata">
		<view class="more-prod">
	<!-- 	<view class="title"></view> -->
		<view class="prod-show">
			<block v-for="(prod, index2) in newsList" :key="index2">
							<view class="show-item" @tap="toProdPage" :data-newsid="prod.newsId">
							  <view class="more-prod-pic">
								<image :src="serverUrl+prod.coverImage" class="more-pic"></image>
							  </view>
							  <view class="prod-text-right">
								<view class="prod-text more">{{prod.newsTitle}}</view>
								<view class="prod-info">{{prod.description}}</view>
								<view class="b-cart">
								  <view class="price">
									<text class="symbol">{{time.dateFormat(prod.createTime,'yyyy-MM-dd hh:mm:ss')}}</text>
								  </view>
								</view>
							  </view>
							</view>
			</block>
		</view>
		</view>
	</view>		
</view>
</template>

<script module="time" lang="wxs" src="../../wxs/timeUtil.wxs"></script>
<script module="wxs" lang="wxs" src="../../wxs/number.wxs"></script>

<script>
//index.js
//获取应用实例
var http = require("../../utils/http.js");
var config = require("../../utils/config.js");
const app = getApp();

export default {
  data() {
    return {
      indicatorDots: true,
      indicatorColor: '#d1e5fb',
      indicatorActiveColor: '#1b7dec',
      autoplay: true,
      interval: 2000,
      duration: 1000,
      seq: 0,
      notice: [],
      newsList: [],
	  newsPage: {
		  pageNum: 1,
		  pageSize: 5,
		  pages: 0,
		  total: 0,
	  },
      sts: 0,
      scrollTop: "",
	  current: 0,
	  updata: true,
	  serverUrl: config.domain,
	  timestr: '',
	  HomeUserInfoVo: {}
    };
  },

  components: {},
  props: {},
  onLoad: function () {
	this.setTimer();
    this.getAllData();
  },
  onShow: function () {
		//#ifdef MP-WEIXIN
    // uni.getSetting({
    //   success(res) {
    //     if (!res.authSetting['scope.userInfo']) {
    //       uni.navigateTo({
    //         url: '/pages/login/login'
    //       });
    //     }
    //   }
    // });
		//#endif
		if (!uni.getStorageSync('token')||typeof(uni.getStorageSync('token')) == "undefined") {
			uni.redirectTo({
				url: '../accountLogin/accountLogin'
			}); //跳转到登录页
		}
  },
  onPullDownRefresh: function () {
    // wx.showNavigationBarLoading() //在标题栏中显示加载
    //模拟加载
    var ths = this;
    setTimeout(function () {
      ths.getAllData(); // wx.hideNavigationBarLoading() //完成停止加载

      uni.stopPullDownRefresh(); //停止下拉刷新
    }, 100);
  },
  onReachBottom: function(){
  			console.log('触底了')
			 var self = this;
			 var newsPage = self.newsPage;
			var pageNum = newsPage.pageNum;
			console.log(newsPage);
			if(newsPage.pages>pageNum) {
			          pageNum = pageNum+1;
					  newsPage.pageNum = pageNum;
					  self.setData({
						  newsPage: newsPage
					  });
			          self.getHotNewsList(newsPage);
			}
			return;
  },
  methods: {
    //事件处理函数
    bindViewTap: function () {
      uni.navigateTo({
        url: '../logs/logs'
      });
    },
    // 页面滚动到指定位置指定元素固定在顶部
    onPageScroll: function (e) {
      //监听页面滚动
      this.setData({
        scrollTop: e.scrollTop
      });
    },
    //跳转文章详情页
    toProdPage: function (e) {
		console.log(e.currentTarget)
      var newsid = e.currentTarget.dataset.newsid;
      uni.navigateTo({
        url: '/pages/news-detail/news-detail?newsId=' + newsid
      });
    },
    // 跳转搜索页
    toSearchPage: function () {
      uni.navigateTo({
        url: '/pages/search-page/search-page'
      });
    },
    //跳转公告列表页面
    onNewsPage: function () {
      uni.navigateTo({
        url: '/pages/recent-news/recent-news'
      });
    },

    getAllData() {
      this.getNoticeList();
	  var newsPage = this.newsPage;
	  this.getHotNewsList(newsPage);
	  this.getHomeUserInfoVo();
    },
	//加载公告
    getNoticeList() {
      var params = {
        url: "/notice/list",
        method: "get",
		needToken: true,
        data: {},
        callBack: res => {
          this.setData({
            notice: res.data
          });
        }
      };
      http.request(params);
    },
	getHomeUserInfoVo() {
	  var params = {
	    url: "/user/HomeUserInfoVo",
	    method: "get",
		needToken: true,
	    data: {},
	    callBack: res => {
	      this.setData({
	        HomeUserInfoVo: res.data
	      });
	    }
	  };
	  http.request(params);
	},
    getHotNewsList(newsPage) {
      var param = {
        url: "/news/list",
        method: "post",
		needToken: true,
        data: {
			pageNum: newsPage.pageNum,
            pageSize: newsPage.pageSize
        },
        callBack: res => {
		  this.updata = false
		  this.updata = true
          var newsList = this.newsList;
		  newsPage = {
			  pageNum: res.data.pageNum,
			  pageSize: res.data.pageSize,
			  pages: res.data.pages,
			  total: res.data.total
		  }
           if(newsPage.pageNum==1) {
                        this.setData({
                          newsList: res.data.list,
						  newsPage: newsPage
                        });
           }else {
                        var nowList =  res.data.list;
						var oldNewsList = newsList;
                        nowList = oldNewsList.concat(nowList);
						console.log(nowList);
                        this.setData({
							newsList: nowList,
						    newsPage: newsPage
                        });
          }		 
        }
      };
      http.request(param);
    },
	setTimer() {
		let holdTime = 60; //定义变量并赋值
		this.getCodeText = "重新获取(60)"
		//setInterval（）是一个实现定时调用的函数，可按照指定的周期（以毫秒计）来调用函数或计算表达式。
		//setInterval方法会不停地调用函数，直到 clearInterval被调用或窗口被关闭。
		this.Timer = setInterval(() => {
			this.displayTime();
		}, 1000)
	},
	displayTime: function() {
			//获取div元素
			var timeDiv=document.getElementById("timeDiv");
			//获取系统当前的年、月、日、小时、分钟、毫秒
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDate();
			var hour = date.getHours();
			var minutes = date.getMinutes();
			var second = date.getSeconds();
			// var timestr = year + "年" + month + "月" + day + "日  " + check(hour)
			// 		+ ":" + check(minutes) + ":" + check(second);
			var timestr = "M1 " + month + "." + day + "  " + this.check(hour)
					+ ":" + this.check(minutes) + ":" + this.check(second);
			//将系统时间设置到div元素中
			this.setData({
				timestr: timestr
			})
	},
	check: function(val) {
			if (val < 10) {
				return ("0" + val);
			} 
			else {
				return (val);
			}
		}
  }
};
</script>
<style>
@import "./index.css";
</style>