package section1_recipe9;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MyPriorityTransferQueue<E> extends PriorityBlockingQueue<E> implements TransferQueue<E> {

	private final AtomicInteger counter;
	
	private final LinkedBlockingQueue<E> transfered;
	
	private final ReentrantLock lock;
	
	public MyPriorityTransferQueue() {
		counter = new AtomicInteger(0);
		lock = new ReentrantLock();
		transfered = new LinkedBlockingQueue<>();
	}
	
	@Override
	public boolean tryTransfer(E e) {
		boolean value = false;
		try {
			lock.lock();
			if (counter.get() == 0) {
				value = false;
			} else {
				put(e);
				value = true;
			}
		} finally {
			lock.unlock();
		}
		return value;
	}
	
	@Override
	public void transfer(E e) throws InterruptedException{
		lock.lock();
		if (counter.get() != 0) {
			try {
				put(e);
			} finally {
				lock.unlock();
			}
		} else {
			try {
				transfered.add(e);
			} finally {
				lock.unlock();
			}
			synchronized (e) {
				e.wait();
			}
		}
	}
	
	@Override
	public boolean tryTransfer(E e, long timeout, TimeUnit unit) throws InterruptedException {
		lock.lock();
		if (counter.get() != 0) {
			try {
				put(e);
			} finally {
				lock.unlock();
			}
			return true;
		} else {
			long newTimeout = 0;
			try {
				transfered.add(e);
				newTimeout = TimeUnit.MILLISECONDS.convert(timeout, unit);
			} finally {
				lock.unlock();
			}
			e.wait(newTimeout);
			lock.lock();
			boolean value;
			try {
				if (transfered.contains(e)) {
					transfered.remove(e);
					value = false;
				} else {
					value = true;
				}
			} finally {
				lock.unlock();
			}
			return value;
		}
	}
	
	@Override
	public boolean hasWaitingConsumer() {
		return (counter.get()!=0);
	}
	
	@Override
	public int getWaitingConsumerCount() {
		return counter.get();
	}
	
	@Override
	public E take() throws InterruptedException {
		lock.lock();
		E value = null;
		try {
			counter.incrementAndGet();
			value = transfered.poll();
			if (value == null) {
				lock.unlock();
				value = super.take();
				lock.lock();
			} else {
				synchronized (value) {
					value.notify();
				}
			}
			counter.decrementAndGet();
		} finally {
			lock.unlock();
		}
		return value;
	}
}
