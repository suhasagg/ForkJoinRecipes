package section2_recipe6;

import java.util.logging.Level;
import java.util.logging.Logger;

import section2_recipe6.MyLoggerFactory;
import section2_recipe6.Task;

public class Main {
	public static void main(String[] args) {
		
		Logger logger=MyLoggerFactory.getLogger(Main.class.getName());
		
		logger.entering(Main.class.getName(), "main()",args);

		Thread threads[]=new Thread[5];
		for (int i=0; i<threads.length; i++) {
			logger.log(Level.INFO,"Launching thread: "+i);
			Task task=new Task();
			threads[i]=new Thread(task);
			logger.log(Level.INFO,"Thread created: "+threads[i].getName());
			threads[i].start();
		}
		
		logger.log(Level.INFO,"Ten Threads created. Waiting for its finalization");
		
		for (int i=0; i<threads.length; i++) {
			try {
				threads[i].join();
				logger.log(Level.INFO,"Thread has finished its execution",threads[i]);
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, "Exception", e);
			}
		}

		logger.exiting(Main.class.getName(), "main()");
	}
}
