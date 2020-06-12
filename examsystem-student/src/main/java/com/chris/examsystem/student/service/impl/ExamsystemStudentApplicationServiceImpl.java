package com.chris.examsystem.student.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.student.dao.ExamsystemStudentApplicationDao;
import com.chris.examsystem.student.entity.ExamsystemStudentApplicationEntity;
import com.chris.examsystem.student.service.ExamsystemStudentApplicationService;


@Service("examsystemStudentApplicationService")
public class ExamsystemStudentApplicationServiceImpl extends ServiceImpl<ExamsystemStudentApplicationDao, ExamsystemStudentApplicationEntity> implements ExamsystemStudentApplicationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemStudentApplicationEntity> page = this.page(
                new Query<ExamsystemStudentApplicationEntity>().getPage(params),
                new QueryWrapper<ExamsystemStudentApplicationEntity>()
        );

        return new PageUtils(page);
    }

}