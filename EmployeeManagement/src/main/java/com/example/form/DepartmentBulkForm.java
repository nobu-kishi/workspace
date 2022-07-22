package com.example.form;

import java.util.Date;
import java.util.List;

import com.example.domain.user.model.DepartmentSector;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentBulkForm {
	private Integer employeeId;
	private String employeeName;
	private Boolean employeeNotExsits;
	private String area;
	private Integer profit;
	private Integer customer;
	private Date updateTime;
	private Boolean hasTempData;
	private Integer departmentId;
	private String departmentName;
	private List<DepartmentSector> departmentSectorList;
}