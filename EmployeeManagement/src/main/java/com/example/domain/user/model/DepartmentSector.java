package com.example.domain.user.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//FIXME:salesとEmployeeを連結する処理に直したい・・・
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentSector {
	private Integer employeeId;
	private String employeeName;
	private Boolean employeeNotExsits;
	private String area;
	private Integer profit;
	private Integer customer;
	private Date updateTime;
	private String departmentId;
	private String departmentName;
}