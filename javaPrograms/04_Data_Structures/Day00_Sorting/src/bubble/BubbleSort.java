package bubble;

public class BubbleSort {

	public static void disp(int[] arr) {
		for(int i = 0; i<arr.length ;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	// Bubble Sort
	public static void bSort(int[] arr) {
		// Not Optimum
//		for(int i = 0 ;i < arr.length ; i++) {
//			for(int j = 0 ; j < arr.length-1-i ; j++) {
//				if(arr[j] > arr[j+1]) {
//					int temp;
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//			}
//		}
		
		// Optimum
		for(int i = 0 ;i < arr.length ; i++) {
			boolean flag = true;
			for(int j = 0 ; j < arr.length-1-i ; j++) {
				if(arr[j] > arr[j+1]) {
					int temp;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
				if(flag) {
					break;
				}
			}
		}
	}
	
	// Selection Sort
	public static void sSort(int[] arr) {
		// Not Optimum
		for(int i = 0;i<arr.length-1 ; i++) {
			int small = arr[i];
			int index = i;
			for(int j = i+1 ; j < arr.length ; j++) {
				if(small>arr[j]) {
					small = arr[j];
					index = j;
				}
			}
			arr[index] = arr[i];
			arr[i] = small;
		}
	}
	
	// Insertion Sort
	public static void iSort(int[] arr) {
		// Not Optimum
		for(int i = 1;i<arr.length ; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	// Quick Sort
	public static void swap(int[] arr, int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int partition(int [] arr,int left,int right) {
		int pivot = arr[left];
		int l = left+1;
		int r = right;
		while(l<r) {
			while(arr[l] < pivot) {
				l++;
			}
			while(arr[r]>pivot) {
				r--;
			}
			if(l<r) {				
				swap(arr,l,r);
			}
		}
		swap(arr,left,r);
		return r;
	}
	
	public static void qSort(int[] arr,int left, int right) {
		// Not Optimum
		if(left < right) {
			int i = partition(arr,left,right);
			System.out.println(i);
			
			qSort(arr,left,i-1);
			qSort(arr,i+1,right);
		}
	}
	
	// Heap Sort
	public static void hSort(int[] arr) {
		// Not Optimum
		for(int i = 0 ;i < arr.length ; i++) {
			for(int j = 0 ; j < arr.length-1-i ; j++) {
				if(arr[j] > arr[j+1]) {
					int temp;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	// Merge Sort
	public static void mSort(int[] arr) {
		// Not Optimum
		for(int i = 0 ;i < arr.length ; i++) {
			for(int j = 0 ; j < arr.length-1-i ; j++) {
				if(arr[j] > arr[j+1]) {
					int temp;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {20,15,1,2,4,9,25,45,35,33,44,9,84,100,50,50};
		
		// Bubble Sort
//		bSort(arr);
//		disp(arr);
		
		// Selection Sort
//		sSort(arr);
//		disp(arr);
//		
//		
		// Insertion Sort
//		iSort(arr);
//		disp(arr);
		
//		
//		
//		// Quick Sort
		qSort(arr,0,arr.length-1);
		disp(arr);
//		
//		
//		// Heap Sort
//		hSort(arr);
//		
//		
//		// Merge Sort
//		mSort(arr);
	}

}
