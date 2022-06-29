package com.example.form;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeesListForm {
	private Integer employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeePhone;
	private String employeeEmail;
	private Date employeeJoinDate;
}