class ReverseNodesInKGroup {
    
    public static Node reverseLL(Node head) {
        if(head == null || head.next == null) return head;
        Node move = head;
        Node prev = null;
        while(move != null) {
            Node front = move.next;
            move.next = prev;
            prev = move;
            move = front;
        }
        return head;
    }

    
    public static Node findKthNode(Node temp, int k) {
        --k;
        while(k > 0 && temp != null) {
            --k;
            temp = temp.next;
        }
        return temp;
    }

    
    public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prevLast = null;
        while(temp != null) {
            Node kthNode = findKthNode(temp, k);
            /** if kthnode is null, that means it is not a complete group */
            if(kthNode == null) {
                /** if there was a previous group link the last node to current node */
                if(prevLast != null) prevLast.next = temp;
                break;
            }

            /** store next node after kth node */
            Node nextNode = kthNode.next;

            /** disconnect kthnode from nextnode to make a seperate ll which we can reverse */
            kthNode.next = null;

            reverseLL(temp);

            /** if the reversed group is the 1st one make head the kth node */
            if(temp == head) head = kthNode;
            else prevLast.next = kthNode;

            /** update pointers */
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    
    public static void main(String[]args) {
        Node head = new Node(1);
        c.addNodeAtEnd(head, 2);
        c.addNodeAtEnd(head, 3);
        c.addNodeAtEnd(head, 4);
        c.addNodeAtEnd(head, 5);
        p.printLL(head);

        head = reverseKGroup(head, 2);
        p.printLL(head);
    }
    private static final Log      log = new Log();
    private static final PrintLL  p   = new PrintLL();
    private static final CreateLL c   = new CreateLL();
}
/**
import java.util.*;

// Node class represents a
// node in a linked list
class Node {
    // Data stored in the node
    int data;      
    // Pointer to the next
    // node in the list
    Node next;     

    // Constructor with both data
    // and next node as parameters
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Main {

    // Function to reverse a linked list
    // using the 3-pointer approach
    static Node reverseLinkedList(Node head) {
        // Initialize'temp' at
        // head of linked list
        Node temp = head;  
   
       // Initialize pointer 'prev' to NULL,
       // representing the previous node
       Node prev = null;  
       
       // Traverse the list, continue till
       // 'temp' reaches the end (NULL)
       while(temp != null){  
           // Store the next node in
           // 'front' to preserve the reference
           Node front = temp.next;  
           
           // Reverse the direction of the
           // current node's 'next' pointer
           // to point to 'prev'
           temp.next = prev;  
           
            // Move 'prev' to the current
            // node for the next iteration
           prev = temp;  
           
            // Move 'temp' to the 'front' node
            // advancing the traversal
           temp = front; 
       }
       
       // Return the new head of
       // the reversed linked list
       return prev;  

    }

    // Function to get the Kth node from
    // a given position in the linked list
    static Node getKthNode(Node temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        k -= 1;
        
        // Decrement K until it reaches
        // the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;
            
            // Move to the next node
            temp = temp.next;
        }
        
        // Return the Kth node
        return temp;
    }

    // Function to reverse nodes in groups of K
    static Node kReverse(Node head, int k) {
        // Initialize a temporary
        // node to traverse the list
        Node temp = head;
        
        // Initialize a pointer to track the
        // last node of the previous group
        Node prevLast = null;
        
        // Traverse through the linked list
        while (temp != null) {
            
            // Get the Kth node of the current group
            Node kThNode = getKthNode(temp, k);
            
            // If the Kth node is NULL
            // (not a complete group)
            if (kThNode == null) {
               
                // If there was a previous group,
                // link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                
                // Exit the loop
                break;
            }
            
            // Store the next node
            // after the Kth node
            Node nextNode = kThNode.next;
            
            // Disconnect the Kth node
            // to prepare for reversal
            kThNode.next = null;
            
            // Reverse the nodes from
            // temp to the Kth node
            reverseLinkedList(temp);
            
             // Adjust the head if the reversal
            // starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous
                // group to the reversed group
                prevLast.next = kThNode;
            }
            
            // Update the pointer to the
            // last node of the previous group
            prevLast = temp;
            
            // Move to the next group
            temp = nextNode;
        }
        
        // Return the head of the
        // modified linked list
        return head;
    }

    // Function to print the linked list
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with
        // values 5, 4, 3, 7, 9 and 2
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = kReverse(head, 4);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}
 */
