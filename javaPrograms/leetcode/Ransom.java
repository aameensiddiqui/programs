class Ransom
{
    public static boolean canConstruct(String r, String m) {
        if(m.length() < r.length()) return false;

        int[]arr = new int[26];

        for(char c : r.toCharArray()) {
            int i = m.indexOf(c, arr[c - 'a']);
            if(i == -1) return false;
            arr[c - 'a'] = i+1;
        }
        return true;
    }

    public static void main(String[]args)
    {
        String r = "aa";
        String m = "ab";
        System.out.println(canConstruct(r, m));
    }
}
