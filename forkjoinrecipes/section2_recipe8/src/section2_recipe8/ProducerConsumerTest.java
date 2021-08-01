package section2_recipe8;

import java.util.concurrent.LinkedTransferQueue;

import edu.umd.cs.mtc.MultithreadedTestCase;

public class ProducerConsumerTest extends MultithreadedTestCase {
	
	private LinkedTransferQueue<String> queue;
	
	@Override
	public void initialize() {
		super.initialize();
		queue=new LinkedTransferQueue<String>();
		System.out.printf("Test: The test has been initialized\n");
	}
	
	public void thread1() throws InterruptedException{
		String ret=queue.take();
		System.out.printf("Thread 1: %s\n",ret);
	}
	
	public void thread2() throws InterruptedException{
		waitForTick(1);
		String ret=queue.take();
		System.out.printf("Thread 2: %s\n",ret);
	}
	
	public void thread3() {
		waitForTick(1);
		waitForTick(2);
		queue.put("Event 1");
		queue.put("Event 2");
		System.out.printf("Thread 3: Inserted two elements\n");
	}
	
	public void finish() {
		super.finish();
		System.out.printf("Test: End\n");
		assertEquals(true, queue.size()==0);
		System.out.printf("Test: Result: The queue is empty\n");
	}

}
