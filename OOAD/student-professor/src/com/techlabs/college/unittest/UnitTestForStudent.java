package com.techlabs.college.unittest;

import com.techlabs.college.exception.AgeLimitException;
import com.techlabs.college.person.student.Branch;
import com.techlabs.college.person.student.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTestForStudent {

	@Test
	public void testGettersofStudent() throws ParseException {
		Student student = new Student("Santosh Dangodra", "Dahisar",
				new SimpleDateFormat("dd/MM/yyyy").parse("30/11/1995"),
				Branch.INFORMATION_TECHNOLOGY);

		assertEquals("Santosh Dangodra", student.getName());
		assertEquals("Dahisar", student.getAddress());
		assertEquals("30/11/1995", student.getDOB());
		assertEquals(Branch.INFORMATION_TECHNOLOGY, student.getBranch());
		assertEquals(22, student.getAge());
		assertNotNull(student.getId());
	}

	@Test
	public void testSettersOfStudent() throws ParseException {
		Student student = new Student("Santosh Dangodra", "Dahisar",
				new SimpleDateFormat("dd/MM/yyyy").parse("30/11/1995"),
				Branch.INFORMATION_TECHNOLOGY);
		student.setName("Dangodra Santosh");
		student.setAddress("Malad");
		student.setDOB(new SimpleDateFormat("dd/MM/yyyy").parse("5/6/1996"));
		student.setBranch(Branch.COMPUTER);

		assertEquals("Dangodra Santosh", student.getName());
		assertEquals("Malad", student.getAddress());
		assertEquals("05/06/1996", student.getDOB());
		assertEquals(Branch.COMPUTER, student.getBranch());
	}

	@Test(expected=AgeLimitException.class)
	public void setDOB_ThrowExceptionIfAgeLessThan15() throws ParseException {
		new Student("Santosh Dangodra", "Dahisar", new SimpleDateFormat(
				"dd/MM/yyyy").parse("30/11/2005"), Branch.CIVIL);
	}
}
