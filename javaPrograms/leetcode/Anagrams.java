class Anagrams {

    public static boolean checkAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[]arr = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < t.length(); ++i) {
            if(t.charAt(i) == 0) return false;
            arr[t.charAt(i) - 'a'] -= 1;
        }
        return true;
    }
    
    public static void main(String[]args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(checkAnagram(s, t));
    }
}
