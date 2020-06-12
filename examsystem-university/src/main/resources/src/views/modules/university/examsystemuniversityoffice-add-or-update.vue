<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="colOfficeId">
      <el-input v-model="dataForm.colOfficeId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="colOfficePsw">
      <el-input v-model="dataForm.colOfficePsw" placeholder=""></el-input>
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
          colOfficeId: '',
          colOfficePsw: '',
          universityId: '',
          universityName: ''
        },
        dataRule: {
          colOfficeId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          colOfficePsw: [
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
              url: this.$http.adornUrl(`/university/examsystemuniversityoffice/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.colOfficeId = data.examsystemUniversityOffice.colOfficeId
                this.dataForm.colOfficePsw = data.examsystemUniversityOffice.colOfficePsw
                this.dataForm.universityId = data.examsystemUniversityOffice.universityId
                this.dataForm.universityName = data.examsystemUniversityOffice.universityName
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
              url: this.$http.adornUrl(`/university/examsystemuniversityoffice/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'colOfficeId': this.dataForm.colOfficeId,
                'colOfficePsw': this.dataForm.colOfficePsw,
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
