import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const state = {
  managerAvatarUrl: 'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/contact/lvzu.png',
  managerName: '张某某'
}
const mutations = {
  setManagerAvatarUrl (state, url) {
    state.managerAvatarUrl = url
  },
  setManagerName (state, name) {
    state.managerName = name
  }
}
export default new Vuex.Store({
  state,
  mutations
})
