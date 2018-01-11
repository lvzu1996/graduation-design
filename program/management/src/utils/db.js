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
  get: {
    url: prefix + '/courses',
    method: 'GET'
  },
  add: {
    url: prefix + '/courses',
    method: 'POST'
  },
  delete: {
    url: prefix + '/courses',
    method: 'DELETE'
  },
  revice: {
    url: prefix + '/courses',
    method: 'PATCH'
  }
})
DBF.create('CLASS', {
  get: {
    url: prefix + '/classes',
    method: 'GET'
  },
  create: {
    url: prefix + '/classes',
    method: 'POST'
  },
  revice: {
    url: prefix + '/classes',
    method: 'PATCH'
  }
})
