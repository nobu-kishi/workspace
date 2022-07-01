package com.example.domain.user.model;


import java.util.Date;

import lombok.Data;

@Data
public class Departments {
	private Integer departmentId;
	private String departmentArea;
	private Integer departmentSales;
	private Integer departmentCustomer;
	private Date departmentUpdateTime;
}