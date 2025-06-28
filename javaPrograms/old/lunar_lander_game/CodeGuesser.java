import java.util.*;

class CodeGuesser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        List<int[]> guesses = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int guess = scan.nextInt();
            int ans = scan.nextInt();
            int[] digits = {
                guess / 100,
                (guess / 10) % 10,
                guess % 10
            };
            guesses.add(digits);
            answers.add(ans);
        }
        
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
               if (j == i) continue;
               for (int k = 0; k <= 9; k++) {
                  if (k == i || k == j) continue;
                  
                  int[] candidate = {i, j, k};
                  if (isValid(candidate, guesses, answers)) {
                     System.out.println("" + i + j + k);
                        return;
                    }
                  }
               }
        }
      }
      
      static boolean isValid(int[] candidate, List<int[]> guesses, List<Integer> answers) {
         for (int g = 0; g < guesses.size(); g++) {
            int[] guess = guesses.get(g);
            int expected = answers.get(g);
            int actual = 0;
            
            for (int i = 0; i < 3; i++) {
               if (candidate[i] == guess[i]) actual++;
            }
            if (actual != expected) return false;
        }
        return true;
    }
}
/*
 * import java.util.*;

class CodeGuesser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        List<int[]> guesses = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int guess = scan.nextInt();
            int ans = scan.nextInt();
            int[] digits = {
                guess / 100,
                (guess / 10) % 10,
                guess % 10
            };
            guesses.add(digits);
            answers.add(ans);
        }
        
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
               if (j == i) continue;
               for (int k = 0; k <= 9; k++) {
                  if (k == i || k == j) continue;
                  
                  int[] candidate = {i, j, k};
                  if (isValid(candidate, guesses, answers)) {
                     System.out.println("" + i + j + k);
                        return;
                    }
                  }
               }
        }
      }
      
      static boolean isValid(int[] candidate, List<int[]> guesses, List<Integer> answers) {
         for (int g = 0; g < guesses.size(); g++) {
            int[] guess = guesses.get(g);
            int expected = answers.get(g);
            int actual = 0;
            
            for (int i = 0; i < 3; i++) {
               if (candidate[i] == guess[i]) actual++;
            }
            if (actual != expected) return false;
        }
        return true;
    }
}
 */
// import java.util.*;

// class CodeGuesser {
   
//    public static void main(String[]args) {
//       Scanner scan = new Scanner(System.in);
//       int n = scan.nextInt();
//       int guess = 0;
//       int answer = 0;
//       int a = 0;
//       int b = 0;
//       int c = 0;
//       Set<Integer> sett = new HashSet<>();
//       Integer[]arr = new Integer[3];

   
//       for(int i = 0 ; i < n ; i++) {
//          guess = scan.nextInt();
//          answer = scan.nextInt();
      
//             // digits nikalo
//          c = guess % 10;
//          guess = guess / 10;
//          b = guess % 10;
//          guess = guess / 10;
//          a = guess % 10;

//          int[] digits = {a, b, c};
         
//          //
//          if(answer == 0){
//             sett.add(a);
//             sett.add(b);
//             sett.add(c);
//          } else {
//            for(int j = 0 ; j < 3 ; j++){
//             // if(!sett.contains(digits[j]))
//             //    sett.add(digits[j]);
//             if(!sett.contains(digits[j]) && arr[j] == null){
//                arr[j] = digits[j];
//                answer--;
//             }
//             if(answer == 0) break;
//            }
//          }
//       }
//       for(int j = 0 ; j < arr.length ; j++) {
//          System.out.print(arr[j]);
//       }
//       scan.close();
//    }
// }
// /*
//  * guess ayega
//  * ans 0 hoga to 
//  *      usko ek ek digit nikalo
//  *      map me uske wrong position ke saath rakho
//  * nahito
//  *      uske ek ek digit nikalo
//  *      map se compare karo ki if that no. has wrong position
//  *      add correct no. to an array[2] at correct position
//  * 
//  * 
//  * Track digits at specific positions from guesses,
//  * Eliminate digits if answer == 0,
//  * Build the correct answer gradually.
//  */