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

import com.chris.examsystem.student.entity.ExamsystemStudentProfileEntity;
import com.chris.examsystem.student.service.ExamsystemStudentProfileService;



/**
 * examsystem-student-profile
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:58
 */
@RestController
@RequestMapping("student/examsystem/student/profile")
public class ExamsystemStudentProfileController {
    @Autowired
    private ExamsystemStudentProfileService examsystemStudentProfileService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = examsystemStudentProfileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")

    public R info(@PathVariable("id") Long id){
		ExamsystemStudentProfileEntity examsystemStudentProfile = examsystemStudentProfileService.getById(id);

        return R.ok().put("examsystemStudentProfile", examsystemStudentProfile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody ExamsystemStudentProfileEntity examsystemStudentProfile){
		examsystemStudentProfileService.save(examsystemStudentProfile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody ExamsystemStudentProfileEntity examsystemStudentProfile){
		examsystemStudentProfileService.updateById(examsystemStudentProfile);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] ids){
		examsystemStudentProfileService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
