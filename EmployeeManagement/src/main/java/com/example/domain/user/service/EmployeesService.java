package com.example.domain.user.service;

import com.example.domain.user.model.Employees;

public interface EmployeesService {

	/** ユーザー登録 */
	public void signup(Employees employees);

	//TODO
	/** ユーザー取得 */
	/*	public List<Employees> getUsers(Employees employees);

		*//** ユーザー取得(1件) */
	/*
	public Employees getUserOne(String employeesId);

	*//** ユーザー更新(1件) */
	/*
	public void updateUserOne(String employeesId,
	String emp_password,
	String employeesName);

	*//** ユーザー削除(1件) *//*
						public void deleteUserOne(String employeesId);*/
}
