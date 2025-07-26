// import java.lang.*;
// class ExcelSheetColumnTitle {

//     public static String convertToTitle(int columnNumber) {
//         String[]arr = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
//         "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
//         "V", "W", "X", "Y", "Z"};
//         if(columnNumber <= 26) return arr[columnNumber-1];
//         int d = 0;
//         int a = 0;

//         StringBuilder s = new StringBuilder();
        
//         while(columnNumber >= 26 && d >=26) {
//             d = columnNumber / 26;
//             System.out.println("---------d--------"+d);
//             a = d * 26;
//             System.out.println("---------a--------"+a);
//             columnNumber -= a;
//             System.out.println("---------columnnumber--------"+columnNumber);
//         }
//         System.out.println("=============================");
//         System.out.println("---------a--------"+a);
//         System.out.println("---------d--------"+d);
//         System.out.println("---------columnnumber--------"+columnNumber);
//         String ans = arr[d-1]+""+arr[columnNumber-1];
//         s.append(ans);
//         return s.toString();
//     }
//     public static void main(String[]args) {
//         System.out.println(convertToTitle(2147483647));
//     }
// }
import java.lang.*;

class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while(columnNumber > 0){
            if(columnNumber % 26 == 0){
                str.append('Z');
                columnNumber /= 26;
                columnNumber--;
            }else{
                char ch = (char)('A' + (columnNumber%26-1)) ;
                columnNumber/= 26;
                str.append(ch);
            }
        }
        return str.reverse().toString();
    }

    public static void main(String[]args) {
        System.out.println(convertToTitle(2147483647));
    }
}
