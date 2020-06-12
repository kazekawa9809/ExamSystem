package com.chris.examsystem.student.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * examsystem-student-grade
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 09:38:58
 */
@Data
@TableName("examsystem_student_grade")
public class ExamsystemStudentGradeEntity implements Serializable {
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
	private BigDecimal science;
	/**
	 * 
	 */
	private BigDecimal liberal;
	/**
	 * 
	 */
	private BigDecimal chinese;
	/**
	 * 
	 */
	private BigDecimal math;
	/**
	 * 
	 */
	private BigDecimal engilist;
	/**
	 * 
	 */
	private Integer sciStatus;
	/**
	 * 
	 */
	private Integer libStatus;
	/**
	 * 
	 */
	private Long gradeId;

}
