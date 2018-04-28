import java.util.Timer;
import java.util.TimerTask;

public class timer {
	static double secondsPassed = 0;
	
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask(){
		public void run(){
			secondsPassed++;
			//System.out.println("completion time: " + secondsPassed);
		}
	};
	
	public void start(){
		myTimer.scheduleAtFixedRate(task, 1, 1); // 0 second delay, counting in milliseconds
	}
	
	public void stop(){
		myTimer.cancel();
	}
}
