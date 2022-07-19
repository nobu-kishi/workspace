package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

//FIXME:salesとEmployeeを連結する処理に直したい・・・
@Data
public class DepartmentSector {
	private Integer employeeId;
	private String employeeName;
	private Boolean employeeNotExsits;
	private String area;
	private Integer profit;
	private Integer customer;
	private Date updateTime;
	private Boolean hasTempData;
	private String departmentId;
	private String departmentName;
}