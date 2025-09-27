import java.util.*;

class SortCharsByFreq {
    public static int findMaxI(int[]arr) {
        int max = Integer.MIN_VALUE, maxI = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] > max) {
                max = arr[i];
                maxI = i;
            }
        }
        return maxI;
    }
    
    public static String solution(String s) {
        int[]arr = new int[128];
        char[]ch = new char[s.length()];
        
        for(int i = 0; i < s.length(); ++i) {
            arr[s.charAt(i)]++;
        }

        for(int i = 0; i < s.length();) {
            int maxI = findMaxI(arr);
            while(arr[maxI] > 0) {
                ch[i++] = (char) maxI;
                arr[maxI]--;
            }
        }
        return new String(ch);
    }
    
    public static void main(String[]args) {
        String s = "tree";
        System.out.println(solution(s));
    }
}
/*
public static String solution(String s) {
    // take a map store char and its occurrence
    // Map<Character, Integer> map = new HashMap<>();
    var map = new HashMap<Character, Integer>();
    for(char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0)+1);
    }
        
    // take an Arraylist, copy data of map in it and sort the list
    var list = new ArrayList<>(map.entrySet());
    list.sort((a, b) -> b.getValue() - a.getValue());

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < list.size(); ++i) {
        int cnt = list.get(i).getValue();
        while(cnt != 0) {
            sb.append(list.get(i).getKey());
            cnt--;
        }
    }
    return sb.toString();
}
*/
