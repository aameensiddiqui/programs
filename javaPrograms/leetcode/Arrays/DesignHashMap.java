/**
   706. Design HashMap

   Design a HashMap without using any built-in hash table libraries.

   Implement the MyHashMap class:

   MyHashMap() initializes the object with an empty map.
   void put(int key, int value) inserts a (key, value) pair into the HashMap.
   If the key already exists in the map, update the corresponding value.
   int get(int key) returns the value to which the specified key is mapped,
   or -1 if this map contains no mapping for the key.
   void remove(key) removes the key and its corresponding value if the map
   contains the mapping for the key.

   Example 1:
   Input
   ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
   [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
   Output
   [null, null, null, 1, -1, null, 1, null, -1]

   Explanation
   MyHashMap myHashMap = new MyHashMap();
   myHashMap.put(1, 1); // The map is now [[1,1]]
   myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
   myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
   myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
   myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
   myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
   myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
   myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

   Constraints:
   0 <= key, value <= 106
   At most 104 calls will be made to put, get, and remove.
*/
import java.util.*;

class ListNode {
    int k;
    int v;
    ListNode next;
    public ListNode() {
        this.k = -1;
        this.v = -1;
        this.next = null;
    }
    public ListNode(int k, int v, ListNode next) {
        this.k = k;
        this.v = v;
        this.next = next;
    }
}
class MyHashMap {
    private ListNode[] map;
    public MyHashMap() {
        map = new ListNode[1000];
        for (int i = 0; i < 1000; ++i) {
            map[i] = new ListNode();
        }
    }
    private int hash(int key) {
        return key % map.length;
    }
    public void put(int key, int value) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) {
            if (cur.next.k == key) {
                cur.next.v = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key, value, null);
    }
    public int get(int key) {
        ListNode cur = map[hash(key)];
        while (cur != null) {
            if (cur.k == key) {
                return cur.v;
            }
            cur = cur.next;
        }
        return -1;
    }
    public void remove(int key) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) {
            if (cur.next.k == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
class DesignHashMap {
    public static void main(String[]args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        Log.info(myHashMap.get(1));
        Log.info(myHashMap.get(3));
        myHashMap.put(2, 1);
        Log.info(myHashMap.get(2));
        myHashMap.remove(2);
        Log.info(myHashMap.get(2));
    }
}
/**
class MyHashMap {
    private int[] arr;
    public MyHashMap() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }
    public void put(int key, int value) {
        arr[key] = value;
    }
    public int get(int key) {
        return arr[key];
    }
    public void remove(int key) {
        arr[key] = -1;
    }
}
*/
/**
class MyHashMap {
    List<Pair> list;
    public MyHashMap() {
        list = new ArrayList<>();
    }
    public void put(int key, int value) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getK() == key) {
                list.get(i).setV(value);
                return;
            }
        }
        list.add(new Pair(key, value));
    }
    public int get(int key) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getK() == key)
                return list.get(i).getV();
        }
        return -1;
    }
    public void remove(int key) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getK() == key) {
                list.remove(i);
                return;
            }
        }
    }
}

class Pair {
    int k;
    int v;
    public Pair(int k, int v) {
        this.k = k;
        this.v = v;
    }
    public int getK() {
        return k;
    }
    public int getV() {
        return v;
    }
    public void setV(int v) {
        this.v = v;
    }
}
*/
