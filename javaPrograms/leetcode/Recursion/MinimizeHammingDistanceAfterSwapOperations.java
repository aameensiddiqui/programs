/**
   1722. Minimize Hamming Distance After Swap Operations

   You are given two integer arrays, source and target, both of length n. You are also given
   an array allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you are allowed
   to swap the elements at index ai and index bi (0-indexed) of array source. Note that you can
   swap elements at a specific pair of indices multiple times and in any order.

   The Hamming distance of two arrays of the same length, source and target, is the number of
   positions where the elements are different. Formally, it is the number of indices i for
   0 <= i <= n-1 where source[i] != target[i] (0-indexed).

   Return the minimum Hamming distance of source and target after performing any amount of swap
   operations on array source.

   Example 1:
   Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
   Output: 1
   Explanation: source can be transformed the following way:
   - Swap indices 0 and 1: source = [2,1,3,4]
   - Swap indices 2 and 3: source = [2,1,4,3]
   The Hamming distance of source and target is 1 as they differ in 1 position: index 3.

   Example 2:
   Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
   Output: 2
   Explanation: There are no allowed swaps.
   The Hamming distance of source and target is 2 as they differ in 2 positions: index 1 and
   index 2.

   Example 3:
   Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
   Output: 0

   Constraints:
   n == source.length == target.length
   1 <= n <= 105
   1 <= source[i], target[i] <= 105
   0 <= allowedSwaps.length <= 105
   allowedSwaps[i].length == 2
   0 <= ai, bi <= n - 1
   ai != bi
*/
import java.util.*;

class MinimizeHammingDistanceAfterSwapOperations {
    private static int[] parent;
    private static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        // if their parents are not same we merge two groups
        if (rootX != rootY) parent[rootX] = rootY;
    }
    private static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        // step 1 initialize each index as its own group
        parent = new int[n];
        for (int i = 0; i < n; ++i) parent[i] = i;

        // step 2 unionize indexes that are allowed to swap and make groups
        for (int[] arr : allowedSwaps) union(arr[0], arr[1]);

        // step 3 for each group, make a frequency bag of available source values
        Map<Integer, Map<Integer, Integer>> groupBag = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int group = find(i);
            groupBag.putIfAbsent(group, new HashMap<>());
            Map<Integer, Integer> bag = groupBag.get(group);
            bag.put(source[i], bag.getOrDefault(source[i], 0) + 1);
        }

        // step 4 for each index, check if target[i] is available in its group bag.
        // if it is available, decrement its counter
        // else increase hamming distance
        int hDist = 0;
        for (int i = 0; i < n; ++i) {
            int group = find(i);
            Map<Integer, Integer> bag = groupBag.get(group);
            if (bag.getOrDefault(target[i], 0) > 0)
                bag.put(target[i], bag.get(target[i]) - 1); // consume the value
            else hDist++; // target[i] is not available in this group
        }
        return hDist;
    }
    public static void main(String[] args) {
        Log.info(minimumHammingDistance(new int[] {1,2,3,4}, new int[] {2,1,4,5}, new int[][] {{0,1},{2,3}}));
        Log.info(minimumHammingDistance(new int[] {1,2,3,4}, new int[] {1,3,2,4}, new int[0][0]));
        Log.info(minimumHammingDistance(new int[] {5,1,2,4,3}, new int[] {1,5,4,2,3}, new int[][] {{0,4},{4,2},{1,3},{1,4}}));
    }
}
/**
   Approach: Union-Find (Disjoint Set Union)
   Core Insight
   The key observation is: if indices can be swapped with each other (directly or transitively(if a = b, b = c then a = c)),
   they form a "group" - and within a group, you can arrange source elements in ANY order you want.

   So the problem reduces to: for each group, how many target values can be satisfied by the source
   values in that group?

   Why Union-Find?
   Consider swaps [0,1] and [1,2]. You can never directly swap 0 and 2, but:

   Swap 0 <-> 1, then 1 <-> 2 -> element from index 0 is now at index 2

   So swaps are transitive - Union-Find is perfect for grouping transitively connected indices.

   Step 1 - Build groups using Union-Find
   allowedSwaps = [[0,1],[2,3]]
   Groups formed: {0,1} and {2,3}

   Step 2 - For each group, count available source values
   source = [1,2,3,4]
   Group {0,1} -> source values available: {1:1, 2:1}
   Group {2,3} -> source values available: {3:1, 4:1}

   Step 3 - For each index, check if target[i] is available in its group
   target = [2,1,4,5]

   Step 4 -
   i=0, group {0,1}, target=2 -> found! decrement count -> {1:1, 2:0}
   i=1, group {0,1}, target=1 -> found! decrement count -> {1:0, 2:0}
   i=2, group {2,3}, target=4 -> found! decrement count -> {3:1, 4:0}
   i=3, group {2,3}, target=5 -> NOT found! ans++
   ans = 1 [OK]

   The decrement is crucial - it prevents reusing the same source element twice.

   Why decrement and not just check existence?
   Imagine source = [1,1], target = [1,1], group = {0,1}.

   Available: {1:2}
   i=0: target=1, found -> {1:1} [OK]
   i=1: target=1, found -> {1:0} [OK]
   ans = 0 [OK]

   Without decrement, both would "find" the same 1, which would be wrong if there was only one.

   Complexity

   Time: O(n · a(n)) - nearly linear; a is the inverse Ackermann function (~= constant)
   Space: O(n)
*/
