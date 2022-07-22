package com.example.domain.user.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class DepartmentBulk {
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