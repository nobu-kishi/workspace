package com.example.form;

import lombok.Data;

@Data
public class DepartmentListForm {
	private Integer departmentId;
	private String departmentName;
	private Integer profitCount;
	private Integer customerCount;
	private Integer profitAvg;
}