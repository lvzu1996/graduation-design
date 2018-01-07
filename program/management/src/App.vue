<template>
  <div id="app">
    <transition name="fade" mode="out-in">
      <div v-if="logined">
        <Header></Header>
            <div id="ope-main">
              <Operation></Operation>
              <transition name="fade" mode="out-in">
                <router-view style="margin-top:60px;margin-left:203px;overflow: hidden;"></router-view>
              </transition>
            </div>
      </div>
     </transition>
     <transition name="fade" mode="out-in">
      <div v-if="!logined">
        <Login @loginOk="_login"></Login>
      </div>
     </transition>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Operation from './components/Operation.vue'
import Login from './components/Login.vue'

export default {
  name: 'app',
  data () {
    return {
      logined: false
    }
  },
  components: {
    Header: Header,
    Operation: Operation,
    Login: Login
  },
  methods: {
    test: function () {
      this.logined = true
    },
    _login () {
      this.logined = true
    }
  }
}
</script>

<style>

body{
  margin: 0;
  min-height: 100%;
}

#app {
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

/* course页面表头居中 */
.el-table th{
  text-align: center;
}

.fade-enter-active,
.fade-leave-active {
	transition: all .2s ease;
}

.fade-enter,
.fade-leave-active {
	opacity: 0;
}
</style>
