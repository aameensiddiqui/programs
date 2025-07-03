package prog05;

import java.util.Scanner;

public class Sparce {
	
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
	
	public static int count(int[][] arr) {
		int cnt = 0;
		for(int i = 0 ; i < arr.length;i++) {
			for(int j = 0 ; j < arr[i].length;j++) {
				if(arr[i][j]!=0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void sparce(int[][] arr,int[][] sparceArr) {
		System.out.println("********* Converting array to sparced array : *******");
		int m = 1;
		for(int i = 0 ; i < arr.length;i++) {
			for(int j = 0 ; j < arr[i].length;j++) {
				if(arr[i][j]!=0) {
					sparceArr[m][0] = i;
					sparceArr[m][1] = j;
					sparceArr[m][2] = arr[i][j];
					m++;
				}
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
		System.out.println("*********** Displaying Orignal Array ***********");
		disp(arr);
		
		
		int nonZero = count(arr);
		int row = nonZero + 1;
		int[][] sparceArr = new int[row][3];
		sparceArr[0][0] = size1;
		sparceArr[0][1] = size1;
		sparceArr[0][2] = nonZero;
		
		sparce(arr,sparceArr);
		
		System.out.println("*********** Displaying sparced Array ***********");
		disp(sparceArr);
		
	}

}
