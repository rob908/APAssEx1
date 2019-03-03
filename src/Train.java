import java.util.*;
import java.util.concurrent.locks.*;

public class Train {
		private ArrayList <Integer> a = new ArrayList<Integer>();
		private int pos = 0;
		private ReentrantLock lock = new ReentrantLock();
	
	public Integer getTrain() {
		 lock.lock();
	        while(pos == 0) {
	            try {
	                Thread.sleep(1);
	                System.out.println("|----Track, " + Thread.currentThread().getName() + "------|");
	            }catch(InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        pos -= 1;
	        Integer val = a.get(pos);
	        lock.unlock();
	        return val;
	    }
	
	public void addTrain(Integer val) {
        lock.lock();
        a.add(val);
        pos += 1;
        lock.unlock();
    }
	 
	public String toString() {
	        String str = "Stack has " + pos + " jobs.\n";
	        return str;
	    }
		
}

	
	