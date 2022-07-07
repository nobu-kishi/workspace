package com.example.form;

import java.util.Date;
import java.util.List;

import com.example.domain.user.model.Department;
import com.example.domain.user.model.Sales;

import lombok.Data;

@Data
public class DepartmentSectorForm {
	/*	private Integer employeeId;
		private String employeePassword;
		private String employeeName;
		private Integer departmentId;
		private List<Sales> salesList;*/

	private Integer employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeePhone;
	private String employeeEmail;
	private Date employeeJoinDate;
	private Boolean employeeExsits;
	private Integer departmentId;
	private List<Department> departmentList;
	private List<Sales> salesList;
}