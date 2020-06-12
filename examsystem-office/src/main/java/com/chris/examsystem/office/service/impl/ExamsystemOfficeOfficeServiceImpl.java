package com.chris.examsystem.office.service.impl;

import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.examsystem.office.dao.ExamsystemOfficeOfficeDao;
import com.chris.examsystem.office.entity.ExamsystemOfficeOfficeEntity;
import com.chris.examsystem.office.service.ExamsystemOfficeOfficeService;


@Service("examsystemOfficeOfficeService")
public class ExamsystemOfficeOfficeServiceImpl extends ServiceImpl<ExamsystemOfficeOfficeDao, ExamsystemOfficeOfficeEntity> implements ExamsystemOfficeOfficeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExamsystemOfficeOfficeEntity> page = this.page(
                new Query<ExamsystemOfficeOfficeEntity>().getPage(params),
                new QueryWrapper<ExamsystemOfficeOfficeEntity>()
        );

        return new PageUtils(page);
    }

}