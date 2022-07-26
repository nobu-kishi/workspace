package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	/** 初期画面表示 */
	@GetMapping("/bulk")
	public String departmentsSales(@ModelAttribute /*("form")*/ DepartmentBulkForm form, Model model) {
		System.out.println("一時保存データ読込");

		//部門毎に従業員を抽出
		DepartmentSector dSector = modelMapper.map(form, DepartmentSector.class);
		List<DepartmentSector> departmentList = departmentService.getTempSales(dSector);

		System.out.println("フォーム出力値");
		System.out.println(departmentList);

		/*form.setDepartmentSectorList(departmentList);*/
		model.addAttribute("departmentList", departmentList);

		return "department/bulk";
	}

	@PostMapping(value = "/bulk/signup", params = "tmpsaves")
	public String tmpSaves(@ModelAttribute("form") DepartmentBulkForm form, Model model, BindingResult result) {

		/*List<DepartmentSectorForm> departmentSectorForm = new ArrayList<DepartmentSectorForm>();*/

		/*いらないかも modelattributeしているからいらないかも*/
		model.addAttribute("departmentBulkForm", form);


		if (result.hasErrors()) {
			System.out.println("更新でエラー");
			return "department/bulk";

		}

		System.out.println("formの値確認");
		System.out.println(form);
		/*DepartmentSector dSector = modelMapper.map(form, DepartmentSector.class);*/
		/*System.out.println(dSector);*/

		/*	System.out.println("セクター型に変換");
			DepartmentSector departmentSector = modelMapper.map(form, DepartmentSector.class);
			System.out.println(departmentSector);*/

		System.out.println("送信処理");
		/*System.out.println(form.getDepartmentSectorList().get(0).getEmployeeId());*/
		System.out.println(form.getDepartmentSectorList());


		/*try {
			departmentService.updateSales(form.getEmployeeId(),
					form.getArea(),
					form.getProfit(),
					form.getCustomer(),
					form.getUpdateTime());

		} catch (Exception e) {
			log.error("社員情報更新でエラー", e);
		}*/


		/*departmentService.tempSaves(form.getDepartmentSectorList());*/
		/*一時保存*/
		/*TODO:リストでformの値を受け取る⇒
		 *
		 *
		 *
		 *
		 * Service.tempSaves(form.List<DepartmentSector>)
		*/

		/*model.addAttribute("departmentBulkForm", form);*/

		/*List<DepartmentBulk> dBulkList = new ArrayList<DepartmentBulk>();
		dBulkList.add(e);
		personList.add(person1);*/

		return "redirect:/department/bulk";
	}
}
