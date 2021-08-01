package section1_recipe10;

public class Sensor1 implements Runnable {
	
	private final ParkingCounter counter;
	
	public Sensor1(ParkingCounter counter) {
		this.counter=counter;
	}
	
	@Override
	public void run() {
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carOut();
		counter.carOut();
		counter.carOut();
		counter.carIn();
		counter.carIn();
		counter.carIn();
	}

}
