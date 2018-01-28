import {data} from './memberListData.js'
import CONFIG from '../globalConfig.js'

Page({
    data :{
        userGroupId:'',
        groupMemberListData:data
    },
    onLoad:function(options){
        const _this = this
        wx.request({
            url:CONFIG.requestUrl + `/group/user_group?userGroupId=${options.userGroupId}`,
            method:"GET",
            header: {
                'content-type': 'application/json' // 默认值
            },
            success:function(res){
                _this.groupMemberListData = res.data.data
                _this.setData({
                    groupMemberListData:res.data.data
                })
                console.log(res.data.data)
            }
        })
        
    }
})