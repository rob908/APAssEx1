import java.util.ArrayList;
import java.util.Random;

public class RailwayMaker extends Thread {
	ArrayList<Track> robsRail = new ArrayList<Track>();
	private int stationLength = 200;
	private Random r = new Random();
	private Track myTrack;
	private String trainSpeed = "";
	
	public String trackMaker() {
		String track = "|----Track------|";
		return track;
	}
	
	public void stationMaker() {
		Station Glasgow = new Station(stationLength, 7);
		TrackSection sectionOne = new TrackSection(1000, 1);
		Station Stirling = new Station(stationLength, 3);
		TrackSection sectionTwo = new TrackSection(1000, 1);
		Station Perth = new Station(stationLength, 4);
		TrackSection sectionThree = new TrackSection(1000, 1);
		Station Inverness = new Station(stationLength, 2);
		robsRail.add(Glasgow);
		robsRail.add(sectionOne);
		robsRail.add(Stirling);
		robsRail.add(sectionTwo);
		robsRail.add(Perth);
		robsRail.add(sectionThree);
		robsRail.add(Inverness);
	}
	
	public void run() {
		while(true) {
			int x = r.nextInt(2);
			if (x == 0) {
				trainSpeed = "fast";
			}
			if (x == 1) {
				trainSpeed = "slow";
			}
			Train myTrain = new Train(trainSpeed,robsRail.get(0));
			
		}
	}
	

}
