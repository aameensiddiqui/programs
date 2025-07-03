package prog01_IntroDuction;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		BinaryTree bbt = new BinaryTree();
		Scanner sc = new Scanner(System.in);
		
		int n;
		do {
			System.out.println("1 : to AddNode in tree");
			System.out.println("2 : to Display traversals tree");
			System.out.println("3. Create Balanced inary Tree");
			System.out.println("4. Maximum element in BST");
			System.out.println("5. Minimum element in BST");
			System.out.println("6. Height of Binary tree");
			System.out.println("7. Depth of Binary Tree");
			System.out.println("8. Search If element present in BST or not");
			System.out.println("9. Delete Node In Binary Tree");
			System.out.println("0 : to exit");
			System.out.print("Enter your choise : ");
			
			n = sc.nextInt();
			
			switch(n) {
			case 1:{
				System.out.print("Enter data to add in Tree : ");
				int data = sc.nextInt();
				// Iterative
//				bt.addNode(data);
				
				// Recursive
				Node newNode = new Node(data);
				bt.addNodeR(bt.root, newNode,sc);
				break;
			}
			case 2:{
				System.out.println("************* Displaying traversals *************");
				bbt.display();
				break;
			}
			case 3:{
//				System.out.print("Enter data to add in Balanced Binary Tree : ");
//				int data = sc.nextInt();
				// for iterative
				// bbt.addBaddBalancedNode(data);
				
				// for Recursive
				Node newNode1 = new Node(100);
				Node newNode2 = new Node(90);
				Node newNode3 = new Node(110);
				Node newNode4 = new Node(80);
				Node newNode5 = new Node(95);
				Node newNode6 = new Node(105);
				Node newNode7 = new Node(120);
				Node newNode8 = new Node(60);
				Node newNode9 = new Node(85);
				Node newNode10 = new Node(107);
				Node newNode11 = new Node(130);
				bbt.addBaddBalancedNodeR(bbt.root, newNode1);
				bbt.addBaddBalancedNodeR(bbt.root, newNode2);
				bbt.addBaddBalancedNodeR(bbt.root, newNode3);
				bbt.addBaddBalancedNodeR(bbt.root, newNode4);
				bbt.addBaddBalancedNodeR(bbt.root, newNode5);
				bbt.addBaddBalancedNodeR(bbt.root, newNode6);
				bbt.addBaddBalancedNodeR(bbt.root, newNode7);
				bbt.addBaddBalancedNodeR(bbt.root, newNode8);
				bbt.addBaddBalancedNodeR(bbt.root, newNode9);
				bbt.addBaddBalancedNodeR(bbt.root, newNode10);
				bbt.addBaddBalancedNodeR(bbt.root, newNode11);
				break;
			}
			case 4:{
				int max = bbt.largest(bbt.root);
				System.out.println("Maximum element in BST is "+max);
				break;
			}
			case 5:{
				int min = bbt.smallest(bbt.root);
				System.out.println("Maximum element in BST is "+min);
				break;
			}
			case 6:{
				int max = bbt.maxHeight(bbt.root);
				System.out.println("Maximum height of BST is "+max);
				break;
			}
			case 7:{
				int maxx = bbt.maxDepth(bbt.root);
				System.out.println("Maximum Depth of BST is "+maxx);
				break;
			}
			case 8:{
				if(bbt.search(100)) {
					System.out.println("Element Found in BST");
				}else {
					System.out.println("Element Not-Found in BST");
				}
				break;
			}
			case 9:{
				System.out.print("Enter data to delete from tree : ");
				int num = sc.nextInt();
				bbt.deleteNode(num);
				break;
			}
			
			case 0:{
				break;
			}
			}
		}while(n!=0);
	}

}
