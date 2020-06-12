package com.chris.examsystem.office.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.office.dao.ExamsystemOfficeGradelineDao;
import com.chris.examsystem.office.entity.ExamsystemOfficeGradelineEntity;
import com.chris.examsystem.office.service.ExamsystemOfficeGradelineService;


@Service("examsystemOfficeGradelineService")
public class ExamsystemOfficeGradelineServiceImpl extends ServiceImpl<ExamsystemOfficeGradelineDao, ExamsystemOfficeGradelineEntity> implements ExamsystemOfficeGradelineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemOfficeGradelineEntity> page = this.page(
                new Query<ExamsystemOfficeGradelineEntity>().getPage(params),
                new QueryWrapper<ExamsystemOfficeGradelineEntity>()
        );

        return new PageUtils(page);
    }

}