package section2_recipe1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Task implements Runnable {
	
	private final Lock lock;
	
	public Task(Lock lock) {
		this.lock=lock;
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			lock.lock();
			System.out.printf("%s: Get the Lock.\n",Thread.currentThread().getName());

			try {
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.printf("%s: Free the Lock.\n",Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

}
