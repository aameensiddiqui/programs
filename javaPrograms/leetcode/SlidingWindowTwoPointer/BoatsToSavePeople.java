/**
   881. Boats to Save People

   You are given an array people where people[i] is the weight of the ith
   person, and an infinite number of boats where each boat can carry a
   maximum weight of limit. Each boat carries at most two people at the
   same time, provided the sum of the weight of those people is at most limit.

   Return the minimum number of boats to carry every given person.

   Example 1:
   Input: people = [1,2], limit = 3
   Output: 1
   Explanation: 1 boat (1, 2)

   Example 2:
   Input: people = [3,2,2,1], limit = 3
   Output: 3
   Explanation: 3 boats (1, 2), (2) and (3)

   Example 3:
   Input: people = [3,5,3,4], limit = 5
   Output: 4
   Explanation: 4 boats (3), (3), (4), (5)

   Constraints:
   1 <= people.length <= 5 * 104
   1 <= people[i] <= limit <= 3 * 104
*/
import java.util.Arrays;

class BoatsToSavePeople {
    private static int numResqueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1, res = 0;
        while (l <= r) {
            int remain = limit - people[r--];
            res++;
            if (l <= r && people[l] <= remain) ++l;
        }
        return res;
    }
    public static void main(String[]args) {
        Log.info(numResqueBoats(new int[]{1,2}, 3));
        Log.info(numResqueBoats(new int[]{3,2,2,1}, 3));
        Log.info(numResqueBoats(new int[]{3,5,3,4}, 5));
    }
}
