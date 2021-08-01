package section2_recipe9;

import java.util.Date;

public class Task implements Runnable {
	
	@Override
	public void run() {
		Date start, end;

		start = new Date();

		do {
			System.out.printf("%s: tick\n", Thread.currentThread().getName());
			end = new Date();
		} while (end.getTime() - start.getTime() < 100000);
	}

}
