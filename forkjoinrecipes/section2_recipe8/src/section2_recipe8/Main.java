package section2_recipe8;

import section2_recipe8.ProducerConsumerTest;

import edu.umd.cs.mtc.TestFramework;

public class Main {
	public static void main(String[] args) throws Throwable {
		
		ProducerConsumerTest test=new ProducerConsumerTest();
		
		System.out.printf("Main: Starting the test\n");
		TestFramework.runOnce(test);
		System.out.printf("Main: The test has finished\n");		
	}
}
