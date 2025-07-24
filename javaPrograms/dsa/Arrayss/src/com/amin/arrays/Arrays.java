package com.amin.arrays;

import java.util.Scanner;

public class Arrays {
	
	Scanner scan = new Scanner(System.in);
	
	public void countOddElements(int[]arr) {
		int cnt = 0;
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] % 2 != 0) cnt++;
		}
		System.out.println("Odd elements: "+cnt);
	}
	
	public void countEvenElements(int[]arr) {
		int cnt = 0;
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] % 2 == 0) cnt++;
		}
		System.out.println("Even elements: "+cnt);
	}
	
	public void insert(int[]arr1, int size1, int[]arr2, int size2) {
		System.out.println("Enter "+ size1 +" elements for 1st array: ");
		for(int i = 0; i < arr1.length; ++i) {
			arr1[i] = scan.nextInt();
		}
		System.out.println("Done.\nEnter "+ size2 +" elements for 2nd array: ");
		for(int i = 0; i < arr2.length; ++i) {
			arr2[i] = scan.nextInt();
		}
		System.out.println("Done.");
	}
	
	public void printArray(int[]arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; ++i) {
			if(i != arr.length-1)	System.out.print(arr[i]+", ");
			else System.out.print(arr[i]+"]");
		}
		System.out.println();
	}
}
