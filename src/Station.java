import java.util.ArrayList;

public class Station {
	public String stationName;
	ArrayList<String> stations = new ArrayList<String>();
	
	public void createStation() {
		setName (stationName);
		stations.add(stationName);
		System.out.print(stations);
		
	}

	public String getName() {
		return stationName;
	}
	
	public void setName(String stationName) {
		this.stationName = stationName;
	}
}
