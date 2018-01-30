var WxParse = require('../../wxParse/wxParse.js');
import CONFIG from '../../config.js'
import {login} from '../../utils/login.js'
const app = getApp()
Page({
  data: {
    groupData: {},
    bannerUrls: [],
    groupId: 0,
    showSetUpView:false
  },
  onLoad: function (options) {
    login()
    const _this = this
    _this.groupId = options.groupId
    _this.setData({
      'groupId': options.groupId
    })
    wx.showShareMenu({
      withShareTicket: true
    })
    wx.request({
      url: `${CONFIG.requestUrl}/group?groupId=${_this.groupId}`, //仅为示例，并非真实的接口地址
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data.data)
        var groupData = res.data.data
        groupData = _this._handleGroupData(groupData)
        _this.groupData = groupData
        _this.setData({
          groupData: groupData
        })

        WxParse.wxParse('groupDetail', 'html', _this.groupData.groupDetail, _this,5);
      }
    })
    wx.request({
      url: `${CONFIG.requestUrl}/group/banners?groupId=${_this.groupId}`, //仅为示例，并非真实的接口地址
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data.data)
        _this.bannerUrls = res.data.data
        _this.setData({
          bannerUrls: res.data.data
        })
      }
    })
  },


  closeSetUpView:function(){
    this.showSetUpView = false
    this.setData({
      showSetUpView:false
    })
  },
  _handleGroupData:function(groupData){
    if(groupData.groupType === 2){
      groupData.groupFavourablePrice =  Math.ceil(groupData.classPrice * (groupData.groupPayCount / groupData.groupCount))
    }
    // console.log(groupData)
    return groupData
  },

  onShareAppMessage: function (res) {
    const _this = this
    if (res.from === 'button') {
      // 来自页面内转发按钮
      // console.log(res.target)
    }
    return {
      title: '自定义转发标题',
      path: '/pages/groupdetail/groupdetail?id=' + _this.id,
      success: function (res) {
        // 转发成功
      },
      fail: function (res) {
        // 转发失败
      }
    }
  },

  _toHome: function () {
    wx.switchTab({
      url: '/pages/index/index'
    })
  },

  _soleBuy: function () {
    wx.showLoading({
      title: '正在跳转支付',
    })
    setTimeout(function () {
      wx.hideLoading()
    }, 2000)
  },

  showSetup:function(){
    const _this = this
    _this.setData({
      showSetUpView:true
    })
  },

  setupGroup:function(){
    const _this= this
    wx.request({
          url: CONFIG.requestUrl+'/user/judge', //仅为示例，并非真实的接口地址
          method: 'POST',
          header: {
            'content-type': 'application/json' // 默认值
          },
          data: {
            userOpenid:app.globalData.openid
          },
          success: function (res) {
            if(res.data.msg == 'fail') {
              wx.loadingNav('正在跳转注册页面', 1200, `/pages/register/register?type=before_buy`)
            }else {
              wx.request({
                url: CONFIG.requestUrl + '/group/user_group', //仅为示例，并非真实的接口地址
                method: 'POST',
                header: {
                  'content-type': 'application/json' // 默认值
                },
                data: {
                  userId: app.globalData.userId,
                  groupId:_this.groupData.groupId,
                  userName:app.globalData.userInfo.nickName,
                  attendUserAvatarUrl:app.globalData.userInfo.avatarUrl,
                  className:_this.groupData.className
                },
                success: function (res) {
                  if (res.data.msg == 'fail') {
                    wx.showModal({
                      title: '提示',
                      content: '您已拼此团',
                      showCancel: false,
                      confirmColor: '#6DC1D2',
                      success: function (res) {
                        wx.navigateBack({ delta: 1 })
                      }
                    })
                  } else {
                    //新建一个user_group
                    //user_grou_member新加一个本人
                    //跳转到新页面
                    wx.loadingNav('正在跳转分享页', 1200, `/pages/share/share?userGroupId=${res.data.data}`)
                  }
                },
              })
            }
          },
        })
  }
})