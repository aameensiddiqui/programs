/**
   1423. Maximum Points You Can Obtain from Cards

   There are several cards arranged in a row, and each card has an associated number
   of points. The points are given in the integer array cardPoints.
   In one step, you can take one card from the beginning or from the end of the row.
   You have to take exactly k cards. Your score is the sum of the points of the cards
   you have taken. Given the integer array cardPoints and the integer k, return the
   maximum score you can obtain.

   Example 1:
   Input: cardPoints = [1,2,3,4,5,6,1], k = 3
   Output: 12
   Explanation: After the first step, your score will always be 1. However, choosing the
   rightmost card first will maximize your total score. The optimal strategy is to take
   the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

   Example 2:
   Input: cardPoints = [2,2,2], k = 2
   Output: 4
   Explanation: Regardless of which two cards you take, your score will always be 4.

   Example 3:
   Input: cardPoints = [9,7,7,9,7,7,9], k = 7
   Output: 55
   Explanation: You have to take all the cards. Your score is the sum of points of all
   cards.

   Constraints:
   1 <= cardPoints.length <= 105
   1 <= cardPoints[i] <= 104
   1 <= k <= cardPoints.length
 */
class MaxPointsFromCards {
    public static int maxScore(int[]arr, int k) {
        int maxScore = 0;
        int n = arr.length;
        int l = 0, r = n;
        int total = 0;
        for(int i = 0; i < k; ++i) {
            total += arr[i];
        }
        maxScore = total;
        for(int i = 0; i < k; ++i) {
            total -= arr[k - 1 - i];
            total += arr[n - 1 - i];
            maxScore = Math.max(maxScore, total);
        }
        return maxScore;
    }
    public static void main(String[]args) {
        int[]arr1 = {1,2,3,4,5,6,1};         int k1 = 3; // 12
        int[]arr2 = {2,2,2};                 int k2 = 2; // 4
        int[]arr3 = {9,7,7,9,7,7,9};         int k3 = 7; // 55
        int[]arr4 = {11,49,100,20,86,29,72}; int k4 = 4; // 232

        log.info(maxScore(arr1, k1));
        log.info(maxScore(arr2, k2));
        log.info(maxScore(arr3, k3));
        log.info(maxScore(arr4, k4));
    }
    private static final Log log = new Log();
}
