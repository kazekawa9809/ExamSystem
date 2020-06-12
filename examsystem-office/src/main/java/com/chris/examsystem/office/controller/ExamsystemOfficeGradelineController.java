package com.chris.examsystem.office.controller;

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

import com.chris.examsystem.office.entity.ExamsystemOfficeGradelineEntity;
import com.chris.examsystem.office.service.ExamsystemOfficeGradelineService;




/**
 * examsystem-office-gradeline
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:29:40
 */
@RestController
@RequestMapping("office/examsystem/office/gradeline")
public class ExamsystemOfficeGradelineController {
    @Autowired
    private ExamsystemOfficeGradelineService examsystemOfficeGradelineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = examsystemOfficeGradelineService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ExamsystemOfficeGradelineEntity examsystemOfficeGradeline = examsystemOfficeGradelineService.getById(id);

        return R.ok().put("examsystemOfficeGradeline", examsystemOfficeGradeline);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExamsystemOfficeGradelineEntity examsystemOfficeGradeline){
		examsystemOfficeGradelineService.save(examsystemOfficeGradeline);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ExamsystemOfficeGradelineEntity examsystemOfficeGradeline){
		examsystemOfficeGradelineService.updateById(examsystemOfficeGradeline);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		examsystemOfficeGradelineService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
