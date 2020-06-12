package com.chris.examsystem.student.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * examsystem-student-profile
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:58
 */
@Data
@TableName("examsystem_student_profile")
public class ExamsystemStudentProfileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String stuName;
	/**
	 * 
	 */
	private Long stuId;
	/**
	 * 
	 */
	private Long stuPsw;
	/**
	 * 
	 */
	private String province;
	/**
	 * 
	 */
	private Long stuExamId;

}
