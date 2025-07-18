import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* A C G T */
class Repetitions {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []s = br.readLine().split("");
        int subs = 0;
        int ans = 0;
        
        for(int i = 0 ; i < s.length ; i++) {
            if(i != 0 && s[i].equals(s[i-1])) subs++;
            else {
                ans = Math.max(ans, subs);
                subs = 1;
            }
        }
        ans = Math.max(ans, subs);
        System.out.println(ans);
    }
}
