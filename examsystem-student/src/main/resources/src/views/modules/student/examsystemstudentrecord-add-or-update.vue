<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="stuExamId">
      <el-input v-model="dataForm.stuExamId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="appId">
      <el-input v-model="dataForm.appId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="gradeId">
      <el-input v-model="dataForm.gradeId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="majorId">
      <el-input v-model="dataForm.majorId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="majorName">
      <el-input v-model="dataForm.majorName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="universityId">
      <el-input v-model="dataForm.universityId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="universityName">
      <el-input v-model="dataForm.universityName" placeholder=""></el-input>
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
          stuExamId: '',
          appId: '',
          gradeId: '',
          majorId: '',
          majorName: '',
          universityId: '',
          universityName: ''
        },
        dataRule: {
          stuExamId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          appId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gradeId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          majorId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          majorName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          universityId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          universityName: [
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
              url: this.$http.adornUrl(`/student/examsystemstudentrecord/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.stuExamId = data.examsystemStudentRecord.stuExamId
                this.dataForm.appId = data.examsystemStudentRecord.appId
                this.dataForm.gradeId = data.examsystemStudentRecord.gradeId
                this.dataForm.majorId = data.examsystemStudentRecord.majorId
                this.dataForm.majorName = data.examsystemStudentRecord.majorName
                this.dataForm.universityId = data.examsystemStudentRecord.universityId
                this.dataForm.universityName = data.examsystemStudentRecord.universityName
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
              url: this.$http.adornUrl(`/student/examsystemstudentrecord/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'stuExamId': this.dataForm.stuExamId,
                'appId': this.dataForm.appId,
                'gradeId': this.dataForm.gradeId,
                'majorId': this.dataForm.majorId,
                'majorName': this.dataForm.majorName,
                'universityId': this.dataForm.universityId,
                'universityName': this.dataForm.universityName
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
