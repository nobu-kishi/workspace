package com.example.form;

import java.util.Date;

import lombok.Data;

@Data
public class UserListForm {
	 private String userId;
	 private String password;
	 private String userName;
	 private Date birthday;
	 private Integer age;
	 private Integer gender;
	}
