var WxParse = require('../../wxParse/wxParse.js');

Page({
    data: {
      id:0,
      imgUrls: [
        'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/swiper/1.png',
        'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/swiper/2.png',
        'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/swiper/3.png',
        'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/swiper/4.png',
      ],
      scrollToView:'groupdetail-swiper',
      basicInfos:{
        text:'【奥数班】小班化教学专为小升初学生量身打造，重点学校教师授课',
        price:'9.5',
        oldprice:'36',
        existingmember:1676,
      },
      detailImages:[
        'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/classroom/1.jpg',
        'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/classroom/2.jpg',
        'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/classroom/3.jpg',
        'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/classroom/4.jpg',
        'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/classroom/5.jpg',
      ] 
    },

    onLoad:function(options){
      this.setData({
        id:options.id
      })
      wx.showShareMenu({
        withShareTicket: true
      })
      // 通过id获取相应拼团详情
      // ({
      //   url: 'test.php', //仅为示例，并非真实的接口地址
      //   data: {
      //     x: '',
      //     y: ''
      //   },
      //   header: {
      //     'content-type': 'application/json' // 默认值
      //   },
      //   success: function (res) {
      //     console.log(res.data)
      //   }
      // })
    },

    _getDetail:function(){
      this.setData({
        scrollToView:'detail2'
      })
    },

    onShareAppMessage: function (res) {
      const _this = this
      if (res.from === 'button') {
        // 来自页面内转发按钮
        console.log(res.target)
      }
      return {
        title: '自定义转发标题',
        path: '/pages/groupdetail/groupdetail?id='+_this.id,
        success: function(res) {
          // 转发成功
        },
        fail: function(res) {
          // 转发失败
        }
      }
    },

    _toHome:function(){
      wx.switchTab({
        url: '/pages/index/index'
      })
    },

    _soleBuy:function(){
      wx.showLoading({
        title: '正在跳转支付',
      })
      setTimeout(function () {
        wx.hideLoading()
      }, 2000)
    },

    _groupBuy:function(){
      wx.showLoading({
        title: '正在跳转支付',
      })
      setTimeout(function () {
        wx.hideLoading()
      }, 2000)
    },
    
  })