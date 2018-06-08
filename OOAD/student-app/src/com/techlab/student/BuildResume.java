package com.techlab.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BuildResume {

	private final static String defaultPath = "src//com//techlab//student//resource//";

	public void autoResumeBuilder(Iterable<Student> students)
			throws IOException {

		BufferedReader bufferReader = new BufferedReader(new FileReader(
				defaultPath + "sample resume//resume.html"));
		String currentLine = "", mainHtmlFileContent = "", htmlFileContent;

		while ((currentLine = bufferReader.readLine()) != null) {
			mainHtmlFileContent = mainHtmlFileContent + currentLine + "\n";
		}
		bufferReader.close();

		for (Student student : students) {
			htmlFileContent = mainHtmlFileContent;
			htmlFileContent = htmlFileContent.replace("$rollNo", student
					.getRollNo().toString());
			htmlFileContent = htmlFileContent.replace("$address",
					student.getAddress());
			htmlFileContent = htmlFileContent.replace("$name",
					student.getName());
			htmlFileContent = htmlFileContent.replace("$designation",
					student.getDesignation());
			htmlFileContent = htmlFileContent.replace("$email",
					student.getEmail());
			htmlFileContent = htmlFileContent.replace("$about",
					student.getAbout());
			htmlFileContent = htmlFileContent.replace("$universityName",
					student.getUniversityName());
			htmlFileContent = htmlFileContent.replace("$qualification",
					student.getQualification());
			htmlFileContent = htmlFileContent.replace("$cgpa",
					Float.toString(student.getCgpa()));
			htmlFileContent = htmlFileContent.replace("$contactNo",
					Long.toString(student.getContactNo()));

			String skills[] = student.getSkills();
			for (int i = 0; i < skills.length; i++) {
				htmlFileContent = htmlFileContent.replace("$skill" + i,
						skills[i]);
			}
			String talents[] = student.getTalents();
			for (int i = 0; i < talents.length; i++) {
				htmlFileContent = htmlFileContent.replace("$talent" + i,
						talents[i]);
			}

			String resumeFileName = student.getName().replace(" ", "-")
					+ ".html";
			FileWriter fileWriter = new FileWriter(defaultPath
					+ "build resume//" + resumeFileName);

			fileWriter.write(htmlFileContent);
			fileWriter.close();
		}
	}
}