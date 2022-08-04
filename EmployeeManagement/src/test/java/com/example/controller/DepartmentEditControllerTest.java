package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.domain.user.service.DepartmentService;
import com.example.form.DepartmentEditForm;

class DepartmentEditControllerTest {

	// MEMO:疑似的なHTTPリクエスト作成する
	private MockMvc mockmvc;

	// MEMO:モックとなる元ネタ（サービスクラス）
	@MockBean
	private DepartmentService departmentService;

	@InjectMocks
	private DepartmentEditController controller;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

//	@Test
//	void testGetEmployees() {
//		fail("まだ実装されていません");
//	}


	@Test
	void testUpdateEmployees() throws Exception {
		// サービスクラスのモックを作成
		// 参考:https://confrage.jp/spring-boot%E3%81%A7mockito%E3%82%92%E4%BD%BF%E3%81%A3%E3%81%A6%E3%83%86%E3%82%B9%E3%83%88%E3%81%99%E3%82%8B/
		DepartmentEditForm form = new DepartmentEditForm();
		form.setEmployeeId(1);
		form.setArea("新宿");
		form.setProfit(1000);
		form.setCustomer(10);
		Date nowDate = new Date();
		form.setUpdateTime(nowDate);

		System.out.println(form.getEmployeeId());
		System.out.println(form.getArea());
		System.out.println(form.getProfit());
		System.out.println(form.getCustomer());
		System.out.println(form.getUpdateTime());

		Mockito.doNothing().when(departmentService).updateSales(form.getEmployeeId(), form.getArea(), form.getProfit(),
				form.getCustomer(), form.getUpdateTime());

		// コントローラーにリクエストを送信
//		MvcResult result =
				mockmvc.perform(post("/department/employee")).andExpect(status().isOk()) // Httpステータスの検査
				.andExpect(view().name("/department/sector")) // 次に表示すべきView名の検査
				.andReturn();

		/*
		 * DepartmentEditForm actualForm = (DepartmentEditForm)
		 *
		 * result.getModelAndView().getModel().get("DepartmentEditForm");
		 * assertEquals(actualForm.getEmployeeId(), form.getEmployeeId());
		 * assertEquals(actualForm.getArea(), form.getArea());
		 * assertEquals(actualForm.getProfit(), form.getProfit());
		 * assertEquals(actualForm.getCustomer(), form.getCustomer());
		 * assertEquals(actualForm.getUpdateTime(), form.getUpdateTime());
		 */
	}

}
