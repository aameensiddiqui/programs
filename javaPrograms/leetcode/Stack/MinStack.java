class MyStack {
    int[]stack;
    int[]minstack;
    int top;

    MyStack() {
        stack = new int[16];
        minstack = new int[16];
        top = 0;
    }

    void push(int x) {
        if(top == 0) {
            minstack[top] = x;
            stack[top] = x;
            top++;
        } else {
            minstack[top] = Math.min(minstack[top-1], x);
            stack[top] = x;
            top++;
        }
        if(top == stack.length) {
            final int[]tstack = new int[stack.length*2];
            final int[]tminstack = new int[minstack.length*2];
            System.arraycopy(stack, 0, tstack, 0, stack.length);
            System.arraycopy(minstack, 0, tminstack, 0, minstack.length);
            stack = tstack;
            minstack = tminstack;
        }
    }

    int pop() {
        if(top != 0) {
            int val = minstack[top-1];
            top--;
            return val;
        }
        return -9999;
    }

    int top() {return stack[top-1];}

    int getMin() {return minstack[top-1];}
    //Stack<Integer> printStack() {return s;}
}

class MinStack {
    public static void main(String[]args) {
        MyStack ms = new MyStack();
        ms.push(111);
        ms.push(26);
        //log.info(ms.printStack());
        log.info("min : "+ms.getMin());
        log.info("pop : "+ms.pop());
        //log.info(ms.printStack());
        log.info("top : "+ms.top());
        ms.push(30);
        ms.push(34);
        log.info("min : "+ms.getMin());
        //log.info(ms.printStack());
    }
    private static final Log log = new Log();
}
/**
import java.util.Stack;
class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class MyStack {
    int min;
    Stack<Pair> s;
    MyStack() {s = new Stack<>();}

    void push(int x) {
        if(s.empty()) min = x;
        else min = Math.min(min, x);
        s.push(new Pair(x, min));
    }

    int pop() {
        int val = s.peek().first;
        s.pop();
        return val;
    }

    int top() {return s.peek().first;}

    int getMin() {return s.peek().second;}
    //Stack<Integer> printStack() {return s;}
}

 */
