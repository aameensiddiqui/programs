package com.amin.arrays;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Arrays a = new Arrays();
		int []arr1 = new int[0];
		int []arr2 = new int[0];
		
		int n = 0;
		do {
			System.out.println("-------------------------------------");
			System.out.println("1. Insert elements into the arrays");
			System.out.println("2. Display arrays");
			System.out.println("3. Count even elements");
			System.out.println("4. Count odd elements");
			System.out.println("0. Exit");
			System.out.print("Enter: ");
			
			boolean isValid = false;
			String input = "";
			
			while(!isValid) {
				input = scan.nextLine();
				try {
					n = Integer.parseInt(input);
					isValid = true;
				} catch(NumberFormatException e) {
				}
			}
			
			switch(n) {
			case 1:
				System.out.print("Enter the size of 1st array: ");
				int size1 = scan.nextInt();
				System.out.print("Enter the size of 2nd array: ");
				int size2 = scan.nextInt();
				arr1 = new int[size1];
				arr2 = new int[size2];
				a.insert(arr1, size1, arr2, size2);
				break;
			case 2:
				a.printArray(arr1);
				a.printArray(arr2);
				break;
			case 3:
				System.out.print("Choose array 1 or 2 :");
				int choice = scan.nextInt();
				if(choice == 1)	a.countEvenElements(arr1);
				else if(choice == 2) a.countEvenElements(arr2);
				else System.out.println("Invalid choice.");
				break;
			case 4:
				System.out.print("Choose array 1 or 2 :");
				int choice2 = scan.nextInt();
				if(choice2 == 1)	a.countOddElements(arr1);
				else if(choice2 == 2) a.countOddElements(arr2);
				else System.out.println("Invalid choice.");
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Try again.");
				break;
			}
		} while(n != 0);
		scan.close();
		System.out.println("-------------------------------------");
	}
}
