package com.example.controller;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.DepartmentSector;
import com.example.domain.user.service.DepartmentService;
import com.example.form.DepartmentEditForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/department")
@Slf4j
public class DepartmentEditController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private ModelMapper modelMapper;

	/** 編集画面を表示 */

	@GetMapping("/employee/{employeeId:.+}")
	public String getEmployees(DepartmentEditForm form, Model model,
			@PathVariable("employeeId") Integer employeeId) {
		System.out.println("編集画面表示開始");
		DepartmentSector dSector = departmentService.personalSales(employeeId);
		System.out.println("SQL抽出結果");
		System.out.println(dSector);
		form = modelMapper.map(dSector, DepartmentEditForm.class);

		model.addAttribute("DepartmentEditForm", form);
		System.out.println("Form出力値");

		System.out.println(form);
		return "department/employee";
	}

	/** ユーザー更新処理 */
	@PostMapping(value = "/employee", params = "update")
	public String updateEmployees(DepartmentEditForm form, Model model) {
		System.out.println("更新処理開始");

		/*Calendar calendar = Calendar.getInstance();*/
		/*form.setUpdateTime(calendar.getTime());*/
		Date nowDate = new Date();
		form.setUpdateTime(nowDate);

		try {
			departmentService.updateSales(form.getEmployeeId(),
					form.getArea(),
					form.getProfit(),
					form.getCustomer(),
					form.getUpdateTime());

		} catch (Exception e) {
			log.error("社員情報更新でエラー", e);
		}
		return "redirect:/department";
	}
}