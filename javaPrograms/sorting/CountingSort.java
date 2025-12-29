class CountingSort {
    private static int[] countingSort(int[] arr) {
        // step 1: find max element in the array
        int maxVal = Integer.MIN_VALUE;
        for (int n : arr) if(n > maxVal) maxVal = n;

        // step 2: create an array of max element size
        // and add the frequency of each element
        // e.g. 2 is present twice, so cntArr[2] = 2;
        // 5 is present once, so cntArr[5] = 1
        int[] cntArr = new int[maxVal + 1];
        for (int n : arr) cntArr[n]++;

        // step 3 : store cumulative sum / prefix sum of the elements
        for (int i = 1; i < cntArr.length; ++i) {
            cntArr[i] = cntArr[i-1] + cntArr[i];
        }

        // step 4 : build sorted array
        // create an int[]ans of size arr.length
        // traverse arr in reverse to maintain order of equal elements
        // and ensuring sort remains stable
        // update ans[cntArr[ans[i] - 1]] = arr[i]
        // decrement cntArr[arr[i]]
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; --i) {
            ans[cntArr[arr[i]] - 1] = arr[i];
            cntArr[arr[i]]--;
        }

        return ans;
    }
    public static void main(String[]args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        //          [0, 0, 2, 2, 3, 3, 3, 5]
        Log.info((int[]) countingSort(arr));
    }
}
