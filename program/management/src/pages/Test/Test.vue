<template>
  <div>
    <el-dialog title="拼团banner编辑" :visible.sync="showBannerEdit" width="30%" :before-close="handleClose">
        <el-carousel :interval="5000" arrow="always" @change="carouselChange">
          <el-carousel-item v-for="(item,index) in groupBannerUrlsDataList" :key="index">
            <img :src="item.groupBannerUrl" >
          </el-carousel-item>
        </el-carousel>
        <div style="margin-top:30px;">
          <el-button @click="addBanner" type="success">添加图片</el-button>
          <el-button @click="deleteBanner" type="danger">删除图片</el-button>
        </div>
    </el-dialog>
  </div>

</template>

<script>
import DB from '../../utils/db.js'

export default{
  data () {
    return {
      showBannerEdit: false,
      groupBannerUrlsDataList: [],
      currentIndex: 0
    }
  },
  created () {
    const _this = this
    _this.getGroupBannerUrlsDataList(3)
  },
  methods: {
    test () {

    },
    handleClose () {

    },
    getGroupBannerUrlsDataList (groupId) {
      const _this = this
      DB.GROUP.getGroupBanners({
        groupId: groupId
      }).then(
            re => {
              _this.groupBannerUrlsDataList = re
              console.log(_this.groupBannerUrlsDataList.length)
            },
            re => {}
          )
    },
    carouselChange (newIndex) {
      this.currentIndex = newIndex
    },
    deleteBanner () {
      const _this = this
      console.log(_this.groupBannerUrlsDataList[this.currentIndex].groupBannerId)
      if (this.groupBannerUrlsDataList[this.currentIndex]) {
        this.$confirm('此操作将永久删除该图片, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          DB.GROUP.deleteGroupBanner({
            'parameter': _this.groupBannerUrlsDataList[this.currentIndex].groupBannerId
          }).then(
            re => {
              this.$message({
                type: 'success',
                message: '删除成功'
              })
              _this.getGroupBannerUrlsDataList(3)
            },
            re => {
              this.$message({
                type: 'error',
                message: re
              })
            }
          )
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
      }
    },

    addBanner () {
      const _this = this
      this.$prompt('请输入图片地址', '添加banner图', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(({ value }) => {
        DB.GROUP.addGroupBanner({
          groupId: _this.groupBannerUrlsDataList[this.currentIndex].groupId,
          bannerUrl: value
        }).then(
          re => {
            this.$message({
              type: 'success',
              message: '添加成功'
            })
            _this.getGroupBannerUrlsDataList(3)
          },
          re => {
            this.$message({
              type: 'error',
              message: re
            })
          }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消添加'
        })
      })
    }
  }
}
</script>
<style>
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