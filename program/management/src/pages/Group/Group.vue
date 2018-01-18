<template>
  <div id="group-body">
    <div id="group-new-group-button">
      <el-button  type="primary" plain style="width:200px;" @click="_showNewGroupForm">新建团购</el-button>
    </div>
    <div id="group-table">
      <el-table :data="groupListData" style="width: 100%">
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
        <el-table-column label="参团人数" prop="groupCount">
        </el-table-column>
         <el-table-column prop="isEnd" label="是否结束" width="100" :filters="[{ text: '结束', value: '1' }, { text: '未结束', value: '0' }]" :filter-method="filterTag"
          filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag :type="scope.row.isEnd == '0' ? 'success' : 'danger'" close-transition>{{scope.row.isEnd==0?'未结束':'结束'}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog title="新建拼团" :visible.sync="showNewGroupForm">
      <el-form ref="form" :model="newGroupForm" label-width="80px" style="text-align:left;width:50%;margin-left:30%;">
        <el-form-item label="拼团班级">
          <el-select v-model="newGroupForm.classId" placeholder="请选择开团班级">
            <el-option v-for="(item,index) in classDataList" :key="index" :label="item.className" :value="item.classId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="拼团名称">
          <el-input v-model="newGroupForm.groupName" suffix-icon="el-icon-edit-outline" style="width:50%;"></el-input>
        </el-form-item>
        <el-form-item label="拼团人数">
          <el-input v-model="newGroupForm.groupCount" suffix-icon="el-icon-share" style="width:50%;"></el-input>
        </el-form-item>
        <el-form-item label="拼团种类">
          <el-radio-group v-model="newGroupForm.groupType">
            <el-radio label="1">折扣拼团</el-radio>
            <el-radio label="2">满团减人拼团</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="需付价格" v-if="newGroupForm.groupType == 1">
          <el-input v-model="newGroupForm.groupFavourablePrice" style="width:50%;"></el-input>
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
        <el-form-item>
          <el-button type="primary" @click="_submitNewGroupForm">立即创建拼团</el-button>
          <el-button @click="_cancelCreateNewGroup">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>

</template>



<script>
import DB from '../../utils/db.js'

export default {
  data () {
    return {
      // 表格显示现有group 数据
      groupListData: [{
        groupName: 'xixixhahah',
        groupId: 'xixixihahah',
        className: 'xixixihaha',
        classPrice: 100,
        classId: 'xixixihaha',
        groupCount: '10',
        groupType: '1',
        groupFavourablePrice: '100',
        groupPayCount: '99',
        groupStartTime: '2017-10-10',
        groupEndTime: '2018-01-19',
        isEnd: '1'
      }, {
        groupName: 'xixixhahah',
        groupId: 'xixixihahah',
        className: 'xixixihaha',
        classPrice: 100,
        classId: 'xixixihaha',
        groupCount: '10',
        groupType: '1',
        groupFavourablePrice: '100',
        groupPayCount: '99',
        groupStartTime: '2017-10-10',
        groupEndTime: '2018-01-19',
        isEnd: '1'
      }, {
        groupName: 'xixixhahah',
        groupId: 'xixixihahah',
        className: 'xixixihaha',
        classPrice: 100,
        classId: 'xixixihaha',
        groupCount: '10',
        groupType: '1',
        groupFavourablePrice: '100',
        groupPayCount: '99',
        groupStartTime: '2017-10-10',
        groupEndTime: '2018-01-19',
        isEnd: '0'
      }],
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
        groupDateRange: ''
      },
      now: new Date(),
      dateRangePickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
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
        classname: this.newGroupForm.classname,
        classId: this.newGroupForm.classId,
        groupFavourablePrice: this.newGroupForm.groupFavourablePrice || 0,
        groupPayCount: this.newGroupForm.groupPayCount || 0,
        groupStartTime: this.newGroupForm.groupDateRange[0],
        groupEndTime: this.newGroupForm.groupDateRange[1]
      }
    }
  },
  created () {
    this._getClassDataList()
    this._getGroupDataList()
  },
  methods: {
    _cancelCreateNewGroup () {
      this.showNewGroupForm = false
    },
    _submitNewGroupForm () {
      DB.GROUP.createGroup(this.newGroupPostData).then(
        re => {},
        re => {}
      )
    },
    _getGroupDataList () {
      const _this = this
      DB.GROUP.getGroup({}).then(
        re => { _this.groupListData = re },
        re => {}
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
      return row.isEnd === value
    },
    _showNewGroupForm () {
      this.showNewGroupForm = true
    }
  }
}
</script>

<style scoped>
@import './Group.css';
</style>
