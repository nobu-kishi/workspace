package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Employees;
import com.example.domain.user.service.EmployeesService;
import com.example.form.EmployeesEditForm;
import com.example.form.EmployeesListForm;

@Controller
@RequestMapping("/employee")
public class EmployeesListController {

	@Autowired
	private EmployeesService employeesService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/list")
	public String getEmployeesList(@ModelAttribute EmployeesListForm form, Model model) {
		Employees employees = modelMapper.map(form, Employees.class);
		List<Employees> employeesList = employeesService.getEmployees(employees);
		model.addAttribute("employeesList", employeesList);
		return "employee/list";
	}

	/* 社員検索 */
	@PostMapping(value = "/list"/*, params = "serch"*/)
	public String postEmployeesList(@ModelAttribute EmployeesListForm form, Model model) {
		Employees employees = modelMapper.map(form, Employees.class);
		List<Employees> employeesList = employeesService.getEmployees(employees);
		model.addAttribute("employeesList", employeesList);
		System.out.println("社員検索開始");
		return "employee/list";
	}

	/*ページ遷移*/
	/*	@PostMapping(value="",params="")
		public String getEmployees(EmployeesEditForm form, Model model,
				@PathVariable("employeeId") Integer employeeId) {

			return "redirect:/employee/list";
		}*/

	/** ユーザー削除処理 */
	@PostMapping(value = "/list", params = "delete")
	public String deleteEmployees(EmployeesEditForm form, Model model) {
		employeesService.deleteOne(form.getEmployeeId());
		return "redirect:/employee/list";
	}
}