package com.techlabs.buildresume;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ResumeBuilder {
	private String name, designation, email, about, universityName,
			qualification;
	private float cgpa;
	private String[] skills, talents;
	private long contactNo;
	private final String defaultPath = "assignment-3//com//techlabs//buildresume//";

	ResumeBuilder(String name, String email, String about, String designation,
			String universityName, String qualification, long contactNo,
			float cgpa, String[] skills, String[] talents) {
		this.name = name;
		this.designation = designation;
		this.email = email;
		this.about = about;
		this.universityName = universityName;
		this.qualification = qualification;
		this.cgpa = cgpa;
		this.contactNo = contactNo;
		this.skills = skills;
		this.talents = talents;
	}

	public void buildResume() throws IOException {
		BufferedReader bufferReader = new BufferedReader(new FileReader(defaultPath + "resume.html"));
		String currentLine = "", htmlFileContent = "";

		while ((currentLine = bufferReader.readLine()) != null) {
			htmlFileContent = htmlFileContent + currentLine + "\n";
		}

		htmlFileContent = htmlFileContent.replace("$name", name);
		htmlFileContent = htmlFileContent.replace("$designation", designation);
		htmlFileContent = htmlFileContent.replace("$email", email);
		htmlFileContent = htmlFileContent.replace("$about", about);
		htmlFileContent = htmlFileContent.replace("$universityName", universityName);
		htmlFileContent = htmlFileContent.replace("$qualification",	qualification);
		htmlFileContent = htmlFileContent.replace("$cgpa", Float.toString(cgpa));
		htmlFileContent = htmlFileContent.replace("$contactNo",	Long.toString(contactNo));
		for (int i = 0; i < skills.length; i++) {
			htmlFileContent = htmlFileContent.replace("$skill" + i, skills[i]);
		}
		for (int i = 0; i < talents.length; i++) {
			htmlFileContent = htmlFileContent.replace("$talent" + i, talents[i]);
		}

		String resumeFileName = name.replace(" ", "-") + ".html";
		FileWriter fileWriter = new FileWriter(defaultPath + resumeFileName);
		fileWriter.write(htmlFileContent);
		fileWriter.close();
		bufferReader.close();
	}
}
