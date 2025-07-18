import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class WeirdAlgorithm {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        while(n != 1) {
            System.out.print(n+" ");
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n *= 3;
                n += 1;
            }
        }
        System.out.print(1);
    }
}
