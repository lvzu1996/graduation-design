<template>
  <div id="group-body">
    <div id="group-table">
      <el-table
    border
    :data="groupListData"
    style="width: 100%">
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
    <el-table-column
        prop="classPrice"
        label="价格"
        width="100">
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
    <div id="group-new"></div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      groupListData: []
    }
  }
}
</script>

<style scoped>
@import './Group.css';
</style>
