<template>
  <div id="group-body">
    <!-- 新建拼团按钮 -->
    <div id="group-new-group-button">
      <el-button  type="primary" plain style="width:200px;" @click="showNewGroupForm = true">新建团购</el-button>
    </div>
    <!-- 拼团列表显示 -->
    <div id="group-table">
      <el-table :data="groupListData" style="width: 100%" v-loading="loading">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="拼团名称">
                <span>{{ props.row.groupName }}</span>
              </el-form-item>
              <el-form-item label="所属班级">
                <span>{{ props.row.className }}</span>
              </el-form-item>
              <el-form-item label="拼团 ID">
                <span>{{ props.row.groupId }}</span>
              </el-form-item>
              <el-form-item label="班级 ID">
                <span>{{ props.row.classId }}</span>
              </el-form-item>
              <el-form-item label="开始时间">
                <span>{{ props.row.groupEndTime }}</span>
              </el-form-item>
              <el-form-item label="结束时间">
                <span>{{ props.row.groupStartTime }}</span>
              </el-form-item>
              <el-form-item label="拼团种类:">
                <span>{{ props.row.groupType==1?'优惠拼团':'满团减人拼团' }}</span>
              </el-form-item>
              <el-form-item label="优惠价格" v-if="props.row.groupType == 1">
                <span>{{ props.row.groupFavourablePrice }}</span>
              </el-form-item>
              <el-form-item label="满付人数" v-if="props.row.groupType == 2">
                <span>{{ props.row.groupPayCount }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column label="拼团名称" prop="groupName">
        </el-table-column>
        <el-table-column label="所属班级" prop="className">
        </el-table-column>
        <el-table-column label="拼团总容量" prop="groupCount">
        </el-table-column>
         <el-table-column prop="groupIsEnd" label="是否结束" width="100" :filters="[{ text: '结束', value: 1 }, { text: '未结束', value: 0 }]" :filter-method="filterTag"
          filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag :type="scope.row.groupIsEnd == '0' ? 'success' : 'danger'" close-transition>{{scope.row.groupIsEnd==0?'未结束':'结束'}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="_handleEdit(scope.$index, scope.row)">详情编辑</el-button>
            <el-button size="mini" @click="_handleEditBanner(scope.$index, scope.row)">banner</el-button>
            <el-button size="mini" type="danger" @click="_handleSetEnd(scope.$index, scope.row)">结束拼团</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- 新建拼团弹窗 -->
    <el-dialog title="新建拼团" :visible.sync="showNewGroupForm">
      <el-form ref="form" :model="newGroupForm" label-width="80px" style="text-align:left;width:50%;margin-left:30%;">
        <el-form-item label="拼团班级">
          <el-select v-model="newGroupForm.classId" placeholder="请选择开团班级">
            <el-option v-for="(item,index) in classDataList" :key="index" :label="item.className" :value="item.classId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="拼团名称">
          <el-input v-model="newGroupForm.groupName" suffix-icon="el-icon-edit-outline" style="width:50%;" clearable></el-input>
        </el-form-item>
        <el-form-item label="拼团人数">
          <el-input v-model="newGroupForm.groupCount" suffix-icon="el-icon-share" style="width:50%;" clearable></el-input>
        </el-form-item>
        <el-form-item label="拼团种类">
          <el-radio-group v-model="newGroupForm.groupType">
            <el-radio label="1">折扣拼团</el-radio>
            <el-radio label="2">满团减人拼团</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="优惠价格" v-if="newGroupForm.groupType == 1">
          <el-input v-model="newGroupForm.groupFavourablePrice" style="width:50%;" clearable></el-input>
          <el-tag type="primary" style="margin-left:5px" v-if="newGroupForm.classId">班级原价:{{_getClassInfoById(newGroupForm.classId,'classPrice')}}</el-tag>
        </el-form-item>
        <el-form-item label="需付人数" v-if="newGroupForm.groupType==2 && newGroupForm.groupCount!=''">
          <el-select v-model="newGroupForm.groupPayCount" placeholder="请选择满团付款人数">
            <el-option v-for="(item,index) in newGroupForm.groupCount-1" :key="index" :label="item" :value="item"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="拼团时间">
          <el-date-picker v-model="newGroupForm.groupDateRange" type="daterange" placeholder="选择日期" value-format="yyyy-MM-dd" :default-value="now"
            :picker-options="dateRangePickerOptions">
          </el-date-picker>
        </el-form-item>
         <el-form-item label="图片地址">
          <el-input v-model="newGroupForm.groupAvatarUrl" suffix-icon="el-icon-picture" style="width:100%;" clearable></el-input>
        </el-form-item>
         <el-form-item label="拼团简介">
          <el-input type="textarea" v-model="newGroupForm.groupIntro"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="_submitNewGroupForm">立即创建拼团</el-button>
          <el-button @click="_cancelCreateNewGroup">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 拼团介绍详情编辑 -->
    <el-dialog
      title="拼团介绍详情编辑"
      :visible.sync="showDetailPreview"
      width="80%">
       <vue-editor v-model="groupDetailContent"></vue-editor>
       <div style="margin-top:20px"></div>
        <el-button type="primary" plain @click="groupDetailAddPic">添加图片</el-button>
        <el-button type="success" plain @click="groupDetailSave">确定保存</el-button>
    </el-dialog>

    <el-dialog title="拼团banner编辑" :visible.sync="showBannerEdit" width="30%">
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
import { VueEditor } from 'vue2-editor'

export default {
  components: {
    VueEditor
  },
  data () {
    return {
      // 表格显示现有group 数据
      groupListData: [],
      classDataList: [],
      showNewGroupForm: false,
      // 新建拼团弹窗form数据
      newGroupForm: {
        groupName: '',
        groupCount: '',
        groupType: '1',
        classname: '',
        classId: '',
        groupFavourablePrice: '',
        groupPayCount: '',
        groupDateRange: '',
        groupAvatarUrl: '',
        groupIntro: ''
      },
      now: new Date(),
      loading: false,
      showDetailPreview: false,
      // 弹窗编辑的dom html
      groupDetailContent: '',
      // 当前正在编辑的groupdetail 的id
      groupDetailEditId: '',
      // 编辑拼团banner
      urlEditingGroupId: '',
      showBannerEdit: false,
      groupBannerUrlsDataList: [],
      currentIndex: 0,
      dateRangePickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            end.setTime(end.getTime() + 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            end.setTime(end.getTime() + 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            end.setTime(end.getTime() + 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
          }
        }]
      }
    }
  },
  computed: {
    newGroupPostData () {
      return {
        groupName: this.newGroupForm.groupName,
        groupCount: this.newGroupForm.groupCount,
        groupType: this.newGroupForm.groupType,
        className: this._getClassInfoById(this.newGroupForm.classId, 'className'),
        classPrice: this._getClassInfoById(this.newGroupForm.classId, 'classPrice'),
        classId: this.newGroupForm.classId,
        groupFavourablePrice: this.newGroupForm.groupFavourablePrice || 0,
        groupPayCount: this.newGroupForm.groupPayCount || 0,
        groupStartTime: this.newGroupForm.groupDateRange[0],
        groupEndTime: this.newGroupForm.groupDateRange[1],
        groupAvatarUrl: this.newGroupForm.groupAvatarUrl,
        groupIntro: this.newGroupForm.groupIntro
      }
    }
  },
  created () {
    this._getClassDataList()
    this._getGroupDataList()
  },
  methods: {
    _getClassInfoById (classId, infoName) {
      for (let i of this.classDataList) {
        if (i.classId === classId) {
          return i[infoName]
        }
      }
    },
    _cancelCreateNewGroup () {
      this.showNewGroupForm = false
    },
    _submitNewGroupForm () {
      const _this = this
      // console.log(this.newGroupPostData)
      DB.GROUP.createGroup(this.newGroupPostData).then(
        re => {
          this.$message({
            type: 'success',
            message: '创建拼团成功！'
          })
          _this._getGroupDataList()
          _this.showNewGroupForm = false
        },
        re => {
          this.$message({
            type: 'error',
            message: re
          })
        }
      )
    },
    _getGroupDataList () {
      const _this = this
      _this.loading = true
      DB.GROUP.getGroup({}).then(
        re => {
          _this.groupListData = re
          _this.loading = false
        },
        re => {
          _this.loading = false
        }
      )
    },
    _getClassDataList () {
      const _this = this
      DB.CLASS.getClass({}).then(
        re => { _this.classDataList = re },
        re => {}
      )
    },
    filterTag (value, row) {
      return row.groupIsEnd === value
    },
    _handleEdit (index, row) {
      // console.log(row.groupDetail)
      this.groupDetailContent = row.groupDetail
      this.groupDetailEditId = row.groupId
      this.showDetailPreview = true
    },
    handleBannerEditClose () {

    },
    _handleEditBanner (index, row) {
      this.getGroupBannerUrlsDataList(row.groupId)
      this.showBannerEdit = true
      this.urlEditingGroupId = row.groupId
    },
    _handleSetEnd (index, row) {
      const _this = this
      this.$confirm('此操作将永久结束该拼团, 是否继续?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'error'
      }).then(() => {
        DB.COURSE.groupSetEnd({
          groupId: row.groupId
        }).then(
            re => {
              _this.$message({
                type: 'success',
                message: '结班成功!'
              })
              _this._getGroupDataList()
            },
            re => {
              _this.$message({
                type: 'error',
                message: re
              })
            }
          )
      }).catch(() => {
        _this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    groupDetailAddPic () {
      this.$prompt('请输入地址', '修改拼团详情', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(({ value }) => {
        this.groupDetailContent += `<img src="${value}" alt="">`
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消添加'
        })
      })
    },
    groupDetailSave () {
      const _this = this
      console.log(this.groupDetailContent)
      this.showDetailPreview = false
      DB.COURSE.reviceGroupDetail({
        groupId: _this.groupDetailEditId,
        groupDetail: _this.groupDetailContent
      }).then(
        re => {
          _this.$message({
            type: 'success',
            message: '修改成功'
          })
          _this._getGroupDataList()
        },
        re => {}
      )
    },
    getGroupBannerUrlsDataList (groupId) {
      const _this = this
      DB.GROUP.getGroupBanners({
        groupId: groupId
      }).then(
            re => {
              _this.groupBannerUrlsDataList = re
              // console.log(_this.groupBannerUrlsDataList.length)
            },
            re => {}
          )
    },
    carouselChange (newIndex) {
      this.currentIndex = newIndex
    },
    deleteBanner () {
      const _this = this
      // console.log(_this.groupBannerUrlsDataList[this.currentIndex].groupBannerId)
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
              _this.getGroupBannerUrlsDataList(_this.urlEditingGroupId)
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
          groupId: _this.urlEditingGroupId,
          bannerUrl: value
        }).then(
          re => {
            this.$message({
              type: 'success',
              message: '添加成功'
            })
            _this.getGroupBannerUrlsDataList(_this.urlEditingGroupId)
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

<style scoped>
@import './Group.css';
</style>
