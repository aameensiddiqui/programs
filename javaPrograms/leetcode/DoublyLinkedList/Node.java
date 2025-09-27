class Node {
    int data;
    Node next;
    Node prev;
    public Node() {}
    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
