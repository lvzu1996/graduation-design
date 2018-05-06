/** 
 * 本文件用于新用户的注册
 * 目前的入口有
 * 发起拼团前 before_buy
 * 加入别人分享的拼团 before_attend_user_group
 */
const app = getApp()
import CONFIG from '../../config.js'
import { checkLoginState } from '../../utils/checkLoginState.js'

Page({
    data:{
      type:'',
      userTelephone:'',
      verifyCode:''
    },
    onLoad : function(options){
      //检查登录态
      wx.checkLoginState()
      //获取页面进入类型
      this.type = options.type
      this.setData({
        type:options.type
      })
    },
    _testPhone:function(){
      var mobiReg = new RegExp(/^1(3|4|5|7|8)\d{9}$/)
      if (!mobiReg.test(this.userTelephone)) {
        wx.showModal({
          title: '提示',
          content: '请输入正确的手机号！',
        })
        this.userTelephone = ''
        this.setData({
          userTelephone:''
        })
        return false
      }
      return true
    },
    // 获取验证码，模拟
    _getVerifyCode:function(){
      var _this = this
      if(!this._testPhone()){
        return
      }
      wx.showLoading({
        title: '正在发送验证码',
      })
      // 获取拼团列表信息
      wx.request({
        url: CONFIG.requestUrl + `/register?telephone=${_this.userTelephone}`, //仅为示例，并非真实的接口地址
        success: function (res) {
          wx.hideLoading()
          wx.showToast({
            title: '发送成功',
            icon: 'success',
            duration: 2000
          })
        }
      })
    },
    /**
     * 点击注册按钮的事件
     * 大致过程如下
     * 1.先验证手机号是否注册
     * 2.未注册则注册号码，注册完成后获取登录态
     * 3.跳转至上一页面
     */
    _register:function(){
      const _this = this
      if (this.verifyCode !=6826){
        wx.showModal({
          title: '提示',
          content: '验证码错误！',
          showCancel: false,
          confirmColor: '#6DC1D2',
          success: function (res) {
            wx.navigateBack({ delta: 1 })
          }
        })
      }
      //检查是否已注册
      wx.request({
        url: CONFIG.requestUrl+'/user', //仅为示例，并非真实的接口地址
        method: 'POST',
        header: {
          'content-type': 'application/json' // 默认值
        },
        data: {
          userOpenid:app.globalData.openid,
          userTelephone:_this.userTelephone,
          userName:app.globalData.userInfo.nicknName,
          userGender:app.globalData.userInfo.gender
        },
        success: function (res) {
          if(res.data.msg){
            if(_this.type == 'before_buy'){
              wx.checkLoginState(() => {
                wx.showLoading({
                  title: '注册成功',
                  duration:2000
                })
                setTimeout(()=>{
                  wx.navigateBack({
                    delta: 1, // 回退前 delta(默认为1) 页面
                  })
                },2000)
              })
            }
            if(_this.type == 'before_attend_user_group'){
              wx.checkLoginState(() => {
                wx.showLoading({
                  title: '注册成功',
                  duration:2000
                })
                setTimeout(()=>{
                  wx.navigateBack({
                    delta: 1, // 回退前 delta(默认为1) 页面
                  })
                },2000)
              })
            }
          }
        },
        fail:function(res){
          wx.showModal({
            title: '提示',
            content: '注册失败！',
            showCancel: false,
            confirmColor: '#6DC1D2',
            success: function (res) {
              wx.navigateBack({ delta: 1 })
            }
          })
        }
      })
    },
    _changePhone:function(e){
      this.userTelephone = e.detail.value
      this.setData({
        userTelephone:e.detail.value
      })
    },
    _changeVerifyCode:function(e){
      this.verifyCode = e.detail.value
      this.setData({
        verifyCode:e.detail.value
      })
    }
})