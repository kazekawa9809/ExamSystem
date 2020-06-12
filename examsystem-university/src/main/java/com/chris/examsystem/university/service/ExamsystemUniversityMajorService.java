package com.chris.examsystem.university.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chris.commom.utils.PageUtils;
import com.chris.examsystem.university.entity.ExamsystemUniversityMajorEntity;

import java.util.Map;

/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:25:34
 */
public interface ExamsystemUniversityMajorService extends IService<ExamsystemUniversityMajorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

