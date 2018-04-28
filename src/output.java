
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;


public class output {
	
	//private Formatter x;
	
	public static void openFile(String s1, String s2, String d1, BigDecimal err){
		/*try{
			x = new Formatter("results.txt");
		}
		catch(Exception e){
			System.out.println("err");
		}
	}
	
	public void addRecords(String s1, String s2, String d1){
		x.format("%s%s%s","Name: " + s1, " / Device: " +  s2, " / Completion Time: " + d1 + " / Errors: ?");
	}
	
	public void closeFile(){
		x.close();
	}*/
	try
    {
        String path = "results.txt";

        File file = new File(path);

        FileWriter fileWriter = new FileWriter(file,true);

        BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);

        //public void addRecords(String s1, String s2, String d1){
    		//x.format("%s%s%s","Name: " + s1, " / Device: " +  s2, " / Completion Time: " + d1 + " / Errors: ?");
    	//}
        fileWriter.append( "Name: " + s1 + " // Device: " +  s2 + " // Completion Time: " + d1 + " // Error Percentage: " + err + "% ");

        bufferFileWriter.close();

        //System.out.println("User Registration Completed");

    }catch(Exception ex)
    {
        System.out.println(ex);
    }
}
}
