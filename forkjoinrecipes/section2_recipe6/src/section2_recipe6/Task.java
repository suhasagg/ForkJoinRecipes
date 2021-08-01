package section2_recipe6;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import section2_recipe6.MyLoggerFactory;

public class Task implements Runnable {
	
	@Override
	public void run() {
		Logger logger=MyLoggerFactory.getLogger(this.getClass().getName());

		logger.entering(Thread.currentThread().getName(), "run()");

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.exiting(Thread.currentThread().getName(), "run()");
	}
}
