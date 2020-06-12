package com.chris.examsystem.university.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chris.commom.utils.PageUtils;
import com.chris.examsystem.university.entity.ExamsystemUniversityCollegeEntity;

import java.util.Map;

/**
 * examsystem-university-college
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:25:34
 */
public interface ExamsystemUniversityCollegeService extends IService<ExamsystemUniversityCollegeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

