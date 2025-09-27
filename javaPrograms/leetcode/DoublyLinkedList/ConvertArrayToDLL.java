class ConvertArrayToDLL {
    public Node arrToDll(int[]arr) {
        Node head = new Node(arr[0]);
        Node back = head;
        for(int i = 1; i < arr.length; ++i) {
            Node temp = new Node(arr[i], null, back);
            back.next = temp;
            back = temp;
        }
        return head;
    }
}
