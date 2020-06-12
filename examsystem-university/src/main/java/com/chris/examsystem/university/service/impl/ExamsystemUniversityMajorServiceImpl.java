package com.chris.examsystem.university.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.university.dao.ExamsystemUniversityMajorDao;
import com.chris.examsystem.university.entity.ExamsystemUniversityMajorEntity;
import com.chris.examsystem.university.service.ExamsystemUniversityMajorService;


@Service("examsystemUniversityMajorService")
public class ExamsystemUniversityMajorServiceImpl extends ServiceImpl<ExamsystemUniversityMajorDao, ExamsystemUniversityMajorEntity> implements ExamsystemUniversityMajorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemUniversityMajorEntity> page = this.page(
                new Query<ExamsystemUniversityMajorEntity>().getPage(params),
                new QueryWrapper<ExamsystemUniversityMajorEntity>()
        );

        return new PageUtils(page);
    }

}