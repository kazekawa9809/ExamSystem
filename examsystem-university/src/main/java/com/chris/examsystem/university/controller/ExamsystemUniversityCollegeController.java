package com.chris.examsystem.university.controller;

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

import com.chris.examsystem.university.entity.ExamsystemUniversityCollegeEntity;
import com.chris.examsystem.university.service.ExamsystemUniversityCollegeService;




/**
 * examsystem-university-college
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:25:34
 */
@RestController
@RequestMapping("university/examsystem/university/college")
public class ExamsystemUniversityCollegeController {
    @Autowired
    private ExamsystemUniversityCollegeService examsystemUniversityCollegeService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = examsystemUniversityCollegeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")

    public R info(@PathVariable("id") Long id){
		ExamsystemUniversityCollegeEntity examsystemUniversityCollege = examsystemUniversityCollegeService.getById(id);

        return R.ok().put("examsystemUniversityCollege", examsystemUniversityCollege);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody ExamsystemUniversityCollegeEntity examsystemUniversityCollege){
		examsystemUniversityCollegeService.save(examsystemUniversityCollege);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody ExamsystemUniversityCollegeEntity examsystemUniversityCollege){
		examsystemUniversityCollegeService.updateById(examsystemUniversityCollege);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] ids){
		examsystemUniversityCollegeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
