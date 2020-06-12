package com.chris.examsystem.office.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * examsystem-office-gradeline
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:29:40
 */
@Data
@TableName("examsystem_office_gradeline")
public class ExamsystemOfficeGradelineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
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
	private Long orderId;
	/**
	 * 
	 */
	private Integer sci0Lib1;
	/**
	 * 
	 */
	private Integer gradeline;
	/**
	 * 
	 */
	private String orderName;

}
