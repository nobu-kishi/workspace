package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.domain.user.service.DepartmentService;
import com.example.form.DepartmentBulkForm;

class DepartmentBulkControllerTest {

	// MEMO:疑似的なHTTPリクエスト作成する
	private Mockmvc mockmvc;

	// MEMO:モックとなる元ネタ（サービスクラス）
	@MockBean
	private DepartmentService departmentService;

	@InjectMocks
	private DepartmentBulkController controller;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void completeRegist() {
		DepartmentBulkForm form = new DepartmentBulkForm(new departmentSectorList());
		form.setDepartmentSectorList(departmentSectorList);
	}

}
