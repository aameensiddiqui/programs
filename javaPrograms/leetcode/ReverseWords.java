class ReverseWords {

    public static String solution(String s) {
        String ans = "";
        String temp = "";
        for(int i = s.length()-1; i >= 0; --i) {
            if(s.charAt(i) != ' ') {
                temp = temp + s.charAt(i);
                System.out.println("temp : "+temp);
            } else {
                // if(s.charAt(i+1) == ' ') continue;
                if((i+1) >= 0 && (i+1) < s.length()-1 && s.charAt(i+1) == ' ') continue;
                for(int k = temp.length()-1; k >= 0; --k) {
                    temp = temp.trim();
                    ans = ans + temp.charAt(k);
                    System.out.println("ans : "+ans);
                }
                ans  = ans + ' ';
                temp = "";
            }
        }
        for(int k = temp.length()-1; k >= 0; --k) {
            ans = ans + temp.charAt(k);
            System.out.println("else if ans : "+ans);
        }
        ans = ans.trim();
        return ans;
 
        // int left = 0;
        // int right = s.length() - 1;

        // String temp = "";
        // String ans = "";

        // //Iterate the string and keep on adding to form a word
        // //If empty space is encountered then add the current word to the result
        // while (left <= right) {
        //     char ch = s.charAt(left);
        //     if (ch != ' ') temp += ch;
        //     else if (ch == ' ') {
        //         if (!ans.equals("")) ans = temp + " " + ans;
        //         else ans = temp;
        //         temp = "";
        //     }
        //     left++;
        // }
        // //If not empty string then add to the result(Last word is added)
        // if (!temp.equals("")) {
        //     if (!ans.equals("")) ans = temp + " " + ans;
        //     else ans = temp;
        // }
        
        // return ans;
    }
    
    public static void main(String[]args) {
        String s = "  the sky is     blue";
        // should return "blue is sky the"
        System.out.println("["+solution(s)+"]");
    }
}
/*
    public String reverseWords(String s){
        char[] str = s.toCharArray();
        char[] rev = new char[str.length];
        int idx = reverseWordsLen(str, rev, 0);
        return new String(rev, 0, idx);
    }
    
    private int reverseWordsLen(char[] str, char[] rev, int start){
        while (start < str.length && str[start] == ' ') start++;
        
        int end = start;
        
        while (end < str.length && str[end] != ' ') end++;
        
        if (start == end) return 0;
        
        int revWordLen = reverseWordsLen(str, rev, end);
        
        if (revWordLen != 0) rev[revWordLen++] = ' ';
        
        while (start < end) rev[revWordLen++] = str[start++];
        
        return revWordLen;
    }
 */
