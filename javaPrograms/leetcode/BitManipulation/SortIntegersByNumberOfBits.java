/**
   1356. Sort Integers by The Number of 1 Bits

   You are given an integer array arr. Sort the integers in the array in ascending
   order by the number of 1's in their binary representation and in case of two or
   more integers have the same number of 1's you have to sort them in ascending order.

   Return the array after sorting it.

   Example 1:
   Input: arr = [0,1,2,3,4,5,6,7,8]
   Output: [0,1,2,4,8,3,5,6,7]
   Explantion: [0] is the only integer with 0 bits.
   [1,2,4,8] all have 1 bit.
   [3,5,6] have 2 bits.
   [7] has 3 bits.
   The sorted array by bits is [0,1,2,4,8,3,5,6,7]

   Example 2:
   Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
   Output: [1,2,4,8,16,32,64,128,256,512,1024]
   Explantion: All integers have 1 bit in the binary representation, you should just
   sort them in ascending order.

   Constraints:
   1 <= arr.length <= 500
   0 <= arr[i] <= 104
*/
class SortIntegersByNumberOfBits {
    private static int[] sortByBits(int[] arr) {
        if (arr.length < 2) return arr;

        int pivotVal = arr[0];
        int pivotBit = Integer.bitCount(arr[0]);
        int lc = 0;
        int hc = 0;

        for (int i = 1; i < arr.length; ++i) {
            int bits = Integer.bitCount(arr[i]);
            if (bits < pivotBit || (bits == pivotBit && arr[i] < pivotVal))
                lc++;
            else hc++;
        }

        int[] h = new int[hc];
        int[] l = new int[lc];
        hc = 0; lc = 0;

        for (int i = 1; i < arr.length; ++i) {
            int bits = Integer.bitCount(arr[i]);
            if (bits < pivotBit || (bits == pivotBit && arr[i] < pivotVal))
                l[lc++] = arr[i];
            else h[hc++] = arr[i];
        }

        sortByBits(l);
        sortByBits(h);

        int ind = 0;
        for (int i = 0; i < l.length; ++i) arr[ind++] = l[i];
        arr[ind++] = pivotVal;
        for (int i = 0; i < h.length; ++i) arr[ind++] = h[i];
        return arr;
    }
    public static void main(String[] args) {
        Log.info(sortByBits(new int[] {0,1,2,3,4,5,6,7,8}));
        Log.info(sortByBits(new int[] {1024,512,256,128,64,32,16,8,4,2,1}));
    }
}
/**
    // bubble
    private static boolean compare(int n1, int n2) {
        int n1b = Integer.bitCount(n1);
        int n2b = Integer.bitCount(n2);
        if (n1b == n2b) return n1 > n2;
        return n1b > n2b;
    }
    private static int[] sortByBits(int[] arr) {
        for (int i = arr.length - 1; i >= 0; --i) {
            boolean didSwap = false;
            for (int j = 0; j <= i - 1; ++j) {
                if (compare(arr[j], arr[j + 1])) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    didSwap = true;
                }
            }
            if (!didSwap) break;
        }
        return arr;
    }
*/
