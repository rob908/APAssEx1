import java.util.concurrent.locks.*;
import java.util.ArrayList;

	public class Track {
		private Train myTrain;
		private int capacity;
		private int length;
		private ReentrantLock lock = new ReentrantLock();
		private Condition cond = lock.newCondition();
		protected ArrayList<Train> trainsOnTrack = new ArrayList<Train>();
		
		public Track(int c, int l) {
			capacity = c;
			length = l;
		}
		
		public int getLength() {
			return length;
		}
		
		public void setLength(int length) {
			this.length = length;
		}
		
		public int getCapacity() {
			return capacity;
		}
		
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		
		//method to add train to piece of track
		public void addTrain(Train myTrain) {
			lock.lock();
			try {
				while(capacity == 0) {
					myTrain.setTrack(this);
		            cond.await();
		        }
				setCapacity(capacity - 1);   
				trainsOnTrack.add(myTrain);    
				}catch(InterruptedException e) {
		            e.printStackTrace();
		            }lock.unlock(); 
		}
		
		//method to remove train from piece of track
		public void removeTrain() {
			lock.lock();
			myTrain.setTrack(null);
			this.setCapacity(capacity + 1);
			trainsOnTrack.remove(myTrain);
			lock.unlock();
			cond.signalAll();
		}
		
	}
	
