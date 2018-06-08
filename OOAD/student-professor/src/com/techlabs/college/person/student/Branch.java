package com.techlabs.college.person.student;

public enum Branch {
	COMPUTER, INFORMATION_TECHNOLOGY, CIVIL, MECHANICAL, ELECTRONICS, ELECTRICAL;

	public String toString() {
		switch (this) {
		case COMPUTER:
			return "Computer";
		case INFORMATION_TECHNOLOGY:
			return "Information Technology";
		case CIVIL:
			return "Civil";
		case MECHANICAL:
			return "Mechanical";
		case ELECTRONICS:
			return "Electronics";
		case ELECTRICAL:
			return "Electrical";
		default:
			return "Unspecified";
		}
	}
}
