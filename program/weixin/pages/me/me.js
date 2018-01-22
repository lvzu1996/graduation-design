const SELECTEDARR = [
    [true, false, false, false],
    [false, true, false, false],
    [false, false, true, false],
    [false, false, false, true]
]
const allDataListTest = [[],[],[],[]]
import mock from 'mock'
Page({
    data: {
        selected: [true, false, false, false],
        allDataList:[[],[],[],[]],
        none:true,
        type:0,
    },

    _select: function (e) {
        var cindex = e.currentTarget.dataset.cindex
        this.selected = SELECTEDARR[cindex]
        type = cindex
        this.setData({
            selected: SELECTEDARR[cindex]
        })
        if(this.allDataList[cindex] == []){
            this.none = true
            this.setData({
                none:true
            })
        }
    },

    onLoad:function(){
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

        this.allDataList = mock
    }

    
    


})