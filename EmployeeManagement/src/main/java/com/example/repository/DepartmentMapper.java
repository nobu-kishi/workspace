package com.example.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.Department;
import com.example.domain.user.model.DepartmentSector;

@Mapper
public interface DepartmentMapper {

	/* 部門一覧取得（集計） */
	public List<Department> departmentCount(Department department);

	/** 営業成績取得（部署別） */
	public List<DepartmentSector> departmentsSales(@Param("departmentId") Integer departmentId,
			DepartmentSector dSector);

	/** 全部署従業員売上(全件) */
	public List<DepartmentSector> allSales(DepartmentSector dSector);

	/** 営業成績取得（個人） */
	public DepartmentSector personalSales(@Param("employeeId") Integer employeeId);

	/** 営業成績更新（1件） */
	public void updateSales(@Param("employeeId") Integer employeeId,
			@Param("area") String area,
			@Param("profit") Integer profit,
			@Param("customer") Integer customer,
			@Param("updateTime") Date updateTime);

	/** 営業成績取得（一時保存） */
	public List<DepartmentSector> getTempSales(DepartmentSector dSector);

	/** 一時保存 */
	/*public List<DepartmentSector> getTempSales(DepartmentSector dSector);*/

}
