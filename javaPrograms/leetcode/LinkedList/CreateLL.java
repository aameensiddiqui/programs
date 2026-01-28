class CreateLL {
    public static void addNodeAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) head = newNode;
        else {
            Node move;
            for(move = head; move.next != null; move = move.next);
            move.next = newNode;
        }
    }
    public static Node createLL(int[] arr) {
        if (arr.length == 0) return null;
        Node head  = new Node(arr[0]);
        for (int i = 1; i < arr.length; ++i) {
            Node newNode = new Node(arr[i]);
            Node move;
            for(move = head; move.next != null; move = move.next);
            move.next = newNode;
        }
        return head;
    }
}
