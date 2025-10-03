import java.util.Stack;
class MyQueue {
    Stack<Integer> s = new Stack<>();    
    Stack<Integer> s2 = new Stack<>();
    
    void push(int x) {
        while(!s.empty()) {
            s2.push(s.peek());
            s.pop();
        }
        s.push(x);
        while(!s2.empty()) {
            s.push(s2.peek());
            s2.pop();
        }
    }
    int pop() {return s.pop();}
    int top() {return s.peek();}
    boolean empty() {return s.size() == 0;}
    int stackSize() {return s.size();}
    Stack<Integer> printQueue() {return s;}
}
class QueueUsingStack {
    public static void main(String[]args) {
        MyQueue q = new MyQueue();

        log.info("empty : "+q.empty());
        log.info("stacksize : "+q.stackSize());
        
        q.push(1);
        log.info(q.printQueue());
        log.info("top : "+q.top());
        log.info("stacksize : "+q.stackSize());

        q.push(2);
        log.info(q.printQueue());
        log.info("top : "+q.top());
        log.info("stacksize : "+q.stackSize());
        log.info("empty : "+q.empty());

        q.push(3);
        log.info(q.printQueue());
        log.info("top : "+q.top());
        log.info("stacksize : "+q.stackSize());

        log.info("pop : "+q.pop());
        q.push(4);
        log.info(q.printQueue());
        log.info("top : "+q.top());
        log.info("stacksize : "+q.stackSize());
    }
    private static final Log log = new Log();
}
