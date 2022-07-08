package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Department;
import com.example.domain.user.service.DepartmentService;
import com.example.form.DepartmentListForm;

@Controller
@RequestMapping("/department")
public class DepartmentListController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public String getDepartmentList(@ModelAttribute DepartmentListForm form, Model model) {
		System.out.println("部署一覧表示");
		Department department = modelMapper.map(form, Department.class);
		List<Department> departmentList = departmentService.getDepartments(department);
		System.out.println(departmentList);
		model.addAttribute("departmentList", departmentList);
		return "department/department";
	}



}