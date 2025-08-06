import java.util.Scanner;

class Main
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int ch;

        do {
            System.out.println("--------------------------");
            System.out.println("0: Exit");               
            System.out.println("1: Create a LinkedList");
            System.out.println("2: Display LinkedList"); 
            System.out.println("3: Add at the end");
            System.out.println("4: Add at the begining");
            System.out.println("5: Add at a position");
            System.out.println("6: Delete a node");
            System.out.println("7: Length of Linkedlist");
            System.out.println("--------------------------");

            ch = scan.nextInt();
            int num, pos;
            
            switch(ch) {
            case 1:
                System.out.print("Enter the size of linkedlist: ");
                int size = scan.nextInt();
                ll.createLinkedList(size);
                ll.display();
                break;
                
            case 2:
                ll.display();
                break;

            case 3:
                System.out.print("Enter a number to add: ");
                num = scan.nextInt();
                ll.addAtEnd(num);
                System.out.println("Added!");
                ll.display();
                break;

            case 4:
                System.out.print("Enter a number to add: ");
                num = scan.nextInt();
                ll.addAtBeg(num);
                System.out.println("Added!");
                ll.display();
                break;
                
            case 5:
                System.out.print("Enter the position: ");
                pos = scan.nextInt();
                System.out.print("Enter the value: ");
                num = scan.nextInt();
                ll.addAtPos(pos, num);
                ll.display();
                break;

            case 6:
                System.out.print("Enter the position to delete: ");
                pos = scan.nextInt();
                ll.deleteAtPos(pos);
                ll.display();
                break;
                
            case 7:
                System.out.println("Length: "+ll.lengthOfLL());
                break;
                
            case 0:
                break;
            }
            
        } while(ch != 0);
    }
}
