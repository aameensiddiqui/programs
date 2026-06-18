/**
   1344. Angle Between Hands of a Clock

   Given two numbers, hour and minutes, return the smaller angle (in degrees)
   formed between the hour and the minute hand.

   Answers within 10-5 of the actual value will be accepted as correct.

   Example 1:
   Input: hour = 12, minutes = 30
   Output: 165

   Example 2:
   Input: hour = 3, minutes = 30
   Output: 75

   Example 3:
   Input: hour = 3, minutes = 15
   Output: 7.5

   Constraints:
   1 <= hour <= 12
   0 <= minutes <= 59
*/
class AngleBetweenHandsOfAClock {
    private static double angleClock(int hr, int min) {
        double ans = 0;
        // every min:
        // hr  hand moves 0.5 degrees every min
        // min hand moves 6   degrees every min
        // angle between 2 numbers 6 * 5min = 30
        if (hr == 12) hr = 0;
        double hrAngle  = (0.5 * min) + (30 * hr);
        double minAngle = 6 * min;
        ans = Math.abs(minAngle - hrAngle);
        return Math.min(ans, 360 - ans); // smaller angle
    }
    public static void main(String[] args) {
        Log.info(angleClock(12, 30)); // 165.0
        Log.info(angleClock(3, 30));  // 75.0
        Log.info(angleClock(3, 15));  // 7.5
        Log.info(angleClock(1, 57));  // 76.5
    }
}
