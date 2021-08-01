package section1_recipe12;

import java.util.concurrent.Flow.Subscription;

public class MySubscription implements Subscription {
	
	private boolean canceled=false;
	
	private long requested=0;
	
	@Override
	public void cancel() {
		canceled=true;
	}
	
	@Override
	public void request(long value) {
		requested+=value;
	}
	
	public boolean isCanceled() {
		return canceled;
	}
	
	public long getRequested() {
		return requested;
	}
	
	public void decreaseRequested() {
		requested--;
	}

}
