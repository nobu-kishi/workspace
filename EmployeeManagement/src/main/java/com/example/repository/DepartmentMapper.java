package com.example.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.Department;
import com.example.domain.user.model.DepartmentSector;

@Mapper
public interface DepartmentMapper {

	/* 部門一覧集計 */
	public List<Department> getDepartments(Department department);

	/** 部署別従業員売上（複数） */
	public List<DepartmentSector> departmentsSales(@Param("departmentId") Integer employeeId,
			DepartmentSector dSector);

	/** 部署別従業員売上(1件) */
	public DepartmentSector personalSales(@Param("employeeId") Integer employeeId);

	/** 全部署従業員売上(全件) */
	public List<DepartmentSector> allSales(DepartmentSector dSector);

	/** 売上更新(1件) */
	public void updateSales(@Param("employeeId" ) Integer employeeId,
			@Param("area") String area,
			@Param("profit") Integer profit,
			@Param("customer") Integer customer,
			@Param("updateTime") Date updateTime);
}
