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
  getCourses: {
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
  patchCourse: {
    url: prefix + '/courses',
    method: 'PATCH'
  }
})
DBF.create('CLASS', {
  getClasses: {
    url: prefix + '/classes',
    method: 'GET'
  },
  createClass: {
    url: prefix + '/classes',
    method: 'POST'
  }
})
