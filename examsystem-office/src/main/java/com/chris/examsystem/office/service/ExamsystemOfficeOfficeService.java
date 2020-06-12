package com.chris.examsystem.office.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chris.commom.utils.PageUtils;
import com.chris.examsystem.office.entity.ExamsystemOfficeOfficeEntity;

import java.util.Map;

/**
 * examsystem-office-office
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:29:40
 */
public interface ExamsystemOfficeOfficeService extends IService<ExamsystemOfficeOfficeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

