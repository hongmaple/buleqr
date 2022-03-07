<template>
	<view>
<!-- 		<view class="logo">
			<view class="img">
				<image mode="widthFix"
					src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2Fd0%2Fa5%2F86%2Fd0a586e0cece1f1dec648e9aa3d8c9d6.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633761077&t=84f5ce7dc4918ef2e89d1fa4e1e72504">
				</image>
			</view>
		</view> -->
		<view class="form userform">
			<view class="username">
				{{content}}
			</view>
<!-- 			<view v-if="processState==2" class="btn" @tap="toLogin">去登录</view>
			<view class="res">
				
			</view> -->
			<view v-if="processState==1" class="btn" @tap="toRegister">去注册</view>
			<!-- <view class="res">
				<view @tap="toRegister">还没有账号立即注册</view>
			</view> -->
		</view>
 
	</view>
</template>
 
<script>
	var http = require("../../utils/http");
	var util = require('../../utils/util.js');
	export default {
		data() {
			return {
				content: "欢迎光临",
				QrCodeUserFile: {},
				qrUuid: "",
				processState: 1
			}
		},
		onLoad(options) {
			if (!options.qrUuid||typeof(options.qrUuid) == "undefined") {
				uni.showToast({
					title: "二维码错误",
					icon: "none"
				}); //弹出提示框
			}
			 this.setData({
				 qrUuid: options.qrUuid
			 })
			 this.getCode();
		},
		methods: {
			Timer() {},
			getCode() {
				uni.hideKeyboard() //隐藏已经显示的软键盘，如果软键盘没有显示则不做任何操作。
				var ths = this;
				//示例用定时器模拟请求效果
				//setTimeout(()用于在指定的毫秒数后调用函数或计算表达式
				var params = {
					url: "/QrCode/"+ths.qrUuid,
					method: "post",
					// contentType: 'application/x-www-form-urlencoded',
					callBack: res => {
						if(res.status==200) {
							// uni.showToast({
							// 	title: '验证码已发送',
							// 	icon: "none"
							// }); //弹出提示框
							var content = "欢迎光临"
							var processState=1
							if(res.data.qrCodeState=="NOT_BOUND") {
								content="该二维码还未绑定，可申请注册绑定"
								processState=1
							}else {
								content="已绑定，不能注册"
								processState=2
							}
							ths.setData({
								QrCodeUserFile: res.data,
								content: content,
								processState: processState
							});
						}else {
							ths.setData({
								content: res.message,
								processState: 0
							});
							uni.showToast({
								title: res.message,
								icon: "none"
							}); //弹出提示框
						}
					},
					errCallBack: err => {
						uni.showToast({
							title: err.message,
							icon: "none"
						}); //弹出提示框
					}
				}
				http.request(params)
			},
			//setTimer： 需要每隔一段时间执行一件事的的时候就需要使用SetTimer函数
			setTimer() {
				let holdTime = 60; //定义变量并赋值
				this.getCodeText = "重新获取(60)"
				//setInterval（）是一个实现定时调用的函数，可按照指定的周期（以毫秒计）来调用函数或计算表达式。
				//setInterval方法会不停地调用函数，直到 clearInterval被调用或窗口被关闭。
				this.Timer = setInterval(() => {
					if (holdTime <= 0) {
						this.getCodeisWaiting = false;
						this.getCodeBtnColor = "#ffffff";
						this.getCodeText = "获取验证码"
						clearInterval(this.Timer); //清除该函数
						return; //返回前面
					}
					this.getCodeText = "重新获取(" + holdTime + ")"
					holdTime--;
				}, 1000)
			},
			toRegister() {
				uni.hideKeyboard() //隐藏已经显示的软键盘，如果软键盘没有显示则不做任何操作。
				uni.redirectTo({
					url: '../register/register?qrUuid='+this.qrUuid
				}); //跳转到注册页
				//uni.navigateBack(); //关闭当前页面，返回上一页面
				return false;
			},
			toLogin() {
				uni.hideKeyboard() //隐藏已经显示的软键盘，如果软键盘没有显示则不做任何操作。
				uni.redirectTo({
					url: '../accountLogin/accountLogin'
				}); //跳转到登录页
			}
		}
	}
</script>
 
<style lang="scss">
	
 
	page {
		background: #3F536E; //整一个页面的背景颜色
		// linear-gradient(to bottom, #f06c7a 0%, #f06c7a 100%);
		height: 100%;
	}
 
	.icon {
		color: #ffffff;
	}
 
	.logo {
		width: 100%;
		height: 45vw;
		display: flex;
		justify-content: center;
		align-items: center;
 
		.img {
			width: 25%;
			height: 25vw;
 
			image {
				width: 100%;
				border-radius: 100%;
			}
		}
	}
 
	.form {
		width: 86%;
		padding: 0 7%;
		font-size: 30upx;
        margin-top: 300rpx;
		.username,
		.password,
		.code {
			width: calc(100% - 90upx);
			height: 290upx;
			display: flex;
			align-items: center;
			border-radius: 45upx;
			background-color: rgba($color: #ffffff, $alpha: 0.1);
			padding: 0 45upx;
			margin-bottom: 26upx;
 
			input {
				width: 100%;
				height: 50upx;
				color: rgba($color: #ffffff, $alpha: 0.8);
				font-weight: 200;
			}
		}
 
		.btn {
			color: #f06c7a;
			width: 100%;
			height: 90upx;
			display: flex;
			justify-content: center;
			align-items: center;
			border-radius: 45upx;
			background-color: #fff;
			font-size: 40upx;
		}
	}
 
	.userform {
		.username {
			position: relative;
            text-align: center;
			align-items: center;
			justify-content: center;
			.get-code {
				position: absolute;
				height: 90upx;
				display: flex;
				align-items: center;
				justify-content: center;
				right: 0;
				padding: 0 40upx;
				z-index: 3;
 
				&:after { //点击以后，左边出现白色的线
					content: " ";
					width: 1upx; //宽度为1upx
					height: 50upx; //高度为50upx
					background-color: #fff;  //背景颜色为白色
					position: absolute;
					z-index: 3;
					margin-right: 100%;
					left: 0;
					top: 20upx;
				}
			}
		}
 
		.res {
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100upx;
			color: rgba($color: #ffffff, $alpha: 0.8);
		}
	}
	@import "./guide.css";
</style>