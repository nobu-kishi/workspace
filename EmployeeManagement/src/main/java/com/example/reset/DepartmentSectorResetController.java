package com.example.reset;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.user.service.EmployeesService;
import com.example.form.DepartmentSectorForm;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentSectorResetController {

	@Autowired
	private EmployeesService employeesService;

	/*	*//** 退職処理 */
	@PutMapping("retire")
	public String updateEmployees(DepartmentSectorForm form, Model model) {
		System.out.println("退職処理開始");

		Calendar calendar = Calendar.getInstance();
		form.setUpdateTime(calendar.getTime());
		Date nowDate = new Date();
		form.setUpdateTime(nowDate);

		try {
			//FormからEmployeeIdを取得したい
			employeesService.updateSales(form.getEmployeeId());

		} catch (Exception e) {
			log.error("退職処理でエラー", e);
		}
		return "redirect:/department";
	}


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
