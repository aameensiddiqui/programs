/**
   846. Hand of Straights

   Alice has some number of cards and she wants to rearrange the cards into groups
   so that each group is of size groupSize, and consists of groupSize consecutive cards.

   Given an integer array hand where hand[i] is the value written on the ith card and
   an integer groupSize, return true if she can rearrange the cards, or false otherwise.

   Example 1:
   Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
   Output: true
   Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

   Example 2:
   Input: hand = [1,2,3,4,5], groupSize = 4
   Output: false
   Explanation: Alice's hand can not be rearranged into groups of 4.

   Constraints:
   1 <= hand.length <= 104
   0 <= hand[i] <= 109
   1 <= groupSize <= hand.length
*/
import java.util.*;

class HandOfStraights {
    public static boolean isNStraightHand(int[]hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> mpp = new TreeMap<>();
        for(int card : hand) mpp.put(card, mpp.getOrDefault(card, 0) + 1);

        while(!mpp.isEmpty()) {
            int start = mpp.firstKey();

            int cnt = mpp.get(start);

            for(int i = 0; i < groupSize; ++i) {
                int card = start + i;
                if(!mpp.containsKey(card) || mpp.get(card) < cnt) return false;
                if(mpp.get(card) == cnt) mpp.remove(card);
                else mpp.put(card, mpp.get(card) - cnt);
            }
        }
        return true;
    }
    public static void main(String[]args) {
        IO.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3)); // true
        IO.println(isNStraightHand(new int[]{1,2,3,4,5}, 4));         // false
        IO.println(isNStraightHand(new int[]{8,10,12}, 3));           // false
        IO.println(isNStraightHand(new int[]{1}, 1));                 // true
        IO.println(isNStraightHand(new int[]{2,1}, 2));               // true
    }
}
