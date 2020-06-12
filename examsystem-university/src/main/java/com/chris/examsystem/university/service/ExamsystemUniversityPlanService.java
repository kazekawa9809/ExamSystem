package com.chris.examsystem.university.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.commom.utils.PageUtils;
import com.chris.examsystem.university.entity.ExamsystemUniversityPlanEntity;

import java.util.Map;

/**
 * examsystem-university-plan
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:25:34
 */
public interface ExamsystemUniversityPlanService extends IService<ExamsystemUniversityPlanEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

