/**
   1833. Maximum Ice Cream Bars

   It is a sweltering summer day, and a boy wants to buy some ice cream bars.

   At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i]
   is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he
   wants to buy as many ice cream bars as possible.

   Note: The boy can buy the ice cream bars in any order.

   Return the maximum number of ice cream bars the boy can buy with coins coins.

   You must solve the problem by counting sort.

   Example 1:
   Input: costs = [1,3,2,4,1], coins = 7
   Output: 4
   Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.

   Example 2:
   Input: costs = [10,6,8,7,7,8], coins = 5
   Output: 0
   Explanation: The boy cannot afford any of the ice cream bars.

   Example 3:
   Input: costs = [1,6,3,1,2,5], coins = 20
   Output: 6
   Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.

   Constraints:
   costs.length == n
   1 <= n <= 105
   1 <= costs[i] <= 105
   1 <= coins <= 108
*/
class MaximumIceCreamBars {
    private static int[] countingSort(int[] arr) {
        int n = arr.length, maxNum = 0;
        if (n == 0) return new int[0];

        // find max num
        for (int num : arr)
            maxNum = Math.max(maxNum, num);

        // create freq cnt array
        int[] cntArr = new int[maxNum + 1];
        for (int i = 0; i < n; ++i)
            cntArr[arr[i]]++;

        // count prefix sum
        for (int i = 1; i <= maxNum; ++i)
            cntArr[i] += cntArr[i - 1];

        // create sorted array
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            ans[cntArr[arr[i]] - 1] = arr[i];
            cntArr[arr[i]]--;
        }
        return ans;
    }
    private static int maxIceCream(int[] costs, int coins) {
        costs = countingSort(costs);
        int iceCreams = 0;
        for (int cost : costs) {
            iceCreams++;
            coins -= cost;
            if (coins == 0) return iceCreams;
            else if (coins < 0) return iceCreams - 1;
        }
        return iceCreams;
    }
    public static void main(String[] args) {
        Log.info(maxIceCream(new int[] {1,3,2,4,1}, 7));             // 4
        Log.info(maxIceCream(new int[] {10,6,8,7,7,8}, 5));          // 0
        Log.info(maxIceCream(new int[] {1,6,3,1,2,5}, 20));          // 6
        Log.info(maxIceCream(new int[] {7,3,3,6,6,6,10,5,9,2}, 56)); // 9
    }
}
