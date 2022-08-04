package com.example.controller;

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

import com.example.domain.user.model.Employees;
import com.example.domain.user.service.EmployeesService;
import com.example.form.EmployeesSignupForm;
import com.example.form.GroupOrder;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeeSignupController {

	@Autowired
	private EmployeesService EmployeesService;

	@Autowired
	private ModelMapper modelMapper;

	//社員登録画面を表示する
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale,
			@ModelAttribute EmployeesSignupForm form) {
		return "employee/signup";
	}

	/** ユーザー登録処理 */
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale,
			@ModelAttribute @Validated(GroupOrder.class) EmployeesSignupForm form,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			System.out.println("社員登録でエラー");
			System.out.println(form);
			return getSignup(model, locale, form);
		}
		log.info(form.toString());

		// Emploeesに型変換して登録
		Employees employees = modelMapper.map(form, Employees.class);
		EmployeesService.signup(employees);

		System.out.println("社員登録成功");
		System.out.println(form);
		return "redirect:/employee/list";
	}
}
