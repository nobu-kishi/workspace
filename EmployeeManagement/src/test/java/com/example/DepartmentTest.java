package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.domain.user.model.Department;

public class DepartmentTest {

	private Department dept = new Department();

	@Test
	public void testHashCode() {
		fail("まだ実装されていません"); // TODO
	}

	@Test
	public void testGetDepartmentId() {
		dept.setDepartmentId(-2147483648);
		assertTrue(dept.getDepartmentId() instanceof Integer);
		/*dept.getDepartmentId("100");*/
	}

	@Test
	public void testGetDepartmentName() {
		dept.setDepartmentName("123456789012345678901234567890");
		assertTrue(dept.getDepartmentName() instanceof String);
	}

	@Test
	public void testSetDepartmentId() {
		fail("まだ実装されていません"); // TODO
	}

	@Test
	public void testSetDepartmentName() {
		fail("まだ実装されていません"); // TODO
	}

	@Test
	public void testEqualsObject() {
		fail("まだ実装されていません"); // TODO
	}

	@Test
	public void testCanEqual() {
		fail("まだ実装されていません"); // TODO
	}

	@Test
	public void testToString() {
		fail("まだ実装されていません"); // TODO
	}

	@Test
	public void testDepartment() {
		fail("まだ実装されていません"); // TODO
	}

}
