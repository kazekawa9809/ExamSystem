package com.chris.examsystem.university.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * examsystem-university-college
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:25:34
 */
@Data
@TableName("examsystem_university_college")
public class ExamsystemUniversityCollegeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long universityId;
	/**
	 * 
	 */
	private String universityName;
	/**
	 * 
	 */
	private Long provinceId;
	/**
	 * 
	 */
	private String provinceName;

}
