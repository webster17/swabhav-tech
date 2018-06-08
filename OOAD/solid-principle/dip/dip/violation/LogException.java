package dip.violation;

@SuppressWarnings("serial")
public class LogException extends RuntimeException {
	public LogException(String errorMessage) {
		super(errorMessage);
	}
}