package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.DepartmentSector;
import com.example.domain.user.service.DepartmentService;
import com.example.form.DepartmentSectorForm;

@Controller
@RequestMapping("/department")
public class DepartmentSectorController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private ModelMapper modelMapper;

	/*	@GetMapping("/sector}")
		public String departmentsSales(@ModelAttribute DepartmentSectorForm form, Model model) {
			System.out.println("全社員一覧取得開始");

			//部門毎に従業員を抽出
			DepartmentSector dSector = modelMapper.map(form, DepartmentSector.class);
			List<DepartmentSector> departmentSectorList = departmentService.allSales(dSector);

			System.out.println("フォーム出力値");
			System.out.println(departmentSectorList);

			model.addAttribute("departmentSectorList", departmentSectorList);
			return "department/sector";
		}*/

	@GetMapping("/sector/{departmentId:.+}")
	public String departmentsSales(@ModelAttribute DepartmentSectorForm form, Model model,
			@PathVariable("departmentId") Integer departmentId) {
		System.out.println("個人一覧取得開始");

		//部門毎に従業員を抽出
		DepartmentSector dSector = modelMapper.map(form, DepartmentSector.class);
		List<DepartmentSector> departmentSectorList = departmentService.departmentsSales(departmentId, dSector);

		System.out.println("フォーム出力値");
		System.out.println(departmentSectorList);

		model.addAttribute("departmentSectorList", departmentSectorList);
		return "department/sector";
	}

	/*	 社員検索
		@PostMapping(value = "/list")
		public String postEmployeesList(@ModelAttribute EmployeesListForm form, Model model) {
			Employees employees = modelMapper.map(form, Employees.class);
			List<Employees> employeesList = employeesService.getEmployees(employees);
			model.addAttribute("employeesList", employeesList);
			System.out.println("社員検索開始");
			return "employee/list";
		}

		*//** ユーザー削除処理 *//*
							@GetMapping(value = "/delete/{employeeId:.+}")
							public String deleteEmployees(EmployeesEditForm form, Model model,
							@PathVariable("employeeId") Integer employeeId) {
							employeesService.deleteOne(form.getEmployeeId());
							return "redirect:/employee/list";
							}*/
}