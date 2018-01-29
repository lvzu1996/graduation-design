var app = getApp()
import CONFIG from '../pages/globalConfig.js'

function login(){
    if(!app.globalData.userInfo){
        wx.getUserInfo({
            success: res => {
                app.globalData.userInfo = res.userInfo
            }
        })
    }
    if(!app.globalData.openid){
        wx.login({
            success: function (res) {
                if (res.code) {
                    console.log(res.code)
                    // 获取拼团列表信息
                    wx.request({
                        url: CONFIG.requestUrl + '/wxlogin', //仅为示例，并非真实的接口地址
                        method: 'POST',
                        header: {
                            'content-type': 'application/json' // 默认值
                        },
                        data: {
                            code: res.code
                        },
                        success: function (res) {
                            app.globalData.openid = res.data.openid
                            app.globalData.session_key = res.data.session_key
                            app.globalData.userId = res.data.userId
                            // console.log(res)
                        }
                    })
                } else {
                    console.log('获取用户登录态失败！' + res.errMsg)
                }
            }
        });
    }
}

module.exports = {
    login:login
}
