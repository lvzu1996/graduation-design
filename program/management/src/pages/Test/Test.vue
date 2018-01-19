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

/* * {
background-image: none !important;
background: none !important;
background:#141414 !important;
color:#888 !important;
border-color:#555 !important;
scrollbar-arrow-color:#CCC !important;
scrollbar-base-color:#26A !important;
scrollbar-shadow-color:#26A !important;
scrollbar-face-color:#333 !important;
scrollbar-highlight-color:#26A !important;
scrollbar-track-color:#333 !important;
}

html a,
html a * {
color:#327cab !important;
text-decoration:none !important;
}

html a:visited,
html a:visited *,
html a:active,
html a:active * {
color:#aa6b80 !important;
}

html a:hover,
html a:hover * {
color:#94d2ca !important;
background:#141414 !important;
}

html input,
html select,
html option,
html button,
html textarea {
color:#AAA !important;
background:#555 !important;
border: 1px solid #666 !important;
border-color: #666 #888 #888 #666 !important;
}

html input:focus,
html select:focus,
html option:focus,
html button:focus,
html textarea:focus,
html input:hover,
html select:hover,
html option:hover,
html button:hover,
html textarea:hover {
color:#BBB !important;
background:#5A5A5A !important;
border-color: #777 #999 #999 #777 !important;
}

html input[type=button],
html input[type=submit],
html input[type=reset],
html input[type=image] {
border-color: #888 #666 #666 #888 !important;
}

html input[type=button]:focus,
html input[type=submit]:focus,
html input[type=reset]:focus,
html input[type=image]:focus,
html input[type=button]:hover,
html input[type=submit]:hover,
html input[type=reset]:hover,
html input[type=image]:hover {
color:#BBB !important;
background:#666 !important;
border-color: #AAA #888 #888 #AAA !important;
}

html img[src],
html input[type=image] {opacity:.6}

@media print {
* {
color: black !important;
background: white !important;
}
}

.block {
box-shadow: none !important;
} */
</style>
