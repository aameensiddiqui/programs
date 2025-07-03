package prog01;

import java.util.Scanner;

public class Array {
	
	public static int countSame(int[] arr1,int[] arr2) {
		int cnt =0;
		for(int i = 0; i < arr1.length ; i++) {
			for(int j = 0 ; j < arr2.length ;j++) {
				if(arr1[i]==arr2[j]) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}
	public static void insert(int[] arr1,int[] arr2) {
		System.out.println("Enter array elements of 1st array : ");
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < arr1.length ; i++) {
			arr1[i] = sc.nextInt();
		}
		System.out.println("Enter array elements of 2nd array : ");
		for(int i = 0 ; i < arr2.length ; i++) {
			arr2[i] = sc.nextInt();
		}
	}
	public static void disp(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static int[] isIntersection(int[] arr1,int[] arr2) {	
		int[] intersection;
		int cnt = countSame(arr1,arr2) , k = 0;
		intersection = new int[cnt];
		
		for(int i = 0; i < arr1.length ; i++) {
			for(int j = 0 ; j < arr2.length ;j++) {
				if(arr1[i]==arr2[j]) {
					intersection[k++] = arr1[i];
					break;
				}
			}
		}
		
		return intersection;
	}
	public static int[] isUnion(int[] arr1,int[] arr2) {
		int[] union;
		int cnt = countSame(arr1,arr2) , k = 0;
		union = new int[arr1.length + arr2.length - cnt];
		
		for(int i = 0 ; i < arr1.length ; i++) {
			union[k++] = arr1[i];
		}

		for(int j = 0 ; j <= cnt ; j++) {
			if(union[k]!=arr2[j]) {
				union[k] = arr2[j];
				k++;
			}
		}
		
//		for(int i = 0; i < arr2.length ; i++) {
//			boolean flag = true;
//			for(int j = 0 ; j < arr1.length ;j++) {
//				if(arr1[j]==arr2[i]) {
//					flag = false;
//					break;
//				}
//			}
//			if(flag) {
//				union[k++] = arr2[i];
//			}
//		}
		return union;
	}
	public static int even(int[] arr1,int[] arr2) {
		int cnt=0;
		for(int i = 0 ; i < arr1.length ; i++) {
			if(arr1[i]%2==0) {
				cnt++;
			}
		}
		for(int i = 0 ; i < arr2.length ; i++) {
			if(arr2[i]%2==0) {
				cnt++;
			}
		}
		return cnt;
	}
	public static int odd(int[] arr1,int[] arr2) {
		int cnt=0;
		for(int i = 0 ; i < arr1.length ; i++) {
			if(arr1[i]%2==1) {
				cnt++;
			}
		}
		for(int i = 0 ; i < arr2.length ; i++) {
			if(arr2[i]%2==1) {
				cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		int size1;
		int size2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of first array : ");
		size1 = sc.nextInt();
		System.out.print("Enter size of second array : ");
		size2 = sc.nextInt();
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		int ch;
		do {
			System.out.println("1. Enter elements");
			System.out.println("2. Disp Array");
			System.out.println("3. Union of Array");
			System.out.println("4. Intersection of Two arrays");
			System.out.println("5. Count no of even elements");
			System.out.println("6. Count no of odd elements");
			System.out.println("0. to exit");
			
			System.out.print("Enter Your Choice : ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				insert(arr1,arr2);
				break;
			case 2:
				disp(arr1);
				disp(arr2);
				break;
			case 3:
				int[] union = isUnion(arr1,arr2);
				disp(union);
				break;
			case 4:
				int[] intersecion = isIntersection(arr1,arr2);
				disp(intersecion);
				break;
			case 5:
				System.out.println("No of even elements in both array are : "+even(arr1,arr2));
				break;
			case 6:
				System.out.println("No of odd elements in both array are : "+odd(arr1,arr2));
				break;
			case 0:
				break;
			}
		}while(ch!=0);
	}
}
