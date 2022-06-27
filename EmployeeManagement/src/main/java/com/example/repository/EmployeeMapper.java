package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.user.model.Employees;

@Mapper
public interface EmployeeMapper {



	/** ユーザー登録 */
	public int insertOne(Employees employees);

	/*	*//** ユーザー取得 */
	/*
	public List<Employees> findMany(Employees employees);

	*//** ユーザー取得(1件) */
	/*
	public Employees findOne(String employeesId);

	*//** ユーザー更新(1件) */
	/*
	public void updateOne(@Param("employeesId") String employeesId,
	@Param("emp_password") String emp_password,
	@Param("employeesName") String employeesName);

	*//** ユーザー削除(1件) *//*
						public int deleteOne(@Param("employeesId") String employeesId);*/
}
