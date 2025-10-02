class Node {
    int data;
    Node next;
    Node() {}
    Node(int data) {this.data = data; this.next = null;}
    Node(int data, Node next) {this.data = data; this.next = next;}
}
class Stack {
    Node top = null;
    int currSize = 0;
    void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        currSize += 1;
    }
    int pop() {
        if(top.next == null) return -1;
        int topData = top.data;
        Node temp = new Node();
        temp = top;
        top = top.next;
        currSize -= 1;
        return topData;
    }
    int top() {
        return top.data;
    }
    int size() {
        return currSize;
    }
    void printStack() {
        log.info("start************");
        Node temp = top;
        while(temp != null) {
            log.info(temp.data);
            temp = temp.next;
        }
        log.info("end**************");
    }
    private static final Log log = new Log();
}
class StackUsingLL {
    public static void main(String[]args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.printStack();
        log.info("size : "+s.size());
        log.info("top  : "+s.top());
        s.push(3);
        s.printStack();
        log.info("size : "+s.size());
        log.info("pop  : "+s.pop());
        s.printStack();
        log.info("size : "+s.size());
        s.push(4);
        s.printStack();
        log.info("size : "+s.size());
        log.info("pop  : "+s.pop());
        s.printStack();
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
        s.printStack();
        log.info("size : "+s.size());
    }
    private static final Log log = new Log();
}
