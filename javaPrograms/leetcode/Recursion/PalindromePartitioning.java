/**
   Substring is a contiguous non-empty sequence of characters within a string 
   Palindrome is a string that reads the same forward and backward

   131. Palindrome Partitioning

   Given a string s, partition s such that every substring of the partition
   is a palindrome. Return all possible palindrome partitioning of s.

   Example 1:
   Input: s = "aab"
   Output: [["a","a","b"],["aa","b"]]

   Example 2:
   Input: s = "a"
   Output: [["a"]]
 
   Constraints:
   1 <= s.length <= 16
   s contains only lowercase English letters.
*/
import java.util.*;
class PalindromePartitioning {
    public static int n = 0;
    public static boolean isPalindrome(String s, int low, int high) {
        while(low < high) {
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
    public static void backtrack(List<List<String>> ans, List<String> list, String s, int start) {
        
        if(start == s.length()) ans.add(new ArrayList<>(list));
        else {
            for(int i = start; i < s.length(); ++i) {
                if(isPalindrome(s, start, i)) {
                    log.info(n+++"====== "+s.substring(start, i+1));
                    list.add(s.substring(start, i+1));
                    backtrack(ans, list, s, i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), s, 0);
        return ans;
    }
    public static void main(String[]args) {
        // String s = "aab";
        // String s = "a";
        String s = "googleelgoog";
        log.info(partition(s));
    }
    private static final Log log = new Log();
}
/**
class Solution {
    public List<List<String>> partition(String s) {
        return new java.util.AbstractList(){
            List<List<String>> result;
            private void init(){
                result = new ArrayList();
                backtrack(0, s, new ArrayList(), result);
            }

            @Override
            public int size(){
                if(result == null){
                    init();
                }
                return result.size();
            }

            @Override
            public List<String> get(int position){
                return result.get(position);
            }
        };
    }

    private void backtrack(int index, String s, List<String> list, List<List<String>> result){
        if(index == s.length()){
            // for(String item : list){
            //     if(!isPalindrome(item)){
            //         return;
            //     }
            // }
            result.add(new ArrayList(list));
            return;
        }
        for(int i = index; i < s.length(); i++){
            String st = s.substring(index, i + 1);
            if(isPalindrome(st)){
                list.add(st);
                backtrack(i + 1, s, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int low = 0;
        int high = s.length() - 1;
        while(low <= high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}



class PalindromePartitioning {
    int n;
    char[] ss;
    boolean dp [][];
    String s;
    List<List<String>> output;
    public List<List<String>> partition(String s) {
        output = new ArrayList<>();
        this.s =s;
        n = s.length();
        dp = new boolean[n][n];
        ss = s.toCharArray();

        // for(int i=0;i<n;i++){
        //     dp[i][i] =true;
        // }
        // for(int i=0;i<n-1;i++){
        //     dp[i][i+1] = ss[i] == ss[i+1];
        // }

        // for(int i=2;i< n;i++){
        //     for(int j=0; j< n-i;j++) {
        //         if(ss[j] == ss[i+j]) {
        //             dp[j][i+j] = dp[j+1][i+j-1];
        //         }
        //     }
        // }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        List<String> res = new ArrayList<>();
        match(res,0);
        return output;
    }

    public void match(List<String> res, int index){
        if(index == n){
            output.add(new ArrayList<>(res));
            return;
        }
        for(int i=index;i<n;i++) {
            // if(dp[index][i]){
            if(isPalindrome(index,i)){
                res.add(s.substring(index,i+1));
                match(res, i+1);
                res.remove(res.size()-1);
            }
        }
    }

    private boolean isPalindrome(int low, int high){
        // int low = 0;
        // int high = s.length() - 1;
        while(low <= high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
 */
