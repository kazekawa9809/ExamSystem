package com.chris.examsystem.student.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.student.dao.ExamsystemStudentGradeDao;
import com.chris.examsystem.student.entity.ExamsystemStudentGradeEntity;
import com.chris.examsystem.student.service.ExamsystemStudentGradeService;


@Service("examsystemStudentGradeService")
public class ExamsystemStudentGradeServiceImpl extends ServiceImpl<ExamsystemStudentGradeDao, ExamsystemStudentGradeEntity> implements ExamsystemStudentGradeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemStudentGradeEntity> page = this.page(
                new Query<ExamsystemStudentGradeEntity>().getPage(params),
                new QueryWrapper<ExamsystemStudentGradeEntity>()
        );

        return new PageUtils(page);
    }

}