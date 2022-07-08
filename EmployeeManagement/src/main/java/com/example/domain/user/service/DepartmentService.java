package com.example.domain.user.service;

import java.util.Date;
import java.util.List;

import com.example.domain.user.model.Department;
import com.example.domain.user.model.DepartmentSector;

public interface DepartmentService {

	/* 部門別集計 */
	public List<Department> getDepartments(Department department);

	/** 社員別営業成績一覧 */
	public List<DepartmentSector> departmentsSales(Integer departmentId, DepartmentSector dSector);

	/** 個人売上(1件) */
	public DepartmentSector personalSales(Integer employeeId);

	/** 全部署従業員売上(全件) */
	public List<DepartmentSector> allSales(DepartmentSector dSector);

	/** 売上更新(1件) */
	public void updateSales(Integer employeeId,
			String area,
			Integer profit,
			Integer customer,
			Date updateTime);

}
