package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentBulkRestController {

	@Autowired
	private DepartmentService departmentService;

	/** 退職処理 */
	/*	@PutMapping("/retire/{employeeId:.+}")
		public int updateEmployees(DepartmentSectorForm form, Model model,
				@PathVariable("employeeId") Integer employeeId) {
			System.out.println("退職処理開始");
			employeesService.retireOne(employeeId);
			return 0;
		}
	*/
	/** 【見本】ユーザーを更新 */
	/*	@PutMapping("/update")
		public int updateUser(UserDetailForm form) {

			// ユーザーを更新
			userService.updateUserOne(form.getUserId(),
					form.getPassword(),
					form.getUserName());
			return 0;
		}*/
}
