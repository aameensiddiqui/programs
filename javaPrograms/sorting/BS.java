import java.util.Random;
public class BS{
    public static void main(String[]args){
	Random r = new Random();
	int[]arr = new int[100];
	for(int i = 0 ; i < arr.length ; i++){
	    arr[i] = r.nextInt(1000);
	}

	printArray(arr);
	bsort(arr);
	printArray(arr);
    }

    public static void bsort(int[]arr){
	for(int i = arr.length-1 ; i >= 0 ; i--){
	    boolean didSwap = false;
	    for(int j = 0 ; j <= i-1 ; j++){
		if(arr[j+1] < arr[j]){
		    int temp = arr[j];
		    arr[j] = arr[j+1];
		    arr[j+1] = temp;
		    didSwap = true;
		}
	    }
	    if(!didSwap) break;
	}
    }

    public static void printArray(int[]arr){
	for(int i = 0 ; i < arr.length ; i++){
	    System.out.print(arr[i]+" ");
	}
	System.out.println("\n-----------");
    }
}
