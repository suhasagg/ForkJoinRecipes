package section1_recipe2;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import section1_recipe2.MyPriorityTask;

public class Main {
	public static void main(String[] args) {
		
		ThreadPoolExecutor executor=new ThreadPoolExecutor(4,4,1,TimeUnit.SECONDS,new PriorityBlockingQueue<Runnable>());
		
		for (int i=0; i<10; i++){
			MyPriorityTask task=new MyPriorityTask("Task "+i,i);
			executor.execute(task);
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i=10; i<20; i++) {
			MyPriorityTask task=new MyPriorityTask("Task "+i,i);
			executor.execute(task);			
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: End of the program.\n");
		
	}

}
