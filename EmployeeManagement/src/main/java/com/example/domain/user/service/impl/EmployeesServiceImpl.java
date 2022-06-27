package com.example.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.Employees;
import com.example.domain.user.service.EmployeesService;
import com.example.repository.EmployeeMapper;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeeMapper mapper;

	/** ユーザー登録 */
	@Override
	public void signup(Employees employees) {
		mapper.insertOne(employees);
	}


	//TODO
	/** ユーザー取得 */
	/*
	@Override
	public List<Employees> getUsers(Employees employee) {
	return mapper.findMany(employee);
	}

	*//** ユーザー取得(1件) */
	/*
	@Override
	public Employees getUserOne(String employeeId) {
	return mapper.findOne(employeeId);
	}

	*//** ユーザー更新(1件) */
	/*
	@Transactional
	@Override
	public void updateUserOne(String employeeId,
	String emp_password,
	String employeeName) {
	mapper.updateOne(employeeId, emp_password, employeeName);

	// 例外を発生させる
	int i = 1 / 0;
	}

	*//** ユーザー削除(1件) *//*
						@Override
						public void deleteUserOne(String employeeId) {
						int count = mapper.deleteOne(employeeId);
						}*/
}
