package com.techlabs.array;

public class MultipleUrls {
	public static void main(String urls[]) {
		String domain, studentName;
		if (urls.length == 0)
			System.out.println("Please pass Arguments...");
		else {
			for (String url : urls) {
				domain = url.substring(url.indexOf('.') + 1, url.lastIndexOf('.'));
				if (domain.length() <= 0)
					System.out.println("Domain name is: Not Found");
				else
					System.out.println("Domain name is: " + domain);

				studentName = url.substring(url.indexOf('=') + 1);
				if (studentName.length() <= 0)
					System.out.println("Argument name is: Not Found");
				else
					System.out.println("Argument name is: " + studentName + "\n");
			}
		}
	}
}