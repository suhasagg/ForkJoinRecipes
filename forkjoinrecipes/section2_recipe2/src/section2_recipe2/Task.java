package section2_recipe2;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	
	private final int time;
	
	private final Phaser phaser;
	
	public Task(int time, Phaser phaser) {
		this.time=time;
		this.phaser=phaser;
	}
	
	@Override
	public void run() {
		phaser.arrive();
		
		System.out.printf("%s: Entering phase 1.\n",Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Finishing phase 1.\n",Thread.currentThread().getName());

		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("%s: Entering phase 2.\n",Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Finishing phase 2.\n",Thread.currentThread().getName());
	
		phaser.arriveAndAwaitAdvance();
	
		System.out.printf("%s: Entering phase 3.\n",Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Finishing phase 3.\n",Thread.currentThread().getName());

		phaser.arriveAndDeregister();
	}

}
