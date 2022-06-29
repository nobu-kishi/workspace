package com.example.domain.user.service;

import java.util.Date;
import java.util.List;

import com.example.domain.user.model.Employees;

public interface EmployeesService {

	/** ユーザー登録 */
	public void signup(Employees employees);

	//TODO
	/** ユーザー取得 */
	public List<Employees> getEmployees(Employees employees);

	/** ユーザー取得(1件) */
	public Employees getfindOne(Integer employeeId);

	/** ユーザー更新(1件) */
	public void updateOne(Integer employeeId,
			String employeePassword,
			String employeeName,
			String employeePhone,
			String employeeEmail,
			Date employeeJoinDate);

	/** ユーザー削除(1件) */
	public void deleteOne(Integer employeeId);
}
