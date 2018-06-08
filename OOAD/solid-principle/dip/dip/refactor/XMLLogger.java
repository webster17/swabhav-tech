package dip.refactor;

public class XMLLogger implements ILoggable {

	@Override
	public void Log(String errorMessage) {
		System.out.println("Log Writing into XML...");
		System.out.println(errorMessage);
		System.out.println("Log written successfully");
	}
}