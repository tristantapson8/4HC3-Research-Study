
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;


public class output {
	
	public static void openFile(String s1, String s2, String d1, BigDecimal err){
		
	try{
        	String path = "results.txt";
        	File file = new File(path);
        	FileWriter fileWriter = new FileWriter(file,true);
		BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);

        	fileWriter.append( "Name: " + s1 + " // Device: " +  s2 + " // Completion Time: " + d1 + " // Error Percentage: " + err + "% ");
        	bufferFileWriter.close();

        //System.out.println("User Registration Completed");

    }catch(Exception ex)
    {
        System.out.println(ex);
    }
}
}
