<template>
  <div>
    <el-button type="success" plain @click="open">编辑</el-button>
    <el-dialog
      title="提示"
      :visible.sync="showDetailPreview"
      width="80%">
       <vue-editor v-model="content"></vue-editor>
        <el-button type="primary" plain @click="addPic">添加图片</el-button>
        <el-button type="success" plain @click="groupDetailSave">确定保存</el-button>
    </el-dialog>
     <div v-html="content"></div>
  </div>
</template>

<script>
import { VueEditor } from 'vue2-editor'
console.log(VueEditor)
export default {
  data () {
    return {
      content: '<img src="http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/1.jpg" alt="">',
      showDetailPreview: true,
      groupDetail: '<p><img src="http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/1.jpg" alt="">哈哈哈哈啊</p><p><img src="http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/%E4%B8%8B%E8%BD%BD.png" alt=""></p> '
    }
  },
  components: {
    VueEditor
  },
  methods: {
    groupDetailSave () {
      console.log(this.content)
      this.dialogVisible = false
    },
    open () {
      this.dialogVisible = true
    },
    addPic () {
      this.$prompt('请输入地址', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(({ value }) => {
        this.content += `<img src="${value}" alt="">`
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        })
      })
    }

  }
}
</script>

<style scoped>
 .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
