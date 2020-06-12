package com.chris.examsystem.university.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.university.dao.ExamsystemUniversityOfficeDao;
import com.chris.examsystem.university.entity.ExamsystemUniversityOfficeEntity;
import com.chris.examsystem.university.service.ExamsystemUniversityOfficeService;


@Service("examsystemUniversityOfficeService")
public class ExamsystemUniversityOfficeServiceImpl extends ServiceImpl<ExamsystemUniversityOfficeDao, ExamsystemUniversityOfficeEntity> implements ExamsystemUniversityOfficeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemUniversityOfficeEntity> page = this.page(
                new Query<ExamsystemUniversityOfficeEntity>().getPage(params),
                new QueryWrapper<ExamsystemUniversityOfficeEntity>()
        );

        return new PageUtils(page);
    }

}