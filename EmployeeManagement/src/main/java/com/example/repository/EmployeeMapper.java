package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.Employees;

@Mapper
public interface EmployeeMapper {

	/** ユーザー登録 */
	public int insertOne(Employees employees);

	/** ユーザー複数取得 */
	public List<Employees> findMany(Employees employees);

	/** ユーザー取得(1件) */
	public Employees findOne(Integer employeeId);

	/** ユーザー更新(1件) */
	public void updateOne(@Param("employeeId" ) Integer employeeId,
			@Param("employeePassword") String employeePassword,
			@Param("employeeName") String employeeName,
			@Param("employeePhone") String employeePhone,
			@Param("employeeEmail") String employeeEmail);

	/** ユーザー削除(1件) */
	public int deleteOne(@Param("employeeId") Integer employeeId);

	/* 部門一覧取得（集計） */
	/*public List<Department> departmentCount(Department department);*/

	/** 社員別営業成績一覧 */
	/*public List<Employees> departmentsSales(@Param("departmentId") Integer departmentId);*/

	public void retireOne(@Param("employeeId" ) Integer employeeId);
}
