class ReverseCharArray {

    public static char[] Solution(char[]s) {
        int i = 0;
        int j = s.length-1;
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            --j; ++i;
        }
        return s;
    }
    
    public static void main(String[]args) {
        char[]s = {'h', 'e', 'l', 'l', 'o'};
        s = Solution(s);
        for(int i = 0; i < s.length; ++i) System.out.print(s[i]);
        System.out.println();
    }
}
