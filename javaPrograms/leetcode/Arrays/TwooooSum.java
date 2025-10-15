import java.util.Map;
import java.util.HashMap;
class TwooooSum {
    private static int[] twoSum(int[]arr, int target) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int sub = 0;
        for(int i = 0; i < arr.length; ++i) {
            sub = target - arr[i];
            if(mpp.containsKey(sub))
                return new int[]{mpp.get(sub), i};
            mpp.put(arr[i], i);
        }
        return new int[]{};
    }
    public static void main(String[]args) {
        int[]arr1 = {2,7,11,15};
        int[]arr2 = {3,2,4};
        int target1 = 9;
        int target2 = 6;
        log.info(twoSum(arr1, target1));
        log.info(twoSum(arr2, target2));
    }
    private static final Log log = new Log();
}
