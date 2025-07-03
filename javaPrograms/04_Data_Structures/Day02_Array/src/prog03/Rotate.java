package prog03;

import java.util.Scanner;

public class Rotate {
	
	public static void insert(int[] arr1) {
		System.out.println("Enter array elements of array : ");
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < arr1.length ; i++) {
			arr1[i] = sc.nextInt();
		}
	}
	
	public static int[] rotateLeft(int[] arr,int k) {
		int[] a = new int[arr.length];
		for(int i = 0; i < arr.length ; i++) {
			a[i] = arr[(i+k)%arr.length];
		}
		return a;
	}
	
	public static int[] rotateRight(int[] arr,int k) {
		int[] a = new int[arr.length];
		for(int i = 0; i < arr.length ; i++) {
			a[i] = arr[(i+k+1)%arr.length];
		}
		return a;
	}
	
	public static void main(String[] args) {
		int size;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array : ");
		size = sc.nextInt();
		int[] arr = new int[size];
		insert(arr);
		
		System.out.println("Orignal Elements");
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.print("ENter index : ");
		int k = sc.nextInt();
		
		int[] arrLeft =  rotateLeft(arr,k);		
		System.out.println("LeftRotate Elements");
		for(int i = 0 ; i < arrLeft.length ; i++) {
			System.out.print(arrLeft[i]+" ");
		}
		System.out.println();
		
		int[] arrRight =  rotateRight(arr,k);		
		System.out.println("LeftRight Elements");
		for(int i = 0 ; i < arrRight.length ; i++) {
			System.out.print(arrRight[i]+" ");
		}
		System.out.println();
	}

}
