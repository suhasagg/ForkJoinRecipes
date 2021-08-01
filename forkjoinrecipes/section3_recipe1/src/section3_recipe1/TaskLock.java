package section3_recipe1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskLock implements Runnable {
	
	private int number;
	private Lock lock;
	
	public TaskLock() {
		this.lock=new ReentrantLock();
	}
	
	@Override
	public void run() {
		for(int i=0; i<1000000; i++) {
			lock.lock();
			number=i;
			lock.unlock();
		}
	}

}
