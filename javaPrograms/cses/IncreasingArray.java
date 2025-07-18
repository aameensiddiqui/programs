import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IncreasingArray {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long cnt = 0;
        String[]arr = br.readLine().split(" ");
        long a = Long.parseLong(arr[0]);
        
        for(int i = 1 ; i < n ; i++){
            long b = Long.parseLong(arr[i]);
            if(b < a) cnt += (a-b);
            else a = b;
        }
        System.out.println(cnt);
    }
}
