package com.example.form;

import java.util.Date;

import lombok.Data;

@Data
public class UserListForm {
	 private String emp_id;
	 private String emp_password;
	 private String emp_name;
	 private Date emp_join_date;
	 private Integer age;
	 private Integer gender;
	}
