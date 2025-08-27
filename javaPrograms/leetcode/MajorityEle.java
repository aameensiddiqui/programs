/* some testing changes */
import java.util.*;
class MajorityEle {
    
    public static List<Integer> majorityElement(int[]arr) {
        List<Integer> ans = new ArrayList<>();
        int n1 = Integer.MIN_VALUE;
        int n2 = Integer.MIN_VALUE;
        int c1 = 0, c2 = 0;
        for(int i = 0; i < arr.length; ++i) {
            if(c1 == 0 && arr[i] != n2) {
                c1 = 1; n1 = arr[i];
            }
            else if(c2 == 0 && arr[i] != n1) {
                c2 = 1; n2 = arr[i];
            }
            else if(n1 == arr[i]) c1++;
            else if(n2 == arr[i]) c2++;
            else {
                c1--; c2--;
            }
        }
        c1 = c2 = 0;
        int x = (int)(arr.length/3)+1;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == n1) c1++;
            if(arr[i] == n2) c2++;
        }
        if(c1 >= x) ans.add(n1);
        if(c2 >= x) ans.add(n2);
            
        return ans;
    }

    public static void main(String[]args) {
        // int[]arr = {3, 2, 3};
        // int[]arr = {1};
        // int[]arr = {1, 2};
        // int[]arr = {1, 2, 2, 3, 2};
        int[]arr = {11, 33, 33, 11, 33, 11};
        // int[]arr = {10, 20, 40, 40, 40};
        log(majorityElement(arr));
    }
    
    public static void log(Object...args) {
        for(Object ob : args) System.out.println(ob);
    }
}
/* *
 * int n = arr.length;
 * List<Integer> ans = new ArrayList<>();
 * Map<Integer, Integer> map = new HashMap<>();
 *
 * // first approach
 * // for(int i = 0; i < n; ++i) {
 * //     if(map.containsKey(arr[i]))
 * //         map.put(arr[i], map.get(arr[i])+1);
 * //     else map.put(arr[i], 1);
 * // }
 * // log(map);
 * // map.forEach((key, value) -> {
 * //         if(value > (n/3)) {
 * //             ans.add(key);
 * //         }
 * //     });
 *
 * //***** better *****
 * int x = (int) (n/3)+1;
 * for(int i = 0; i < n; ++i) {
 *     int value = map.getOrDefault(arr[i], 0);
 *     map.put(arr[i], value+1);
 *     if(map.get(arr[i]) == x) ans.add(arr[i]);
 *     if(ans.size() == 2) break;
 * }
 *
 */
/* *
 * Using getOrDefault() (More concise): A more streamlined approach leverages the getOrDefault()
 * method, which retrieves the value associated with a key, or returns a default value if the key
 * is not found.
 * 
 * for (int number : numbers) {
 * numberCountMap.put(number, numberCountMap.getOrDefault(number, 0) + 1);
 * }
 *
 * This single line handles both cases: if the number is new, getOrDefault() returns 0, which is
 * then incremented to 1; if it exists, its current  * count is retrieved and incremented.
 *
 * Using merge() (Java 8 and later): For an even more concise and potentially thread-safe approach
 * (depending on the Map implementation), you can use the merge() method.
 *
 * for (int number : numbers) {
 * numberCountMap.merge(number, 1, Integer::sum);
 * }
 * The merge() method attempts to combine the new value (1) with the existing value using the
 * provided remapping function (Integer::sum). If the key is not present, it simply adds the key
 * with the new value (1).
 *
 */
