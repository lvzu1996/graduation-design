Page({
    data :{
        groupId:''
    },
    onLoad:function(options){
        console.log(options.groupId)
        wx.showActionSheet({
            itemList: ['A', 'B', 'C'],
            success: function (res) {
                console.log(res.tapIndex)
            },
            fail: function (res) {
                console.log(res.errMsg)
            }
        })
    }
})