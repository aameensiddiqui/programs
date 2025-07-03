package bubbleSort;

import java.util.Scanner;

public class Main {
	public static int noOfPasses;
	public static int noOfSwapping;
	
	static {
		noOfPasses = 0;
		noOfSwapping = 0;
	}
	
	public static void bubbleSort(int[] arr) {
		for(int i = 0 ;i < arr.length-1 ;i++) {
			boolean b = true;
			for(int j = 0; j<arr.length-1-i ;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					noOfSwapping++;
					b=false;
				}
			}
			noOfPasses++;
			if(b) {
				break;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Array size");
		int size = sc.nextInt();

		int[] arr = new int[size];
		System.out.println("Enter Array Elements");
		for(int i = 0 ;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Array before sort");
		for(int i = 0 ;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		bubbleSort(arr);
		System.out.println("Array After sort");
		for(int i = 0 ;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		System.out.println("No of swapping happen are : "+noOfSwapping);
		System.out.println("No of Passes are : "+noOfPasses);
	}
}
