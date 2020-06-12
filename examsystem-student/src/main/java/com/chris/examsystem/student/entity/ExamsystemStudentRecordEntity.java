package com.chris.examsystem.student.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * examsystem-student-record
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:57
 */
@Data
@TableName("examsystem_student_record")
public class ExamsystemStudentRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long stuExamId;
	/**
	 * 
	 */
	private Long appId;
	/**
	 * 
	 */
	private Long gradeId;
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
	private Long universityId;
	/**
	 * 
	 */
	private String universityName;

}
