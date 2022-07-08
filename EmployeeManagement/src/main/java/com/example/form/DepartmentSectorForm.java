package com.example.form;

import java.util.Date;

import lombok.Data;

@Data
public class DepartmentSectorForm {
	/*	private Integer employeeId;
		private String employeePassword;
		private String employeeName;
		private Integer departmentId;
		private List<Sales> salesList;*/

	/*	private Integer employeeId;
		private String employeePassword;
		private String employeeName;
		private String employeePhone;
		private String employeeEmail;
		private Date employeeJoinDate;
		private Boolean employeeExsits;
		private Integer departmentId;
		private List<Department> departmentList;
		private List<Sales> salesList;*/

	private Integer employeeId;
	private String employeeName;
	private String area;
	private Integer profit;
	private Integer customer;
	private Date updateTime;
}