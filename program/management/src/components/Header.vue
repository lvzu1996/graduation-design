<template>
  <div id='manage-header'>
    <div id="manage-title">兴趣班拼团后台管理</div>
    <div id="manager-info">
      <img :src="managerAvatarUrl">
      <span>{{managerName}}</span>
    </div>
  </div>
</template>

<script>
import store from '../store/store.js'
export default {
  name: 'Header',
  data () {
    return {
      managerAvatarUrl: this.$store.state.managerAvatarUrl,
      managerName: this.$store.state.managerName
    }
  },
  store
}
</script>

<style scoped>

#manage-header{
  position: fixed;
  width: 100%;
  height: 60px;
  top:0;
  left:0;
  background-color:#38A0FC;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  z-index:9999;
}

#manage-title{
  display: flex;
  align-items: center;
  font-size: 18px;
  padding:0 20px;
  height: 100%;
  color: #fff;
  text-align: center;
  border-color: rgba(238, 241, 146, 0.3);
  border-right-width: 1px;
  border-right-style: solid;
}

#manager-info{
  display: flex;
  align-items: center;
  color: #fff;
  position: absolute;
  right:50px;
}
#manager-info>img{
  width: 40px;
  height: 40px;
  border-radius:50%; 
  overflow:hidden;
}
#manager-info>span{
  padding-left: 10px;
}

</style>
