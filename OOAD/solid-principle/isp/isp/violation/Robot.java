package isp.violation;

public class Robot implements IWorker {

	@Override
	public void startWork() {
		System.out.println("Robot started working.");
	}

	@Override
	public void stopWork() {
		System.out.println("Robot stoped working.");
	}

	@Override
	public void startEat() {
		throw new EatingException("Robot can not start eating.");
	}

	@Override
	public void stopEat() {
		throw new EatingException("Robot can not stop eating.");
	}
}