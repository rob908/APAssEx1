import java.util.*;
import java.util.concurrent.locks.*;

	public class Train extends Thread {
		private ArrayList <Track> robsRail = new ArrayList<Track>();
		private Track myTrack;
		private String setSpeed;
		private int speed;
		protected int trainID;
		protected int nextTrainID;
		protected RailwayMaker makeMyRail;
		
		public Train (String trainSpeed, Track whichTrack) {
			if (trainSpeed == "fast") {
				speed = 1000;
			}
			if (trainSpeed == "slow") {
				speed = 100;
			}
			
			myTrack = whichTrack;
			nextTrainID = this.trainID++;
//			System.out.print(trainID);
			setTrainID(nextTrainID);
			 
		}
		
		public String getSpeed() {
			return setSpeed;
		}
		
		public void setSpeed(String setSpeed) { 
			this.setSpeed = setSpeed;
		}
		public Track getTrack() {
			return myTrack;
		}
	
		public void setTrack(Track track) {
			myTrack = track;
		}
	
		public int getTrainID() {
			return trainID;
		}
	
		public void setTrainID(int trainID) {
			this.nextTrainID = trainID;
		}
		
		public int typeOfTrack() {
			int x = 0;
			if (this.getTrack() instanceof TrackSection) {
				x = 1;
			}
			if (this.getTrack() instanceof Station) {
				x = 2;
			}
			return x;
		}
		
		public void run() {
			robsRail = makeMyRail.robsRail;
			while (true) {
					try {
						int x = typeOfTrack();
						if (x == 1) {
							Thread.sleep((this.getTrack().getLength() / speed) * 1000);
						}
						if (x == 2) {
							Thread.sleep((this.getTrack().getLength() / speed + 5) * 1000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (this.getTrack() == robsRail.get(robsRail.size() - 1)) {
						robsRail.get(robsRail.size() - 1).removeTrain();
						break;
					}
					
					for (int i = 0; i < robsRail.size() - 1; i++) {
						if (this.getTrack() == robsRail.get(i)) {
							robsRail.get(i + 1).addTrain(this);
							robsRail.get(i).trainsOnTrack.remove(this);
							robsRail.get(i).setCapacity(robsRail.get(i).getCapacity()+1);
							break;
						}
					}
					
						
			}
		}
}


	
	