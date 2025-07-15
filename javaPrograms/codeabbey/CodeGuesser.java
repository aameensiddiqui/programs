import java.util.Scanner;

public class CodeGuesser
{
    public static void main(String[]args)
    {
	Scanner scan = new Scanner(System.in);
	int t = scan.nextInt();
	int num = 0;
	int guess = 0;
	int[]g0 = new int[11];
	int[]g1 = new int[11];
	int[]g2 = new int[11];
        
	for(int i = 0 ; i <= t ; i++){
	    num = scan.nextInt();
	    guess = scan.nextInt();
	    
	    if(guess == 0){
	        int cnt = 3;
		while(num > 0){
		    int digit = 0;
		    int an = 0;
		    digit = num % 10;
		    if(digit == 0) digit = 10;
		    num = num / 10;
		    an = (digit * 10) + cnt;
		    g0[digit] = an;
		    --cnt;
		}
	    } else if(guess == 1){
	        int cnt = 3;
		while(num > 0){
		    int digit = 0;
		    int an = 0;
		    digit = num % 10;
		    if(digit == 0) digit = 10;
		    num = num / 10;
		    an = (digit * 10) + cnt;;
		    g1[digit] = an;
	            --cnt;
		}
	    } else if(guess == 2){
	        int cnt = 3;
		while(num > 0){
		    int digit = 0;
		    int an = 0;
		    digit = num % 10;
		    if(digit == 0) digit = 10;
		    num = num / 10;
		    an = (digit * 10) + cnt;
		    g2[digit] = an;
	            --cnt;
		}
	    }
	    
        }
	// scan.close();
        printArray(g0);
	printArray(g1);
	printArray(g2);
    }

    static void printArray(int[]arr){
	System.out.println("printing array:");
	for(int i = 0 ; i < arr.length ; ++i){
	    System.out.print(arr[i]+" ");
	}
	System.out.println("-------------");
    }
}


/*
  
  -------------

  846
  
6
402 0
390 0
816 2
848 2
777 0
815 1

  the corect number should be in the right position also?
  
  take an array of 0-9
  if ans = 0
  i have to mark those three numbers that
      1. position x
      2. number x

  0 1 2 3 4 5 6 7 8 9
  x y x x x   y   y x

  1:
  4 0 2 --> 0

  2:
  3 9 0 --> 0

  3:
  8 1 6 --> 2

  4:
  8 4 8 --> 2

  5:
  7 7 7 --> 0
  
  6:
  8 5 1 --> 1

  -----------------------
  array logic for storing and getting num

  to add:
  digit * 10 + position

  3 arrays:
  81 = 8 at 1st position
  82 = 8 at 2nd position
  83 = 8 at 3rd position

  to get:
  digit % 10 = position
  digit / 10 = num
  -----------------------

  


*/
