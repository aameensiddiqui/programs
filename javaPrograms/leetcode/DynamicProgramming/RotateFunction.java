/**
396. Rotate Function

You are given an integer array nums of length n.

Assume arrk to be an array obtained by rotating nums by k positions clock-wise.
We define the rotation function F on nums as follow:

F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
Return the maximum value of F(0), F(1), ..., F(n-1).

The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:
Input: nums = [4,3,2,6]
Output: 26
Explanation:
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

Example 2:
Input: nums = [100]
Output: 0

Constraints:
n == nums.length
1 <= n <= 105
-100 <= nums[i] <= 100
*/
/*********************************************************************************************/
/**
Intuition

We need a fast way to calculate the next rotation value, F(i), using the previous value, F(i-1).

This avoids recalculating the entire sum from scratch at every step.

Let's consider the array A:

A = [a, b, c, ..., y, z]
with a length of n, where z is the last element of the array: z = A[n-1]
​
Approach

Initial State:

Let the initial state be F(0), where each element is multiplied by its corresponding index:

F(0) = 0a + 1b + 2c + ... + (n-2)y + (n-1)z
​
By performing clockwise rotation by 1, the next state becomes:

Thus, F(1):

F(1) = 1a + 2b + 3c + ... + (n-1)y + 0z
​
To find out what changes between steps, let's determine the difference between F(1) and F(0):

F(1) = 1a + 2b + 3c + ... + (n-1)y +     0z
F(0) = 0a + 1b + 2c + ... + (n-2)y + (n-1)z -
-----------------------------------------------
diff = 1a + 1b + 1c + ... +     1y - (n-1)z
​
Hence, the difference between two states is:

diff = a + b + c + ... + y - (n-1)z
​
Now, if we add +z, we can convert the inner expression into the sum of the array Asum:

diff = a + b + c + ... + y + z - (n-1)z​
      |<--------Asum--------->|

Then, add -z back to restore the the equation, and simplify:

diff = Asum + (-z) - (n-1)z
     = Asum - z - zn + z
     = Asum - nz
     = Asum - n * A[n-1]
​
Substitute:  z = A[n-1]
​
Therefore: diff = Asum -A[n-1]*n
​
Recurrence Relation
Determining the next state F(1) using current state F(0):

Since F(1) - F(0) = diff, we add F(0) to both sides:

F(1) = F(0) - diff
F(1) = F(0) - Asum +A[n-1]*n
​
Generalization
We can generalize the formula to any F(i):

If F(i) is the current state, then F(i+1) is the next state, and we can apply the same rule:

For example, in F(1), the current array state is:

where the last element is:

y = A[n-2]
​
Then the next last element for the following states are:

Hence:

next = A[n-i]
​
Conclusion
For any step i, the pattern is:

F(i) = F(i-1) + Asum - A[n-i] * n
​
We use this simple formula to calculate all rotation values using only the total sum and
the single element that moved.

Time  Complexity: O(n)
Space Complexity: O(1)
*/
class RotateFunction {
    private static int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, sum = 0, ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            f += i * nums[i];
        }
        ans = f;
        for (int i = n - 1; i >= 0; --i) {
            f += sum - n * nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
    public static void main(String[] args) {
        Log.info(maxRotateFunction(new int[] {4,3,2,6}));
        Log.info(maxRotateFunction(new int[] {100}));
    }
}
/**
    // TLE
    private static int findAddition(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            ans += (i * nums[i]);
        }
        return ans;
    }
    private static void rotateArrByOne(int[] nums) {
        int[] arr = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; ++i) {
            arr[i] = nums[i];
        }
        nums[0] = nums[nums.length - 1];
        for (int i = 0, j = 1; i < arr.length; ++i, ++j) {
            nums[j] = arr[i];
        }
    }
    private static int maxRotateFunction(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            ans = Math.max(ans, findAddition(nums));
            rotateArrByOne(nums);
        }
        return ans;
    }
*/
