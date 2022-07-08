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

	@GetMapping("/sector/{departmentId:.+}")
	public String getDepartmentSector(@ModelAttribute DepartmentSectorForm form, Model model,
			@PathVariable("departmentId") Integer departmentId) {
		System.out.println("個人一覧取得開始");

		//部門毎に従業員を抽出
		List<DepartmentSector> departmentSectorList = departmentService.getDepartmentSector(departmentId);
		System.out.println("SQL抽出");
		System.out.println(departmentSectorList);
		form = modelMapper.map(departmentSectorList, DepartmentSectorForm.class);
		System.out.println("フォーム出力値");
		System.out.println(departmentSectorList.get(1));


		/*Employees test = employeesList.get(1);*/
		/*System.out.println(test);*/

		//型変換
		/*Employees employees = modelMapper.map(form, Employees.class);*/


		/*form.setSalesList(employeesList.getSalesList());*/

		/*form.setSalesList(employees.getSalesList());*/

		//TODO:Forで値をセットする
		/*form.setSalesList(employeesList.get(0).getSalesList());
		*/


		/*System.out.println(employeesList.get(0).getSalesList());*/

		model.addAttribute("departmentSectorForm", form);
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