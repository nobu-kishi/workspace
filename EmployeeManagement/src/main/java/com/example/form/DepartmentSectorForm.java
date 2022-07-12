package com.example.form;

import java.util.Date;

import lombok.Data;

@Data
public class DepartmentSectorForm {
	private Integer employeeId;
	private String employeeName;
	private Boolean employeeExsits;
	private String area;
	private Integer profit;
	private Integer customer;
	private Date updateTime;
}