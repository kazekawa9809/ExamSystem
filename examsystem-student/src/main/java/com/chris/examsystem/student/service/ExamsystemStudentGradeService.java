package com.chris.examsystem.student.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chris.commom.utils.PageUtils;
import com.chris.examsystem.student.entity.ExamsystemStudentGradeEntity;

import java.util.Map;

/**
 * examsystem-student-grade
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:58
 */
public interface ExamsystemStudentGradeService extends IService<ExamsystemStudentGradeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

