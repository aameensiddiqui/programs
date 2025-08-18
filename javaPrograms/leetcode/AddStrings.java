import java.lang.StringBuilder;

class AddStrings {

    public static String solution(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        for(int i = num1.length()-1, j = num2.length()-1; i >= 0 || j >= 0; --i, --j) {
            int x = i < 0 ? 0 : num1.charAt(i)-'0';
            int y = j < 0 ? 0 : num2.charAt(i)-'0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
        /**************************************************/
        // StringBuilder sb = new StringBuilder();
        // int i = num1.length()-1, j = num2.length()-1, carry = 0;
        // while (i >= 0 || j >= 0 || carry > 0) {
        //     int x = (i >= 0) ? num1.charAt(i--) - '0' : 0;
        //     int y = (j >= 0) ? num2.charAt(j--) - '0' : 0;
        //     int sum = x + y + carry;
        //     sb.append(sum % 10);
        //     carry = sum / 10;
        // }
        // return sb.reverse().toString();
        /**************************************************/
        // return String.valueOf(Long.parseLong(num1) + Long.parseLong(num2));
        /**************************************************/
    }
    
    public static void main(String[]args) {
        String num1 = "11";
        String num2 = "22";
        System.out.println(solution(num1, num2));
    }
}
