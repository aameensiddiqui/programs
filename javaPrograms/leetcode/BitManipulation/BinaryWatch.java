/**
   401. Binary Watch

   A binary watch has 4 LEDs on the top to represent the hours (0-11),
   and 6 LEDs on the bottom to represent the minutes (0-59).
   Each LED represents a zero or one, with the least significant bit on the right.

   For example, the below binary watch reads "4:51".


   Given an integer turnedOn which represents the number of LEDs that are currently
   on (ignoring the PM), return all possible times the watch could represent.
   You may return the answer in any order.

   The hour must not contain a leading zero.

   For example, "01:00" is not valid. It should be "1:00".
   The minute must consist of two digits and may contain a leading zero.

   For example, "10:2" is not valid. It should be "10:02".

   Example 1:
   Input: turnedOn = 1
   Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]

   Example 2:
   Input: turnedOn = 9
   Output: []

   Constraints:
   0 <= turnedOn <= 10
*/
import java.util.*;

class BinaryWatch {
    /*
      Another way to enumerate valid times is to consider all 2^10 = 1024 possible
      configurations of the lights. Each configuration can be represented by a
      10-bit binary number, where the higher 4 bits represent the hour and the
      lower 6 bits represent the minute.

      For each configuration, we extract the hour and minute values using bitwise
      operations. If both values fall within their valid ranges and the total
      number of 1s in the binary representation equals turnedOn, we add the
      corresponding time to the answer.
     */
    private static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 1024; ++i) {

            int h = i >> 6;
            // right shifts 6 bits from 10 bits to extract first 4 bits
            // eg.  i = 1001101011 (10 bits)
            // i >> 6 = 1001

            int m = i & 63;
            // keeps last 6 bits, removes first 4 bits
            // 63 in binary is 111111
            // so i & 111111 keeps only last 6 bits
            // eg.  i = 1001101011
            // i & 63 =
            //   1001101011
            // & 0000111111
            // -------------
            //   0000101011

            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn)
                res.add(h + ":" + (m < 10 ? "0" : "") + m);
        }
        return res;
    }
    public static void main(String[]args) {
        Log.info(readBinaryWatch(1));
        Log.info(readBinaryWatch(9));
    }
}
/*
  From the problem statement, we know that the hour is represented using 4 bits
  and the minute is represented using 6 bits. A bit value of 0 indicates that
  the light is off, while a bit value of 1 indicates that the light is on.

  We can enumerate all possible hour values in the range [0,11] and all possible
  minute values in the range [0,59]. For each combination, we compute the total
  number of 1s in their binary representations. If this total equals turnedOn,
  we add the corresponding time to the answer.
*/
/**
    private static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn)
                    res.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return res;
    }
*/
