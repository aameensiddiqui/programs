class RecursivePow {
    /*
      0 : 2
      1 : 2*2 = 4
      2 : 4*2 = 8
      3 : 8*2 = 16
      4 : 16*2 = 32
      5 : 32*2 = 64
      6 : 64*2 = 128
      7 : 128*2 = 256
      8 : 256*2 = 512
      9 : 512*2 = 1024
    */

    public static double solution(double x, int n) {
        long n2 = n;
        if(n2 < 0){
            x = 1 / x;
            n2 = -n2;
        }
        return fastPow(x, n2);
    }

    private static double fastPow(double x, long n){
        if(n == 0) return 1.0;
            
        double halfPow = fastPow(x, n/2);
        double halfPowSq = halfPow * halfPow;

        if(n % 2 != 0){
            halfPowSq = x * halfPowSq;
        }
        return halfPowSq;
    }
    
    public static void main(String[]args) {
        double x = 2.0;
        int n = -2147483647;
        log(solution(x, n));
    }
    
    public static void log(Object...args) {
        for(Object ob : args) System.out.println(ob);
    }
}
 
/******************************************************/
// public static double solution(double x, int n) {
//     double ans = 1.0;
//     if(x == 1.0) return ans;
//     long n2 = n;
//     if(n2 < 0) n2 = -1*n2;
//     while(n2 > 0) {
//         if(n2 % 2 == 1) {
//             ans = ans * x;
//             --n2;
//         } else {
//             x = x * x;
//             n2 = n2 / 2;
//         }
//     }
//     if(n < 0) ans = (double)(1.0) / (double)(ans);
//     return ans;
// }
/******************************************************/


/******************************************************/
// public static double solution(double x, int n) {
//     double ans = 1.0;
//     if(x == 1.0) {
//         ans = n;
//         return ans;
//     }
//     long n2 = n;
//     if(n2 < 0){
//         n2 = -1*n2;
//         for(int i = 0; i < n2; ++i) {
//             ans = ans / x;
//             log(i+" : "+ans);
//         }
//     } else {
//         for(int i = 0; i < n2; ++i) {
//             ans = ans * x;
//             log(i+" : "+ans);
//         }    
//     }
//     return ans;
// }
/******************************************************/
