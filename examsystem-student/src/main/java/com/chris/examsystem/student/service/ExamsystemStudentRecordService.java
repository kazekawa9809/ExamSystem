package com.chris.examsystem.student.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chris.commom.utils.PageUtils;
import com.chris.examsystem.student.entity.ExamsystemStudentRecordEntity;

import java.util.Map;

/**
 * examsystem-student-record
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:57
 */
public interface ExamsystemStudentRecordService extends IService<ExamsystemStudentRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

