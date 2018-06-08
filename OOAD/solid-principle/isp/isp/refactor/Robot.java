package isp.refactor;

public class Robot implements IWorkable {

	@Override
	public void startWork() {
		System.out.println("Robot started working.");
	}

	@Override
	public void stopWork() {
		System.out.println("Robot stoped working.");
	}
}