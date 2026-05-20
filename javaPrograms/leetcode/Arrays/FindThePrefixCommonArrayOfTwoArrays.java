/**
   2657. Find the Prefix Common Array of Two Arrays

   You are given two 0-indexed integer permutations A and B of length n.

   A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers
   that are present at or before the index i in both A and B.

   Return the prefix common array of A and B.

   A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly
   once.

   Example 1:
   Input: A = [1,3,2,4], B = [3,1,2,4]
   Output: [0,2,3,4]
   Explanation: At i = 0: no number is common, so C[0] = 0.
   At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
   At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
   At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.

   Example 2:
   Input: A = [2,3,1], B = [3,1,2]
   Output: [0,1,3]
   Explanation: At i = 0: no number is common, so C[0] = 0.
   At i = 1: only 3 is common in A and B, so C[1] = 1.
   At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.

   Constraints:
   1 <= A.length == B.length == n <= 50
   1 <= A[i], B[i] <= n
   It is guaranteed that A and B are both a permutation of n integers.
*/
/**
   Intuition
   We need to compute, for every index i, how many numbers have appeared in both arrays within the prefix [0...i].

   Since A and B are permutations, every number appears exactly once in each array.

   A number becomes common the moment we have seen it in both arrays.

   Approach
   Instead of repeatedly comparing prefixes, we can track which numbers have already appeared using a seen array:

   As we check every element in array A:

   If A[i] was already seen before, it means it previously appeared in B.
   (so it is now common).
   Otherwise, mark it as seen.
   Do the same for array B.

   Each number contributes exactly once to the common count.
*/
class FindThePrefixCommonArrayOfTwoArrays {
    private static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int cnt = 0;
        int[] C = new int[n];
        boolean[] S = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (S[A[i] - 1]) cnt++;
            else S[A[i] - 1] = true;
            if (S[B[i] - 1]) cnt++;
            else S[B[i] - 1] = true;
            C[i] = cnt;
        }
        return C;
    }
    public static void main(String[] args) {
        Log.info(findThePrefixCommonArray(new int[] {1,3,2,4}, new int[] {3,1,2,4}));
        Log.info(findThePrefixCommonArray(new int[] {2,3,1}, new int[] {3,1,2}));
    }
}
/**
    private static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int a = 0; a <= i; ++a) {
                for (int b = 0; b <= i; ++b) {
                    if (A[a] == B[b]) {cnt++; break;}
                }
            }
            C[i] = cnt;
        }
        return C;
    }
*/
