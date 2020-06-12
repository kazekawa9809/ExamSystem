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

import com.chris.examsystem.university.entity.ExamsystemUniversityOfficeEntity;
import com.chris.examsystem.university.service.ExamsystemUniversityOfficeService;




/**
 * examsystem-university-office
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:25:34
 */
@RestController
@RequestMapping("university/examsystem/university/office")
public class ExamsystemUniversityOfficeController {
    @Autowired
    private ExamsystemUniversityOfficeService examsystemUniversityOfficeService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = examsystemUniversityOfficeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")

    public R info(@PathVariable("id") Long id){
		ExamsystemUniversityOfficeEntity examsystemUniversityOffice = examsystemUniversityOfficeService.getById(id);

        return R.ok().put("examsystemUniversityOffice", examsystemUniversityOffice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody ExamsystemUniversityOfficeEntity examsystemUniversityOffice){
		examsystemUniversityOfficeService.save(examsystemUniversityOffice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody ExamsystemUniversityOfficeEntity examsystemUniversityOffice){
		examsystemUniversityOfficeService.updateById(examsystemUniversityOffice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] ids){
		examsystemUniversityOfficeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
