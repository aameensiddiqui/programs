import java.util.*;

class CodeGuesser {
   
   public static void main(String[]args) {
      class Pair<K, V> {
         public final K key;
         public final V value;  
      
         public Pair(K key, V value) {
            this.key = key;
            this.value = value;
         } 
      }
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int guess = 0;
      int answer = 0;
      int a = 0;
      int b = 0;
      int c = 0;
      List<Pair<Integer, Integer>> list = new ArrayList<>();
      int[]arr = new int[3];
   
      for(int i = 0 ; i < n ; i++) {
         guess = scan.nextInt();
         answer = scan.nextInt();
      
            // digits nikalo
         c = guess % 10;
         guess = guess / 10;
         b = guess % 10;
         guess = guess / 10;
         a = guess % 10;
      
            //
         if(answer == 0){
            list.add(new Pair(1, a));
            list.add(new Pair(2, b));
            list.add(new Pair(3, c));
         } else {
            for(Pair<Integer, Integer> p : list) {
               if(p.value == a) {
                  if(p.key == 1){
                     arr[0] = a;
                  } else {
                     list.add(new Pair(1, a));
                  }
               }
                     
               else if(p.value == b) {
                     if(p.key == 2){
                        arr[1] = b;
                     } else {
                        list.add(new Pair(2, b));
                     }
                  }
                  else if(p.value == c) {
                     if(p.key == 3){
                        arr[2] = c;
                     } else {
                        list.add(new Pair(3, c));
                     }
                  }
            }
         }
      }
      for(int j = 0 ; j < arr.length ; j++) {
         System.out.print(arr[j]);
      }
      scan.close();
   }
}
/*
 * guess ayega
 * ans 0 hoga to 
 *      usko ek ek digit nikalo
 *      map me uske wrong position ke saath rakho
 * nahito
 *      uske ek ek digit nikalo
 *      map se compare karo ki if that no. has wrong position
 *      add correct no. to an array[2] at correct position
 */