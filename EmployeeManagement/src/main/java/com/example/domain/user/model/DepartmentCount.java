package com.example.domain.user.model;

import lombok.Data;

@Data
public class DepartmentCount {
	private Integer departmentId;
	private String departmentName;
	private Integer profitCount;
	private Integer customerCount;
	private Integer profitAvg;
}
