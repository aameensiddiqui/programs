import java.util.Queue;
import java.util.LinkedList;
class MyStack {
    Queue<Integer> q;
    MyStack() {
        q = new LinkedList<>();
    }
    int currSize = 0;
    
    void push(int x) {
        q.add(x);
        for(int i = 0; i < q.size()-1; ++i)
            q.add(q.remove());
    }
    int pop() {
        return q.remove();
    }
    int top() {
        return q.peek();
    }
    int size() {
        return q.size();
    }
    Queue<Integer> printStack() {
        return q;
    }
}
class StackUsingQueue {
    public static void main(String[]args) {
        MyStack s = new MyStack();
        s.push(1);
        log.info(s.printStack());
        s.push(2);
        log.info(s.printStack());
        s.push(3);
        log.info(s.printStack());
        log.info("top : "+s.top());
        log.info("pop : "+s.pop());
        log.info(s.printStack());
        log.info("pop : "+s.pop());
        log.info(s.printStack());
        log.info("pop : "+s.pop());
        log.info(s.printStack());
    }
    private static final Log log = new Log();
}
