(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-index-index"],{"108d":function(t,e,i){"use strict";(function(t,i){e["a"]=function(e){(e.options.wxs||(e.options.wxs={}))["time"]=function(e){var o=t("(y+)","i"),a=function(e,a){a||(a="yyyy-MM-dd hh:mm:ss"),e=parseInt(e);var r=i(e);function n(t){return t<10?"0"+t:t}var s=[["M+",n(r.getMonth()+1)],["d+",n(r.getDate())],["h+",n(r.getHours())],["m+",n(r.getMinutes())],["s+",n(r.getSeconds())],["q+",Math.floor((r.getMonth()+3)/3)],["S+",r.getMilliseconds()]],d=o.exec(a);d&&(a=a.replace(d[1],(r.getFullYear()+"").substring(4-d[1].length)));for(var c=0;c<s.length;c++){var l=s[c][0],p=s[c][1],f=t("("+l+")").exec(a);f&&(a=a.replace(f[1],1==f[1].length?p:("00"+p).substring((""+p).length)))}return a},r=function(t,e=0,i=10){if(0!=t.length&&void 0!=t)return t.length>i?t.substring(e,i)+"...":t},n=function(t){return JSON.parse(t)};return e.exports={dateFormat:a,sub:r,toParse:n},e.exports}({exports:{}})}}).call(this,i("5fff")["getRegExp"],i("5fff")["getDate"])},"4b31":function(t,e,i){var o=i("8292");"string"===typeof o&&(o=[[t.i,o,""]]),o.locals&&(t.exports=o.locals);var a=i("4f06").default;a("6df136fd",o,!0,{sourceMap:!1,shadowMode:!1})},"50bb":function(t,e,i){"use strict";var o;i.d(e,"b",(function(){return a})),i.d(e,"c",(function(){return r})),i.d(e,"a",(function(){return o}));var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"container"},[i("v-uni-view",{staticClass:"bg-sear"},[i("v-uni-view",{staticClass:"scrolltop"},[i("v-uni-view",{staticClass:"section",on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.toSearchPage.apply(void 0,arguments)}}},[i("v-uni-image",{staticClass:"search-img",attrs:{src:"/static/images/icon/search.png"}}),i("v-uni-text",{staticClass:"placeholder"},[t._v("搜索")])],1)],1)],1),i("v-uni-view",{staticClass:"content"},[i("v-uni-view",{staticClass:"message-play",on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onNewsPage.apply(void 0,arguments)}}},[i("v-uni-image",{staticClass:"hornpng",attrs:{src:"/static/images/icon/horn.png"}}),i("v-uni-swiper",{staticClass:"swiper-cont",attrs:{vertical:"true",autoplay:"true",duration:"1000"}},[i("v-uni-swiper-item",{staticClass:"items"},[i("a",{staticStyle:{"text-decoration":"none",color:"#000000"},attrs:{href:""}},[t._v("送花的常识和技巧")])]),i("v-uni-swiper-item",{staticClass:"items"},[i("a",{staticStyle:{"text-decoration":"none",color:"#000000"},attrs:{href:""}},[t._v("测试测试")])]),i("v-uni-swiper-item",{staticClass:"items"},[i("a",{staticStyle:{"text-decoration":"none",color:"#000000"},attrs:{href:""}},[t._v("版本升级")])])],1),i("v-uni-text",{staticClass:"arrow"})],1),i("v-uni-view",{staticClass:"more-prod"},[i("v-uni-view",{staticClass:"prod-show"},[t._l(t.newsListData.list,(function(e,o){return[i("v-uni-view",{key:o+"_0",staticClass:"show-item",attrs:{"data-newsid":e.newsId},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.toProdPage.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"more-prod-pic"},[i("v-uni-image",{staticClass:"more-pic",attrs:{src:t.serverUrl+e.coverImage}})],1),i("v-uni-view",{staticClass:"prod-text-right"},[i("v-uni-view",{staticClass:"prod-text more"},[t._v(t._s(e.newsTitle))]),i("v-uni-view",{staticClass:"prod-info"},[t._v(t._s(e.description))]),i("v-uni-view",{staticClass:"b-cart"},[i("v-uni-view",{staticClass:"price"},[i("v-uni-text",{staticClass:"symbol"},[t._v(t._s(t.time.dateFormat(e.createTime,"yyyy-MM-dd hh:mm:ss")))])],1)],1)],1)],1)]}))],2)],1)],1)],1)},r=[]},"5fff":function(t,e,i){"use strict";function o(){var t=Array.prototype.slice.call(arguments);return t.unshift(RegExp),new(Function.prototype.bind.apply(RegExp,t))}function a(){var t=Array.prototype.slice.call(arguments);return t.unshift(Date),new(Function.prototype.bind.apply(Date,t))}i("fb6a"),i("4d63"),i("ac1f"),i("25f0"),Object.defineProperty(e,"__esModule",{value:!0}),e.getDate=a,e.getRegExp=o},8292:function(t,e,i){var o=i("24fb");e=o(!1),e.push([t.i,'/**index.wxss**/uni-page-body[data-v-2e4fe36c]{background:#f7f7f7;height:auto}\r\n\r\n/* 轮播图及搜索框 */uni-swiper[data-v-2e4fe36c]{width:100%;height:%?350?%;overflow:hidden}uni-swiper.pic-swiper[data-v-2e4fe36c]{margin-top:%?75?%;padding:%?10?% 0;background:#fff;height:%?422?%}uni-swiper-item[data-v-2e4fe36c]{font-size:%?26?%;font-weight:700}uni-swiper.pic-swiper .img-box[data-v-2e4fe36c]{font-size:0}.wx-swiper-dots[data-v-2e4fe36c]{margin-bottom:%?15?%}.banner-item[data-v-2e4fe36c]{box-sizing:border-box}uni-swiper.pic-swiper .banner[data-v-2e4fe36c]{position:absolute;width:%?690?%;margin:0 %?10?%;height:%?402?%;border-radius:%?8?%;display:inline-block;box-shadow:0 4px 10px 0 rgba(83,83,83,.288)}.container .bg-sear[data-v-2e4fe36c]{position:fixed;z-index:999;width:100%;line-height:%?56?%;background:#fff;padding:%?20?% 0;text-align:center;top:0}.bg-sear .section[data-v-2e4fe36c]{display:flex;justify-content:center;align-items:center;height:%?60?%;background:#fff;z-index:1;border-radius:%?50?%;width:75%;margin:auto;left:4%;background:#f7f7f7}.bg-sear .section .placeholder[data-v-2e4fe36c]{display:block;font-size:%?24?%;color:#999}.bg-sear .section .search-img[data-v-2e4fe36c]{width:%?32?%;height:%?32?%;margin-right:%?10?%}\r\n\r\n/* 分类栏目 */.content[data-v-2e4fe36c]{background:#fff}.cat-item[data-v-2e4fe36c]{display:flex;justify-content:space-between;background:#fff;padding-top:%?20?%;padding-bottom:%?30?%}.cat-item .item[data-v-2e4fe36c]{text-align:center;width:25%;display:flex;flex-direction:column;margin:auto;align-items:center}.cat-item .item uni-image[data-v-2e4fe36c]{width:%?75?%;height:%?75?%}.cat-item .item uni-text[data-v-2e4fe36c]{font-size:%?26?%;margin-top:%?20?%}\r\n\r\n/* 消息播放 */.message-play[data-v-2e4fe36c]{position:relative;height:%?90?%;background:#fff;margin:auto;padding:0 %?60?% 0 %?100?%;box-sizing:border-box;box-shadow:0 %?16?% %?32?% 0 rgba(7,17,27,.05);border:%?2?% solid #fafafa}.message-play .hornpng[data-v-2e4fe36c]{width:%?77?%;height:%?36?%;position:absolute;left:%?20?%;top:%?27?%;margin-right:%?8?%}.message-play .swiper-cont[data-v-2e4fe36c]{height:%?90?%;line-height:%?90?%}.message-play .swiper-cont .items[data-v-2e4fe36c]{text-overflow:ellipsis;display:-webkit-box;-webkit-line-clamp:1;-webkit-box-orient:vertical;text-align:left}.arrow[data-v-2e4fe36c]{width:%?15?%;height:%?15?%;border-top:%?3?% solid #686868;border-right:%?3?% solid #686868;-webkit-transform:rotate(45deg);transform:rotate(45deg);position:absolute;right:%?30?%;top:%?34?%}\r\n\r\n/* 每日上新 */.title[data-v-2e4fe36c]{position:relative;height:%?64?%;line-height:%?64?%;font-size:%?32?%;padding:%?40?% 0 %?10?% %?30?%;color:#333;background:#fff}.up-to-date .title[data-v-2e4fe36c]{color:#fff;background:none}.title .more-prod-cont[data-v-2e4fe36c]{color:#999;display:inline-block;text-align:right}.up-to-date .title .more-prod-cont .more[data-v-2e4fe36c]{position:absolute;right:%?30?%;top:%?48?%;color:#fff;font-size:%?24?%;background:#65addf;border-radius:%?30?%;padding:0 %?30?%;height:%?44?%;line-height:%?44?%}.title .more-prod-cont .more[data-v-2e4fe36c]{position:absolute;right:%?30?%;top:%?48?%;color:#666;font-size:%?24?%;padding:0 %?20?%;height:%?44?%;line-height:%?44?%}.title .more-prod-cont .arrow[data-v-2e4fe36c]{top:%?58?%;right:%?30?%;border-top:%?2?% solid #666;border-right:%?2?% solid #666}.up-to-date[data-v-2e4fe36c]{background-image:url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAUAAAABxCAYAAACkwXoWAAABS2lUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4KPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxMzggNzkuMTU5ODI0LCAyMDE2LzA5LzE0LTAxOjA5OjAxICAgICAgICAiPgogPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4KICA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIi8+CiA8L3JkZjpSREY+CjwveDp4bXBtZXRhPgo8P3hwYWNrZXQgZW5kPSJyIj8+IEmuOgAAAZBJREFUeJzt1DEBwCAAwLAxYfhEGXJABkcTBb065trnAwj6XwcAvGKAQJYBAlkGCGQZIJBlgECWAQJZBghkGSCQZYBAlgECWQYIZBkgkGWAQJYBAlkGCGQZIJBlgECWAQJZBghkGSCQZYBAlgECWQYIZBkgkGWAQJYBAlkGCGQZIJBlgECWAQJZBghkGSCQZYBAlgECWQYIZBkgkGWAQJYBAlkGCGQZIJBlgECWAQJZBghkGSCQZYBAlgECWQYIZBkgkGWAQJYBAlkGCGQZIJBlgECWAQJZBghkGSCQZYBAlgECWQYIZBkgkGWAQJYBAlkGCGQZIJBlgECWAQJZBghkGSCQZYBAlgECWQYIZBkgkGWAQJYBAlkGCGQZIJBlgECWAQJZBghkGSCQZYBAlgECWQYIZBkgkGWAQJYBAlkGCGQZIJBlgECWAQJZBghkGSCQZYBAlgECWQYIZBkgkGWAQJYBAlkGCGQZIJBlgECWAQJZBghkGSCQZYBAlgECWQYIZBkgkGWAQJYBAlkGCGRdKykDj9OUNYkAAAAASUVORK5CYII=");background-position:top;background-size:100% %?332?%;background-repeat:no-repeat;background-color:#fff}.up-to-date .item-cont[data-v-2e4fe36c]{margin:auto;height:auto;width:calc(100% - %?40?%);padding:0 %?20?%;display:flex;flex-wrap:wrap;justify-content:space-around\r\n  /* padding: 10rpx 0 0 0; */}.hotsale-item-cont[data-v-2e4fe36c]{padding-bottom:%?20?%;background:#fff}.up-to-date .item-cont[data-v-2e4fe36c]::before{clear:both;height:0;overflow:hidden}.up-to-date .item-cont .prod-item[data-v-2e4fe36c]{border-radius:%?10?%;width:%?220?%;background:#fff;display:inline-block;margin-bottom:%?20?%;box-shadow:%?0?% %?6?% %?8?% rgba(58,134,185,.2)}.up-to-date .item-cont .prod-item .imagecont[data-v-2e4fe36c]{width:100%;font-size:0}.up-to-date .item-cont .prod-item .imagecont .prodimg[data-v-2e4fe36c]{width:%?220?%;height:%?220?%;vertical-align:middle;border-top-left-radius:%?10?%;border-top-right-radius:%?10?%;font-size:0}.up-to-date .item-cont .prod-item .prod-text[data-v-2e4fe36c]{font-size:%?28?%;overflow:hidden;margin:%?10?% 0;height:%?75?%;display:-webkit-box;word-break:break-all;display:-webkit-box;-webkit-line-clamp:2;-webkit-box-orient:vertical;color:#000;padding:0 %?10?%}.up-to-date .item-cont .prod-item .prod-price[data-v-2e4fe36c]{font-size:%?25?%;color:#eb2444;font-family:Arial;padding:0 %?10?%}.more.prod-price[data-v-2e4fe36c]{position:absolute;bottom:%?20?%}\r\n\r\n/* 商城热卖 */.hot-sale[data-v-2e4fe36c]{\r\n  /* margin: 15rpx 0; */}.hot-sale .prod-items[data-v-2e4fe36c]{width:%?345?%;display:inline-block;background:#fff;padding-bottom:%?20?%;box-sizing:border-box;\r\n  /* border: 2rpx solid #e1e1e1; */box-shadow:%?0?% %?6?% %?8?% rgba(58,134,185,.2)}.hot-sale .prod-items[data-v-2e4fe36c]:nth-child(2n-1){margin:%?20?% %?10?% %?10?% %?20?%}.hot-sale .prod-items[data-v-2e4fe36c]:nth-child(2n){margin:%?20?% %?20?% %?10?% %?10?%}.prod-items .hot-imagecont .hotsaleimg[data-v-2e4fe36c]{width:%?341?%;height:%?341?%}.prod-items .hot-text .hotprod-text[data-v-2e4fe36c]{\r\n  /* margin-left:10px; */font-size:%?28?%;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.prod-items .hot-imagecont[data-v-2e4fe36c]{font-size:0;text-align:center}.prod-items .hot-text[data-v-2e4fe36c]{margin-top:%?20?%;padding:0 %?10?%}.prod-items .hot-text .prod-info[data-v-2e4fe36c], .more-prod .prod-text-right .prod-info[data-v-2e4fe36c]{font-size:%?22?%;color:#999;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;margin-top:%?10?%}.prod-items .hot-text .prod-text-info[data-v-2e4fe36c]{position:relative;height:%?70?%;line-height:%?70?%;font-family:Arial}.prod-items .hot-text .prod-text-info .hotprod-price[data-v-2e4fe36c]{display:inline;font-size:%?26?%;color:#eb2444}.prod-items .hot-text .prod-text-info .basket-img[data-v-2e4fe36c]{width:%?50?%;height:%?50?%;position:absolute;right:0;bottom:%?7?%;\r\n  /* border: 2rpx solid #eb2444;\r\n  border-radius: 50%; */padding:%?8?%}.singal-price[data-v-2e4fe36c]{display:inline;font-size:%?20?%;text-decoration:line-through;color:#777;margin-left:%?15?%}\r\n\r\n/* 更多宝贝 */.more-prod[data-v-2e4fe36c]{background:#fff}.more-prod .prod-show .show-item .more-prod-pic[data-v-2e4fe36c]{width:%?250?%;height:%?250?%}.more-prod .prod-show .show-item[data-v-2e4fe36c]{position:relative;display:flex;padding:%?20?%;justify-content:start;border-top:%?2?% solid #f4f4f4}.more-prod .prod-show .show-item .more-prod-pic .more-pic[data-v-2e4fe36c]{max-width:100%;max-height:100%}.more-prod .prod-show .show-item .prod-text-right[data-v-2e4fe36c]{margin-left:%?30?%;width:60%;padding-bottom:%?10?%;display:flex;flex-direction:column;justify-content:center\r\n  /* background-color: #000000; */}.more-prod .prod-show .show-item .prod-text-right .go-to-buy[data-v-2e4fe36c]{font-size:%?26?%;background:#fff2f5;color:#eb2444;border-radius:%?50?%;text-align:center;padding:%?12?% %?20?%;position:absolute;right:%?20?%;bottom:%?20?%}.more-prod .prod-show .show-item .prod-text-right .prod-text.more[data-v-2e4fe36c]{margin:0;font-size:%?28?%;overflow:hidden;margin-bottom:%?20?%;display:-webkit-box;word-break:break-all;display:-webkit-box;-webkit-line-clamp:2;-webkit-box-orient:vertical}.more-prod .prod-show .show-item .prod-text-right .more.prod-price[data-v-2e4fe36c]{font-size:%?28?%;font-family:arial}.b-cart[data-v-2e4fe36c]{margin-left:-7px;margin-top:%?30?%\r\n  /* background-color: #000000; */}.b-cart .basket-img[data-v-2e4fe36c]{width:%?50?%;height:%?50?%;position:absolute;right:%?46?%;\r\n  /* border: 2rpx solid #eb2444;\r\n  border-radius: 50%; */padding:%?8?%}body.?%PAGE?%[data-v-2e4fe36c]{background:#f7f7f7}',""]),t.exports=e},a483:function(t,e,i){"use strict";var o=i("108d");e["a"]=o["a"]},b156:function(t,e,i){"use strict";i.r(e);var o=i("c32a"),a=i.n(o);for(var r in o)"default"!==r&&function(t){i.d(e,t,(function(){return o[t]}))}(r);e["default"]=a.a},bad1:function(t,e,i){"use strict";var o=function(t){(t.options.wxs||(t.options.wxs={}))["wxs"]=function(t){function e(t){return t||(t=0),t.toFixed(2)}function i(t){return t||(t=0),t.toFixed(2).split(".")}function o(t,e){for(var i=0;i<t.length;i++)if(t[i]==e)return!0;return!1}function a(t,e,i,o,a){var r="";e[i]=o;for(var n=0;n<a.length;n++)r+=a[n]+":"+e[a[n]]+";";r=r.substring(0,r.length-1);for(var s=!1,d=0;d<t.length;d++)if(r==t[d]){s=!0;break}return s}function r(t){return 0==t?"满额减":1==t?"满件减":2==t?"满额折":3==t?"满件折":""}function n(t,e,i){return 0==t?"购满"+e+"元减"+i+"元":1==t?"购满"+e+"件减"+i+"元":2==t?"购满"+e+"元打"+i+"折":3==t?"购满"+e+"件打"+i+"折":""}return t.exports={toPrice:e,parsePrice:i,array_contain:o,props_contain:a,parseDiscount:r,parseDiscountMsg:n},t.exports}({exports:{}})};e["a"]=o},c32a:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var o=i("f813"),a=i("a458"),r=(getApp(),{data:function(){return{indicatorDots:!0,indicatorColor:"#d1e5fb",indicatorActiveColor:"#1b7dec",autoplay:!0,interval:2e3,duration:1e3,seq:0,news:[],newsListData:{},sts:0,scrollTop:"",current:0,updata:!0,serverUrl:a.domain}},components:{},props:{},onLoad:function(){this.getAllData()},onShow:function(){},onPullDownRefresh:function(){var t=this;setTimeout((function(){t.getAllData(),uni.stopPullDownRefresh()}),100)},methods:{bindViewTap:function(){uni.navigateTo({url:"../logs/logs"})},onPageScroll:function(t){this.setData({scrollTop:t.scrollTop})},toProdPage:function(t){console.log(t.currentTarget);var e=t.currentTarget.dataset.newsid;uni.navigateTo({url:"/pages/news-detail/news-detail?newsId="+e})},toSearchPage:function(){uni.navigateTo({url:"/pages/search-page/search-page"})},onNewsPage:function(){},getAllData:function(){this.getNoticeList(),this.getHotNewsList()},getNoticeList:function(){},getHotNewsList:function(t){var e=this,i={url:"/news/list",method:"post",needToken:!0,data:{pageNum:1,pageSize:6},callBack:function(t){e.updata=!1,e.updata=!0;e.newsListData;e.setData({newsListData:t.data})}};o.request(i)}}});e.default=r},d16d:function(t,e,i){"use strict";var o=i("4b31"),a=i.n(o);a.a},db8f:function(t,e,i){"use strict";i.r(e);var o=i("50bb"),a=i("b156");for(var r in a)"default"!==r&&function(t){i.d(e,t,(function(){return a[t]}))}(r);i("d16d");var n,s=i("f0c5"),d=i("a483"),c=i("bad1"),l=Object(s["a"])(a["default"],o["b"],o["c"],!1,null,"2e4fe36c",null,!1,o["a"],n);"function"===typeof d["a"]&&Object(d["a"])(l),"function"===typeof c["a"]&&Object(c["a"])(l),e["default"]=l.exports}}]);