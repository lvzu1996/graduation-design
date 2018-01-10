<template>
<div id="class-body">
<div id ="class-father">
  
  <el-table
    border
    :data="classListData"
    style="width: 100%">
    <el-table-column
      label="课程名"
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
    <el-form-item label="课程名">
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
    <el-form-item label="起始日期">
    <el-date-picker
      v-model="newClass.classStartTime"
      type="date"
      placeholder="选择日期">
    </el-date-picker>
    </el-form-item>
    <el-form-item label="结束日期">
    <el-date-picker
      v-model="newClass.classEndTime"
      type="date"
      placeholder="选择日期">
    </el-date-picker>
    </el-form-item>
    <el-button @click="createClass">创建班级</el-button>
  </el-form>
  </div>
  </div>
</div>

</template>

<script>
import DB from '../../utils/db.js'

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
        courseName: '零基础】Scratch趣味创意编程'
      }],
      newClass: {
        courseId: '',
        className: '',
        classStartTime: '',
        classEndTime: ''
      }
    }
  },
  created () {
    this.getClassList()
    this.getCourseList()
  },
  methods: {
    getClassList () {
      const _this = this
      DB.CLASS.getClasses({}).then(
        re => {
          _this.classListData = re
        },
        re => {
        }
      )
    },
    getCourseList () {
      const _this = this
      DB.COURSE.getCourses({}).then(
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
      DB.CLASS.createClass(_this.newClass).then(
        re => { console.log(re) },
        re => { console.log(re) }
      )
    },
    handleEdit (index, row) {
      console.log(index, row)
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
