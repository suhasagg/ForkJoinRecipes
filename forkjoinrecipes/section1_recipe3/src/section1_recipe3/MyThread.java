package section1_recipe3;

import java.util.Date;

public class MyThread extends Thread {
	
	private final Date creationDate;
	
	private Date startDate;
	
	private Date finishDate;
	
	public MyThread(Runnable target, String name) {
		super(target,name);
		creationDate = new Date();
	}
	
	@Override
	public void run() {
		setStartDate();
		super.run();
		setFinishDate();
	}
	
	public synchronized void setStartDate() {
		startDate=new Date();
	}
	
	public synchronized void setFinishDate() {
		finishDate=new Date();
	}
	
	public synchronized long getExecutionTime() {
		return finishDate.getTime()-startDate.getTime();
	}
	
	@Override
	public synchronized String toString(){
		StringBuilder buffer=new StringBuilder();
		buffer.append(getName());
		buffer.append(": ");
		buffer.append(" Creation Date: ");
		buffer.append(creationDate);
		buffer.append(" : Running time: ");
		buffer.append(getExecutionTime());
		buffer.append(" Milliseconds.");
		return buffer.toString();
	}
}
