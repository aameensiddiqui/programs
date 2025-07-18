import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class MissingNumber {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = (n*(n+1))/2;
        long add = 0;
        String[]nums = br.readLine().split(" ");
        for(int i = 0; i < nums.length; ++i) {
            add += Long.parseLong(nums[i]);
        }
        System.out.print(sum - add);
    }
}
