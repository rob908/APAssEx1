import java.util.Random;

public class Runme implements Runnable {
	private Train train;
	private Random r = new Random();
	
	public Runme(Train train) {
		this.train = train;
	}
	
	public void run() {
		int numberTrain = 0;
		while(true) {
			Integer nextVal = numberTrain++ ;
//			train.addTrain(nextVal);
			System.out.print(train.getTrain());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Train myTrain = new Train();
		new Thread(new Runme(myTrain)).start();
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
