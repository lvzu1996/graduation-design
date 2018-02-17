/**
 * 此文件控制商品详情页逻辑
 */
var WxParse = require('../../wxParse/wxParse.js');
import CONFIG from '../../config.js'
import { checkLoginState } from '../../utils/checkLoginState.js'
const app = getApp()
Page({
  data: {
    groupData: {},
    bannerUrls: [],
    groupId: 0,
    showSetUpView:false
  },
  onLoad: function (options) {
    //获取登录态
    wx.checkLoginState()
    const _this = this
    //本地化url传过来的groupId数据
    _this.groupId = options.groupId
    _this.setData({
      'groupId': options.groupId
    })
    //设置右上角分享按钮
    wx.showShareMenu({
      withShareTicket: true
    })

    //通过groupId获取拼团基础信息
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
        //使用WxParse渲染商品详情的富文本内容
        WxParse.wxParse('groupDetail', 'html', _this.groupData.groupDetail, _this,5);
      }
    })
    //通过groupId获取拼团的轮播图地址list
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

  //关闭拼团上浮框
  closeSetUpView:function(){
    this.showSetUpView = false
    this.setData({
      showSetUpView:false
    })
  },
  //对获取到的group数据做自定义处理
  _handleGroupData:function(groupData){
    if(groupData.groupType === 2){
      groupData.groupFavourablePrice =  Math.ceil(groupData.classPrice * (groupData.groupPayCount / groupData.groupCount))
    }
    // console.log(groupData)
    return groupData
  },

  //打开页面转发
  onShareAppMessage: function (res) {
    const _this = this
    if (res.from === 'button') {
      // 来自页面内转发按钮
      // console.log(res.target)
    }
    return {
      title: _this.groupData.groupIntro,
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

  /**
   * 点击发起拼团按钮事件
   * 主要分为以下几部分
   * 1.判断用户是否已经注册
   * 2.未注册则跳转注册页面
   * 3.注册则判断用户是否已经参加该拼团
   * 4.若已拼则提示
   * 5.若未拼则调用接口发起拼团，并跳转至拼团分享页
   */
  setupGroup:function(){
    const _this= this
    //判断用户是否已经注册
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
              //判断用户是否已经参与该拼团
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
                    /**
                     * 新建一个user_group
                     * user_grou_member新加一个本人
                     * 跳转到新页面
                     */
                    wx.loadingNav('正在跳转分享页', 1200, `/pages/share/share?userGroupId=${res.data.data}`)
                  }
                },
              })
            }
          },
        })
  }
})