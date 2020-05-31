package datastructure.hackerrank.algo;

import java.io.*;
import java.text.*;
import java.util.*;

public class TimeConversion {
	   /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
    	 SimpleDateFormat sdfInputFmt = new SimpleDateFormat("hh:mm:ssa");        
         
         SimpleDateFormat outputDateFmt = new SimpleDateFormat("HH:mm:ss");
         String outputDate = "";
         try {
             outputDate = outputDateFmt.format(sdfInputFmt.parse(s));
         } catch (ParseException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         
         return outputDate;
    	    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}