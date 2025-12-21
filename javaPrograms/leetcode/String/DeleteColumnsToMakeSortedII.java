/**
   955. Delete Columns to Make Sorted II

   You are given an array of n strings strs, all of the same length.

   We may choose any deletion indices, and we delete all the characters in
   those indices for each string.

   For example, if we have strs = ["abcdef","uvwxyz"] and deletion indices
   {0, 2, 3}, then the final array after deletions is ["bef", "vyz"].

   Suppose we chose a set of deletion indices answer such that after deletions,
   the final array has its elements in lexicographic order
   (i.e., strs[0] <= strs[1] <= strs[2] <= ... <= strs[n - 1]).
   Return the minimum possible value of answer.length.

   Example 1:
   Input: strs = ["ca","bb","ac"]
   Output: 1
   Explanation: 
   After deleting the first column, strs = ["a", "b", "c"].
   Now strs is in lexicographic order (ie. strs[0] <= strs[1] <= strs[2]).
   We require at least 1 deletion since initially strs was not in lexicographic
   order, so the answer is 1.

   Example 2:
   Input: strs = ["xc","yb","za"]
   Output: 0
   Explanation: 
   strs is already in lexicographic order, so we do not need to delete anything.
   Note that the rows of strs are not necessarily in lexicographic order:
   i.e., it is NOT necessarily true that (strs[0][0] <= strs[0][1] <= ...)

   Example 3:
   Input: strs = ["zyx","wvu","tsr"]
   Output: 3
   Explanation: We have to delete every column.

   Constraints:
   n == strs.length
   1 <= n <= 100
   1 <= strs[i].length <= 100
   strs[i] consists of lowercase English letters.
*/
import java.util.*;

class DeleteColumnsToMakeSortedII {
    private static int minDeletionSize(String[]strs) {
        Log.info("----------------------------------------------------------------");
        Log.info((Object) new Object[]{"mindeletionsize start :--", (Object)strs});
        if (strs.length == 0) return 0;
        int cnt = 0;
        int i = 0, j = 1;
        while (i < strs.length-1 && strs[0].length() > 0) {
            String one = strs[i];
            String two = strs[j];

            int index = compare(one, two);
            if (index != -1) {
                deleteIndex(strs, index);
                cnt++;
                i = 0; j = 1;
            } else {
                i++; j++;
                if (j == strs.length) {
                    i++; j = i+1;
                }
            }
        }
        Log.info((Object) new Object[]{"mindeletionsize enddd :--", (Object)strs}, cnt);
        Log.info("----------------------------------------------------------------");
        return cnt;
    }

    private static void deleteIndex(String[]strs, int index) {
        Log.info((Object) new Object[]{"deleteIndex start", (Object)strs, index});
        for (int i = 0; i < strs.length; ++i) {
            StringBuilder newstr = new StringBuilder(strs[i]);
            newstr.deleteCharAt(index);
            strs[i] = newstr.toString();
        }
        Log.info((Object) new Object[]{"deleteIndex enddd", (Object)strs, index});
    }
    
    private static int compare(String one, String two) {
        Log.info((Object) new Object[]{"compare start", one, two});
        int n = -1;
        for (int i = 0; i < one.length(); ++i) {
            if (one.charAt(i) > two.charAt(i)) {
                n = i;
                Log.info((Object) new Object[]{"compare enddd", one, two, n});
                return n;
            }          
            else if (one.charAt(i) < two.charAt(i)) {
                n = -1;
                Log.info((Object) new Object[]{"compare enddd", one, two, n});
                return n;
            }
        }
        Log.info((Object) new Object[]{"compare enddd", one, two, -1});
        return -1;
    }
    
    public static void main(String[]args) {
        IO.println(minDeletionSize(new String[]{"ca","bb","ac"}));
        IO.println(minDeletionSize(new String[]{"xc","yb","za"}));
        IO.println(minDeletionSize(new String[]{"zyx","wvu","tsr"}));
        IO.println(minDeletionSize(new String[]{"xga","xfb","yfa"})); // 1
    }
}
