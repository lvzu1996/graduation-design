<template>
  <div id="main-part">
    <p>登录后台管理系统</p>
    <el-input 
        v-model="telephone" 
        placeholder="请输入手机号" 
        class="login-input" 
        prefix-icon='el-icon-phone-outline'>
    </el-input>
    <el-input 
        v-model="telephone" 
        placeholder="请输入密码" 
        class="login-input"
        prefix-icon='el-icon-edit-outline'>
    </el-input>
    <el-button plain style="width:60%;margin-top:25px;">登录</el-button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      telephone: '',
      password: ''
    }
  }
}
</script>

<style scoped>
#main-part{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 450px;
    height: 350px;
    overflow: hidden;
    text-align: center;
    margin: 10% auto 0;
    vertical-align: middle;
    background-color: #fff;
    -webkit-box-shadow: 0 0 15px 15px #d9d9d9;
    box-shadow: 0 0 15px 15px #d9d9d9;
    font-family: monaco,-apple-system,SF UI Display,Arial,PingFang SC,Hiragino Sans GB,Microsoft YaHei,WenQuanYi Micro Hei,sans-serif;
}
#main-part p{
    margin-top: 50px;
    font-size: 18px;
    font-weight: 700;
    color: #969696;
}
.login-input{
    width: 60%;
}
</style>
