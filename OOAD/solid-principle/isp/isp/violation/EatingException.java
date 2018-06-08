package isp.violation;

@SuppressWarnings("serial")
public class EatingException extends RuntimeException {
	public EatingException(String errorMessage) {
		super(errorMessage);
	}
}