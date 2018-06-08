package com.techlab.student.junittest;

import com.techlab.student.Student;
import com.techlab.student.StudentDataStore;
import com.techlab.student.customexception.SearchRecordNotFound;
import com.techlab.student.customexception.StudentNotFound;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class JunitTest {

	private String[] skills = { "Web Design", "Interface Design",
			"Project Direction" };
	private String[] talents = { "HTML5", "CSS3", "javaScript", "jQuery",
			"JAVA", "PHP" };

	@Test
	public void testAddStudentInDataStore() {
		Student student = new Student("Sumit Busa", "sumitbusa@gmail.com",
				"Learner", "Web Developer", "MU", "BEIT", 8097513123l, 7.12f,
				skills, talents, "Miraroad");

		StudentDataStore studentDataStore = new StudentDataStore();
		int prevCount = studentDataStore.countRecords();

		studentDataStore.addStudent(student);
		int newCount = studentDataStore.countRecords();

		assertEquals(prevCount + 1, newCount);
	}

	@Test
	public void testRetriveStudentsListFromDataStore() {
		Student student = new Student("Sumit Busa", "sumitbusa@gmail.com",
				"Learner", "Web Developer", "MU", "BEIT", 8097513123l, 7.12f,
				skills, talents, "Miraroad");

		StudentDataStore studentDataStore = new StudentDataStore();
		studentDataStore.addStudent(student);
		int count = studentDataStore.countRecords();

		Iterable<Student> students;
		students = studentDataStore.retrieve();
		int flagCounter = 0;

		for (@SuppressWarnings("unused")
		Student student2 : students) {
			flagCounter++;
		}
		assertEquals(count, flagCounter);
	}

	@Test(expected = FileNotFoundException.class)
	public void load_shoulThrowExceptionIfFileNotFound()
			throws ClassNotFoundException, IOException {

		StudentDataStore newStudentDataStore = new StudentDataStore();
		newStudentDataStore.load();
	}

	@Test
	public void whetherObjectsLoadAndStore() throws FileNotFoundException,
			IOException, ClassNotFoundException {
		Student student = new Student("Sumit Busa", "sumitbusa@gmail.com",
				"Learner", "Web Developer", "MU", "BEIT", 8097513123l, 7.12f,
				skills, talents, "Miraroad");

		StudentDataStore studentDataStore = new StudentDataStore();
		studentDataStore.addStudent(student);
		int prevCount = studentDataStore.countRecords();

		studentDataStore.store();

		StudentDataStore newStudentDataStore = new StudentDataStore();
		newStudentDataStore.load();
		int newCount = studentDataStore.countRecords();

		assertEquals(prevCount, newCount);
	}

	@Test
	public void testDeleteStudentFromDataRecord() {
		StudentDataStore studentDataStore = new StudentDataStore();
		Student student = new Student("Sumit Busa", "sumitbusa@gmail.com",
				"Learner", "Web Developer", "MU", "BEIT", 8097513123l, 7.12f,
				skills, talents, "Miraroad");
		studentDataStore.addStudent(student);
		int prevCount = studentDataStore.countRecords();
		studentDataStore.removeStudent(student.getRollNo().toString());

		assertEquals(prevCount - 1, studentDataStore.countRecords());
	}

	@Test(expected = StudentNotFound.class)
	public void shoudThrowStudentNotFoundException() {
		StudentDataStore studentDataStore = new StudentDataStore();
		Student student = new Student("Sumit Busa", "sumitbusa@gmail.com",
				"Learner", "Web Developer", "MU", "BEIT", 8097513123l, 7.12f,
				skills, talents, "Miraroad");
		studentDataStore.addStudent(student);
		studentDataStore.removeStudent("2486723523242");
	}

	@Test
	public void testStudentRecordSearch() {
		StudentDataStore studentDataStore = new StudentDataStore();
		Student student1 = new Student("Sumit Busa", "sumitbusa@gmail.com",
				"Learner", "Web Developer", "MU", "BEIT", 8097513123l, 7.12f,
				skills, talents, "Miraroad");
		studentDataStore.addStudent(student1);

		Student student2 = new Student("Santosh Dangodra",
				"santoshdangodra@gmail.com", "Learner", "Web Developer", "MU",
				"BEIT", 7666605343l, 7.12f, skills, talents, "Dahisar");
		studentDataStore.addStudent(student2);

		Student student3 = new Student("Ajit Patel", "ajitpatel@gmail.com",
				"Learner", "Web Developer", "MU", "BEIT", 7555605343l, 7.12f,
				skills, talents, "Malad");
		studentDataStore.addStudent(student3);
		
		int counter = 0;
		for (@SuppressWarnings("unused")
		Student student : studentDataStore.search("S")) {
			counter++;
		}

		assertEquals(2, counter);
	}

	@Test(expected = SearchRecordNotFound.class)
	public void shouldThrowSearchRecordNotFoundException() {
		StudentDataStore studentDataStore = new StudentDataStore();
		Student student1 = new Student("Sumit Busa", "sumitbusa@gmail.com",
				"Learner", "Web Developer", "MU", "BEIT", 8097513123l, 7.12f,
				skills, talents, "Miraroad");
		studentDataStore.addStudent(student1);

		Student student2 = new Student("Santosh Dangodra",
				"santoshdangodra@gmail.com", "Learner", "Web Developer", "MU",
				"BEIT", 7666605343l, 7.12f, skills, talents, "Dahisar");
		studentDataStore.addStudent(student2);

		Student student3 = new Student("Ajit Patel", "ajitpatel@gmail.com",
				"Learner", "Web Developer", "MU", "BEIT", 7555605343l, 7.12f,
				skills, talents, "Malad");
		studentDataStore.addStudent(student3);

		studentDataStore.search("mehta");
	}
}