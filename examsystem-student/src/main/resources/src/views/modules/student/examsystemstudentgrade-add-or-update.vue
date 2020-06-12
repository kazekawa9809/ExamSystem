<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="stuExamId">
      <el-input v-model="dataForm.stuExamId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="science">
      <el-input v-model="dataForm.science" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="liberal">
      <el-input v-model="dataForm.liberal" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="chinese">
      <el-input v-model="dataForm.chinese" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="math">
      <el-input v-model="dataForm.math" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="engilist">
      <el-input v-model="dataForm.engilist" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sciStatus">
      <el-input v-model="dataForm.sciStatus" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="libStatus">
      <el-input v-model="dataForm.libStatus" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="gradeId">
      <el-input v-model="dataForm.gradeId" placeholder=""></el-input>
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
          science: '',
          liberal: '',
          chinese: '',
          math: '',
          engilist: '',
          sciStatus: '',
          libStatus: '',
          gradeId: ''
        },
        dataRule: {
          stuExamId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          science: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          liberal: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          chinese: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          math: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          engilist: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sciStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          libStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gradeId: [
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
              url: this.$http.adornUrl(`/student/examsystemstudentgrade/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.stuExamId = data.examsystemStudentGrade.stuExamId
                this.dataForm.science = data.examsystemStudentGrade.science
                this.dataForm.liberal = data.examsystemStudentGrade.liberal
                this.dataForm.chinese = data.examsystemStudentGrade.chinese
                this.dataForm.math = data.examsystemStudentGrade.math
                this.dataForm.engilist = data.examsystemStudentGrade.engilist
                this.dataForm.sciStatus = data.examsystemStudentGrade.sciStatus
                this.dataForm.libStatus = data.examsystemStudentGrade.libStatus
                this.dataForm.gradeId = data.examsystemStudentGrade.gradeId
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
              url: this.$http.adornUrl(`/student/examsystemstudentgrade/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'stuExamId': this.dataForm.stuExamId,
                'science': this.dataForm.science,
                'liberal': this.dataForm.liberal,
                'chinese': this.dataForm.chinese,
                'math': this.dataForm.math,
                'engilist': this.dataForm.engilist,
                'sciStatus': this.dataForm.sciStatus,
                'libStatus': this.dataForm.libStatus,
                'gradeId': this.dataForm.gradeId
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
