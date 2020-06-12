package com.chris.examsystem.university.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * examsystem-university-plan
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:25:34
 */
@Data
@TableName("examsystem_university_plan")
public class ExamsystemUniversityPlanEntity implements Serializable {
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
	private Integer planNum;
	/**
	 * 
	 */
	private BigDecimal planRadio;
	/**
	 * 
	 */
	private Long provinceId;
	/**
	 * 
	 */
	private String provinceName;
	/**
	 * 
	 */
	private Long typeId;
	/**
	 * 
	 */
	private String typeName;
	/**
	 * 
	 */
	private Long majorId;
	/**
	 * 
	 */
	private String majorName;

}
