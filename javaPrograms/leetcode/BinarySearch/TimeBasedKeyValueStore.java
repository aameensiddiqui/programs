/**
   981. Time Based Key-Value Store

   Design a time-based key-value data structure that can store multiple values for the same
   key at different time stamps and retrieve the key's value at a certain timestamp.

   Implement the TimeMap class:

   TimeMap() Initializes the object of the data structure.
   void set(String key, String value, int timestamp) Stores the key key with the value value
   at the given time timestamp.
   String get(String key, int timestamp) Returns a value such that set was called previously,
   with timestamp_prev <= timestamp. If there are multiple such values, it returns the value
   associated with the largest timestamp_prev. If there are no values, it returns "".

   Example 1:
   Input
   ["TimeMap", "set", "get", "get", "set", "get", "get"]
   [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
   Output
   [null, null, "bar", "bar", null, "bar2", "bar2"]

   Explanation
   TimeMap timeMap = new TimeMap();
   timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
   timeMap.get("foo", 1);         // return "bar"
   timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo
   at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
   timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
   timeMap.get("foo", 4);         // return "bar2"
   timeMap.get("foo", 5);         // return "bar2"

   Constraints:
   1 <= key.length, value.length <= 100
   key and value consist of lowercase English letters and digits.
   1 <= timestamp <= 107
   All the timestamps timestamp of set are strictly increasing.
   At most 2 * 105 calls will be made to set and get.
*/
import java.util.*;

class TimeBasedKeyValueStore {

    private static class TimeMap {
        private Map<String, TreeMap<Integer, String>> mpp;
        public TimeMap() {
            mpp = new HashMap<>();
        }
        public void set(String key, String value, int timestamp) {
            mpp.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }
        public String get(String key, int timestamp) {
            if (!mpp.containsKey(key)) return "";
            TreeMap<Integer, String> tstamps = mpp.get(key);
            Map.Entry<Integer, String> entry = tstamps.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }

    public static void main(String[]args) {
        TimeMap obj1 = new TimeMap();
        obj1.set("foo", "bar", 1);
        Log.info(obj1.get("foo", 1));
        Log.info(obj1.get("foo", 3));
        obj1.set("foo", "bar2", 4);
        Log.info(obj1.get("foo", 4));
        Log.info(obj1.get("foo", 5));

        Log.info("=======================");

        TimeMap obj2 = new TimeMap();
        obj2.set("love", "high", 10);
        obj2.set("love", "low", 20);
        Log.info(obj2.get("love", 5));
        Log.info(obj2.get("love", 10));
        Log.info(obj2.get("love", 15));
        Log.info(obj2.get("love", 20));
        Log.info(obj2.get("love", 25));
    }
}
/**
    private static class TimeMap {
        private Map<String, Map<Integer, List<String>>> mpp;
        public TimeMap() {
            mpp = new HashMap<>();
        }
        public void set(String key, String value, int timestamp) {
            if (!mpp.containsKey(key))
                mpp.put(key, new HashMap<>());
            if (!mpp.get(key).containsKey(timestamp))
                mpp.get(key).put(timestamp, new ArrayList<>());
            mpp.get(key).get(timestamp).add(value);
        }
        public String get(String key, int timestamp) {
            if (!mpp.containsKey(key)) return "";
            int seen = 0;
            for (int time : mpp.get(key).keySet()) {
                if (time <= timestamp) {
                    seen = Math.max(seen, time);
                }
            }
            if (seen == 0) return "";
            int back = mpp.get(key).get(seen).size() - 1;
            return mpp.get(key).get(seen).get(back);
        }
    }
*/
