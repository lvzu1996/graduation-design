const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

function getWindowW() {
  var windowW
  wx.getSystemInfo({
    success: function(res) {
      windowW = res.windowWidth
    }
  })
  return windowW
}

function loadingNav(msg,timeout,url){
  wx.showLoading({
    title: msg,
    duration:timeout
  })
  setTimeout(() => {
    wx.navigateTo({
      url: url,
    })
  },timeout)
}

function sData(key,value,t){
  t[key] = value
  t.setData({
    key:value
  })
}

function sDataList(keyList,valueList,t){
  var newObj = {}
  for(let i = 0 ; i < keyList ; i ++){
    t[keyList[i]] = valueList[i]
    newObj[keyList[i]] = valueList[i]
  }
  t.setData(newObj)
}

wx.loadingNav = loadingNav
wx.sData = sData
wx.sDataList = sDataList

module.exports = {
  formatTime: formatTime,
  getWindowW : getWindowW,
  loadingNav: loadingNav
}
