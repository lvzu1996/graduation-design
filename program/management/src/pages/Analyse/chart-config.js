
var option1 = {
  tooltip: {
    trigger: 'item',
    formatter: '{a} <br/>{b} : {c} ({d}%)'
  },
  legend: {
    orient: 'vertical',
    x: 'left',
    data: ['Scratch趣味一班', '面向对象程序设计', '数据结构', '极客少年', 'python', 'java', 'php', 'vue', 'react', 'javascript']
  },
  toolbox: {
    show: true,
    feature: {
      mark: { show: true },
      dataView: { show: true, readOnly: false },
      magicType: {
        show: true,
        type: ['pie', 'funnel']
      },
      restore: { show: true },
      saveAsImage: { show: true }
    }
  },
  calculable: false,
  series: [
    {
      name: '班级分布',
      type: 'pie',
      selectedMode: 'single',
      radius: [0, 70],

            // for funnel
      x: '20%',
      width: '40%',
      funnelAlign: 'right',
      max: 1548,

      itemStyle: {
        normal: {
          label: {
            position: 'inner'
          },
          labelLine: {
            show: false
          }
        }
      },
      data: [
          { value: 335, name: 'Scratch趣味一班' },
          { value: 679, name: '面向对象程序设计' },
          { value: 1548, name: '数据结构', selected: true }
      ]
    },
    {
      name: '班级报名',
      type: 'pie',
      radius: [100, 140],

            // for funnel
      x: '60%',
      width: '35%',
      funnelAlign: 'left',
      max: 1048,

      data: [
                { value: 335, name: '极客少年' },
                { value: 310, name: 'python' },
                { value: 234, name: 'java' },
                { value: 135, name: 'php' },
                { value: 1048, name: 'vue' },
                { value: 251, name: 'react' },
                { value: 147, name: 'javascript' },
                { value: 102, name: '其他' }
      ]
    }
  ]
}

var option2 = {
  title: {
    text: '拼团课程趋势',
    link: 'http://geek.163.com/'
  },
  tooltip: {
    show: true
  },
  series: [{
    type: 'wordCloud',
    shape: 'circle',
    left: 'center',
    top: 'center',
    width: '70%',
    height: '80%',
    right: null,
    bottom: null,
    sizeRange: [12, 60],
    rotationRange: [-90, 90],
    rotationStep: 45,
    gridSize: 8,
    drawOutOfBound: false,
    textStyle: {
      normal: {
        fontFamily: 'sans-serif',
        fontWeight: 'bold',
        color: function () {
          return 'rgb(' + [
            Math.round(Math.random() * 180),
            Math.round(Math.random() * 180),
            Math.round(Math.random() * 180)
          ].join(',') + ')'
        }
      },
      emphasis: {
        shadowBlur: 10,
        shadowColor: '#333'
      }
    },
    data: [{
      name: 'Scratch趣味一班',
      value: 366
    }, {
      name: '面向对象程序设计一班',
      value: 366
    }, {
      name: '数据结构及算法初级班',
      value: 366
    }, {
      name: 'Scratch趣味二班',
      value: 366
    }, {
      name: '数据结构及算法中级班',
      value: 366
    }, {
      name: '面向对象程序设计二班',
      value: 366
    }, {
      name: '极客少年3班',
      value: 366
    }, {
      name: 'sratch初级课程',
      value: 366
    }, {
      name: 'Code+Personalize',
      value: 366
    }, {
      name: 'Computing+Play',
      value: 366
    }, {
      name: 'Design+Create',
      value: 366
    }, {
      name: 'Analyze+Remix',
      value: 366
    }, {
      name: 'python',
      value: 366
    }, {
      name: 'java',
      value: 366
    }, {
      name: 'javascript',
      value: 366
    }, {
      name: 'deeplearning',
      value: 366
    }, {
      name: 'php',
      value: 366
    }, {
      name: 'html',
      value: 366
    }]
  }]
}

var option3 = {
  title: {
    text: '海码爸爸2018上半年运营图',
    subtext: '渠道拓宽'
  },
  tooltip: {
    trigger: 'axis'
  },
  legend: {
    orient: 'vertical',
    x: 'right',
    y: 'bottom',
    data: ['预算分配（Allocated Budget）', '实际收获（Actual Spending）']
  },
  toolbox: {
    show: true,
    feature: {
      mark: { show: true },
      dataView: { show: true, readOnly: false },
      restore: { show: true },
      saveAsImage: { show: true }
    }
  },
  polar: [
    {
      indicator: [
                { text: '销售（sales）', max: 6000 },
                { text: '管理（Administration）', max: 16000 },
                { text: '信息技术（Information Techology）', max: 30000 },
                { text: '客服（Customer Support）', max: 38000 },
                { text: '研发（Development）', max: 52000 },
                { text: '市场（Marketing）', max: 25000 }
      ]
    }
  ],
  calculable: true,
  series: [
    {
      name: '投入vs产出',
      type: 'radar',
      data: [
        {
          value: [4300, 10000, 28000, 35000, 50000, 19000],
          name: '投入'
        },
        {
          value: [5000, 14000, 28000, 31000, 42000, 21000],
          name: '产出'
        }
      ]
    }
  ]
}

var option4 = {
  tooltip: {
    trigger: 'axis',
    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
      type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    }
  },
  legend: {
    data: ['利润', '支出', '收入']
  },
  toolbox: {
    show: true,
    feature: {
      mark: { show: true },
      dataView: { show: true, readOnly: false },
      magicType: { show: true, type: ['line', 'bar'] },
      restore: { show: true },
      saveAsImage: { show: true }
    }
  },
  calculable: true,
  xAxis: [
    {
      type: 'value'
    }
  ],
  yAxis: [
    {
      type: 'category',
      axisTick: { show: false },
      data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
    }
  ],
  series: [
    {
      name: '利润',
      type: 'bar',
      itemStyle: { normal: { label: { show: true, position: 'inside' } } },
      data: [200, 170, 240, 244, 200, 220, 210]
    },
    {
      name: '收入',
      type: 'bar',
      stack: '总量',
      barWidth: 5,
      itemStyle: {
        normal: {
          label: { show: true }
        }
      },
      data: [320, 302, 341, 374, 390, 450, 420]
    },
    {
      name: '支出',
      type: 'bar',
      stack: '总量',
      itemStyle: {
        normal: {
          label: { show: true, position: 'left' }
        }
      },
      data: [-120, -132, -101, -134, -190, -230, -210]
    }
  ]
}

module.exports = {
  option1: option1,
  option2: option2,
  option3: option3,
  option4: option4
}
