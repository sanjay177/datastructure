package datastructure.hackerrank.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarkNToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
    	int totalToysPrice =0;
    	int totalToys=0;
    	List<Integer> intList = new ArrayList<Integer>(prices.length);
    	for (int i : prices)
    	{
    	    intList.add(i);
    	}
    	Collections.sort(intList);
    	for (int i : intList) {
    		if ( totalToysPrice + i < k) {
    			totalToys++;
    			totalToysPrice+= i;
    		}
    	}
    	return totalToys;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
