import {data} from './memberListData.js'
Page({
    data :{
        groupId:'',
        groupMemberListData:data
    },
    onLoad:function(options){
        console.log(options.groupId)
        
    }
})