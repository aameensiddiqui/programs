/**
   2213. Longest Substring of One Repeating Character

   You are given a 0-indexed string s. You are also given a 0-indexed string queryCharacters of length k and a 0-indexed
   array of integer indices queryIndices of length k, both of which are used to describe k queries.

   The ith query updates the character in s at index queryIndices[i] to the character queryCharacters[i].

   Return an array lengths of length k where lengths[i] is the length of the longest substring of s consisting of only
   one repeating character after the ith query is performed.

   Example 1:
   Input: s = "babacc", queryCharacters = "bcb", queryIndices = [1,3,3]
   Output: [3,3,4]
   Explanation:
   - 1st query updates s = "bbbacc". The longest substring consisting of one repeating character is "bbb" with length 3.
   - 2nd query updates s = "bbbccc".
   The longest substring consisting of one repeating character can be "bbb" or "ccc" with length 3.
   - 3rd query updates s = "bbbbcc". The longest substring consisting of one repeating character is "bbbb" with length 4.
   Thus, we return [3,3,4].

   Example 2:
   Input: s = "abyzz", queryCharacters = "aa", queryIndices = [2,1]
   Output: [2,3]
   Explanation:
   - 1st query updates s = "abazz". The longest substring consisting of one repeating character is "zz" with length 2.
   - 2nd query updates s = "aaazz". The longest substring consisting of one repeating character is "aaa" with length 3.
   Thus, we return [2,3].

   Constraints:
   1 <= s.length <= 105
   s consists of lowercase English letters.
   k == queryCharacters.length == queryIndices.length
   1 <= k <= 105
   queryCharacters consists of lowercase English letters.
   0 <= queryIndices[i] < s.length
*/
/**
   Approach: Segment Tree
   Intuition
   We can use a segment tree to maintain information about the string s.
   Each node of the segment tree stores the following information for its corresponding interval:
   ## pre: The length of the longest continuous sequence of identical characters at the beginning of the interval.

   ## suf: The length of the longest continuous sequence of identical characters at the end of the interval.

   ## maxLen: The length of the longest continuous sequence of identical characters within the interval.

   ## leftChar: The character at the leftmost position of the interval.

   ## rightChar: The character at the rightmost position of the interval.
   For a leaf node, whose interval has length 1, we have pre = suf = maxLen = 1,
   and leftChar = rightChar = s[i].
   For a non-leaf node, let its left and right child nodes be left and right, respectively.
   We can merge their information according to the following rules:

   ## leftChar is inherited from the leftChar of the left child.

   ## rightChar is inherited from the rightChar of the right child.

   ## pre initially takes the value of pre*left.
   If the prefix of the left child covers the entire left interval,
   and rightChar*left is equal to leftChar*right, then the prefix can be extended into the right child.
   In this case, pre=pre*left+preright.

   ## suf initially takes the value of suf*right. If the suffix of the right child covers the entire
   right interval, and rightChar*left is equal to leftChar*right, then the suffix can be extended into
   the left child. In this case, suf=suf*right+sufleft.

   ## maxLen initially takes the maximum of maxLen*left and maxLen*right. If rightChar*left is equal to
   leftChar*right, the suffix of the left child and the prefix of the right child can be concatenated.
   Therefore, we update maxLen with suf*left+pre*right.
   For each query, we perform a point update, changing the character at the corresponding position to
   the new character. After each update, maxLen at the root of the segment tree represents the length
   of the longest substring consisting of a single repeated character in the current string.
   The initial construction of the segment tree takes O(n) time, and each point update takes O(logn) time.
   Therefore, the total time complexity is O(n+klogn).

   Complexity Analysis

   Let n be the length of the string s, and let k be the number of queries.
   Time complexity: O((n+k)logn).
   Building the segment tree initially takes O(n) time. Each query performs a single-point update,
   which takes O(logn) time. Therefore, the total time complexity is O(n+klogn).
   Space complexity: O(n).
   The segment tree uses arrays of size O(n).
*/
class LongestSubstringOfOneRepeatingCharacter {
    private static char[] sArr;
    private static int[] pre, suf, maxLen;
    private static char[] leftChar, rightChar;
    private static int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {
        int n = s.length();
        sArr = s.toCharArray();
        pre = new int[4 * n];
        suf = new int[4 * n];
        maxLen = new int[4 * n];
        leftChar = new char[4 * n];
        rightChar = new char[4 * n];

        build(1, 0, n - 1);
        int k = queryIndices.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = maxLen[1];
        }
        return ans;
    }
    private static void pushUp(int u, int l, int r) {
        int mid = (l + r) >> 1;
        int leftLen = mid - l + 1,
            rightLen = r - mid;
        int left = u << 1,
            right = (u << 1) | 1;
        leftChar[u] = leftChar[left];
        rightChar[u] = rightChar[right];
        pre[u] = pre[left];
        if (pre[left] == leftLen && rightChar[left] == leftChar[right]) {
            pre[u] = pre[left] + pre[right];
        }
        suf[u] = suf[right];
        if (suf[right] == rightLen && rightChar[left] == leftChar[right]) {
            suf[u] = suf[right] + suf[left];
        }
        maxLen[u] = Math.max(maxLen[left], maxLen[right]);
        if (rightChar[left] == leftChar[right]) {
            maxLen[u] = Math.max(maxLen[u], suf[left] + pre[right]);
        }
    }
    private static void build(int u, int l, int r) {
        if (l == r) {
            pre[u] = 1;
            suf[u] = 1;
            maxLen[u] = 1;
            leftChar[u] = sArr[l];
            rightChar[u] = sArr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build((u << 1) | 1, mid + 1, r);
        pushUp(u, l, r);
    }
    private static void update(int u, int l, int r, int pos, char ch) {
        if (l == r) {
            leftChar[u] = ch;
            rightChar[u] = ch;
            return;
        }
        int mid = (l + r) >> 1;
        if (pos <= mid)
            update(u << 1, l, mid, pos, ch);
        else
            update((u << 1) | 1, mid + 1, r, pos, ch);
        pushUp(u, l, r);
    }
    public static void main(String[] args) {
        Log.info(longestRepeating("babacc", "bcb", new int[] {1,3,3}));
        Log.info(longestRepeating("abazz", "aa", new int[] {2,1}));
    }
}
/**
    // TLE
    private static int longestSubstring(char[] arr) {
        int maxlen = 1, len = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] == arr[i]) len++;
            else len = 1;
            maxlen = Math.max(maxlen, len);
        }
        return maxlen;
    }
    private static int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {
        char[] sarr = s.toCharArray();
        char[] qchar = queryCharacters.toCharArray();
        int[] res = new int[qchar.length];
        for (int i = 0; i < queryIndices.length; ++i) {
            sarr[queryIndices[i]] = qchar[i];
            res[i] = longestSubstring(sarr);
            // Log.info(res);
        }
        return res;
    }
*/
