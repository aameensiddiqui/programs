/**
   135. Candy

   There are n children standing in a line. Each child is assigned a rating value
   given in the integer array ratings.

   You are giving candies to these children subjected to the following requirements:

   Each child must have at least one candy.
   Children with a higher rating get more candies than their neighbors.
   Return the minimum number of candies you need to have to distribute the candies
   to the children.

   Example 1:
   Input: ratings = [1,0,2]
   Output: 5
   Explanation: You can allocate to the first, second and third child with 2, 1, 2
   candies respectively.

   Example 2:
   Input: ratings = [1,2,2]
   Output: 4
   Explanation: You can allocate to the first, second and third child with 1, 2, 1
   candies respectively.
   The third child gets 1 candy because it satisfies the above two conditions.

   Constraints:
   n == ratings.length
   1 <= n <= 2 * 104
   0 <= ratings[i] <= 2 * 104
*/
int candy(int[]nums) {
    int n = nums.length;
    int i = 1, candies = n;
    while(i < n) {
        if(nums[i] == nums[i-1]) {
            i++;
            continue;
        }
        // up
        int peak = 0;
        while(i < n && nums[i] > nums[i-1]) {
            peak++;
            candies += peak;
            i++;
        }
        // down
        int down = 0;
        while(i < n && nums[i] < nums[i-1]) {
            down++;
            candies += down;
            i++;
        }
        candies -= Math.min(down, peak);
    }
    return candies;
}
void main() {
    IO.println(candy(new int[]{1,0,2}));     //5
    IO.println(candy(new int[]{1,2,2}));     //4
    IO.println(candy(new int[]{1,3,2,2,1})); //7
}
private static final Log log = new Log();
/**
int candy(int[]nums) {
    int[]l = new int[nums.length];
    l[0] = 1;
    for(int i = 1; i < nums.length; ++i) {
        if(nums[i] > nums[i-1]) l[i] = l[i-1]+1;
        else l[i] = 1;
    }
    int r = 1, candies = Math.max(1, l[nums.length-1]);
    for(int i = nums.length-2; i >= 0; --i) {
        if(nums[i] > nums[i+1]) r++;
        else r = 1;
        candies += Math.max(l[i], r);
    }
    return candies;
}
 */
/**
int candy(int[]nums) {
    int[]l = new int[nums.length];
    int[]r = new int[nums.length];
    l[0] = 1;
    for(int i = 1; i < nums.length; ++i) {
        if(nums[i] > nums[i-1]) l[i] = l[i-1]+1;
        else l[i] = 1;
    }
    r[nums.length-1] = 1;
    for(int i = nums.length-2; i >= 0; --i) {
        if(nums[i] > nums[i+1]) r[i] = r[i+1]+1;
        else r[i] = 1;
    }
    int candies = 0;
    for(int i = 0; i < nums.length; ++i) {
        candies += Math.max(l[i], r[i]);
    }
    return candies;
}

 */
