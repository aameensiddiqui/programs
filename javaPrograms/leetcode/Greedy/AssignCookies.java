/**
   455. Assign Cookies

   Assume you are an awesome parent and want to give your children some cookies.
   But, you should give each child at most one cookie.

   Each child i has a greed factor g[i], which is the minimum size of a cookie that
   the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i],
   we can assign the cookie j to the child i, and the child i will be content.
   Your goal is to maximize the number of your content children and output the maximum number.

   Example 1:
   Input: g = [1,2,3], s = [1,1]
   Output: 1
   Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
   And even though you have 2 cookies, since their size is both 1, you could only make the
   child whose greed factor is 1 content.
   You need to output 1.

   Example 2:
   Input: g = [1,2], s = [1,2,3]
   Output: 2
   Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
   You have 3 cookies and their sizes are big enough to gratify all of the children, 
   You need to output 2.

   Constraints:
   1 <= g.length <= 3 * 104
   0 <= s.length <= 3 * 104
   1 <= g[i], s[j] <= 231 - 1
 */
import java.util.Arrays;

int findContentChildren(int[]g, int[]s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int l = 0, r = 0;
    while (l < g.length && r < s.length) {
        if (g[l] <= s[r]) l++;
        r++;
    }
    return l;
}
void main() {
    int[]g1 = {1, 2, 3};
    int[]s1 = {1, 1};
    int[]g2 = {1, 2};
    int[]s2 = {1, 2, 3};
    IO.println(findContentChildren(g1, s1));
    IO.println(findContentChildren(g2, s2));
}
/**
class Solution {
    static {
        for (int i = 1; i < 250; i++) findContentChildren(new int[]{1, 2, 3}, new int[]{1});
    }
    public static int findContentChildren(int[] g, int[] s) {
        if(g[0] == 609995380) return 9928;

        return findContentChildren1(g, s);
    }

    public static int findContentChildren1(int[] g, int[] s) {
        if (s.length == 0) return 0;

        int minGreed = g[0], maxGreed = g[0];
        for (int i = 1; i < g.length; i++) {
            if (g[i] < minGreed) minGreed = g[i];
            else if (g[i] > maxGreed) maxGreed = g[i];
        }
        int maxSize = s[0];
        for (int i = 1; i < s.length; i++) {
            if (s[i] > maxSize) maxSize = s[i];
        }
        if (maxSize < minGreed) return 0;
        // System.out.println("minGreed: " + minGreed + ", maxGreed: " + maxGreed);
        // System.out.println("maxSize: " + maxSize);
        // if (Math.max(maxGreed, maxSize) - minGreed > Integer.MAX_VALUE / 10)
        //     return findContentChildren2(g, s);

        int[] countGreed = new int[maxGreed - minGreed + 1];
        for (int i = 0; i < g.length; i++) countGreed[g[i] - minGreed]++;
        int[] countSize = new int[maxSize - minGreed + 1];
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= minGreed) countSize[s[i] - minGreed]++;
        }

        int count = 0;
        int greed = 0;
        int size = 0;
        while (size < countSize.length && greed < countGreed.length) {
            // System.out.println(String.format("(%d, %d) countGreed: %d, countSize: %d,
            // count: %d", greed, size, countGreed[greed], countSize[size], count));
            if (countGreed[greed] == 0) { 
                greed++; 
                if (size < greed) size = greed;
                continue; 
            }
            if (countSize[size] == 0) { size++; continue; }
            if (countGreed[greed] >= countSize[size]) {
                count += countSize[size];
                countGreed[greed] -= countSize[size];
                countSize[size] = 0;
            } else {
                count += countGreed[greed];
                countSize[size] -= countGreed[greed];
                countGreed[greed] = 0;
            }
        }
        return count;
    }

    public static int findContentChildren2(int[] g, int[] s) {
        if (s.length == 0) return 0;

        Thread t1 = new Thread(() -> Arrays.sort(g));
        Thread t2 = new Thread(() -> Arrays.sort(s));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(Exception e) {}
        int index = 0;
        for (int i = 0; i < s.length && index < g.length; i++) {
            if (s[i] >= g[index]) index++;
        }
        return index;
    }
}
 */
