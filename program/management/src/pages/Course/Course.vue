<template>
<div id="course-father">
  <el-table
    :data="courseListData"
    style="width: 100%">
    <el-table-column
      label="课程名"
      width="300">
      <template slot-scope="scope">
        <el-popover trigger="focus" placement="top">
          <p>课程ID: {{ scope.row.courseId }}</p>
          <p>课程名: {{ scope.row.courseName }}</p>
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.courseName }}</el-tag>
          </div>
        </el-popover>
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
        <el-button
        size="mini"
        type="success"
        @click="handleAdd(scope.$index, scope.row)">新增</el-button>
      </template>
    </el-table-column>
  </el-table>
  <!-- <div id="course-add">
    <el-input v-model="courseAddName" placeholder="添加课程" prefix-icon='el-icon-edit' id="course-add-input"></el-input>
    <el-button type="success" >成功按钮</el-button>
  </div> -->
  </div>
</template>

<script>
import DB from '../../utils/db.js'

/**
     *  ****************************
     *  1000x ----- /api/course
     *  10001 duplicated course name
     *  10002 insert fail
     *  10003 course not found
     *  10004 revice fail
     *  10005 delete fail
     *  ****************************
     *  2000x ----- /api/login
     *  20001 telephone password error
     */

const errorNumMap = {
  '10001': 'duplicated course name',
  '10002': 'insert fail',
  '10003': 'course not found',
  '10004': 'revice fail',
  '10005': 'delete fail'
}

export default {
  data () {
    return {
      courseListData: [],
      courseAddName: ''
    }
  },
  created () {
    this.getCourseList()
  },
  methods: {
    _handleError (re) {
      this.$message.error(errorNumMap[re.error_num])
    },
    getCourseList () {
      const _this = this
      DB.COURSE.getCourse({}).then(
      re => {
        _this.courseListData = re
      },
      re => {
        _this._handleError(re)
      }
    )
    },
    handleEdit (index, row) {
      const _this = this
      this.$prompt('请输入修改后的新课程名', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(({ value }) => {
        DB.COURSE.reviceCourse({
          'oldCourseName': row.courseName,
          'newCourseName': value
        }).then(
          re => {
            _this.getCourseList()
          },
          re => {
            _this._handleError(re)
          }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消修改'
        })
      })
    },
    handleDelete (index, row) {
      const _this = this
      _this.$confirm('此操作将永久删除该课程, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        DB.COURSE.deleteCourse({
          'parameter': row.courseName
        }).then(
          re => {
            _this.getCourseList()
          },
          re => {
            _this._handleError(re)
          }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    handleAdd (index, row) {
      const _this = this
      this.$prompt('请输入新课程名', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(({ value }) => {
        DB.COURSE.addCourse({
          'courseName': value
        }).then(
          re => {
            _this.getCourseList()
          },
          re => {
            _this._handleError(re)
          }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消新增'
        })
      })
    }
  }
}
</script>

<style scoped>
@import './Course.css';
</style>
