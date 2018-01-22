import DBF from './dbFactory'

export default DBF.context

var prefix = ''

// if (process.env.NODE_ENV === 'development') {
//   prefix = 'http://127.0.0.1:8000'
// }
// if (process.env.NODE_ENV === 'production') {
//   prefix = 'https://world-elite.site'
// }
prefix = 'http://127.0.0.1:8080/api'
// prefix = 'https://world-elite.site'

DBF.create('LOGIN', {
    // 登录api
  login: {
    url: prefix + '/login',
    method: 'POST'
  }
})
DBF.create('COURSE', {
  getCourse: {
    url: prefix + '/courses',
    method: 'GET'
  },
  addCourse: {
    url: prefix + '/courses',
    method: 'POST'
  },
  deleteCourse: {
    url: prefix + '/courses',
    method: 'DELETE'
  },
  reviceCourse: {
    url: prefix + '/courses',
    method: 'PATCH'
  }
})
DBF.create('CLASS', {
  getClass: {
    url: prefix + '/classes',
    method: 'GET'
  },
  createClass: {
    url: prefix + '/classes',
    method: 'POST'
  },
  reviceClass: {
    url: prefix + '/classes',
    method: 'PATCH'
  }
})

DBF.create('GROUP', {
  getGroup: {
    url: prefix + '/groups',
    method: 'GET'
  },
  createGroup: {
    url: prefix + '/groups',
    method: 'POST'
  },
  reviceGroupDetail: {
    url: prefix + '/groups/detail',
    method: 'PATCH'
  },
  groupSetEnd: {
    url: prefix + '/groups/end',
    method: 'PATCH'
  },
  deleteGroup: {
    url: prefix + '/groups',
    method: 'DELETE'
  },
  getGroupBanners: {
    url: prefix + '/group/banners',
    method: 'GET'
  },
  addGroupBanner: {
    url: prefix + '/group/banners',
    method: 'POST'
  },
  deleteGroupBanner: {
    url: prefix + '/group/banners',
    method: 'DELETE'
  }
})
