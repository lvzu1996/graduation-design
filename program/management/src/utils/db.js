import DBF from './dbFactory'

export default DBF.context

var prefix = ''

// if (process.env.NODE_ENV === 'development') {
//   prefix = 'http://127.0.0.1:8000'
// }
// if (process.env.NODE_ENV === 'production') {
//   prefix = 'https://world-elite.site'
// }
prefix = 'http://127.0.0.1:8080'
// prefix = 'https://world-elite.site'

DBF.create('api', {
    // 登录api
  login: {
    url: prefix + '/api/login',
    method: 'POST'
  },
  getCourses: {
    url: prefix + '/api/courses',
    method: 'GET'
  },
  addCourse: {
    url: prefix + '/api/courses',
    method: 'POST'
  },
  deleteCourse: {
    url: prefix + '/api/courses',
    method: 'DELETE'
  },
  patchCourse: {
    url: prefix + '/api/courses',
    method: 'PATCH'
  }

})
