/**
   997. Find the Town Judge

   In a town, there are n people labeled from 1 to n. There is a rumor that one of these
   people is secretly the town judge.

   If the town judge exists, then:

   The town judge trusts nobody.
   Everybody (except for the town judge) trusts the town judge.
   There is exactly one person that satisfies properties 1 and 2.
   You are given an array trust where trust[i] = [ai, bi] representing that the person
   labeled ai trusts the person labeled bi. If a trust relationship does not exist in
   trust array, then such a trust relationship does not exist.

   Return the label of the town judge if the town judge exists and can be identified,
   or return -1 otherwise.

   Example 1:
   Input: n = 2, trust = [[1,2]]
   Output: 2

   Example 2:
   Input: n = 3, trust = [[1,3],[2,3]]
   Output: 3

   Example 3:
   Input: n = 3, trust = [[1,3],[2,3],[3,1]]
   Output: -1

   Constraints:
   1 <= n <= 1000
   0 <= trust.length <= 104
   trust[i].length == 2
   All the pairs of trust are unique.
   ai != bi
   1 <= ai, bi <= n
*/
class FindTheTownJudge {
    private static int findJudge(int n, int[][] trust) {
        int[] arr = new int[n + 1];
        for (int[] t : trust) {
            arr[t[0]]--;
            arr[t[1]]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (arr[i] == n - 1) return i;
        }
        return -1;
    }
    public static void main(String[]args) {
        log.info(findJudge(2, new int[][] {{1, 2}}));
        log.info(findJudge(3, new int[][] {{1, 3}, {2, 3}}));
        log.info(findJudge(3, new int[][] {{1, 3}, {2, 3}, {3, 1}}));
    }
}
/**
    private static int findJudge(int n, int[][] trust) {
        int[] out = new int[n + 1];
        int[] in  = new int[n + 1];
        for (int[] t : trust) {
            out[t[0]]++;
            in[t[1]]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (out[i] == 0 && in[i] == n - 1) return i;
        }
        return -1;
    }
*/
