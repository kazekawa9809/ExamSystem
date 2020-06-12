<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="uniId">
      <el-input v-model="dataForm.uniId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uniName">
      <el-input v-model="dataForm.uniName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="stuExamId">
      <el-input v-model="dataForm.stuExamId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="stuName">
      <el-input v-model="dataForm.stuName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="majorId">
      <el-input v-model="dataForm.majorId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="majorName">
      <el-input v-model="dataForm.majorName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderName">
      <el-input v-model="dataForm.orderName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="typeId">
      <el-input v-model="dataForm.typeId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="typeName">
      <el-input v-model="dataForm.typeName" placeholder=""></el-input>
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
          uniId: '',
          uniName: '',
          stuExamId: '',
          stuName: '',
          majorId: '',
          majorName: '',
          orderId: '',
          orderName: '',
          typeId: '',
          typeName: ''
        },
        dataRule: {
          uniId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uniName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          stuExamId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          stuName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          majorId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          majorName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          typeId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          typeName: [
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
              url: this.$http.adornUrl(`/student/examsystemstudentapplication/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uniId = data.examsystemStudentApplication.uniId
                this.dataForm.uniName = data.examsystemStudentApplication.uniName
                this.dataForm.stuExamId = data.examsystemStudentApplication.stuExamId
                this.dataForm.stuName = data.examsystemStudentApplication.stuName
                this.dataForm.majorId = data.examsystemStudentApplication.majorId
                this.dataForm.majorName = data.examsystemStudentApplication.majorName
                this.dataForm.orderId = data.examsystemStudentApplication.orderId
                this.dataForm.orderName = data.examsystemStudentApplication.orderName
                this.dataForm.typeId = data.examsystemStudentApplication.typeId
                this.dataForm.typeName = data.examsystemStudentApplication.typeName
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
              url: this.$http.adornUrl(`/student/examsystemstudentapplication/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'uniId': this.dataForm.uniId,
                'uniName': this.dataForm.uniName,
                'stuExamId': this.dataForm.stuExamId,
                'stuName': this.dataForm.stuName,
                'majorId': this.dataForm.majorId,
                'majorName': this.dataForm.majorName,
                'orderId': this.dataForm.orderId,
                'orderName': this.dataForm.orderName,
                'typeId': this.dataForm.typeId,
                'typeName': this.dataForm.typeName
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
