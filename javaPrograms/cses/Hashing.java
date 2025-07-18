public class Hashing
{
    public static void main(String[]args)
    {
	/* number hashing */
	int[]arr = {1, 2, 1, 3, 2, 4, 6, 1, 3, 5, 8};
	int[]hashArray = new int[11];
	for(int i = 0 ; i < hashArray.length ; ++i)
	    hashArray[arr[i]]++;

	for(int i = 0 ; i < hashArray.length ; ++i)
	    System.out.println(i+" : "+ hashArray[i]);
    }
}
