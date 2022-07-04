package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Employees;
import com.example.domain.user.service.EmployeesService;
import com.example.form.DepartmentListForm;

@Controller
@RequestMapping("/employee")
public class DepartmentListController {

	@Autowired
	private EmployeesService employeesService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/department")
	public String getDepartment(@ModelAttribute DepartmentListForm form, Model model) {
		Employees employees = modelMapper.map(form, Employees.class);
		System.out.println("部署一覧表示");
		List<Employees> departmentList = employeesService.salesCount(employees);
		model.addAttribute("departmentList", departmentList);
		System.out.println(departmentList);
		return "employee/department";
	}

	/* 社員検索 */
	/*	@PostMapping(value = "/list")
		public String postEmployeesList(@ModelAttribute EmployeesListForm form, Model model) {
			Employees employees = modelMapper.map(form, Employees.class);
			List<Employees> employeesList = employeesService.getEmployees(employees);
			model.addAttribute("employeesList", employeesList);
			System.out.println("社員検索開始");
			return "employee/list";
		}*/

}