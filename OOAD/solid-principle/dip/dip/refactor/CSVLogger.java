package dip.refactor;

public class CSVLogger implements ILoggable {

	@Override
	public void Log(String errorMessage) {
		System.out.println("Log Writing into CSV...");
		System.out.println(errorMessage);
		System.out.println("Log written successfully");
	}
}