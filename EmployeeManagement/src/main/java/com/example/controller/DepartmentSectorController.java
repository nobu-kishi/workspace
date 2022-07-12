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

	@GetMapping("/sector")
	public String departmentsSales(@ModelAttribute DepartmentSectorForm form, Model model) {
		System.out.println("全社員一覧取得開始");

		//部門毎に従業員を抽出
		DepartmentSector dSector = modelMapper.map(form, DepartmentSector.class);
		List<DepartmentSector> departmentList = departmentService.allSales(dSector);

		System.out.println("フォーム出力値");
		System.out.println(departmentList);

		model.addAttribute("departmentList", departmentList);
		return "department/sector";
	}

	@GetMapping("/sector/{departmentId:.+}")
	public String departmentsSales(@ModelAttribute DepartmentSectorForm form, Model model,
			@PathVariable("departmentId") Integer departmentId) {
		System.out.println("個人一覧取得開始");

		//部門毎に従業員を抽出
		DepartmentSector dSector = modelMapper.map(form, DepartmentSector.class);
		List<DepartmentSector> departmentList = departmentService.departmentsSales(departmentId, dSector);

		System.out.println("フォーム出力値");
		System.out.println(departmentList);

		model.addAttribute("departmentList", departmentList);
		return "department/sector";
	}

	/** ユーザー更新処理 */
	/*	@PostMapping("/sector/{departmentId:.+}")
		public String updateEmployees(DepartmentEditForm form, Model model) {
			System.out.println("更新処理開始");

			Calendar calendar = Calendar.getInstance();
			form.setUpdateTime(calendar.getTime());
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
		}*/
}