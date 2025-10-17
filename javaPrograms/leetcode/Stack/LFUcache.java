/**
   460. LFU Cache

   Design and implement a data structure for a Least Frequently Used (LFU) cache.

   Implement the LFUCache class:

   LFUCache(int capacity) Initializes the object with the capacity of the data structure.
   int get(int key) Gets the value of the key if the key exists in the cache.
   Otherwise, returns -1.
   void put(int key, int value) Update the value of the key if present, or inserts the key
   if not already present. When the cache reaches its capacity, it should invalidate and
   remove the least frequently used key before inserting a new item. For this problem,
   when there is a tie (i.e., two or more keys with the same frequency), the least recently
   used key would be invalidated.
   To determine the least frequently used key, a use counter is maintained for each key in
   the cache. The key with the smallest use counter is the least frequently used key.

   When a key is first inserted into the cache, its use counter is set to 1 (due to the put
   operation). The use counter for a key in the cache is incremented either a get or put
   operation is called on it.

   The functions get and put must each run in O(1) average time complexity.

   Example 1:
   Input
   ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
   [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
   Output
   [null, null, null, 1, null, -1, 3, null, -1, 3, 4]

   Explanation
   // cnt(x) = the use counter for key x
   // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
   LFUCache lfu = new LFUCache(2);
   lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
   lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
   lfu.get(1);      // return 1
   // cache=[1,2], cnt(2)=1, cnt(1)=2
   lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
   // cache=[3,1], cnt(3)=1, cnt(1)=2
   lfu.get(2);      // return -1 (not found)
   lfu.get(3);      // return 3
   // cache=[3,1], cnt(3)=2, cnt(1)=2
   lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
   // cache=[4,3], cnt(4)=1, cnt(3)=2
   lfu.get(1);      // return -1 (not found)
   lfu.get(3);      // return 3
   // cache=[3,4], cnt(4)=1, cnt(3)=3
   lfu.get(4);      // return 4
   // cache=[4,3], cnt(4)=2, cnt(3)=3
 

   Constraints:

   1 <= capacity <= 104
   0 <= key <= 105
   0 <= value <= 109
   At most 2 * 105 calls will be made to get and put.
 */
import java.util.Map;
import java.util.HashMap;

class LFUcache {
    public static void main(String[]args) {
        Log log = new Log();
        LFUcacheClass cache = new LFUcacheClass(2);
        // Queries
        cache.put(1, 1);
        cache.put(2, 2);
        log.info(cache.get(1) + " ");
        cache.put(3, 3);
        log.info(cache.get(2) + " ");
        log.info(cache.get(3) + " ");
        cache.put(4, 4);
        log.info(cache.get(1) + " ");
        log.info(cache.get(3) + " ");
        log.info(cache.get(4) + " ");
    }
}

class LFUcacheClass {

    Map<Integer, Node>  keyNodeMap  = new HashMap<>();
    Map<Integer, Listt> freqListMap = new HashMap<>();

    int capacity;
    int minFreq;
    int maxCacheSize;
    int curCacheSize;

    public LFUcacheClass(int capacity) {
        maxCacheSize = capacity;
        minFreq = 0;
        curCacheSize = 0;
        keyNodeMap  = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    public int get(int key) {
        if(keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            updateFreqListMap(node);
            return node.value;
        } else return -1;
    }

    public void put(int key, int value) {
        if(maxCacheSize == 0) return;

        if(keyNodeMap.containsKey(key)) {
            Node node  = keyNodeMap.get(key);
            node.value = value;
            updateFreqListMap(node);
        } else {
            if(curCacheSize == maxCacheSize) {
                Listt list = freqListMap.get(minFreq);
                keyNodeMap.remove(list.tail.prev.key);
                freqListMap.get(minFreq).removeNode(list.tail.prev);
                curCacheSize--;
            }

            curCacheSize++;

            minFreq = 1;

            Listt listFreq = new Listt();

            if(freqListMap.containsKey(minFreq))
                listFreq = freqListMap.get(minFreq);

            Node newNode = new Node(key, value);

            listFreq.addNodeInFront(newNode);
            keyNodeMap.put(key, newNode);
            freqListMap.put(minFreq, listFreq);
        }
    }

    public void updateFreqListMap(Node node) {
        keyNodeMap.remove(node.key);
        freqListMap.get(node.count).removeNode(node);

        if(node.count == minFreq && freqListMap.get(node.count).size == 0)
            minFreq++;

        Listt nextHigherFreqList = new Listt();

        if(freqListMap.containsKey(node.count+1))
            nextHigherFreqList = freqListMap.get(node.count+1);

        node.count += 1;

        nextHigherFreqList.addNodeInFront(node);

        freqListMap.put(node.count, nextHigherFreqList);
        keyNodeMap.put(node.key, node);
    }
}

class Listt {
    int size;
    Node head;
    Node tail;

    Listt() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void addNodeInFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
        size++;
    }

    void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
}

class Node {
    int key, value, count;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.count = 1;
    }
}
