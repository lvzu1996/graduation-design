<template>
  <div class="analyse-body">
    <div class="analyse-top">
      兴趣班拼团数据分析
    </div>
    <div class="analyse-charts">
      <div class="analyse-single-chart" id="chart1"></div>
      <div class="analyse-single-chart" id="chart2"></div>
      <div class="analyse-single-chart" id="chart3"></div>
      <div class="analyse-single-chart" id="chart4"></div>
    </div>
  </div>
</template>

<script>
import chartConfig from './chart-config'
require('echarts-wordcloud')
export default {
  mounted () {
    this.drawLine()
  },
  methods: {
    drawLine () {
        // 基于准备好的dom，初始化echarts实例
      let chart1 = this.$echarts.init(document.getElementById('chart1'))
      let chart2 = this.$echarts.init(document.getElementById('chart2'))
      let chart3 = this.$echarts.init(document.getElementById('chart3'))
      let chart4 = this.$echarts.init(document.getElementById('chart4'))
        // 绘制图表
      chart1.setOption(chartConfig.option1)
      chart2.setOption(chartConfig.option2)
      chart3.setOption(chartConfig.option3)
      chart4.setOption(chartConfig.option4)
    }
  }
}
</script>

<style scoped>
  .analyse-top{
    padding: 20px 0;
    font-size: 21px;
  }
  .analyse-charts{
    margin-top:30px;
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  .analyse-single-chart{
    width: 80%;
    height:500px;
  }
</style>
