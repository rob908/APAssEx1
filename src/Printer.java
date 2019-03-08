
public class Printer extends Thread {
	private String Track = "|----Track--";
	private String Glasgow = "|----Glasgow--";
	private String Stirling = "|----Stirling--";
	private String Perth = "|----Perth--";
	private String Inverness = "|----Inverness--";
	protected RailwayMaker myRail = new RailwayMaker();
	StringBuilder bob = new StringBuilder();
	
	public void run() {
		while(true) {
			bob.append(Glasgow);
			for (int i = 0; i < myRail.robsRail.get(0).trainsOnTrack.size(); i++) {
				bob.append(myRail.robsRail.get(0).trainsOnTrack.get(i).getTrainID() + ",");
			}
			bob.append(Track);
			for (int i = 0; i < myRail.robsRail.get(1).trainsOnTrack.size(); i++) {
				bob.append(myRail.robsRail.get(1).trainsOnTrack.get(i).getTrainID() + ",");
			}
			bob.append(Stirling);
			for (int i = 0; i < myRail.robsRail.get(2).trainsOnTrack.size(); i++) {
				bob.append(myRail.robsRail.get(2).trainsOnTrack.get(i).getTrainID() + ",");
			}
			bob.append(Track);
			for (int i = 0; i < myRail.robsRail.get(3).trainsOnTrack.size(); i++) {
				bob.append(myRail.robsRail.get(3).trainsOnTrack.get(i).getTrainID() + ",");
			}
			bob.append(Perth);
			for (int i = 0; i < myRail.robsRail.get(4).trainsOnTrack.size(); i++) {
				bob.append(myRail.robsRail.get(4).trainsOnTrack.get(i).getTrainID() + ",");
			}
			bob.append(Track);
			for (int i = 0; i < myRail.robsRail.get(5).trainsOnTrack.size(); i++) {
				bob.append(myRail.robsRail.get(5).trainsOnTrack.get(i).getTrainID() + ",");
			}
			bob.append(Inverness);
			for (int i = 0; i < myRail.robsRail.get(6).trainsOnTrack.size(); i++) {
				bob.append(myRail.robsRail.get(6).trainsOnTrack.get(i).getTrainID() + ",");
			}
			
			bob.append("|");
			System.out.println(bob);
			bob.setLength(0);
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
