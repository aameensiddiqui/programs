import java.util.*;

class WordBreak {
    // bottom-up dynamic programming approach
    private static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; --i) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() &&
                    (s.substring(i, i + w.length()).equals(w))) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) break;
            }
        }
        return dp[0];
    }

    public static void main(String[]args) {
        List<String> wordDict = new ArrayList<>();
        String[] arr = {"leet","code","cats","dog","sand","and","cat","apple",
                        "pen","pine","pineapple","a","aa","aaa","aaaa","aaaaa",
                        "aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        for (String s : arr) wordDict.add(s);
        log.info(wordBreak("leetcode", wordDict));
        log.info(wordBreak("applepenapple", wordDict));
        log.info(wordBreak("catsandog", wordDict));
        log.info(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
                           "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
                           "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
                           "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict));
    }
}
/**
    // top-down dynamic programming solution with pruning
    private static HashSet<String> wordSet;
    private static Boolean[] memo;
    private static int t;
    private static boolean dfs(int i, String s) {
        if (i == s.length()) return true;
        if (memo[i] != null) return memo[i];
        for (int j = i; j < Math.min(t + i, s.length()); ++j) {
            if (wordSet.contains(s.substring(i, j + 1))) {
                if (dfs(j + 1, s)) {
                    memo[i] = true;
                    return true;
                }
            }
        }
        memo[i] = false;
        return false;
    }
    private static boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];
        t = 0;
        for (int i = 0; i < wordDict.size(); ++i)
            t = Math.max(t, wordDict.get(i).length());
        return dfs(0, s);
    }
*/
/**
    // optimized version of recursion using memoization
    private static Map<Integer, Boolean> memo;
    private static boolean dfs(int i, String s, List<String> wordDict) {
        if (memo.containsKey(i)) return memo.get(i);
        for (String w : wordDict) {
            if (i + w.length() <= s.length() &&
                (s.substring(i, i + w.length()).equals(w))) {
                if (dfs(i + w.length(), s, wordDict)) {
                    memo.put(i, true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }
    private static boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);
        return dfs(0, s, wordDict);
    }
*/
/**
    // recursion and HashSet for O(1) lookup time
    private static boolean dfs(int i, String s, HashSet<String> wordSet) {
        if (i == s.length()) return true;
        for (int j = i; j < s.length(); ++j) {
            if (wordSet.contains(s.substring(i, j + 1))) {
                if (dfs(j + 1, s, wordSet)) return true;
            }
        }
        return false;
    }
    private static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        return dfs(0, s, wordSet);
    }
*/
/**
    // recursive
    private static boolean dfs(int i, String s, List<String> wordDict) {
        if (i == s.length()) return true;
        for (String w : wordDict) {
            if (i + w.length() <= s.length() &&
                (s.substring(i, i + w.length()).equals(w))) {
                if (dfs(i + w.length(), s, wordDict)) return true;
            }
        }
        return false;
    }
    private static boolean wordBreak(String s, List<String> wordDict) {
        return dfs(0, s, wordDict);
    }
*/
