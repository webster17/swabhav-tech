package com.techlab.student.customexception;

@SuppressWarnings("serial")
public class SearchRecordNotFound extends RuntimeException {
	public SearchRecordNotFound(String s) {
		super(s);
	}
}
