<template>
  <div class="index-body">
    <div class="index-time">
      现在是
      {{now_time}}
    </div>
    <div class="index-badge">
      待处理事项：
      <el-badge :value="12" class="item">
        <el-button size="small" @click="_toGroup">报名</el-button>
      </el-badge>
      <el-badge :value="3" class="item" style="margin-left:20px;">
        <el-button size="small"  @click="_toGroup">拼团</el-button>
      </el-badge>
    </div>
    <div class="index-carousel">
      <el-carousel :interval="4000" type="card" height="300px">
        <el-carousel-item v-for="(item,index) in imgurls" :key="item">
          <img :src="item" alt="">
          <h3>{{ index + 1}}</h3>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script>
import moment from 'moment'

export default {
  data () {
    return {
      now_time: moment().format('MMMM Do YYYY, h:mm:ss a'),
      imgurls: [
        'https://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/3.jpg',
        'https://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/interestclass/%E6%9E%81%E5%AE%A2%E5%B0%91%E5%B9%B4/scratch%E8%B6%A3%E5%91%B3%E5%88%9B%E6%84%8F%E7%BC%96%E7%A8%8B.png',
        'https://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/5909a1250001197e05400300.jpg',
        'https://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/59e6b62c0001fbc805400300.jpg']
    }
  },
  methods: {
    _toGroup () {
      this.$router.push('/group')
    }
  }

}
</script>

<style scoped>
.index-body{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.index-time{
  margin-top:30px;
  font-size: 25px;
}
.index-badge{
  margin-top:30px;
}
.index-carousel{
  margin-top:30px;
  width: 70%;
}
 .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
  

</style>
