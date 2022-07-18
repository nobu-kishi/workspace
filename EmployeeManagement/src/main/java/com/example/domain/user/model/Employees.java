package com.example.domain.user.model;


import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Employees {
	private Integer employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeePhone;
	private String employeeEmail;
	private Date employeeJoinDate;
	private Boolean employeeNotExsits;
	private Integer departmentId;
	private List<Department> departmentList;
	private List<Sales> salesList;
}