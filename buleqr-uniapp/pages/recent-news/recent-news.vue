<template>
<!--pages/recent-news/recent-news.wxml-->
<view class="container">
	<view class="top_title-content">
	    <view  @tap="topage">
	        <image src="../../static/images/icon/fanhui.png" class="top_topage">
	    </view>
	    <view class="top_title">
	        <view class="top_line-fix">
	            <text>公告</text>
	        </view>
	    </view>
	</view>
  <view class="recent-news">
  <block v-for="(item, index) in notice" :key="index">
    <view class="news-item" @tap="toNewsDetail" :data-id="item.noticeId">
      <view class="news-item-title">{{item.noticeTitle}}</view>
      <view class="news-item-date">
        {{time.dateFormat(item.createTime,'yyyy-MM-dd hh:mm:ss')}}
      </view>
    </view>
   </block>
  </view>
</view>
</template>
<script module="time" lang="wxs" src="../../wxs/timeUtil.wxs"></script>
<script>
// pages/recent-news/recent-news.js
var http = require("../../utils/http.js");
var config = require("../../utils/config.js");

export default {
  data() {
    return {
      notice: []
    };
  },

  components: {},
  props: {},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {},

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {},

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var ths = this; //加载公告
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
    // 跳转公告详情页
    toNewsDetail: function (e) {
      var id = e.currentTarget.dataset.id; // console.log(id)
	  console.log(id);
	  uni.navigateTo({
	    url: '/pages/recent-detail/recent-detail?id=' + id
	  });
    },
	topage: function (){
	    uni.navigateBack({
	        delta: 1
	    });
	},
  }
};
</script>
<style>
@import "./recent-news.css";
</style>