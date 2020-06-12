<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="universityId">
      <el-input v-model="dataForm.universityId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="universityName">
      <el-input v-model="dataForm.universityName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderName">
      <el-input v-model="dataForm.orderName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="majorId">
      <el-input v-model="dataForm.majorId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="majorName">
      <el-input v-model="dataForm.majorName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="priority">
      <el-input v-model="dataForm.priority" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          universityId: '',
          universityName: '',
          orderId: '',
          orderName: '',
          majorId: '',
          majorName: '',
          priority: ''
        },
        dataRule: {
          universityId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          universityName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          majorId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          majorName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          priority: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/university/examsystemuniversitymajor/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.universityId = data.examsystemUniversityMajor.universityId
                this.dataForm.universityName = data.examsystemUniversityMajor.universityName
                this.dataForm.orderId = data.examsystemUniversityMajor.orderId
                this.dataForm.orderName = data.examsystemUniversityMajor.orderName
                this.dataForm.majorId = data.examsystemUniversityMajor.majorId
                this.dataForm.majorName = data.examsystemUniversityMajor.majorName
                this.dataForm.priority = data.examsystemUniversityMajor.priority
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/university/examsystemuniversitymajor/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'universityId': this.dataForm.universityId,
                'universityName': this.dataForm.universityName,
                'orderId': this.dataForm.orderId,
                'orderName': this.dataForm.orderName,
                'majorId': this.dataForm.majorId,
                'majorName': this.dataForm.majorName,
                'priority': this.dataForm.priority
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
