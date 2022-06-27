package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class Employees {
	private int emp_id;
	private String emp_password;
	private String emp_name;
	private String emp_phone;
	private String emp_email;
	private Date emp_join_date;
}


