// camera.js
Page({
    data: {
        grouplist: [{
            id: 1,
            info: '数学兴趣班,五人小班化教学，适合小升初的有奥数基础的学生',
            price: '12.9',
            existingmember: '1291',
            avatar: 'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/contact/lvzu.png'
        }, {
            id: 2,
            info: '安卓兴趣班,五人小班化教学，适合小升初的有奥数基础的学生',
            price: '128.5',
            existingmember: '1291',
            avatar: 'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/5909a1250001197e05400300.jpg'
        }, {
            id: 3,
            info: '数学兴趣班,五人小班化教学，适合小升初的有奥数基础的学生',
            price: '5.9',
            existingmember: '1291',
            avatar: 'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/59e6b62c0001fbc805400300.jpg'
        }, {
            id: 4,
            info: '数学兴趣班,五人小班化教学，适合小升初的有奥数基础的学生',
            price: '36',
            existingmember: '1291',
            avatar: 'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/1.jpg'
        }, {
            id: 5,
            info: '数学兴趣班,五人小班化教学，适合小升初的有奥数基础的学生',
            price: '21',
            existingmember: '1291',
            avatar: 'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/2.jpg'
        }, {
            id: 6,
            info: '数学兴趣班,五人小班化教学，适合小升初的有奥数基础的学生',
            price: '24',
            existingmember: '1291',
            avatar: 'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/3.jpg'
        }, ]
    },
    onLoad: function () {
        const _this = this;
        // 获取信息
        wx.request({
            url: 'http://localhost:8080/api/groups', //仅为示例，并非真实的接口地址
            header: {
                'content-type': 'application/json' // 默认值
            },
            success: function (res) {
                console.log(res)
                _this.grouplist = res.data.data
                _this.setData({
                    grouplist: res.data.data
                })
            }
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