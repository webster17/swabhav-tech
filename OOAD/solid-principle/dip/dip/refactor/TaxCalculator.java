package dip.refactor;

public class TaxCalculator {
	private ILoggable iLoggable;

	public TaxCalculator(ILoggable iLoggable) {
		this.iLoggable = iLoggable;
	}

	public int calculate(int salary, int r) {
		int c = 0;
		try {
			c = salary / r;
		} catch (Exception e) {
			iLoggable.Log(e.getMessage());
			throw e;
		}
		return c;
	}
}