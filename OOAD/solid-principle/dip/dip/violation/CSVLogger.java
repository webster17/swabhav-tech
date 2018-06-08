package dip.violation;

public class CSVLogger {
	
	public void Log(String errorMessage) {
		System.out.println("Log Writing into CSV...");
		System.out.println(errorMessage);
		System.out.println("Log written successfully");
	}
}