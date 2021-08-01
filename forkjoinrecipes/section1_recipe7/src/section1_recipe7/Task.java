package section1_recipe7;

public class Task extends MyWorkerTask {


	private static final long serialVersionUID = 1L;

	
	private int array[];

	private int start;

	private int end;

	public Task(String name, int array[], int start, int end){
		super(name);
		this.array=array;
		this.start=start;
		this.end=end;
	}
	
	@Override
	protected void compute() {
		if (end-start>100){
			int mid=(end+start)/2;
			Task task1=new Task(this.getName()+"1",array,start,mid);
			Task task2=new Task(this.getName()+"2",array,mid,end);
			invokeAll(task1,task2);
		} else {
			for (int i=start; i<end; i++) {
				array[i]++;
			}			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
