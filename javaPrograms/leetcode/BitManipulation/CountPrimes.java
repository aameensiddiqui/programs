import java.util.Arrays;

public class CountPrimes {
    public static int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[]arr = new boolean[n];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for(int i = 2; i*i < n; ++i) {
            if(arr[i]) {
                for(int j = i*i; j < n; j += i) {
                    arr[j] = false;
                }
            }
        }
        log.info(arr);
        int cnt = 0;
        for(int i = 2; i < n; ++i)
            if(arr[i]) cnt++;
        return cnt;
    }
    public static void main(String[] args) {
        log.info(countPrimes(10));
    }
    private static final Log log = new Log();
}
