package prog02;

import java.util.Scanner;

public class Matricx {

	public static void insert(int[][] arr1) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < arr1.length ; i++) {
			System.out.println("Enter array elements of " + i + "th index : ");
			for(int j = 0 ; j < arr1[i].length ; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
	
	public static int sum(int[][] arr) {
		int sum =0 ;
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length ; j++) {
				sum+=arr[i][j];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int size1;
		int size2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of first array : ");
		size1 = sc.nextInt();
		System.out.print("Enter size of second array : ");
		size2 = sc.nextInt();
		int[][] arr = new int[size1][size2];

		insert(arr);
		
		System.out.println("sum of all elements in array is : "+sum(arr));
	} 

}
