/*
Koko loves to eat bananas. There are n piles of bananas,
the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k.
Each hour, she chooses some pile of bananas and eats k bananas
from that pile.
If the pile has less than k bananas, she eats all of them instead
and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all
the bananas before the guards return.

Return the minimum integer k such that she can eat all the
bananas within h hours.

----example:

piles = [3, 6, 7, 11]
h = 8

There are 4 piles of bananas:

Pile 0 -> 3 bananas
Pile 1 -> 6 bananas
Pile 2 -> 7 bananas
Pile 3 -> 11 bananas

Koko has 8 hours to eat all the bananas.

How do we visualize a k value?
Let's try k = 4 bananas/hour and see what happens:

Now for each pile, she will need this many hours:
Pile 0 -> ceil(3 / 4) = 1 hour
Pile 1 -> ceil(6 / 4) = 2 hours
Pile 2 -> ceil(7 / 4) = 2 hours
Pile 3 -> ceil(11 / 4) = 3 hours
Total = 1 + 2 + 2 + 3 = 8 hours
So k = 4 works.
*/
/*
The extremely naive approach is to check all possible answers from 1 to max(a[]).
The minimum number for which the required time <= h, is our answer.

    public static int findMax(int []arr)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static int calTotalHrs(int[]a, int hourly)
    {
        int totalHrs = 0;
        for(int i = 0; i < a.length; ++i) {
            totalHrs += Math.ceil((double)a[i] / (double) hourly);
        }
        return totalHrs;
    }
    
    public static int minRateToEatBananas(int[]arr, int h)
    {
        int max = findMax(arr);
        for(int i = 0; i < max; ++i) {
            int reqTime = calTotalHrs(arr, i);
            if(reqTime <= h) return i;
        }
        return max;
    }
*/

class Bananas
{

    public static int findMax(int[]arr)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static int calHrs(int[]arr, int h)
    {
        int totalHrs = 0;
        for(int i = 0; i < arr.length; ++i) {
            totalHrs += Math.ceil((double)(arr[i]) / (double)(h));
        }
        return totalHrs;
    }
    
    public static int minRateToEatBananas(int[]arr, int h)
    {
        int low = 1, high = findMax(arr);

        while(low <= high) {
            int mid = (low + high) / 2;
            int reqHrs = calHrs(arr, mid);
            if(reqHrs <= h) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
    
    public static void main(String[]args)
    {
        int[]arr = {30,11,23,4,20};
        int h = 6;
        int k = minRateToEatBananas(arr, h);
        System.out.println(k);
    }
}
/*
  
// faster solution:

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long total = 0;
        for(int banana : piles) {
            total += banana;
        }
        // calculate tighter lower and upper bounds
        int low  = (int) ((total - 1) / h) + 1;
        int high = (int) ((total - piles.length) / (h - piles.length + 1)) + 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            // time taken at speed = mid
            int time = 0;
            for(int pile : piles) {
                time += (pile - 1) / mid + 1;
            }
            
            if(time > h) low = mid + 1; // too slow. need faster speed
            else high = mid; // can go slower
        }
        return low; // or right both will be equal here
    }
}


### Example:

```java
piles = [3, 6, 7, 11]
h = 8
```

---

### Step 1: Pre-calculate

```java
n = piles.length = 4
total = 3 + 6 + 7 + 11 = 27 bananas
```

---

### Step 2: Calculate bounds

```java
left = ceil(total / h) = ceil(27 / 8) = 4
right = ceil((total - n) / (h - n + 1)) = ceil((27 - 4) / (8 - 4 + 1)) = ceil(23 / 5) = 5
```

So now we'll **binary search** in the range `k = [4, 5]`.

---

### Step 3: Binary Search Loop

We go through:

#### First Iteration:

```java
mid = (4 + 5)/2 = 4
```

Simulate how many hours it takes to eat all bananas with `k = 4`:

| Pile | Bananas | Time = (pile - 1)/k + 1          |
| ---- | ------- | -------------------------------- |
| 0    | 3       | (3 - 1)/4 + 1 = 0 + 1 = 1 hour   |
| 1    | 6       | (6 - 1)/4 + 1 = 1 + 1 = 2 hours  |
| 2    | 7       | (7 - 1)/4 + 1 = 1 + 1 = 2 hours  |
| 3    | 11      | (11 - 1)/4 + 1 = 2 + 1 = 3 hours |

Total time = 1 + 2 + 2 + 3 = 8 hours

Since time ** <= h**, we can try a smaller `k`, so we do:

```java
right = mid = 4
```

---

#### Second Iteration:

Now:

```java
left = 4, right = 4 --> loop exits
```

Final answer: `k = 4`

---

### Key Insight:

This version avoids checking unnecessary large values (like 6 to 11), and doesn't bother with impossible small speeds (like 1 to 3).

It jumps directly to the **mathematically tight range** `[4, 5]`, and quickly locks in on the answer.

---

### Visual Summary:

* **Left bound** `ceil(total / h)` --> absolute **minimum** speed needed
* **Right bound** estimates how fast Koko must go assuming a worst-case pile distribution
* You binary search in this small window and simulate time needed using the clever formula:

```java
(m - 1) / k + 1 ~= ceil(m / k)
```

Let me know if you'd like a visual number-line diagram too!

 */
