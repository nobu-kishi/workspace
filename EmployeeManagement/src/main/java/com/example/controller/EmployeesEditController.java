package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Employees;
import com.example.domain.user.service.EmployeesService;
import com.example.form.EmployeesEditForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeesEditController {

	@Autowired
	private EmployeesService employeesService;
	@Autowired
	private ModelMapper modelMapper;

	/** 編集画面を表示 */
	@GetMapping("/edit/{employeeId:.+}")
	public String getEmployees(EmployeesEditForm form, Model model,
			@PathVariable("employeeId") Integer employeeId) {
		System.out.println("編集画面Debag");
		System.out.println(employeesService.getfindOne(employeeId));
		Employees employees = employeesService.getfindOne(employeeId);
		employees.setEmployeePassword(null);
		form = modelMapper.map(employees, EmployeesEditForm.class);
		model.addAttribute("EmployeesEditForm", form);
		return "employee/edit";
	}

	/** ユーザー更新処理 */
	@PostMapping(value = "/edit", params = "update")
	public String updateEmployees(EmployeesEditForm form, Model model) {
		System.out.println("更新処理開始");
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");*/
		try {
			employeesService.updateOne(form.getEmployeeId(),
					form.getEmployeePassword(),
					form.getEmployeeName(),
					form.getEmployeePhone(),
					form.getEmployeeEmail()
			/*form.getEmployeeJoinDate()*/
			);
		} catch (Exception e) {
			log.error("社員情報更新でエラー", e);
		}
		return "redirect:/employee/list";
	}

	/*	*//** ユーザー削除処理 */
	@PostMapping(value = "/edit", params = "delete")
	public String deleteEmployees(EmployeesEditForm form, Model model) {
		employeesService.deleteOne(form.getEmployeeId());
		return "redirect:/employee/list";
	}
}