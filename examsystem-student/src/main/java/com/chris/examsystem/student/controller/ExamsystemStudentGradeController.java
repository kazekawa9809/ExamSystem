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

import com.chris.examsystem.student.entity.ExamsystemStudentGradeEntity;
import com.chris.examsystem.student.service.ExamsystemStudentGradeService;




/**
 * examsystem-student-grade
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:58
 */
@RestController
@RequestMapping("student/examsystem/student/grade")
public class ExamsystemStudentGradeController {
    @Autowired
    private ExamsystemStudentGradeService examsystemStudentGradeService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = examsystemStudentGradeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")

    public R info(@PathVariable("id") Long id){
		ExamsystemStudentGradeEntity examsystemStudentGrade = examsystemStudentGradeService.getById(id);

        return R.ok().put("examsystemStudentGrade", examsystemStudentGrade);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody ExamsystemStudentGradeEntity examsystemStudentGrade){
		examsystemStudentGradeService.save(examsystemStudentGrade);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody ExamsystemStudentGradeEntity examsystemStudentGrade){
		examsystemStudentGradeService.updateById(examsystemStudentGrade);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] ids){
		examsystemStudentGradeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
