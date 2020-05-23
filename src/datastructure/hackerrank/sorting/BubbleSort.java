package datastructure.hackerrank.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BubbleSort {

	static int numSwaps =0;
	static int firstElement =0;
	static int lastElement =0;
	
	// Complete the countSwaps function below.
    static void countSwaps(int[] a) {
    	for(int i=0; i<a.length; i++) {
    		for(int j=0; j<a.length - 1; j++) {
    			if(a[j] > a[j+1]) {
    				performSwap(a, j, j+1);
    				numSwaps++;
    				}
    			}
    	}
    	firstElement = a[0];
    	lastElement = a[a.length-1];
    }

    private static void performSwap(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[j+1];
		a[j+1] = temp;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);
        System.out.println("Array is sorted in "+numSwaps+" swaps");
        System.out.println("First Element: "+firstElement);
        System.out.println("Last Element: "+lastElement);

        scanner.close();
    }
	
	
}




