<template>
<div id="class-body">
<div id ="class-father">
  
  <el-table
    border
    :data="classListData"
    style="width: 100%">
    <el-table-column
      label="课程名称"
      width="300">
      <template slot-scope="scope">
          <div slot="reference" class="name-wrapper">
            <el-popover trigger="focus" placement="top">
              <p>课程ID: {{ scope.row.courseId }}</p>
              <p>课程名: {{ scope.row.courseName }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.courseName }}</el-tag>
              </div>
            </el-popover>
          </div>
      </template>
    </el-table-column>
    <el-table-column
      label="班级名"
      width="300">
      <template slot-scope="scope">
        <el-popover trigger="focus" placement="top">
          <p>班级ID: {{ scope.row.classId }}</p>
          <p>班级名: {{ scope.row.className }}</p>
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.className }}</el-tag>
          </div>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column
      label="开始时间"
      width="200">
      <template slot-scope="scope">
        {{ scope.row.classStartTime }}
      </template>
    </el-table-column>
    <el-table-column
      label="结束时间"
      width="200">
      <template slot-scope="scope">
        {{ scope.row.classEndTime }}
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <div id="create-class">
    <el-form label-position="right" :inline="true" label-width="80px" :model="newClass">
    <el-form-item label="课程名称">
      <el-select v-model="newClass.courseId" filterable placeholder="请选择课程" >
      <el-option
        v-for="(item,index) in courseListData"
        :key="index"
        :label="item.courseName"
        :value="item.courseId">
      </el-option>
    </el-select>
    </el-form-item>
    <el-form-item label="班级名">
      <el-input v-model="newClass.className"></el-input>
    </el-form-item>
    <el-form-item label="起止日期">
    <el-date-picker
      v-model="newClass.classDateRange"
      type="daterange"
      placeholder="选择日期"
      value-format="yyyy-MM-dd"
      :default-value="now"
      :picker-options="dateRangePickerOptions">
    </el-date-picker>
    </el-form-item>
    <!-- <el-form-item label="结束日期">
    <el-date-picker
      v-model="newClass.classEndTime"
      type="date"
      placeholder="选择日期"
      value-format="yyyy-MM-dd">
    </el-date-picker>
    </el-form-item> -->
    <el-button @click="createClass">创建班级</el-button>
  </el-form>
  </div>
  </div>

  <el-dialog title="修改课程信息" :visible.sync="dialogFormVisible">
     <el-form :model="revClass">
        <el-form-item label="课程名称" label-width="120px">
          <el-select v-model="revClass.courseId" filterable placeholder="请选择课程" style="width:50%;">
            <el-option
              v-for="(item,index) in courseListData"
              :key="index"
              :label="item.courseName"
              :value="item.courseId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="班级名称" label-width="120px">
          <el-input v-model="revClass.className" auto-complete="off" style="width:50%;"></el-input>
        </el-form-item>
        <el-form-item label="起止时间" label-width="120px">
          <el-date-picker
            v-model="revClass.classDateRange"
            type="daterange"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            :default-value="revClass.classStartTime"
            :picker-options="dateRangePickerOptions">
          </el-date-picker>
        </el-form-item>
     </el-form>
        <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="reviceClass">确 定</el-button>
      </div>
  </el-dialog>
</div>

</template>

<script>
/*  ****************************
  *  3000x ----- /api/class
  *  30001 insert fail
  */
import DB from '../../utils/db.js'
const errorNumMap = {
  '30001': 'insert fail'
}

export default {
  data () {
    return {
      classListData: [{
        classId: 1,
        className: 'haha',
        courseName: 'nihao',
        courseId: 11,
        classStartTime: '1996-01-16',
        classEndTime: '1996-01-14'
      }],
      courseListData: [{
        courseId: 1,
        courseName: '【零基础】Scratch趣味创意编程'
      }],
      newClass: {
        courseId: '',
        className: '',
        classDateRange: ['', '']
      },
      now: new Date(),
      dialogFormVisible: false,
      revClass: {

      },
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
    dialogFormData () {
      return {
        courseName: this.revClass.courseName,
        className: this.revClass.className,
        classDateRange: [this.revClass.classStartTime, this.revClass.classEndTime]
      }
    },
    newClassFormData () {
      return {
        courseId: this.newClass.courseId,
        className: this.newClass.className,
        classStartTime: this.newClass.classDateRange[0],
        classEndTime: this.newClass.classDateRange[1]
      }
    },
    reviceClassFormData () {
      return {
        classId: this.revClass.classId,
        courseId: this.revClass.courseId,
        className: this.revClass.className,
        classStartTime: this.revClass.classDateRange[0],
        classEndTime: this.revClass.classDateRange[1]
      }
    }
  },
  created () {
    this.getClassList()
    this.getCourseList()
  },
  methods: {
    _handleError (re) {
      this.$message.error(errorNumMap[re.error_num])
    },
    getClassList () {
      const _this = this
      DB.CLASS.get({}).then(
        re => {
          _this.classListData = re
        },
        re => {
        }
      )
    },
    getCourseList () {
      const _this = this
      DB.COURSE.get({}).then(
      re => {
        _this.courseListData = re
      },
      re => {
        _this._handleError(re)
      }
    )
    },
    createClass () {
      const _this = this
      if (!_this._varifyCreateForm(1)) {
        return
      }
      DB.CLASS.create(_this.newClassFormData).then(
        re => {
          _this.getClassList()
        },
        re => { console.log(re) }
      )
    },
    reviceClass () {
      const _this = this
      if (!_this._varifyCreateForm(2)) {
        return
      }
      DB.CLASS.revice(_this.reviceClassFormData).then(
        re => {
          _this.getClassList()
        },
        re => {
          console.log(re)
        }
      )
    },
    _varifyCreateForm (type) {
      if (type === 1) {
        if (this.newClassFormData.courseId === '') {
          this.$message.error('请选择课程!')
          return false
        }
        if (this.newClassFormData.className === '') {
          this.$message.error('请输入班级名!')
          return false
        }
        if (this.newClassFormData.classStartTime === '' || this.newClassFormData.classEndTime === '') {
          this.$message.error('请选择正确的时间!')
          return false
        }
      } else {
        if (this.reviceClassFormData.courseId === '') {
          this.$message.error('请选择课程!')
          return false
        }
        if (this.reviceClassFormData.className === '') {
          this.$message.error('请输入班级名!')
          return false
        }
        if (this.reviceClassFormData.classStartTime === '' || this.reviceClassFormData.classEndTime === '') {
          console.log(this.revClass)
          console.log(this.reviceClassFormData.classStartTime)
          this.$message.error('请选择正确的时间!')
          return false
        }
      }
      return true
    },
    handleEdit (index, row) {
      this.revClass = this.classListData[index]
      this.dialogFormVisible = true
    },
    handleDelete (index, row) {
      console.log(index, row)
    }
  }

}
</script>

<style scoped>
@import './Class.css';
</style>
