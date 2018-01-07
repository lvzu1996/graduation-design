<template>
  <div id="main-part">
    <p>登录后台管理系统</p>
    <el-input 
        v-model="managerTelephone" 
        placeholder="请输入手机号" 
        class="login-input" 
        :maxlength=11
        @blur="_mobiTest(managerTelephone)"
        prefix-icon='el-icon-phone-outline'>
    </el-input>
    <el-input 
        v-model="managerPassword" 
        placeholder="请输入密码" 
        class="login-input"
        type = 'password'
        :maxlength=22
        prefix-icon='el-icon-edit-outline'>
    </el-input>
    <el-button plain style="width:60%;margin-top:25px;" @click="_login">登录</el-button>
  </div>
</template>

<script>
import DB from '../utils/db.js'
import SHA1 from '../utils/sha1'
export default {
  data () {
    return {
      managerTelephone: '',
      managerPassword: ''
    }
  },
  methods: {
    _login: function () {
      const _this = this
      DB.api.login({
        'managerTelephone': _this.managerTelephone,
        'managerPassword': SHA1(_this.managerTelephone + _this.managerPassword)
      }).then(
        re => {
          _this.$store.commit('setManagerAvatarUrl', re.managerAvatarUrl)
          _this.$store.commit('setManagerName', re.managerName)
          _this.$emit('loginOk')
        },
        re => {
          _this.$message.error('账号密码错误')
          _this.managerTelephone = ''
          _this.managerPassword = ''
        }
      )
    },
    _mobiTest: function (pn) {
      var mobiReg = new RegExp(/^1(3|4|5|7|8)\d{9}$/)
      if (!mobiReg.test(pn)) {
        this.$message.error('请输入正确的手机号！')
        this.managerTelephone = ''
        return false
      }
      return true
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
