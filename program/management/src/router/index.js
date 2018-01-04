import Vue from 'vue'
import Router from 'vue-router'

const Test = () => import('@/pages/Test')

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Test',
      component: Test
    }
  ]
})
