package com.jpa.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jpa.dao.EmpDeptDao;
import com.jpa.entity.Department;
import com.jpa.entity.Employee;

public class TestEmpDept {

	private static EmpDeptDao dao;

	@BeforeAll
	public static void init() {
		dao = new EmpDeptDao();

	}

	@Test
	public void testSaveDept() {
		Department d = new Department(50, "IT", "cdc");
		assertNotNull(dao.saveDept(d));

	}

	@Test
	public void testSaveDeptWithEmps() {
		Department d = new Department(60, "Marketing", "Kolkata");

		Employee e1 = new Employee(601, "Nik", "Manager", 8600);
		Employee e2 = new Employee(602, "Ben", "Clerk", 6300);

		e1.setDept(d);
		e2.setDept(d);

		d.getEmps().add(e1);
		d.getEmps().add(e2);

		assertNotNull(dao.saveDept(d));

	}

	@Test
	public void testSaveEmp() {
		Employee e = new Employee(50, "mike", "IT", 4500);
		assertNotNull(dao.saveEmp(e, 50));

	}

	@Test
	public void testfindDept() {
		Department d = dao.findDept(50);
		assertNotNull(d);
		System.out.println(d);

		List<Employee> emp = d.getEmps();
		emp.forEach(System.out::println);
	}
	@Test
	public void testDeleteDept() {
		
		assertTrue(dao.deleteDept(50));
		
	}

}
