import Vue from 'vue'
import Router from 'vue-router'

const Index = () => import('@/pages/Index/Index')
const Course = () => import('@/pages/Course/Course')
const Class = () => import('@/pages/Class/Class')
const Group = () => import('@/pages/Group/Group')
const Customer = () => import('@/pages/Customer/Customer')
const Analyse = () => import('@/pages/Analyse/Analyse')
const Test = () => import('@/pages/Test/Test')

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/course',
      name: 'Course',
      component: Course
    },
    {
      path: '/class',
      name: 'Class',
      component: Class
    },
    {
      path: '/group',
      name: 'Group',
      component: Group
    },
    {
      path: '/customer',
      name: 'Customer',
      component: Customer
    },
    {
      path: '/analyse',
      name: 'Analyse',
      component: Analyse
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    }
  ]
})
