package com.chris.examsystem.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chris.commom.utils.PageUtils;
import com.chris.examsystem.student.entity.ExamsystemStudentApplicationEntity;

import java.util.Map;

/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:56
 */
public interface ExamsystemStudentApplicationService extends IService<ExamsystemStudentApplicationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

