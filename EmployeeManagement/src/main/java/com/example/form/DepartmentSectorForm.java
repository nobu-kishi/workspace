package com.example.form;

import java.util.Date;

import lombok.Data;

@Data
public class DepartmentSectorForm {
	private Integer employeeId;
	private String employeeName;
	private Boolean employeeNotExsits;
	private String area;
	private Integer profit;
	private Integer customer;
	private Date updateTime;
	private Boolean hasTempData;
	/*private String departmentId;*/
	private String departmentName;
}