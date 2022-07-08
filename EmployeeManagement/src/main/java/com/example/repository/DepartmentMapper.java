package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.Department;
import com.example.domain.user.model.DepartmentSector;

@Mapper
public interface DepartmentMapper {

	/* 部門一覧集計 */
	public List<Department> getDepartments(Department department);

	/** 社員別営業成績一覧 */
	public List<DepartmentSector> getDepartmentSector(@Param("departmentId") Integer departmentId);
}
