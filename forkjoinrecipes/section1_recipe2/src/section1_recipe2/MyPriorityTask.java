package section1_recipe2;

import java.util.concurrent.TimeUnit;

public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {
	
	private int priority;
	
	private String name;
	
	public MyPriorityTask(String name, int priority) {
		this.name=name;
		this.priority=priority;
	}
	
	public int getPriority() {
		return priority;
	}
	
	@Override
	public int compareTo(MyPriorityTask o) {
		return Integer.compare(o.getPriority(), this.getPriority());
	}
	
	@Override
	public void run() {
		System.out.printf("MyPriorityTask: %s Priority : %d\n",name,priority);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}	
	}

}
