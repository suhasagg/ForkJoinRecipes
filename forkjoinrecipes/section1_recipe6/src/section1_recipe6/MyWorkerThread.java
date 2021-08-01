package section1_recipe6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class MyWorkerThread extends ForkJoinWorkerThread {
	
	private final static ThreadLocal<Integer> taskCounter=new ThreadLocal<>();

	protected MyWorkerThread(ForkJoinPool pool) {
		super(pool);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		System.out.printf("MyWorkerThread %d: Initializing task counter.\n",getId());
		taskCounter.set(0);
	}
	
	@Override
	protected void onTermination(Throwable exception) {
		System.out.printf("MyWorkerThread %d: %d\n",getId(),taskCounter.get());
		super.onTermination(exception);
	}
	
	public void addTask() {
		taskCounter.set(taskCounter.get() + 1);;
	}

}
