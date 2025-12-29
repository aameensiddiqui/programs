import java.util.Random;
public class IS{
    public static void main(String[]args){
	Random r = new Random();
	int[]arr = new int[100];
	for(int i = 0 ; i < arr.length ; i++){
	    arr[i] = r.nextInt(1000);
	}
	printArray(arr);
	isort(arr);
	printArray(arr);
    }

    public static void isort(int[]arr){
	for(int i = 1 ; i < arr.length ; i++){
	    int j = i;
	    while(j > 0 && arr[j-1] > arr[j]){
		int temp = arr[j-1];
		arr[j-1] = arr[j];
		arr[j] = temp;
		j--;
	    }
	}
    }
    
    public static void printArray(int[]arr){
	for(int i = 0 ; i < arr.length ; i++){
	    System.out.print(arr[i]+" ");
	}
	System.out.println("\n-------------");
    }
}
