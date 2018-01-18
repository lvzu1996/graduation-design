<template>
  <div>
    <el-table
    :data="groupListData"
    style="width: 100%">
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
    <el-table-column
      label="拼团名称"
      prop="groupName">
    </el-table-column>
    <el-table-column
      label="所属班级"
      prop="className">
    </el-table-column>
     <el-table-column
      label="参团人数"
      prop="groupCount">
    </el-table-column>
     <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
  </el-table>
  </div>
</template>

<script>
  export default {
    data () {
      return {
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
          groupEndTime: '2018-01-19'
        }],
        tableData5: [{
          id: '12987122',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987123',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987125',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987126',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }]
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
