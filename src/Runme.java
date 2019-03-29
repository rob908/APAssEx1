import java.util.Random;

public class Runme {
	
	public static void main(String[] args) {
		RailwayMaker myRail = new RailwayMaker();
		Printer myPrinter = new Printer();
		myRail.start();
		myPrinter.myRail = myRail; 
		myPrinter.start();
		try {
			while (true) {
			myRail.join();
			myPrinter.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
} 
 //arrrrrghh almost working