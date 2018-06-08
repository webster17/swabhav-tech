package ocp.violation;

public enum FestivalType {
	NEW_YEAR, HOLI, NORMAL;
	
	public float getRate() {
		switch(this){
			case NEW_YEAR:
				return 8f;
			case HOLI:
				return 8.5f;
			case NORMAL:
				return 7f;
			default:
				return 6.5f;
		}
	}
}
