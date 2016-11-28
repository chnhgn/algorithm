package misc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread implements Runnable {

	public static int count = 0;
	
	public static ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run() {
		print();
	}

	public void currentTime(){
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		String time = format.format(date);
		System.out.println(time);
	}
	
	public void print() {
		if (count > 10) return;
		
		try {
			if (lock.tryLock()) {
				System.out.println("I'm in!");
				this.currentTime();
				System.out.println("--------");
				count ++;
				print();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			lock.unlock();
		}
	}
	
}
