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

import com.chris.examsystem.office.entity.ExamsystemOfficeOfficeEntity;
import com.chris.examsystem.office.service.ExamsystemOfficeOfficeService;



/**
 * examsystem-office-office
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:29:40
 */
@RestController
@RequestMapping("office/examsystem/office/office")
public class ExamsystemOfficeOfficeController {
    @Autowired
    private ExamsystemOfficeOfficeService examsystemOfficeOfficeService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = examsystemOfficeOfficeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")

    public R info(@PathVariable("id") Long id){
		ExamsystemOfficeOfficeEntity examsystemOfficeOffice = examsystemOfficeOfficeService.getById(id);

        return R.ok().put("examsystemOfficeOffice", examsystemOfficeOffice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody ExamsystemOfficeOfficeEntity examsystemOfficeOffice){
		examsystemOfficeOfficeService.save(examsystemOfficeOffice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody ExamsystemOfficeOfficeEntity examsystemOfficeOffice){
		examsystemOfficeOfficeService.updateById(examsystemOfficeOffice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] ids){
		examsystemOfficeOfficeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
