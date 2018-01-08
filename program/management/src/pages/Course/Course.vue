<template>
<div>
  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
      label="课程名"
      width="300">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
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
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
import DB from '../../utils/db.js'
export default {
  data () {
    return {
      tableData: []
    }
  },
  created () {
    this.getCourseList()
  },
  methods: {
    getCourseList () {
      const _this = this
      DB.api.getCourses({}).then(
      re => {
        _this.tableData = re
      },
      re => {
        console.log(re)
      }
    )
    },
    handleEdit (index, row) {
      this.editCourse(row.courseName)
    },
    handleDelete (index, row) {
      this.deleteCourse(row.courseName)
    },
    editCourse (courseName) {
      const _this = this
      this.$prompt('请输入新课程名', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(({ value }) => {
        DB.api.patchCourse({
          'oldCourseName': courseName,
          'newCourseName': value
        }).then(
          re => {
            _this.getCourseList()
          },
          re => {
            _this.$message.error(re)
          }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消修改'
        })
      })
    },
    deleteCourse (courseName) {
      const _this = this
      _this.$confirm('此操作将永久删除该课程, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        DB.api.deleteCourse({
          'parameter': courseName
        }).then(
          re => {
            _this.getCourseList()
          },
          re => {
            _this.$message.error(re)
          }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>

<style scoped>
@import './Course.css';
</style>
