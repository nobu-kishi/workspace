package com.example.domain.user.model;

import java.util.List;

import lombok.Data;

@Data
public class DepartmentSector {
	private Integer departmentId;
	private String departmentName;
	private List<Sales> salesList;
}
