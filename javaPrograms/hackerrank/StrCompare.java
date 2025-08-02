// // import java.io.*;
// // import java.util.*;

// class StrCompare
// {
//     public static void main(String[] args)
//     {
//         // Scanner sc = new Scanner(System.in);
//         // String A = sc.next();
//         // String B = sc.next();
//         /* Enter your code here. Print output to STDOUT. */
//         String A = "hello";
//         String B = "java";

//         System.out.println(A.length()+B.length());
        
//         if(A.compareTo(B) >= 0) System.out.println("Yes");
//         else System.out.println("No");

        
//         System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1, A.length()) + " " +
//                            B.substring(0, 1).toUpperCase() + B.substring(1, B.length()));
//     }
// }

class StrCompare
{
    public static String getSmallestAndLargest(String s, int k)
    {
        String smallest = s.substring(0, 3);
        // System.out.println(smallest);
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for(int i = 0; i < s.length()-2; ++i) {
            if(s.substring(i, i+3).compareTo(smallest) < 0) {
                smallest = s.substring(i, i+3);
                // System.out.println(smallest);
            }
            if(s.substring(i, i+3).compareTo(largest) > 0)
                largest = s.substring(i, i+3);
        }
        return smallest + "\n" + largest;
    }


    public static void main(String[]args)
    {
        String s = "welcometojava";
        int k = 3;
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
