package com.example.domain.user.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	public List<Department> departmentCount(Department department) {
		return mapper.departmentCount(department);
	}

	/** 社員別営業成績一覧 */
	@Override
	public List<DepartmentSector> departmentsSales(Integer departmentId, DepartmentSector dSector) {
		return mapper.departmentsSales(departmentId, dSector);
	}

	/** 個人売上(1件) */
	@Override
	public DepartmentSector personalSales(@Param("employeeId") Integer employeeId) {
		return mapper.personalSales(employeeId);
	}

	/** 全部署従業員売上(全件) */
	@Override
	public List<DepartmentSector> allSales(DepartmentSector dSector) {
		return mapper.allSales(dSector);

	}

	/** 営業成績更新（1件） */
	@Override
	public void updateSales(Integer employeeId,
			String area,
			Integer profit,
			Integer customer,
			Date updateTime) {
		mapper.updateSales(employeeId, area, profit, customer, updateTime);
	}

	/** 営業成績取得（一時保存） */
	@Override
	public List<DepartmentSector> tempSales(DepartmentSector dSector) {
		return mapper.tempSales(dSector);
	}
}
