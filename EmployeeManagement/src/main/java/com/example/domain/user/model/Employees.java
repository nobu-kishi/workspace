package com.example.domain.user.model;


import java.util.Date;

import lombok.Data;

@Data
public class Employees {
	private Integer employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeePhone;
	private String employeeEmail;
	private Date employeeJoinDate;
}