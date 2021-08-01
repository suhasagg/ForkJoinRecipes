package section3_recipe4;

import section3_recipe4.Task;

public class Main {
	public static void main(String[] args) {
		
		for (int i=0; i<20; i++){
			Task task=new Task();
			Thread thread=new Thread(task);
			thread.start();
		}		
	}
}
