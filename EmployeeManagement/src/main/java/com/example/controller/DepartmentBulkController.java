package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.DepartmentSector;
import com.example.domain.user.service.DepartmentService;
import com.example.form.DepartmentBulkForm;

@Controller
@RequestMapping("/department")
public class DepartmentBulkController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private ModelMapper modelMapper;

	/** 退職処理 */
	@GetMapping("/bulk")
	public String departmentsSales(@ModelAttribute DepartmentBulkForm form, Model model) {
		System.out.println("一時保存データ読込");

		//部門毎に従業員を抽出
		DepartmentSector dSector = modelMapper.map(form, DepartmentSector.class);
		List<DepartmentSector> departmentList = departmentService.tempSales(dSector);


		System.out.println("フォーム出力値");
		System.out.println(departmentList);

		model.addAttribute("departmentList", departmentList);
		return "department/bulk";
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
