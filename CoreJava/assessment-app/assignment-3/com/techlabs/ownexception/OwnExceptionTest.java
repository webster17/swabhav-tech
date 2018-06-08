package com.techlabs.ownexception;

public class OwnExceptionTest {

	public static void main(String args[]) {
		int num1 = 12, num2 = 15;
		float result;

		result = num1 / num2;
		if (result < 0.99) {
			throw new OwnException("Result is less than 1");
		}
	}
}
