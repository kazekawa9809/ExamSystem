package com.chris.examsystem.student.controller;

import java.util.Arrays;
import java.util.Map;


import com.chris.commom.utils.PageUtils;
import com.chris.commom.utils.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.examsystem.student.entity.ExamsystemStudentApplicationEntity;
import com.chris.examsystem.student.service.ExamsystemStudentApplicationService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:56
 */
@RestController
@RequestMapping("student/examsystem/student/application")
public class ExamsystemStudentApplicationController {
    @Autowired
    private ExamsystemStudentApplicationService examsystemStudentApplicationService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = examsystemStudentApplicationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")

    public R info(@PathVariable("id") Long id){
		ExamsystemStudentApplicationEntity examsystemStudentApplication = examsystemStudentApplicationService.getById(id);

        return R.ok().put("examsystemStudentApplication", examsystemStudentApplication);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody ExamsystemStudentApplicationEntity examsystemStudentApplication){
		examsystemStudentApplicationService.save(examsystemStudentApplication);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody ExamsystemStudentApplicationEntity examsystemStudentApplication){
		examsystemStudentApplicationService.updateById(examsystemStudentApplication);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] ids){
		examsystemStudentApplicationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
