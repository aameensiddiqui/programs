package prog01;

import java.util.Scanner;

public class Transpose {
	public static void insert(int[][] arr) {
		System.out.println("********* Enter array elements of array : *******");
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < arr.length;i++) {
			for(int j = 0 ; j < arr[i].length;j++) {
				System.out.print("Enter element in "+i+ ","+j+" : ");
				arr[i][j] = sc.nextInt();
			}
		}
	}

	public static void disp(int[][] arr) {
		System.out.println("********* Displaying elements of array : *******");
		for(int i = 0 ; i < arr.length;i++) {
			for(int j = 0 ; j < arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void transpose(int[][] arr) {
	
		
		int[][] arrT = new int[arr.length][arr.length] ; 
		
		for(int i = 0 ; i < arr.length;i++) {
			for(int j = 0 ; j < arr[i].length;j++) {
				arrT[j][i] = arr[i][j];
			}
		}
		
		for(int i = 0 ; i < arr.length;i++) {
			for(int j = 0 ; j < arr[i].length;j++) {
				arr[i][j] = arrT[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		int size1;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of 2d array : ");
		size1 = sc.nextInt();
		int[][] arr = new int[size1][size1];		
		insert(arr);
		disp(arr);
		System.out.println("********* Array After Transposing elements *******");
		
		transpose(arr);
		disp(arr);
	}
	
}
