class Node {
    int data;
    Node next;
    Node() {}
    Node(int data) {this.data = data; this.next = null;}
    Node(int data, Node next) {this.data = data; this.next = next;}
}
class Queue {
    Node start = null;
    Node end = null;
    int currSize = 0;
    void push(int x) {             
        Node newNode = new Node(x);
        if(start == null) {start = end = newNode;}
        else {
            end.next = newNode;
            end = newNode;
        }
        currSize += 1;
    }
    int pop() {
        if(start == null) return -1;
        int topData = start.data;
        start = start.next;
        currSize -= 1;
        return topData;
    }
    int top() {
        if(start == null) return -1;
        return start.data;
    }
    int size() {
        return currSize;
    }
    void printQueue() {
        log.info("start************");
        Node temp = start;
        while(temp != null) {
            log.info(temp.data);
            temp = temp.next;
        }
        log.info("end**************");
    }
    private static final Log log = new Log();
}
class QueueUsingLL {
    public static void main(String[]args) {
        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.printQueue();
        log.info("size : "+q.size());
        log.info("top  : "+q.top());
        q.push(3);
        q.printQueue();
        log.info("size : "+q.size());
        log.info("pop  : "+q.pop());
        q.printQueue();
        log.info("size : "+q.size());
        q.push(4);
        q.printQueue();
        log.info("size : "+q.size());
        log.info("pop  : "+q.pop());
        q.printQueue();
        log.info("size : "+q.size());
        q.push(5);
        q.push(6);
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(10);
        q.push(11);
        q.push(12);
        q.push(13);
        q.printQueue();
        log.info("size : "+q.size());
        log.info("top  : "+q.top());
    }
    private static final Log log = new Log();
}
