package com.example.form;

import java.util.Date;
import java.util.List;

import com.example.domain.user.model.Department;

import lombok.Data;

@Data
public class EmployeesListForm {
	private Integer employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeePhone;
	private String employeeEmail;
	private Date employeeJoinDate;
	private List<Department> departmenstList;
}