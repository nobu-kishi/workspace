package com.example.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeesEditForm {
	private Integer employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeePhone;
	private String employeeEmail;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	/*	@JsonFormat(pattern = "yyyy/MM/dd")*/
	private Date employeeJoinDate;
}