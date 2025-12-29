import java.util.Random;

public class BinS{
    public static void main(String[]args){
	Random r = new Random();
	int[]arr = new int[50];
	for(int i = 0; i < 50; ++i){
	    arr[i] = r.nextInt(1000);
	}
	//printArray(arr);
	arr = bubbleSort(arr);
	printArray(arr);
	yo();
    }

    public static int[] bubbleSort(int[]arr){
	for(int i = arr.length-1; i >= 0; --i){
	    boolean didSwap = false;
	    for(int j = 0; j <= i-1; ++j){
		if(arr[j] > arr[j+1]){
		    int temp = arr[j];
		    arr[j] = arr[j+1];
		    arr[j+1] = temp;
		    didSwap = true;
		}
	    }
	    if(!didSwap) break;
	}
	return arr;
    }
    
    public static void printArray(int[]arr){
	for(int i = 0; i < 50; ++i){
	    System.out.println((i+1)+":    "+arr[i]);
	}
    }
    public static void yo(){
	System.err.println("yo");
    }
}
