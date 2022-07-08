package com.example.form;

import java.util.Date;

import lombok.Data;

@Data
public class DepartmentEditForm {
	private Integer employeeId;
	private String employeeName;
	private String area;
	private Integer profit;
	private Integer customer;
	private Date updateTime;
}