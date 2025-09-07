/**
   1304. Find N Unique Integers Sum up to Zero

   Given an integer n, return any array containing n unique integers such that
   they add up to 0.

   Example 1:

   Input: n = 5
   Output: [-7,-1,1,3,4]
   Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
   Example 2:

   Input: n = 3
   Output: [-1,0,1]
   Example 3:

   Input: n = 1
   Output: [0]
 
   Constraints:
   1 <= n <= 1000
   **************************
   Approach: Construction
   Intuition
   We start by placing the smallest [n/2] positive integers and their
   negatives into the array. At this point, their sum is 0.

   When n is even, the array already satisfies the requirements.
   When n is odd, we add 0 to the array.
   Thus, the n numbers are all distinct, and their sum is 0.
   This gives us an array that satisfies the requirements.

   Complexity Analysis
   Time complexity: O(n).
   Space complexity: O(1).
   Apart from the output array ans, the extra space used is constant.
*/
class FindNUniqueIntSumUpTo0 {
    public static int[] sumZero(int n) {
        int[]ans = new int[n];
        int ind  = 0;
        for(int i = 1; i <= n/2; ++i) {
            ans[ind++] = i;
            ans[ind++] = -i;
        }
        if(n % 2 == 1) ans[ind] = 0;
        return ans;
    }
    public static void main(String[]args) {
        int n = 5;
        log.info(sumZero(n));
    }
    private static final Log log = new Log();
}
/**
   Approach 1:

   class Solution {
       public int[] sumZero(int n) {
           int[] res = new int[n];
           res[0] = n * (1 - n) / 2;
           for (int i = 1; i < n; ++i)
           res[i] = i;
           return res;
       }
   }

   Example:
   n=9
   res=[-36,1,2,3,4,5,6,7,8]

   Mathematical Idea
   We generate an array of length n with:
   - a sequence of consecutive positive numbers from 1 to (n-1).
   - and a single negative number to reset the sum of the array to 0.

   Recall: To compute the sum of the first N natural numbers, we use the triangular number formula:

   TN = 1+2+3+...+N = (N(N+1))/2

   Let S be the total sum of series from 1 to n-1.

   S = [(n-1)((n-1)+1)]/2
   = [n(n-1)]/2

   To restore the sum back to 0, we need to insert a negative number -S.
   For simplicity, we set -S as the first element res[0]:

   res[0] = -S
   = -[n(n-1)]/2
   = [n(1-n)]/2

   Thus, the total sum of the generated array is 0:

   -S + S = 0

   Finally, we construct the sequence:

   res = {[n(1-n)]/2, 1, 2, 3, ... , n-1}


   ## Approach 2:

   class Solution {
       public int[] sumZero(int n) {
           int[] A = new int[n];
           for (int i = 0; i < n; ++i)
               A[i] = i * 2 - n + 1;
           return A;
       }
   }

   Examples:
   n=1: [0]
   n=2: [-1,1]
   n=3: [-2,0,2]
   n=4: [-3,-1,1,3]
   n=5: [-4,-2,0,2,4]

   The generated sequence is symmetric around zero, and consecutive terms are evenly spaced.

   Arithmetic Progression
   Let the sequence be an arithmetic progression (AP) of length n:
   a0, a1, a2, ..., a(n-1)

   with:
   a(k) = a(k-1) + Δ,  Δ ≠ 0
   a0 = first term
   Δ = common difference

   Condition for Zero Sum
   The sum of an AP is:

   S = (a0 + a(n-1)) ⋅ n / 2

   For S = 0, we require:

   a0 + a(n-1) = 0

   Since:
   a(n-1) = a0 + (n-1)Δ

   we obtain:
   a(n-1) - a0 = (n-1)Δ = -2a0

   Choosing Δ
   From the relation:
   (n-1)Δ = -2a0

   a natural choice is:
   Δ = 2,  a0 = 1-n

   General Formula
   Thus each term is:

   A[i] = a0 + iΔ
   = (1-n) + 2i
   = 2i - n + 1

   This generates n integers symmetric about zero with sum equal to zero.

 */
