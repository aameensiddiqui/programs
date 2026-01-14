/**
   705. Design HashSet

   Design a HashSet without using any built-in hash table libraries.

   Implement MyHashSet class:

   void add(key) Inserts the value key into the HashSet.
   bool contains(key) Returns whether the value key exists in the HashSet or not.
   void remove(key) Removes the value key in the HashSet.
   If key does not exist in the HashSet, do nothing.

   Example 1:
   Input
   ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
   [[], [1], [2], [1], [3], [2], [2], [2], [2]]
   Output
   [null, null, null, true, false, null, true, null, false]

   Explanation
   MyHashSet myHashSet = new MyHashSet();
   myHashSet.add(1);      // set = [1]
   myHashSet.add(2);      // set = [1, 2]
   myHashSet.contains(1); // return True
   myHashSet.contains(3); // return False, (not found)
   myHashSet.add(2);      // set = [1, 2]
   myHashSet.contains(2); // return True
   myHashSet.remove(2);   // set = [1]
   myHashSet.contains(2); // return False, (already removed)

   Constraints:
   0 <= key <= 106
   At most 104 calls will be made to add, remove, and contains.
*/
import java.util.Arrays;

class MyHashSet {
    private int[] arr;

    public MyHashSet() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }

    public void add(int key) {
        arr[key] = key;
    }

    public void remove(int key) {
        arr[key] = -1;
    }

    public boolean contains(int key) {
        if (arr[key] == key) return true;
        else return false;
    }
}

class DesignHashSet {
    public static void main(String[]args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        Log.info(myHashSet.contains(1)); // return True
        Log.info(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        Log.info(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        Log.info(myHashSet.contains(2)); // return False, (already removed)
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
/**
class MyHashSet {
    private ListNode[] map;
    public MyHashSet() {
        map = new ListNode[1000001];
        for (int i = 0; i < map.length; ++i) {
            map[i] = new ListNode();
        }
    }

    private int hash(int key) {
        return key % map.length;
    }

    public void add(int key) {
        ListNode cur = map[hash(key)];
        cur.k = key;
    }

    public void remove(int key) {
        ListNode cur = map[hash(key)];
        cur.k = -1;
    }

    public boolean contains(int key) {
        ListNode cur = map[hash(key)];
        if (cur.k == -1) return false;
        else return true;
    }
}

class ListNode {
    int k;
    ListNode next;
    public ListNode() {
        this.k = -1;
        this.next = next;
    }
    public ListNode(int k, ListNode next) {
        this.k = k;
        this.next = next;
    }
}
*/
