package com.example.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

	//TODO:画面上に自動採番した値を出したい
	/*@NotNull(groups = ValidGroup1.class)*/
	private Integer employeeId;

	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 4, max = 100, groups = ValidGroup2.class)
	/*@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)*/
	private String employeePassword;

	@NotBlank(groups = ValidGroup1.class)
	private String employeeName;

	@NotBlank(groups = ValidGroup1.class)
	private String employeePhone;

	@Email(groups = ValidGroup2.class)
	private String employeeEmail;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull(groups = ValidGroup1.class)
	private Date employeeJoinDate;
}