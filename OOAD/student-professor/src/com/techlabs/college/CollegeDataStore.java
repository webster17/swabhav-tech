package com.techlabs.college;

import com.techlabs.college.exception.PersonNotFoundException;
import com.techlabs.college.person.professor.Professor;
import com.techlabs.college.person.student.Student;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CollegeDataStore {

	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Professor> professors = new ArrayList<Professor>();
	private static final String defaultPath = "src//com//techlabs//college/resources//";
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	@SuppressWarnings("unchecked")
	public void DataImporter() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		objectInputStream = new ObjectInputStream(new FileInputStream(
				defaultPath + "students_data.ser"));
		students = (ArrayList<Student>) objectInputStream.readObject();

		objectInputStream = new ObjectInputStream(new FileInputStream(
				defaultPath + "professors_data.ser"));
		professors = (ArrayList<Professor>) objectInputStream.readObject();

		objectInputStream.close();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void addProfessor(Professor professor) {
		professors.add(professor);
	}

	private void removeStudent(Student student) {
		students.remove(student);
	}

	private void removeProfessor(Professor professor) {
		students.remove(professor);
	}

	public boolean removeStudent(String id) {
		for (Student student : students) {
			if (student.getId().toString().equals(id)) {
				removeStudent(student);
				return true;
			}
		}
		throw new PersonNotFoundException("No such student found with id= '"
				+ id + "'");
	}

	public boolean removeProfesssor(String id) {
		for (Professor professor : professors) {
			if (professor.getId().toString().equals(id)) {
				removeProfessor(professor);
				return true;
			}
		}
		throw new PersonNotFoundException("No such professor found with id= '"
				+ id + "'");
	}

	public int getStudentCount() {
		return students.size();
	}

	public int getProfessorCount() {
		return professors.size();
	}

	public Iterable<Student> getStudents() {
		return students;
	}

	public Iterable<Professor> getProfessors() {
		return professors;
	}

	public void DataExporter() throws FileNotFoundException, IOException {
		objectOutputStream = new ObjectOutputStream(new FileOutputStream(
				defaultPath + "students_data.ser"));
		objectOutputStream.writeObject(students);

		objectOutputStream = new ObjectOutputStream(new FileOutputStream(
				defaultPath + "professors_data.ser"));
		objectOutputStream.writeObject(professors);
		objectOutputStream.close();
	}
}