class Bouquets {

    static {
        int[]arr = new int[1];
        for(int i = 0; i < 500; ++i) minDays(arr, 1, 1);
    }
    
    public static boolean possible(int[]arr, int days, int m, int k) {
        int nob = 0, cnt = 0;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] <= days) cnt++;
            else {
                nob = nob + (cnt/k);
                cnt = 0;
            }
        }
        nob = nob + (cnt/k);
        return nob >= m;
    }
    
    public static int minDays(int[]bloomDay, int m, int k) {

        if((long) m*k > bloomDay.length) return -1;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < bloomDay.length; ++i) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int low = min, high = max;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(possible(bloomDay, mid, m, k))
                high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    
    public static void main(String[]args) {
        int[]bloomDay = {1,10,3,10,2};
        int m = 3, k = 1;
        // int[]bloomDay = {7,7,7,7,12,7,7};
        // int m = 2, k = 3;
        // int[]bloomDay = {1,10,3,10,2};
        // int m = 3, k = 2;
        System.out.println(minDays(bloomDay, m, k));
    }
}
/*
tumko bloomday namka array diya hua hai
m bouquets banane hai
k number of flowers should be there in a bouquet and they must be adjacent
the flowers bloom if bloomday[i] = i

{1, 10, 3, 10, 2}

day 1: [x, _, _, _, _]
day 2: [x, _, _, _, x]
day 3: [x, _, x, _, x]

*/
