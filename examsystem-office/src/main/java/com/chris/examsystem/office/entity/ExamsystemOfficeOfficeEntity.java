package com.chris.examsystem.office.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * examsystem-office-office
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-12 10:29:40
 */
@Data
@TableName("examsystem_office_office")
public class ExamsystemOfficeOfficeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long officeId;
	/**
	 * 
	 */
	private String offcePsw;

}
