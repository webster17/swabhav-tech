package dip.violation;

public class TaxCalculator {
	private LogType logType;

	public TaxCalculator(LogType logType) {
		this.logType = logType;
	}

	public int calculate(int salary, int r) {
		int c = 0;
		try {
			c = salary / r;
		} catch (Exception e) {
			if (logType == LogType.XML) {
				new XMLLogger().Log(e.getMessage());
			} else if (logType == LogType.CSV) {
				new CSVLogger().Log(e.getMessage());
			}
			throw e;
		}
		return c;
	}
}