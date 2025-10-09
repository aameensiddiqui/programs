import java.util.*;
class AsteroidCollision {
    public static int[] asteroidCollision(int[]arr) {
        List<Integer> st = new ArrayList<>();
        
        for(int i = 0; i < arr.length; ++i) {
            
            if(arr[i] > 0) {
                st.add(arr[i]);
            }
            
            else {
                while(!st.isEmpty() && st.get(st.size()-1) > 0 && st.get(st.size()-1) < Math.abs(arr[i])) {
                    st.remove(st.size()-1);
                }
                if(!st.isEmpty() && st.get(st.size()-1) == Math.abs(arr[i])) {
                    st.remove(st.size()-1);
                }
                if(st.isEmpty() || st.get(st.size()-1) < 0) {
                    st.add(arr[i]);
                }
            }
        }
        int[]res = new int[st.size()];
        for(int i = 0; i < st.size(); ++i) {
            res[i] = st.get(i);
        }
        return res;
    }
    public static void main(String[]args) {
        //int[]arr = {5, 10, -5};
        int[]arr = {10, 2, -5};
        //int[]arr = {8, -8};
        log.info(asteroidCollision(arr));
    }
    private static final Log log = new Log();
}
/**
   // using stack
   public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; ++i) {
            if(asteroids[i] > 0) st.push(asteroids[i]);
            else {
                while(!st.empty() && 
                        st.peek() > 0 && 
                        st.peek() < Math.abs(asteroids[i])
                    ) {
                    st.pop();
                }
                if(!st.empty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                } else if(st.empty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }
        int[]ans = new int[st.size()];
        // *** IMP to iterate ulta cause, stack size changes
        // if iterated sidha
        for(int i = st.size()-1; i >= 0; --i) {
            ans[i] = st.pop();
        }
        return ans;
    }
 */
/**
   public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < asteroids.length; ++i) {
            if(asteroids[i] > 0) st.push(asteroids[i]);
            else {
                while(!st.isEmpty() && 
                        st.peek() > 0 && 
                        st.peek() < Math.abs(asteroids[i])
                    ) {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                } else if(st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }
        int[]ans = new int[st.size()];
        for(int i = st.size()-1; i >= 0; --i) {
            ans[i] = st.pop();
        }
        return ans;
    }
 */

/**
**ArrayList version is slightly faster and more efficient** than the
Stack version in modern Java.
Here's why
---
### 1. Stack is a legacy class

* Stack (in java.util) extends Vector, which is **synchronized**.
* That means every  push(), pop(), peek(), and size() call uses
**synchronized methods** -> adding **thread-safety overhead**, even when you don't need it.

 You almost never need this synchronization for algorithm problems like *Asteroid Collision*.

---

### 2. ArrayList  is unsynchronized

* ArrayList  has no synchronization overhead.
* It's a modern, lighter, and more cache-friendly structure.
* So operations like  add(),  get(), and  remove(size−1)  are faster in single-threaded code
(like LeetCode problems).

---

### 3. Stack uses inheritance; ArrayList uses composition

 Stack inherits from Vector, which means it brings extra baggage
 (old methods, synchronized structure).
 ArrayList is simpler - it directly manages its array internally.

---

### Benchmark-level difference

For this kind of problem:

| Structure             | Thread-safe         | Typical Speed              | Recommended? |
| --------------------- | ------------------- | -------------------------- | ------------ |
|  Stack<Integer>       | Yes (unnecessary)   | Slower (≈~ 10–20% overhead)|  X No        |
|  ArrayList<Integer>   | X No                | Faster                     |  Yes         |
|  ArrayDeque<Integer>  | X No                | Fastest                    |  Best        |

So the **fastest and most modern** structure for this type of “stack behavior” is actually:

Deque<Integer> st = new ArrayDeque<>();   

It gives:

* O(1)  push ->  st.push(x) 
* O(1)  pop  ->  st.pop() 
* O(1)  peek ->  st.peek() 
* No synchronization
* Better memory locality

---

| Version      | Performance | Notes                           |
| ------------ | ----------- | ------------------------------- |
|  Stack       | Slowest     | Old, synchronized, legacy class |
|  ArrayList   | Faster      | Good for logic like this        |
|  ArrayDeque  | Fastest     | Modern replacement for Stack    |

 */
