package com.chris.examsystem.university.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.university.dao.ExamsystemUniversityCollegeDao;
import com.chris.examsystem.university.entity.ExamsystemUniversityCollegeEntity;
import com.chris.examsystem.university.service.ExamsystemUniversityCollegeService;


@Service("examsystemUniversityCollegeService")
public class ExamsystemUniversityCollegeServiceImpl extends ServiceImpl<ExamsystemUniversityCollegeDao, ExamsystemUniversityCollegeEntity> implements ExamsystemUniversityCollegeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemUniversityCollegeEntity> page = this.page(
                new Query<ExamsystemUniversityCollegeEntity>().getPage(params),
                new QueryWrapper<ExamsystemUniversityCollegeEntity>()
        );

        return new PageUtils(page);
    }

}