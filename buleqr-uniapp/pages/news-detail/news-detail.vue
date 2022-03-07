<template>
<!--pages/news-detail/news-detail.wxml-->
<view class="container">
	<view class="top_title-content">
	    <view  @tap="topage">
	        <image src="../../static/images/icon/fanhui.png" class="top_topage">
	    </view>
	    <view class="top_title">
	        <view class="top_line-fix">
	            <text>文章详情</text>
	        </view>
	    </view>
	</view>
<!-- <block wx:for='{{news}}' wx:key=''> -->
  <view class="news-detail" v-if="ifOk">
    <view class="news-detail-title">{{news.newsTitle}}</view>
	<view class="pushTime">
		<text class="symbol">发布时间 {{time.dateFormat(news.createTime,'yyyy-MM-dd hh:mm:ss')}}</text>
    </view>
	<!-- <view class='news-detail-text'>{{news.content}}</view> -->
<!--   <rich-text :nodes="news.newsContent"></rich-text> -->
   <u-parse :content="news.newsContent" @preview="preview" @navigate="navigate" ></u-parse>
  </view>
  <view v-else>文章不存在或网络错误</view>
   <!-- </block> -->
</view>
</template>
<script module="time" lang="wxs" src="../../wxs/timeUtil.wxs"></script>
<script>
import uParse from '@/components/u-parse/u-parse.vue'
// pages/news-detail/news-detail.js
var http = require("../../utils/http.js");
var config = require("../../utils/config.js");

export default {
  data() {
    return {
      news: {
        newsTitle: '',
        newsContent: '',
        newsId: null
      },
	  ifOk:false
    };
  },
  components: {
	  uParse
  },
  props: {},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var ths = this;
    //加载公告详情
    var params = {
      // `/shop/notice/info/${options.id}`
      url: '/news/' + options.newsId,
      method: "GET",
	  needToken: true,
      // data: {
      //   id: id,
      // },
      // callBack: function(news){
      callBack: res => {
		  if(res.status==200) {
			  var news = res.data;
			  // news.newsContent = ths.formatRichText(news.newsContent);
			  ths.setData({
			    news: news,
				ifOk: true
			  });
		  }else {
			  ths.setData({
			  	ifOk: false
			  });
		  }
		
      }
    };
    http.request(params);
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {},

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {},

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {},

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {},

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {},

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {},

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {},
  methods: {
	  formatRichText: function(html){
	      let newContent= html.replace(/<img[^>]*>/gi,function(match,capture){
	        match = match.replace(/style="[^"]+"/gi, '').replace(/style='[^']+'/gi, '');
	        match = match.replace(/width="[^"]+"/gi, '').replace(/width='[^']+'/gi, '');
	        match = match.replace(/height="[^"]+"/gi, '').replace(/height='[^']+'/gi, '');
	        return match;
	    });
	    newContent = newContent.replace(/style="[^"]+"/gi,function(match,capture){
	      match = match.replace(/width:[^;]+;/gi, 'max-width:100%;').replace(/width:[^;]+;/gi, 'max-width:100%;');
	      return match;
	    });
	    newContent = newContent.replace(/<br[^>]*\/>/gi, '');
	    newContent = newContent.replace(/\<img/gi, '<img style="max-width:100%;"');  
	    return newContent;
	  },
	  topage: function (){
	      uni.navigateBack({
	          delta: 1
	      });
	  },
	  navigate(href, e) {  
	      //比如点击a标签，打开某个webview并传输url  
	       uni.navigateTo({  
	          url: '/pages/webviewPage/webviewPage?url=' + href  
	       })  
	  },
	  preview(src, e) {
	        // do something
	  },
  }
};
</script>
<style>
@import "./news-detail.css";
@import url("@/components/u-parse/u-parse.css");
</style>