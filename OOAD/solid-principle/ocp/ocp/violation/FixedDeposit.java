package ocp.violation;

public class FixedDeposit {
	private int accountNo;
	private String name;
	private double principle;
	private int years;
	private FestivalType festival;
	
	public FixedDeposit(int accountNo, String name, double principle, int years, FestivalType festival){
		this.accountNo=accountNo;
		this.principle=principle;
		this.name=name;
		this.years=years;
		this.festival=festival;
	}
	
	private float getRate(){
		if(festival == FestivalType.NEW_YEAR)
			return(8f);
		else if(festival == FestivalType.HOLI)
			return (8.5f);
		else if (festival==FestivalType.NORMAL)
			return(7f);
		else
			return(6f);
	}
	
	public double calculateTotalIntrest(){
		return principle*years*(getRate()/100);
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