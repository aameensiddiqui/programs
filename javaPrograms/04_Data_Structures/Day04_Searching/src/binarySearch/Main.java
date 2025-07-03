package binarySearch;

public class Main {

	public static int binarySearch(int[] arr,int key) {
		int low = 0;
		int high = arr.length -1;
		int mid;
		while(low<=high) {
			mid = (low+high)/2;
			if(arr[mid] == key) {
				return mid;
			}
			if(arr[mid]>key) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int a = binarySearch(arr,0);
		if(a!=-1) {
			System.out.println("Element present in arry at index "+a);
		}else{
			System.out.println("Element not present in array");
		}
	}

}
