package com.chris.examsystem.student.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.student.dao.ExamsystemStudentProfileDao;
import com.chris.examsystem.student.entity.ExamsystemStudentProfileEntity;
import com.chris.examsystem.student.service.ExamsystemStudentProfileService;


@Service("examsystemStudentProfileService")
public class ExamsystemStudentProfileServiceImpl extends ServiceImpl<ExamsystemStudentProfileDao, ExamsystemStudentProfileEntity> implements ExamsystemStudentProfileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemStudentProfileEntity> page = this.page(
                new Query<ExamsystemStudentProfileEntity>().getPage(params),
                new QueryWrapper<ExamsystemStudentProfileEntity>()
        );

        return new PageUtils(page);
    }

}