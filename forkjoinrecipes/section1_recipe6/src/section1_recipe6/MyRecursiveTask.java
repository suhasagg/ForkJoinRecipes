package section1_recipe6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class MyRecursiveTask extends RecursiveTask<Integer> {
	
	private int array[];
	
	private int start, end;
	
	public MyRecursiveTask(int array[],int start, int end) {
		this.array=array;
		this.start=start;
		this.end=end;
	}
	
	@Override
	protected Integer compute() {
		Integer ret;
		MyWorkerThread thread=(MyWorkerThread)Thread.currentThread();
		thread.addTask();
		
		if (end-start>100) {
			int mid=(start+end)/2;
			MyRecursiveTask task1=new MyRecursiveTask(array,start,mid);
			MyRecursiveTask task2=new MyRecursiveTask(array,mid,end);
			invokeAll(task1,task2);
			ret=addResults(task1,task2);
		} else {
			int add=0;
			for (int i=start; i<end; i++) {
				add+=array[i];
			}
			ret=add;
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	private Integer addResults(MyRecursiveTask task1, MyRecursiveTask task2) {
		int value;
		try {
			value = task1.get().intValue()+task2.get().intValue();
		} catch (InterruptedException e) {
			e.printStackTrace();
			value=0;
		} catch (ExecutionException e) {
			e.printStackTrace();
			value=0;
		}
		return value;
	}

}
