package com.example.form;

import java.util.Date;

import lombok.Data;

@Data
public class DepartmentBulkForm {
	private Integer employeeId;
	private String employeeName;
	private Boolean employeeNotExsits;
	private String area;
	private Integer profit;
	private Integer customer;
	private Date updateTime;
	private Boolean hasTempData;
	private Integer departmentId;
	private String departmentName;
}