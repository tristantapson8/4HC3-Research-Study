
import java.awt.event.*;
import java.io.File;
import java.math.BigDecimal;
import java.util.Timer;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.Color;
import java.awt.MouseInfo;
import java.util.Scanner;

@SuppressWarnings("serial")
public abstract class Draw extends Paint implements WindowListener{
	
	public static boolean run  = false;
	public static double error_percent = 0;
	
	// --------------------- MAIN FUNCTION --------------------- // 
	
	public static void main(String[] args) {
		
		// Sound effect to let users know that test has started
		File tweet = new File("whistle.wav");
		
		// margin of error (due to windowed mode)
		int errorMarginX = 10;
	    	int errorMarginY = 30;
	
	   	// start button
		rect[] rect;
	    	rect = new rect[1];
		
	   	// top left x, top left y, width, height format 
	    	rect[0]= new rect(50, 50, 50, 50, Color.BLUE);  // start point
	    
	   	// instruction manual via console
	    	Scanner in = new Scanner(System.in); 
		System.out.println("---- Welcome to the HCI testing scenario ----");
		System.out.println("* click blue button to start");
		System.out.println("* click red button to finish");
		System.out.println("* navigate your cursor around the maze!");
		System.out.println("");
	    	System.out.printf(" Enter name:  ");
	    	String s1 = in.nextLine();
	    	System.out.printf(" Enter device:  ");
	    	String s2 = in.nextLine();
	   
	    	//recording data, opening files
	    	//output outFile = new output();
	    	//outFile.openFile();
	
	    	JFrame frame = new JFrame("4HC3 - Research Project");
	    	frame.setVisible(true);
	    	frame.setSize(550, 575);
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.add(new Paint());
	    	frame.addMouseListener(new MouseAdapter(){
    	   
           	public void  mouseClicked(MouseEvent e){
           	
           		// mouse cursor x and mouse cursor y
        	   	int x = e.getX();
        	   	int y = e.getY();
        	   
        	   	// decimal rounding scale
        	   	int yourScale = 4;
        	 
        	   	//System.out.println("click: " + x + "," + y);
        	   
        	   	// once start point has been clicked
        	   	if(x >= rect[0].x + errorMarginX && y >= rect[0].y + errorMarginY && x < (rect[0].x + rect[0].w + errorMarginX) && y < (rect[0].y + rect[0].h + errorMarginY)){
        	   		System.out.println("");
        	   		Sound.playSound(tweet);
        	   		System.out.println("-> CLICKED START POINT !!!");
       				begin();
       				System.out.println("-> REACHED END POINT !!!");
       				frame.setVisible(false);
       				double d1 = (timer.secondsPassed/1000);
       				System.out.println("* completion time: " + d1 + " s ! await further instruction..."); // prints run time when completed
       				//outFile.addRecords(s1, s2, String.valueOf(d1));
       				//outFile.closeFile(); 
       				output.openFile(s1, s2, String.valueOf(d1),(BigDecimal.valueOf(error_percent).setScale(yourScale, BigDecimal.ROUND_HALF_UP)));
       				in.close(); //recording data, closing files
       			}	
           	}
        	});
	} // end of main
	
	// --------------------- SUB FUNCTIONS --------------------- // 
	
	// updates if user is running the test
	public static boolean begin(){
		// timer starts
		timer run_timer = new timer();
		run = true;
		run_timer.start();
		check(run);
		return run;
	}
	
	// updates if user has completed the test
	public static boolean end(){
		run = false;
		return run;
	}
	
	// checking if test is in progress
	public static void check(Boolean run){
		
		double within_bounds_count = 0;
		double out_of_bounds_count = 0;
		
		int errorMarginX = 10;
	    	int errorMarginY = 30;
	
		rect[] walls;
	     	walls = new rect[11];
	
	     	// top left x, top left y, width, height format
	     	walls[0] = new rect(0, 0, 50, 500, Color.BLACK); // walls 
	     	walls[1] = new rect(50, 0, 400, 50, Color.BLACK);
	    	walls[2] = new rect(50, 450, 400,50, Color.BLACK);
	    	walls[3]= new rect(50, 100, 350,50, Color.BLACK);
	    	walls[4] = new rect(450, 0, 50, 500, Color.BLACK);
	     	walls[5] = new rect(100, 200, 350, 50, Color.BLACK);
	     	walls[6] = new rect(50, 300, 350, 50, Color.BLACK);
	     	walls[7] = new rect(350, 350, 50,50, Color.BLACK);
	     	walls[8] = new rect(250, 400, 50, 50, Color.BLACK);
	     	walls[9]= new rect(150, 350, 50, 50, Color.BLACK);
	     	walls[10] = new rect(50, 400, 50, 50, Color.BLACK); // end point

	     	// when the user is doing his/her test... do checks!
	     	while(run = true){
		
	    		within_bounds_count+=1;
	    	 
	    	 	double x = MouseInfo.getPointerInfo().getLocation().getX();
	    	 	double y = MouseInfo.getPointerInfo().getLocation().getY();
	    	 
	    	 	for(int i = 0; i < walls.length;i++){
	    		 
	    		 	//TODO checks if a wall is being dragged over, add a second timer to account for errors
	    		 	if(x >= walls[i].x + errorMarginX && y >= walls[i].y + errorMarginY && x < (walls[i].x + walls[i].w + errorMarginX) && y < (walls[i].y + walls[i].h + errorMarginY) && i !=10){
		    		 	//System.out.println("dragging over: " + i );
		    		 	out_of_bounds_count+=1;
		    		 	within_bounds_count+=-1;
		    	 	}
	    		 
		    	 	else{
		    		 	//System.out.println("SAFE");
		    		}
	    	 	}
	    	 
	    	 	// once end point has been reached
	    	 	if(x >= walls[10].x + errorMarginX && y >= walls[10].y + errorMarginY && x < (walls[10].x + walls[10].w + errorMarginX) && y < (walls[10].y + walls[10].h + errorMarginY)){
	    		 	//System.out.println("END");
	    		 	end();
	    		 	break;
	    	 	}
	     	}
	    
        //System.out.println("W: " + within_bounds_count);
        //System.out.println("O: " + out_of_bounds_count);
        double result = ((out_of_bounds_count / (within_bounds_count + out_of_bounds_count)) * 100);
        //System.out.println("R: " + result);
        error_percent += result;
	   
    } //end of check
}
 
