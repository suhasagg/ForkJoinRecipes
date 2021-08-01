package section1_recipe7;

import java.util.concurrent.ForkJoinPool;

import section1_recipe7.Task;

public class Main {

	public static void main(String[] args) throws Exception {
		
		int array[]=new int[10000];
		
		ForkJoinPool pool=new ForkJoinPool();

		Task task=new Task("Task",array,0,array.length);
	
		pool.invoke(task);

		pool.shutdown();
		
		System.out.printf("Main: End of the program.\n");
		
	}
}
