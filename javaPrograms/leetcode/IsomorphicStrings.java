import java.util.HashMap;

class IsomorphicStrings {

    public static boolean Solution(String s, String t) {
        if(s.length() != t.length()) return false;
        int[]sarr = new int[200];
        int[]tarr = new int[200];
        
        for(int i = 0; i < s.length(); ++i) {
            if(sarr[s.charAt(i)] != tarr[t.charAt(i)]) return false;
            sarr[s.charAt(i)] = i+1;
            tarr[t.charAt(i)] = i+1;
        }
        return true;
    }
    
    public static void main(String[]args) {
        boolean ans = Solution("paper", "title");
        System.out.println(ans);
    }
}
/*
  import java.util.HashMap;

class IsomorphicStrings {

    public static boolean Solution(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> hmap = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i) {
            if(hmap.containsKey(s.charAt(i))) {
                if(hmap.get(s.charAt(i)) != t.charAt(i)) return false;
            }
            else if(hmap.containsValue(t.charAt(i))) return false;
            hmap.put(s.charAt(i), t.charAt(i));
            System.out.println("---------------------\n"+hmap);
        }
        return true;
    }
    
    public static void main(String[]args) {
        boolean ans = Solution("paper", "title");
        System.out.println(ans);
    }
}

*/
