package com.chris.examsystem.university.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.university.dao.ExamsystemUniversityPlanDao;
import com.chris.examsystem.university.entity.ExamsystemUniversityPlanEntity;
import com.chris.examsystem.university.service.ExamsystemUniversityPlanService;


@Service("examsystemUniversityPlanService")
public class ExamsystemUniversityPlanServiceImpl extends ServiceImpl<ExamsystemUniversityPlanDao, ExamsystemUniversityPlanEntity> implements ExamsystemUniversityPlanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemUniversityPlanEntity> page = this.page(
                new Query<ExamsystemUniversityPlanEntity>().getPage(params),
                new QueryWrapper<ExamsystemUniversityPlanEntity>()
        );

        return new PageUtils(page);
    }

}