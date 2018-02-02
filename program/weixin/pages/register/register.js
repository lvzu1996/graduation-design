const app = getApp()
import {login} from '../../utils/login.js'
import CONFIG from '../../config.js'
Page({
    data:{
      type:'',
      userTelephone:'',
      verifyCode:''
    },
    onLoad : function(options){
      login()
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
    _getVerifyCode:function(){
      console.log(1)
      if(!this._testPhone()){
        return
      }
      wx.showLoading({
        title: '正在发送验证码',
      })
      setTimeout(function () {
        wx.hideLoading()
        wx.showToast({
          title: '发送成功',
          icon: 'success',
          duration: 2000
        })
      }, 2000)
    },
    _register:function(){
      const _this = this
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
              wx.lvlogin(() => {
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
              wx.lvlogin(() => {
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