package com.techlabs.buildresume;

import java.io.IOException;

public class BuildResumeTest {
	public static void main(String args[]) throws IOException {
		String[] skills = { "Web Design", "Interface Design",
				"Project Direction" };
		String[] talents = { "HTML5", "CSS3", "javaScript", "jQuery", "JAVA",
				"PHP" };
		ResumeBuilder resumeBuilder = new ResumeBuilder(
				"Santosh Rajpoot",
				"santoshdangodra@gmail.com",
				"Progressively evolve cross-platform ideas before impactful infomediaries. Energistically visualize tactical initiatives before cross-media catalysts for change.",
				"Web Designer",
				" Mumbai University (A.P. Shah Institute of Technology, Thane)",
				"BE in Information Technology", 7666605343l,
				7.12f, skills, talents);
		resumeBuilder.buildResume();
		System.out.println("Successfully Resume built.");
	}
}
