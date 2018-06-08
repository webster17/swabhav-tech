package ocp.refactor;

public class FixedDeposit {
	private int accountNo;
	private String name;
	private double principle;
	private int years;
	private IFestivalType festival;

	public FixedDeposit(int accountNo, String name, double principle,
			int years, IFestivalType festival) {
		this.accountNo = accountNo;
		this.principle = principle;
		this.name = name;
		this.years = years;
		this.festival = festival;
	}

	public double calculateTotalIntrest() {
		return principle * years * (festival.getRate()/100);
	}

	public double getPrinciple() {
		return principle;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}
}
