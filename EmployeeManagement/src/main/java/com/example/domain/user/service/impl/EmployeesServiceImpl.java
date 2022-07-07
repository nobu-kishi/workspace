package com.example.domain.user.service.impl;

import java.util.List;

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

	/** ユーザー複数取得 */
	@Override
	public List<Employees> getEmployees(Employees employees) {
		return mapper.findMany(employees);
	}

	/** ユーザー取得(1件) */
	@Override
	public Employees getfindOne(Integer employeeId) {
		return mapper.findOne(employeeId);
	}

	/** ユーザー更新(1件) */
	@Override
	public void updateOne(Integer employeeId,
			String employeePassword,
			String employeeName,
			String employeePhone,
			String employeeEmail
	/*Date employeeJoinDate*/) {
		mapper.updateOne(employeeId, employeePassword, employeeName, employeePhone,
				employeeEmail/*, employeeJoinDate*/);
	}

	/** ユーザー削除(1件) */
	@Override
	public void deleteOne(Integer employeeId) {
		int count = mapper.deleteOne(employeeId);
	}

	/* 部門別集計 */
	/*	@Override
		public List<Department> getDepartments(Department department) {
			return mapper.getDepartments(department);
		}*/

	/** 社員別営業成績一覧 */
	@Override
	public List<Employees> getDepartmentSector(Integer departmentId) {
		return mapper.getDepartmentSector(departmentId);
	}
}
