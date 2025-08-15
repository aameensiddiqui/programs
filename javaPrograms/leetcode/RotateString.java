class RotateString {

    public static boolean solution(String s, String goal) {
        if(s.equals(goal)) return true;
        String ans = "";
        char c = goal.charAt(0);
        
        for(int i = 1; i < s.length(); ++i) {            
            if(s.charAt(i) == c) {
                ans = s.substring(i, s.length());
                ans += s.substring(0, i);
                if(ans.equals(goal)) return true;
            }   
        }
        return false;
    }
    
    public static void main(String[]args) {
        String s = "gcmbf";
        String goal = "fgcmb";
        System.out.println(solution(s, goal));
    }
}
/*
System.out.println("***log*** s.charAt(i)--> "+s.charAt(i));
System.out.println("***log*** ans--> "+ans);
System.out.println("***log*** goal--> "+goal);
 */
