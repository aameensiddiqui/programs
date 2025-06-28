import java.util.Random;

public class QS{
    public static void main(String[]args){
	Random r = new Random();
	int[]arr = new int[100];
	for(int i = 0 ; i < arr.length ; i++){
	    arr[i] = r.nextInt(1000);
	}
	print(arr);

	qsort(arr);

	print(arr);
    }
    
    public static void print(int[]arr){
	for(int i = 0 ; i < arr.length ; i++){
	    System.out.print(arr[i]+" ");
	}
	System.out.println("\n------------------");
    }

    public static int[] qsort(int[]arr){

	if(arr.length < 2) return arr; // escape for recursion

	int pivot = arr[0];
	int lCount = 0;
	int hCount = 0;
	
	for(int i = 1 ; i < arr.length ; i++){
	    if(arr[i] <= pivot) lCount++;
	    else hCount++;
	}
	
	int[]lesser = new int[lCount];
	int[]higher = new int[hCount];
	
	lCount = 0; hCount = 0;

	// fill the lesser and higher arrays
	for(int i = 1 ; i < arr.length ; i++){
	    if(arr[i] <= pivot) lesser[lCount++] = arr[i];
	    else higher[hCount++] = arr[i];
	}

	// recursion
	qsort(lesser);
	qsort(higher);

	// combine lesser[] + pivot + higher[]
	int index = 0;
	for(int i = 0 ; i < lesser.length ; i++){
	    arr[index++] = lesser[i];
	}
	arr[index++] = pivot;

	for(int i = 0 ; i < higher.length ; i++){
	    arr[index++] = higher[i];
	}

	return arr;
    }
    
}
