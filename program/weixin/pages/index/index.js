/**
 * 此文件控制拼团列表页逻辑
 */
const app = getApp()
import CONFIG from '../../config.js'
import { checkLoginState } from '../../utils/checkLoginState.js'
Page({
    data: {
        grouplist: []
    },

    onLoad: function () {
        const _this = this;
        wx.checkLoginState()
        if (app.globalData.userInfo) {
            this.setData({
                userInfo: app.globalData.userInfo,
                hasUserInfo: true
            })
        } else if (this.data.canIUse) {
            // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
            // 所以此处加入 callback 以防止这种情况
            app.userInfoReadyCallback = res => {
                this.setData({
                    userInfo: res.userInfo,
                    hasUserInfo: true
                })
            }
        } else {
            // 在没有 open-type=getUserInfo 版本的兼容处理
            wx.getUserInfo({
                success: res => {
                    app.globalData.userInfo = res.userInfo
                    this.setData({
                        userInfo: res.userInfo,
                        hasUserInfo: true
                    })
                }
            })
        }
        // 获取拼团列表信息
        wx.request({
            url: CONFIG.requestUrl+'/groups', //仅为示例，并非真实的接口地址
            header: {
                'content-type': 'application/json' // 默认值
            },
            success: function (res) {
                console.log(res)
                _this.grouplist = _this._handleGroupsDataList(res.data.data)
                _this.setData({
                    grouplist: _this.grouplist
                })
            }
        })

    },
    _handleGroupsDataList:function(data){
        for(let i of data){
            if(i.groupType == 1){
                i.groupShowPrice = i.groupFavourablePrice
            }else{
                i.groupShowPrice = Math.ceil(i.classPrice * i.groupPayCount / i.groupCount)
            }
        }
        return data
    },
    getUserInfo: function (e) {
        app.globalData.userInfo = e.detail.userInfo
        this.setData({
            userInfo: e.detail.userInfo,
            hasUserInfo: true
        })
    },
    onPullDownRefresh: function () {
        wx.showToast({
            title: '每天十点上新', //提示信息
            icon: 'success', //成功显示图标
            duration: 400 //时间
        })
    },
    _setupGroup: function (e) {
        wx.navigateTo({
            url: `../groupdetail/groupdetail?groupId=${e.target.dataset.groupid}`
        })
    },


})