package com.chris.examsystem.student.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:56
 */
@Data
@TableName("examsystem_student_application")
public class ExamsystemStudentApplicationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long uniId;
	/**
	 * 
	 */
	private String uniName;
	/**
	 * 
	 */
	private Long stuExamId;
	/**
	 * 
	 */
	private String stuName;
	/**
	 * 
	 */
	private Long majorId;
	/**
	 * 
	 */
	private String majorName;
	/**
	 * 
	 */
	private Long orderId;
	/**
	 * 
	 */
	private String orderName;
	/**
	 * 
	 */
	private Long typeId;
	/**
	 * 
	 */
	private String typeName;

}
