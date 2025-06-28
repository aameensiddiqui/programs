import java.util.Random;

public class Bubble
{
    public static void main(String[]args)
    {
	int[]arr = new int[10];
	Random r = new Random();

	for(int i = 0 ; i < 10 ; ++i){
	    arr[i] = r.nextInt(1000);
	}
	arr = bub(arr);
	printArray(arr);
    }
    
    public static void printArray(int[]arr)
    {
	for(int i = 0 ; i < arr.length ; ++i){
	    if(i == 0)
		System.out.println("[" + arr[i] + ", ");
	    else if(i == arr.length-1)
		System.out.println(arr[i] + "]");
	    else
		System.out.println(arr[i] + ", ");
	}
    }

    public static int[] bub(int[]arr)
    {
	for(int i = arr.length ; i >= 0 ; --i){
	    boolean didSwap = false;
	    for(int j = 0 ; j < i-1 ; ++j){
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

    
}
