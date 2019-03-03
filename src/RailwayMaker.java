
public class RailwayMaker {
	Station myStations = new Station();
	
	public String trackMaker() {
		String track = "|----Track------|";
		return track;
	}
	
	public void stationMaker() {
		myStations.setName("Glasgow");
		myStations.createStation();
		myStations.setName("Stirling");
		myStations.createStation();
		myStations.setName("Perth");
		myStations.createStation();
		myStations.setName("Inverness");
		myStations.createStation();
	}	
	
//	public static void main(String[] args) {
//		RailwayMaker x = new RailwayMaker();
//		x.stationMaker();
//	}
}
