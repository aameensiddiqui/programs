/**
 * Implementing Stack using an Array
 * Last In First Out (LIFO) principle
 */
class Stack {
    int top = -1;
    int[]arr = new int[10];
    int push(int n) {
        if(top+1 >= arr.length) return -1;
        top = top+1;
        arr[top] = n;
        return arr[top];
    }
    int pop() {    
        if(top < 0) return -1;
        int temp = arr[top];
        arr[top] = 0;
        top = top-1;
        return temp;
    }
    int top() {
        if(top < 0 || top >= arr.length) return -1;
        return top;
    }
    int[] array() {return arr;}
    int size() {return top+1;}
}

class StackImpl {
    public static void main(String[]args) {
        Stack s = new Stack();
        log.info("push : "+s.push(1));
        log.info(s.array());
        log.info("push : "+s.push(2));
        log.info(s.array());
        log.info("top  : "+s.top());
        log.info(s.array());
        log.info("push : "+s.push(3));
        log.info(s.array());
        log.info("pop  : "+s.pop());
        log.info(s.array());
        log.info("push : "+s.push(4));
        log.info(s.array());
        log.info("pop  : "+s.pop());
        log.info(s.array());
        log.info("size : "+s.size());
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(11);
        s.push(12);
        s.push(13);
        log.info(s.array());
        log.info("size : "+s.size());
        
    }
    private static final Log log = new Log();
}
