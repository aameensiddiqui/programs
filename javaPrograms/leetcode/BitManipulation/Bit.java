class Bit {
    /** Divide two numbers without using division, multiplication and mod signs */
    public static int divideWithout(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        boolean sign = true;
        if(dividend <= 0 && divisor > 0) sign = false;
        else if(dividend >= 0 && divisor < 0) sign = false;

        long n = Math.abs((long) dividend); // Math.abs() converts to int first which can cause wrong ans
        long d = Math.abs((long) divisor);
        long q = 0;

        while(n >= d) {
            int cnt = 0;
            while(n >= (d << (cnt+1))) {
                log.info("n="+n+": d="+d+": cnt="+cnt);
                cnt += 1;
            }
            q += 1 << cnt;
            n -= d << cnt;
            log.info("q="+q+": n="+n);
        }

        if(q == (1 << 31) &&  sign) return Integer.MAX_VALUE;
        if(q == (1 << 31) && !sign) return Integer.MIN_VALUE;
        return (int)(sign ? q : -q);
    }
    /**
       (d << k) means d * (2^k)
       
       This loop finds the largest power of 2 -> multiple of divisor -> that still fits into n
       3 << 1 = 6, fits
       3 << 2 = 12, fits
       3 << 3 = 24, fits
       3 << 4 = 48, doesn't fit
       So cnt = 3

       Add 2^cnt to the quotient (since we fit divisor that many times)
       Subtract (d * 2^cnt) from dividend n (reduce remainder)
       This is similar to how we do long division manually but faster,
       since it subtracts in "big chunks" using powers of 2 instead of one divisor at a time
       
       ***************************************************************************************

       n = 37, d = 3
       sign = true (both positive)

       1)Outer loop (37 >= 3):

       Inner loop: find biggest shift

       3 << 1 = 6  <= 37 (yes)

       3 << 2 = 12 <= 37 (yes)

       3 << 3 = 24 <= 37 (yes)

       3 << 4 = 48 > 37 (no) -> stop, so cnt = 3

       q += 1 << 3 = 8
       n = 37 - 24 = 13

       2)Outer loop again (13 >= 3):

       Inner loop:

       3 << 1 = 6  <= 13 (yes)

       3 << 2 = 12 <= 13 (yes)

       3 << 3 = 24 > 13 (no) -> stop, cnt = 2

       q += 1 << 2 = 4 + 8 = 12
       n = 13 - 12 = 1

       Outer loop stops (n = 1 < 3)

       Return q = 12
    */
    public static boolean oddOrNot(int n) {
        if((n & 1) == 1) {log.info("odd"); return true;}
        else {log.info("even"); return false;}
    }
    public static int countSetBitsBitWayFaster(int n) {
        /**
           1 0 1 0 1 0 0 -> 84 n
         & 1 0 1 0 0 1 1 -> 83 n-1
           -------------
       n = 1 0 1 0 0 0 0

           cnt = 1

           1 0 1 0 0 0 0 n
         & 1 0 0 1 1 1 1 n-1
           -------------
       n = 1 0 0 0 0 0 0

           cnt = 2

           1 0 0 0 0 0 0 n
         & 0 1 1 1 1 1 1 n-1
           -------------
       n = 0 0 0 0 0 0 0

           cnt = 3

           n == 0 and 84 had 3 ones
         */
        int cnt = 0;
        while(n != 0) {
            n = n & n-1;
            cnt++;
        }
        return cnt;
    }
    public static int countSetBitsBitWay(int n) {
        /**
           all odd numbers have 1 in the end of binary form
           13 -> 1 1 0 [1]
           5  -> 1 0 [1]
           65 -> 1 0 0 0 0 0 [1]
           so if we & an odd num by 1, it will give us 1

           n/2 = n >> 1 (faster)
           also use it in binarySearch for faster operations: (low+high) >> 1
        */
        int cnt = 0;
        while(n > 1) {
            if((n & 1) == 1) cnt++;
            // cnt += n & 1;
            n = n >> 1;
        }
        if(n == 1) cnt++;
        return cnt;
    }
    public static int countSetBits(int n) {
        int cnt = 0;
        while(n > 1) {
            if(n % 2 == 1) cnt++;
            n = n/2;
        }
        if(n == 1) cnt++;
        return cnt;
    }
    public static boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return ((n & n-1) == 0);
        /**
           all power of 2 have only one 1 in their binary formats
           4 -> 1 0 0
           8 -> 1 0 0 0

           1 0 0 0 0 -> 16
         & 0 1 1 1 1 -> 15
           ---------
           0 0 0 0 0 -> 0 yes it is a power of 2
        */
    }
    public static int removeLastSetBit(int n) {
        return (n & (n-1));
        /**
           removing i.e changing last occuring 1 to 0
                   |
           1 0 1 0 1 0 0 -> 84
         & 1 0 1 0 1 1 1 -> 84-1 = 83
           -------------
           1 0 1 0 0 0 0
        */
    }
    public static int toggleIthBit(int n, int i) {
        return (n ^ (1 << i));
        // 1 ^ 1 = 0
        // 0 ^ 1 = 1
        /**
           1 1 0 1
         ^ 0 1 0 0
           -------
           1 0 1 1
           ==========
           1 1 0 1
         ^ 0 0 1 0
           -------
           1 1 1 1
        */
    }
    public static int clearIthBit(int n, int i) {
        return (n & ~(1 << i));
        /**
           ~(0 1 0 0) = 1 0 1 1
           1 1 0 1
         & 1 0 1 1
           --------
           1 0 0 1
           ==========
           1 0 0 1
         & 1 0 1 1
           --------
           1 0 0 1

        */
    }
    public static int setIthBit(int n, int i) {
        return (n | (1 << i));
        /**
           1 0 0 1 -> 9
         | 0 1 0 0 -> 1 << i
           -------
           1 1 0 1 ->13
        */
    }
    public static boolean checkIthBitByLeftShift(int n, int i) {
        if((n & (1 << i)) != 0) return true;
        else return false;
    }
    public static boolean checkIthBitByRightShift(int n, int i) {
        if((1 & (n >> i)) != 0) return true;
        else return false;
    }
    public static void main(String[]args) {
        // log.info(checkIthBitByLeftShift(13, 2));
        // log.info(checkIthBitByRightShift(13, 2));

        // int a = 3, b = 5;
        // log.info("before---"+a+" "+b);
        // a = a^b;
        // b = a^b; // (a^b)^b
        // a = a^b; // (a^b)^b = (a^a)^b
        // log.info("after----"+a+" "+b);

        // log.info(setIthBit(9, 2));

        // log.info(clearIthBit(13, 2));
        // log.info(clearIthBit(9, 2));

        // log.info(toggleIthBit(13, 2));
        // log.info(toggleIthBit(13, 1));

        // log.info(removeLastSetBit(84));

        // log.info(isPowerOfTwo(32));
        // log.info(isPowerOfTwo(31));

        // log.info(countSetBits(13)); // 3 ones
        // log.info(countSetBits(7));  // 3 ones

        // log.info(countSetBitsBitWay(13)); // 3 ones
        // log.info(countSetBitsBitWay(7));  // 3 ones

        // log.info(countSetBitsBitWayFaster(13)); // 3 ones
        // log.info(countSetBitsBitWayFaster(7));  // 3 ones

        // log.info(oddOrNot(4));
        // log.info(oddOrNot(45));
        // log.info(oddOrNot(458));
        // log.info(oddOrNot(4589));

        log.info(divideWithout(37, 3));
        log.info(divideWithout(7, -3));
        log.info(divideWithout(-2147483648, -1)); // 2147483647
    }
    private static final Log log = new Log();
}
