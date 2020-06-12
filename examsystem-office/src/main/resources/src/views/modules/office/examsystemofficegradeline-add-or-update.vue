<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="provinceId">
      <el-input v-model="dataForm.provinceId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="provinceName">
      <el-input v-model="dataForm.provinceName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sci0Lib1">
      <el-input v-model="dataForm.sci0Lib1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="gradeline">
      <el-input v-model="dataForm.gradeline" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderName">
      <el-input v-model="dataForm.orderName" placeholder=""></el-input>
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
          provinceId: '',
          provinceName: '',
          orderId: '',
          sci0Lib1: '',
          gradeline: '',
          orderName: ''
        },
        dataRule: {
          provinceId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          provinceName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sci0Lib1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gradeline: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderName: [
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
              url: this.$http.adornUrl(`/office/examsystemofficegradeline/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.provinceId = data.examsystemOfficeGradeline.provinceId
                this.dataForm.provinceName = data.examsystemOfficeGradeline.provinceName
                this.dataForm.orderId = data.examsystemOfficeGradeline.orderId
                this.dataForm.sci0Lib1 = data.examsystemOfficeGradeline.sci0Lib1
                this.dataForm.gradeline = data.examsystemOfficeGradeline.gradeline
                this.dataForm.orderName = data.examsystemOfficeGradeline.orderName
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
              url: this.$http.adornUrl(`/office/examsystemofficegradeline/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'provinceId': this.dataForm.provinceId,
                'provinceName': this.dataForm.provinceName,
                'orderId': this.dataForm.orderId,
                'sci0Lib1': this.dataForm.sci0Lib1,
                'gradeline': this.dataForm.gradeline,
                'orderName': this.dataForm.orderName
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
