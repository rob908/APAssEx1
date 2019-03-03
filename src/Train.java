import java.util.*;
import java.util.concurrent.locks.*;

	public class Train extends Thread {
		private ArrayList <Integer> a = new ArrayList<Integer>();
		private int whichTrack;
		private String setSpeed;
		private int speed;
		private int trainID;
		private int nextTrainID = 1;
		private int pos = 0;
		private Track myTrack;
		private ReentrantLock lock = new ReentrantLock();
		
		public Train (String trainSpeed, Track whichTrack) {
			if (trainSpeed == "fast") {
				speed = 1000;
			}
			if (trainSpeed == "slow") {
				speed = 300;
			}
			myTrack = whichTrack;
			this.trainID = nextTrainID;
			nextTrainID++;
			
		}
		
		public String getSpeed() {
			return setSpeed;
		}
		
		public void setSpeed(String setSpeed) {
			this.setSpeed = setSpeed;
		}
		public int getTrack() {
			return whichTrack;
		}
	
		public void setTrack(Track myTrack) {
			this.myTrack = myTrack;
		}
	
		public int getTrainID() {
			return trainID;
		}
	
		public void setTrainID(int trainID) {
			this.trainID = trainID;
		}
		
}

	
	