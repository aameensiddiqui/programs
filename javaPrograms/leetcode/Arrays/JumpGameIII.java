/**
   1306. Jump Game III

   Given an array of non-negative integers arr, you are initially positioned
   at start index of the array. When you are at index i, you can jump to
   i + arr[i] or i - arr[i], check if you can reach any index with value 0.

   Notice that you can not jump outside of the array at any time.

   Example 1:
   Input: arr = [4,2,3,0,3,1,2], start = 5
   Output: true
   Explanation:
   All possible ways to reach at index 3 with value 0 are:
   index 5 -> index 4 -> index 1 -> index 3
   index 5 -> index 6 -> index 4 -> index 1 -> index 3

   Example 2:
   Input: arr = [4,2,3,0,3,1,2], start = 0
   Output: true
   Explanation:
   One possible way to reach at index 3 with value 0 is:
   index 0 -> index 4 -> index 1 -> index 3

   Example 3:
   Input: arr = [3,0,2,1,2], start = 2
   Output: false
   Explanation: There is no way to reach at index 1 with value 0.

   Constraints:
   1 <= arr.length <= 5 * 104
   0 <= arr[i] < arr.length
   0 <= start < arr.length

   (not a greedy problem but graph reachability problem)
*/
class JumpGameIII {
    private static boolean bfs(int[] arr, int i, boolean[] visited) {
        if (i < 0 || i >= arr.length || visited[i]) return false;
        if (arr[i] == 0) return true;
        visited[i] = true;
        return bfs(arr, i + arr[i], visited)
            || bfs(arr, i - arr[i], visited);
    }
    private static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return bfs(arr, start, visited);
    }
    public static void main(String[]args) {
        IO.println(canReach(new int[]{4,2,3,0,3,1,2}, 5));
        IO.println(canReach(new int[]{4,2,3,0,3,1,2}, 0));
        IO.println(canReach(new int[]{3,0,2,1,2}, 2));
    }
}
