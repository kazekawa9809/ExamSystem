package com.chris.examsystem.student.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.student.dao.ExamsystemStudentRecordDao;
import com.chris.examsystem.student.entity.ExamsystemStudentRecordEntity;
import com.chris.examsystem.student.service.ExamsystemStudentRecordService;


@Service("examsystemStudentRecordService")
public class ExamsystemStudentRecordServiceImpl extends ServiceImpl<ExamsystemStudentRecordDao, ExamsystemStudentRecordEntity> implements ExamsystemStudentRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemStudentRecordEntity> page = this.page(
                new Query<ExamsystemStudentRecordEntity>().getPage(params),
                new QueryWrapper<ExamsystemStudentRecordEntity>()
        );

        return new PageUtils(page);
    }

}