package com.example.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {


	//TODO
	@NotNull(groups = ValidGroup1.class)
	private int emp_id;

	@NotBlank(groups = ValidGroup1.class)
	/*@Length(min = 4, max = 100, groups = ValidGroup2.class)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)*/
	private String emp_password;

	@NotBlank(groups = ValidGroup1.class)
	private String emp_name;

	@NotBlank(groups = ValidGroup1.class)
	private String emp_phone;

	@Email(groups = ValidGroup2.class)
	private String emp_email;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull(groups = ValidGroup1.class)
	private Date emp_join_date;
}