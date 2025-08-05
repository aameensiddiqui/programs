import java.util.Scanner;

class LinkedList
{
    Node head;

    public LinkedList()
    {
        head = null;
    }
    
    public LinkedList(int data)
    {
        head = new Node(data);
    }

    Scanner scan = new Scanner(System.in);
    // create a linked list
    public void createLinkedList(int num)
    {
        for(int i = 1; i <= num; ++i) {
            if(i == 1) System.out.print("Enter "+i+"st number: ");
            else if(i == 2) System.out.print("Enter "+i+"nd number: ");
            else if(i == 3) System.out.print("Enter "+i+"rd number: ");
            else System.out.print("Enter "+i+"th number: ");

            int n = scan.nextInt();
            addAtEnd(n);
        }
    }

    // add data at the end
    public void addAtEnd(int data)
    {
        Node record = new Node(data);
        if(head == null) head = record;
        else {
            Node move;
            for(move = head; move.next != null; move = move.next);
            move.next = record;
        }
    }

    // add at the begining
    public void addAtBeg(int data)
    {
        Node record = new Node(data);
        if(head == null) head = record;
        else {
            record.next = head;
            head = record;
        }
    }

    // add a value at any position in ll
    public void addAtPos(int position, int data)
    {
        if(position > lengthOfLL()+1 || position <= 0) return;
        else {
            Node newNode = new Node(data);
            if(position == 1 && head == null) {
                head = newNode;
            } else if(position == 1) {
                newNode.next = head;
                head = newNode;
            } else {
                // take two nodes
                Node x = head, y = head;
                // travel upto the node before position
                for(int i = 0; i < position-1; ++i) {
                    x = x.next; y = y.next;
                }
                // swap nodes
                y = y.next;
                x.next = newNode;
                newNode.next = y;
            }
            
        }
    }

    // delete at a position
    public void deleteAtPos(int position)
    {
        if(position <= 0 || head == null || position > lengthOfLL())
            return;
        else {
            if(position == 1) head = head.next;
            else {
                Node x = head, y = head;
                for(int i = 0; i < position-1; ++i) {
                    x = x.next; y = y.next;
                }
                x = x.next;
                y.next = x.next;
                x.next = null;
            }
        }
    }

    // display linked list
    public void display()
    {
        if(head == null) System.out.println("Linkedlist is empty");
        else {
            Node move;
            for(move = head; move.next != null; move = move.next) {
                System.out.print(move.data+" ");
            }
            System.out.print(move.data+" ");
            System.out.println();
        }
    }

    // returns the length of Linkedlist
    public int lengthOfLL()
    {
        int cnt = 0;
        if(head == null) return cnt;
        else {
            Node move = head;
            while(move != null) {
                move = move.next;
                cnt++;
            }
        }
        return cnt;
    }
}
