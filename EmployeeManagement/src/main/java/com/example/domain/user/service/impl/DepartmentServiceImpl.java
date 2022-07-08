package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.Department;
import com.example.domain.user.model.DepartmentSector;
import com.example.domain.user.service.DepartmentService;
import com.example.repository.DepartmentMapper;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper mapper;

	/* 部門別集計 */
	@Override
	public List<Department> getDepartments(Department department) {
		return mapper.getDepartments(department);
	}

	/** 社員別営業成績一覧 */
	@Override
	public List<DepartmentSector> getDepartmentSector(Integer departmentId) {
		return mapper.getDepartmentSector(departmentId);
	}


	/*	@Override
		public List<DepartmentSector> getDepartmentSector(Integer departmentId) {
			return mapper.getDepartmentSector(departmentId);
		}*/
}
