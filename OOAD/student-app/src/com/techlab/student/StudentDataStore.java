package com.techlab.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.techlab.student.customexception.SearchRecordNotFound;
import com.techlab.student.customexception.StudentNotFound;

public class StudentDataStore {

	private ArrayList<Student> students = new ArrayList<Student>();
	private final static String defaultPath = "src//com//techlab//student//resource//";
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;

	@SuppressWarnings("unchecked")
	public void load() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		objectInputStream = new ObjectInputStream(new FileInputStream(
				defaultPath + "student_data.ser"));
		students = (ArrayList<Student>) objectInputStream.readObject();
		objectInputStream.close();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public Iterable<Student> search(String keyWord) {
		ArrayList<Student> searchRecord = new ArrayList<Student>();
		for (Student stud : students) {
			if (stud.getName().toLowerCase().startsWith(keyWord.toLowerCase())) {
				searchRecord.add(stud);
			}
		}
		if(searchRecord.isEmpty())
			throw new SearchRecordNotFound("No such record match with given '"+keyWord+"' keyword");
		else
			return searchRecord;
	}

	private void removeStudent(Student student) {
		students.remove(student);
	}

	public boolean removeStudent(String id) {
		for (Student stud : students) {
			if (stud.getRollNo().toString().equals(id)) {
				removeStudent(stud);
				return true;
			}
		}
		throw new StudentNotFound("No such student found with id= '"+id+"'");
	}

	public Iterable<Student> retrieve() {
		return students;
	}

	public int countRecords() {
		return students.size();
	}

	public void store() throws FileNotFoundException, IOException {
		objectOutputStream = new ObjectOutputStream(new FileOutputStream(
				defaultPath + "student_data.ser"));
		objectOutputStream.writeObject(students);
		objectOutputStream.close();
	}
}