class Node
{
    int data;
    Node next;

    Node(int newData, Node newNext) {
        this.data = newData;
        this.next = newNext;
    }

    Node(int newData) {
        this.data = newData;
        this.next = null;
    }
}
