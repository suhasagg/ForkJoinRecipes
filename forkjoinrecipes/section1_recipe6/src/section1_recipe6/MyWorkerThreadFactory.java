package section1_recipe6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;

public class MyWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
	
	@Override
	public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
		return new MyWorkerThread(pool);
	}
}
