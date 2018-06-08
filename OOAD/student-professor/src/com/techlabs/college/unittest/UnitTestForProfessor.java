package com.techlabs.college.unittest;

import com.techlabs.college.exception.AgeLimitException;
import com.techlabs.college.exception.MinimumSalaryException;
import com.techlabs.college.person.professor.Professor;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTestForProfessor {

	@Test
	public void testGettersOfProffessor() throws ParseException {
		Professor professor = new Professor("Vishal Badgujar", "Thane",
				new SimpleDateFormat("dd/MM/yyyy").parse("31/5/1978"), 10000);

		assertEquals("Vishal Badgujar", professor.getName());
		assertEquals("Thane", professor.getAddress());
		assertEquals("31/05/1978", professor.getDOB());
		assertEquals(10000, professor.getBasicSalary());
		assertEquals(39, professor.getAge());
		assertNotNull(professor.getId());
	}

	@Test
	public void testSettersOfProffessor() throws ParseException {
		Professor professor = new Professor("Vishal Badgujar", "Thane",
				new SimpleDateFormat("dd/MM/yyyy").parse("31/5/1978"), 10000);

		professor.setName("Badgujar Vishal");
		professor.setAddress("Malad");
		professor.setDOB(new SimpleDateFormat("dd/MM/yyyy").parse("5/6/1977"));
		professor.setBasicSalary(20000);

		assertEquals("Badgujar Vishal", professor.getName());
		assertEquals("Malad", professor.getAddress());
		assertEquals("05/06/1977", professor.getDOB());
		assertEquals(20000, professor.getBasicSalary());
	}

	@Test
	public void testCalculatedSalary() throws ParseException {
		Professor professor = new Professor("Vishal Badgujar", "Thane",
				new SimpleDateFormat("dd/MM/yyyy").parse("31/5/1978"), 20000);

		assertEquals(23000, professor.calculateSalary());
	}

	@Test(expected = MinimumSalaryException.class)
	public void setBasicSalary_ThrowExceptionIfSalaryLessThan10k()
			throws ParseException {
		new Professor("Vishal Badgujar", "Thane", new SimpleDateFormat(
				"dd/MM/yyyy").parse("31/5/1978"), 9000);
	}

	@Test(expected = AgeLimitException.class)
	public void setDOB_ThrowExceptionIfageLessThan30() throws ParseException {
		new Professor("Vishal Badgujar", "Thane", new SimpleDateFormat(
				"dd/MM/yyyy").parse("31/5/1989"), 10000);
	}
}
