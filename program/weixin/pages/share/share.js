import {
    data
} from './memberListData.js'
import CONFIG from '../../config.js'
import {
    checkLoginState
} from '../../utils/checkLoginState.js'
const app = getApp()
Page({
    data: {
        userGroupId: '',
        groupMemberListData: data
    },
    onLoad: function (options) {
        //检查登录态
        wx.checkLoginState()
        this.getUserGroupMember(options.userGroupId)
        //设置可以转发
        wx.showShareMenu({
            withShareTicket: true
        })
    },

    getUserGroupMember:function(userGroupId){
        const _this = this
        _this.userGroupId = userGroupId
        _this.setData({
            userGroupId: userGroupId
        })
        wx.request({
            url: CONFIG.requestUrl + `/group/user_group?userGroupId=${userGroupId}`,
            method: "GET",
            header: {
                'content-type': 'application/json' // 默认值
            },
            success: function (res) {
                _this.groupMemberListData = res.data.data
                _this.setData({
                    groupMemberListData: res.data.data
                })
            }
        })
    },

    onShareAppMessage: function (res) {
        const _this = this
        if (res.from === 'button') {
            // 来自页面内转发按钮
            console.log(res.target)
        }
        return {
            title: '网易极客少年邀您家孩子学编程啦！',
            path: `/page/share/share?userGroupId=${_this.userGroupId}`,
            success: function (res) {
                // 转发成功
                console.log(res)
            },
            fail: function (res) {
                // 转发失败
            }
        }
    },
    attendUserGroup: function () {
        const _this = this
        wx.request({
            url: CONFIG.requestUrl + '/user/judge', //仅为示例，并非真实的接口地址
            method: 'POST',
            header: {
                'content-type': 'application/json' // 默认值
            },
            data: {
                userOpenid: app.globalData.openid
            },
            success: function (res) {
                if (res.data.msg == 'fail') {
                    wx.loadingNav('正在跳转注册页面', 1200, `/pages/register/register?type=before_attend_user_group`)
                } else {
                    wx.showModal({
                        title: '提示',
                        content: '确定参加拼团吗?',
                        success: function (res) {
                            if (res.confirm) {
                                wx.request({
                                    url: CONFIG.requestUrl + '/group/user_group_member',
                                    method: 'POST',
                                    header: {
                                        'content-type': 'application/json' // 默认值
                                    },
                                    data: {
                                        attendUserId: app.globalData.userId,
                                        attendUserName: app.globalData.userInfo.nickName,
                                        userGroupId: _this.userGroupId,
                                        attendUserAvatarUrl: app.globalData.userInfo.avatarUrl||''
                                    },
                                    success: function (res) {
                                        if (res.data.msg == "success") {
                                            // wx.loadingNav('拼团成功！', 1200, '/pages/index/index')
                                            wx.showLoading({
                                                title:'拼团成功！',
                                                duration:2000
                                            })
                                            setTimeout(() => {
                                                _this.getUserGroupMember(_this.userGroupId)
                                            },2000)
                                        } else {
                                            if (res.data.error_num == "40012") {
                                                wx.showModal({
                                                    title: '提示',
                                                    content: '您已拼此团',
                                                    showCancel: false,
                                                    confirmColor: '#6DC1D2',
                                                    success: function (res) {
                                                        wx.navigateBack({
                                                            delta: 1
                                                        })
                                                    }
                                                })
                                            } else if (res.data.error_num == "40011") {
                                                wx.showModal({
                                                    title: '提示',
                                                    content: '拼团失败！',
                                                    showCancel: false,
                                                    confirmColor: '#6DC1D2',
                                                    success: function (res) {
                                                        wx.navigateBack({
                                                            delta: 1
                                                        })
                                                    }
                                                })
                                            }
                                        }
                                    }
                                })
                            }
                        }
                    })
                }
            }
        })
    }
})