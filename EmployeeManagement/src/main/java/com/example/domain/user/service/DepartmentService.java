package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.Department;

public interface DepartmentService {

	/* 部門別集計 */
	public List<Department> getDepartments(Department department);

	/** 社員別営業成績一覧 *//*
					public Employees getDepartmentSector(Integer departmentId);*/
}
