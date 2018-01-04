<template>
  <div id="operation">
    <el-col :span="12" style="width:203px;">
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#eef1f6">
      <el-menu-item index="1">
        <template slot="title">
          <i class="el-icon-menu"></i>
          <span>首页信息</span>
        </template>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-edit"></i>
        <span slot="title">课程管理</span>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-goods"></i>
        <span slot="title">发起团购</span>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-mobile-phone"></i>
        <span slot="title">用户管理</span>
      </el-menu-item>
      <el-menu-item index="5">
        <i class="el-icon-document"></i>
        <span slot="title">数据统计</span>
      </el-menu-item>
    </el-menu>
  </el-col>
  </div>
</template>

<script>
export default {
  data () {
    return {}
  },
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  }

}
</script>

<style scoped>

#operation{
    position: fixed;
    width: 203px;
    background-color:#eef1f6;
    top: 60px;
    bottom: 0px;
    left: 0px;
}
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
</style>
