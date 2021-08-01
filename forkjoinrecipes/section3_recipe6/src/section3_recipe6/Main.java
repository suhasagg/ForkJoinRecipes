package section3_recipe6;

import java.util.concurrent.locks.ReentrantLock;

import section3_recipe6.Task;

public class Main {
	public static void main(String[] args) {
		
		ReentrantLock lock=new ReentrantLock();
		for (int i=0; i<10; i++) {
			Task task=new Task(lock);
			Thread thread=new Thread(task);
			thread.start();
		}		
	}
}
