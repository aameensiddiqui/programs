package prog08;

public class Merge {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {11,22,33,44,55};
		
		int[] ans = new int[arr1.length+arr2.length];
		
		int j = 0;
		for(int i = 0 ; i < ans.length ; i++) {
			ans[i] = arr1[j];
			ans[++i] = arr2[j];
			j++;
		}
		for(int i = 0 ; i<ans.length ;i++) {
			System.out.println(ans[i]);
		}
		
//		int size = arr1.length + arr2.length ;
//		int[] nArr = new int[size];
//		
//		int i = 0;
//		for(int j = 0 ; j < arr1.length ; j++) {
//			nArr[i] = arr1[j];
//			i++;
//		}
//		for(int j = 0 ; j < arr2.length ; j++) {
//			nArr[i] = arr2[j];
//			i++;
//		}
//		
//		for(int j = 0 ; j<size ;j++) {
//			System.out.println(nArr[j]);
//		}
	}

}
