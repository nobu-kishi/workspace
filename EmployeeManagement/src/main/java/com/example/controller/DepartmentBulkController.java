package com.example.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.service.DepartmentService;
import com.example.form.DepartmentBulkForm;

@Controller
@RequestMapping("/department")
public class DepartmentBulkController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private ModelMapper modelMapper;

	/** 初期画面表示 */
	@GetMapping("/bulk")
	public String getDepartments(@ModelAttribute("form") DepartmentBulkForm form, Model model, Locale locale) {
		System.out.println("一時保存データ読込");

		// stream練習用
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		integerList.stream() // streamの取得
				.filter(i -> i % 2 == 0) // 中間操作
				.forEach(i -> System.out.println(i)); // 終端操作

		//		//部門毎に従業員を抽出
		//		DepartmentSector dSector = modelMapper.map(form, DepartmentSector.class);
		//		List<DepartmentSector> departmentList = departmentService.getTempSales(dSector);
		//
		//		System.out.println("フォーム出力値");
		//		System.out.println(departmentList);
		//
		/*form.setDepartmentSectorList(departmentList);*/
		//		model.addAttribute("departmentList", departmentList);

		/* MEMO:
		 * 		jsで値をセットしているため、java上は値がnullとなる
		 * 		js or javaでmodelattributeしないと、バインドできない
		 *
		 * */

		/*form.setDepartmentSectorList(form.getDepartmentSectorList());
		System.out.println(form);*/

		return "department/bulk";
	}

	@PostMapping("/bulk")
	public String completeRegist(@Validated @ModelAttribute("form") DepartmentBulkForm form, Model model, Locale locale,
			BindingResult bindingResult) {
		System.out.println("ポスト処理");
		/*	List<DepartmentSectorForm> departmentSectorForm = new ArrayList<DepartmentSectorForm>();*/

		/*いらないかも modelattributeしているからいらないかも*/
		model.addAttribute("form", form);

		if (bindingResult.hasErrors()) {
			System.out.println("更新でエラー");
			/*List<String> errorList = new ArrayList<String>();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}*/
			//			boolean isError = errorList.size() > 0 ? true : false;
			//			model.addAttribute("isError", isError);
			/*//			model.addAttribute("errorList", errorList);
			*/ //			model.addAttribute("mode", "update");
			/*return getDepartments(form, model, locale);*/
			return "department/bulk";
		}

		System.out.println("formの値確認");
		System.out.println(form);

		// stream練習用
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		integerList.stream() // streamの取得
				.filter(i -> i % 2 == 0) // 中間操作
				.forEach(i -> System.out.println(i)); // 終端操作

		System.out.println("従業員登録");
		System.out.println(form.getDepartmentSectorList());
		departmentService.employeesBulk(form.getDepartmentSectorList());
		System.out.println("売上登録");
		departmentService.depeartmentsBulk(form.getDepartmentSectorList());

		/*try {
			departmentService.employeesBulk(form.getDepartmentSectorList());
			departmentService.depeartmentsBulk(form.getDepartmentSectorList());
		} catch (Exception e) {
			log.error("一括登録でエラー", e);
		}*/
		return "redirect:/department";
	}
}
