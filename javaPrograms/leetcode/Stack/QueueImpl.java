class Queue {
    int start = -1, end = -1, currSize = 0, size = 10;
    int[]arr = new int[size];

    void push(int x) {
        if(currSize == size) return;
        if(currSize == 0) {start = 0; end = 0;}
        else {end = (end + 1) % size;}
        arr[end] = x;
        currSize += 1;
    }
    int pop() {
        if(currSize == 0) return -1;
        int temp = arr[start];
        if(currSize == 1) {start = -1; end = -1;}
        else {start = (start + 1) % size;}
        currSize -= 1;
        return temp;
    }
    int top() {
        if(currSize == 0) return -1;
        return arr[start];
    }
    int size() {return currSize;}
    int[] array() {return arr;}
}
class QueueImpl {
    public static void main(String[]args) {
        Queue q = new Queue();
        q.push(1);
        log.info("top : "+q.top());
        log.info(q.array());
        q.push(2);
        log.info(q.array());
        log.info("top  : "+q.top());
        log.info(q.array());
        q.push(3);
        log.info(q.array());
        log.info("pop : "+q.pop());
        log.info(q.array());
        q.push(4);
        log.info(q.array());
        log.info("pop : "+q.pop());
        log.info(q.array());
        log.info(q.size());
        q.push(5);
        q.push(6);
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(10);
        q.push(11);
        q.push(12);
        q.push(13);
        log.info(q.array());
        log.info(q.size());
    }
    private static final Log log = new Log();
}
