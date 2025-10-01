import java.util.List;
import java.util.ArrayList;
public class Subsets {
    public static List<List<Integer>> subsets(int[]arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int subset = 1 << n;
        for(int i = 0; i < subset; ++i) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; ++j) {
                if((i & (1 << j)) != 0) list.add(arr[j]);
            }
            ans.add(list);
        }
        return ans;
    }
    public static void main(String[]args) {
        int[]arr = {1, 2, 3};
        log.info(subsets(arr));
    }
    private static final Log log = new Log();
}
