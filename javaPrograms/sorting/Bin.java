public class Bin {
    public static void main(String[] args){
	int[]arr = new int[1000];
	int i = 1; int n = 0;
	while(n != arr.length){
	    if(isPrime(i)){
		arr[n] = i;
		n++;
		++i;
	    }
	    ++i;
	}
	// printer(arr);
	int find = 773;
	int ans = binSearch(find, arr);
	if(ans == -9999) System.out.println("Not found!");
	else System.out.println("Found it! It's at => "+ ans);
	yo();
    }

    private static int binSearch(int n, int[]arr){
	int low = 0;
	int high = arr.length-1;
	while(low <= high){
	    int mid = (low + high)/2;
	    if(arr[mid] == n) return mid;
	    if(n < arr[mid]){
		high = mid - 1;
	    } else {
		low = mid + 1;
	    }
	}
	return -9999;
    }

    private static void printer(int[]arr){
	System.out.print("\n[ ");
	for(int i = 0 ; i < arr.length ; i++){
	    if(i == arr.length-1) System.out.print(arr[i] + " ]\n");
	    else System.out.print(arr[i] + ", ");
	}
    }

    private static boolean isPrime(int n){
	if(n < 2) return false;
	if(n == 2) return true;
	if(n % 2 == 0) return false;
	for(int i = 3 ; i <= Math.sqrt(n) ; i+=2){
	    if(n % i == 0) return false;
	}
	return true;
    }
    
    private static void yo(){
	System.out.println("yo");
    }
    
}
