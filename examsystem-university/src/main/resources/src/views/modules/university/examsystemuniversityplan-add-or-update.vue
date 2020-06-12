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
    <el-form-item label="" prop="planNum">
      <el-input v-model="dataForm.planNum" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="planRadio">
      <el-input v-model="dataForm.planRadio" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="provinceId">
      <el-input v-model="dataForm.provinceId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="provinceName">
      <el-input v-model="dataForm.provinceName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="typeId">
      <el-input v-model="dataForm.typeId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="typeName">
      <el-input v-model="dataForm.typeName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="majorId">
      <el-input v-model="dataForm.majorId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="majorName">
      <el-input v-model="dataForm.majorName" placeholder=""></el-input>
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
          planNum: '',
          planRadio: '',
          provinceId: '',
          provinceName: '',
          typeId: '',
          typeName: '',
          majorId: '',
          majorName: ''
        },
        dataRule: {
          universityId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          universityName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          planNum: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          planRadio: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          provinceId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          provinceName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          typeId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          typeName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          majorId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          majorName: [
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
              url: this.$http.adornUrl(`/university/examsystemuniversityplan/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.universityId = data.examsystemUniversityPlan.universityId
                this.dataForm.universityName = data.examsystemUniversityPlan.universityName
                this.dataForm.planNum = data.examsystemUniversityPlan.planNum
                this.dataForm.planRadio = data.examsystemUniversityPlan.planRadio
                this.dataForm.provinceId = data.examsystemUniversityPlan.provinceId
                this.dataForm.provinceName = data.examsystemUniversityPlan.provinceName
                this.dataForm.typeId = data.examsystemUniversityPlan.typeId
                this.dataForm.typeName = data.examsystemUniversityPlan.typeName
                this.dataForm.majorId = data.examsystemUniversityPlan.majorId
                this.dataForm.majorName = data.examsystemUniversityPlan.majorName
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
              url: this.$http.adornUrl(`/university/examsystemuniversityplan/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'universityId': this.dataForm.universityId,
                'universityName': this.dataForm.universityName,
                'planNum': this.dataForm.planNum,
                'planRadio': this.dataForm.planRadio,
                'provinceId': this.dataForm.provinceId,
                'provinceName': this.dataForm.provinceName,
                'typeId': this.dataForm.typeId,
                'typeName': this.dataForm.typeName,
                'majorId': this.dataForm.majorId,
                'majorName': this.dataForm.majorName
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
