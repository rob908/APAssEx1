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
		
		
		//train constructor 
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
			this.trainID = trainID;
		}
		
		//variable for track type. may be better way to do this but for some reason using instance of in the run method 
		//seemed to cause problems. probably (definitely) me just being stupid.
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
		
		
		//determines capacity and type of track. if it's a station it's capacity will be 1+, a track sections will only be 1
		//time spent on track section (sleep) is determined by length of track / speed of train x 1000 to make things faster.
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
					
					//adds train to next bit of track and removes train section of track (not properly working!!!)
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


	
	