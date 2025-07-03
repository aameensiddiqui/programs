package prog01_IntroDuction;

import java.util.Scanner;

public class BinaryTree {
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int data) {
		Node newNode = new Node(data);
		root = newNode;
	}
	
	
	// Iterative
	public void addNode(int data) {
		Scanner sc= new Scanner(System.in);
		Node newNode = new Node(data);
		if(root==null) {
			root=newNode;
			System.out.println("Element Inserted at root");
			return;
		}		
		int ch ;
		Node move = root;
		while(true) {				
			System.out.println("press 0 : to insert data at left side of "+move.data);
			System.out.println("press 1 : to insert data at right side of "+move.data);
			System.out.print("Enter Your Choise : ");
			
			ch = sc.nextInt();
			if(ch==0) {
				if(move.left==null) {
					move.left = newNode;
					break;
				}
				move = move.left;
			}else if(ch==1) {
				if(move.right==null) {
					move.right = newNode;
					break;
				}
				move = move.right;
			}else {
				System.out.println("No such option");
				break;
			}
		}
	}
	
	// Recursive
	public void addNodeR(Node move,Node newNode,Scanner sc) {
		if(move==null) {
			root=newNode;
			System.out.println("In null");
			return;
		}else {
			int ch ;
			System.out.println("press 0 : to insert data at left side of "+move.data);
			System.out.println("press 1 : to insert data at right side of "+move.data);
			System.out.print("Enter Your Choise : ");
			ch = sc.nextInt();
			if(ch==0) {
				if(move.left==null) {
					move.left = newNode;
					return;
				}else {					
					addNodeR(move.left, newNode,sc);
				}
			}else if(ch==1) {
				if(move.right==null) {
					move.right = newNode;
					return;
				}else{					
					addNodeR(move.right, newNode,sc);
				}
			}
		}
	}
	
	
	
	// Iterative
	public void addBaddBalancedNodeI(int data) {
		Node newNode = new Node(data);
		if(root==null) {
			root=newNode;
			System.out.println("Element Inserted at root");
			return;
		}		
		Node current = root;
		while(true) {
			if(data<current.data) {
				if(current.left==null) {
					current.left = newNode;
					break;
				}
				current = current.left;				
			}else {
				if(current.right==null) {
					current.right = newNode;
					break;
				}
				current = current.right;				
			}
		}
	}
	
	// Recursive
	public void addBaddBalancedNodeR(Node move,Node newNode) {
		if(move==null) {
			root=newNode;
			return;
		}else {
			if(newNode.data < move.data) {
				if(move.left==null) {
					move.left = newNode;
					return;
				}else{
					addBaddBalancedNodeR(move.left, newNode);
				}
			}else if(newNode.data > move.data) {
				if(move.right==null) {
					move.right = newNode;
					return;
				}else{
					addBaddBalancedNodeR(move.right, newNode);
				}
			}
		}
	}
	
	public void inOrder(Node move) {
		if(move!=null) {
			inOrder(move.left);
			System.out.print(move.data + " ");
			inOrder(move.right);
		}
	}
	
	public void preOrder(Node move) {
		if(move!=null) {
			System.out.print(move.data + " ");
			preOrder(move.left);
			preOrder(move.right);
		}
	}
	
	public void postOrder(Node move) {
		if(move!=null) {
			postOrder(move.left);
			postOrder(move.right);
			System.out.print(move.data + " ");
		}
	}
	
	int maxHeight(Node move) {
		if(move == null) {
			return -1;
		}
		int maxl = maxHeight(move.left);
		int maxr = maxHeight(move.right);
		return maxl>maxr? maxl+1 : maxr+1 ;
	}
	
	int maxDepth(Node move) {
		if(move == null) {
			return 0;
		}
		int maxl = maxDepth(move.left);
		int maxr = maxDepth(move.right);
		return maxl>maxr? maxl+1 : maxr+1 ;
	}
	
	int largest(Node move) {
		if(move==null) {
			return -1;
		}
		while(move.right!=null) {
			move = move.right;
		}
		return move.data;
	}
	
	int smallest(Node move) {
		if(move==null) {
			return -1;
		}
		while(move.left!=null) {
			move = move.left;
		}
		return move.data;
	}
	
	boolean search(int data) {
		boolean b = false;
		if(root == null) {
			return b;
		}
		Node move = root;
		while(move!=null) {
			if(move.data==data) {
				b = true;
				break;
			}else if(data<move.data) {
				move = move.left;
			}else {
				move = move.right;
			}
		}
		return b;
	}	
	
	// Delete Node
	public void deleteNode(int data) {
		// if root is null
		if(root==null) {
			System.out.println("No Element Present in Tree");
			return ;
		}
		
		// Creating two variables to traverse in tree
		Node temp = root;
		Node tag = null;
		
		// Traversing till the element is found
		while(temp!=null) {
			if(temp.data==data) {
				break;
			}
			tag = temp;
			if(data>temp.data) {
				temp=temp.right;
			}else {
				temp=temp.left;
			}
		}
		
		// if element found in root
		if(temp==root && root.data == data) {
			// condition
			if(root.right == null && root.left == null) {
				System.out.println("Data present at Root : Root deleted");
				root=null;
			}else if(root.left == null) {
				System.out.println("Data present at Root : Root deleted");
				root=root.right;
			}else if(root.right == null) {
				System.out.println("Data present at Root : Root deleted");
				root = root.left;
			}else {
				// if root.left and root.right not both are not null
				
				// right node to store node till the temp.right.leftest
				Node rightNode = root.right;
				while(rightNode.left!=null) {
					rightNode=rightNode.left;
				}
				
				// assigning nodes to right node
				rightNode.left = root.left;
				root.left=null;
				root = root.right;
				System.out.println("Data present at Root : Root deleted");
			}
		}else if(temp==root || temp==null) {
			System.out.println("Data is Not present in the Tree");
		}else {
			if(tag.left==temp) {				
				if(temp.left==null && temp.right==null) {
					tag.left=null;
				}else if(temp.left==null) {
					tag.left = temp.right;
				}else if(temp.right==null) {
					tag.left = temp.left;
				}else {
					Node rightNode = root.right;
					while(rightNode.left!=null) {
						rightNode=rightNode.left;
					}
					rightNode.left = temp.left;
					tag.left = temp.right;
				}
			}else if(tag.right==temp) {
				if(temp.left==null && temp.right==null) {
					tag.right=null;
				}else if(temp.left==null) {
					tag.right = temp.right;
				}else if(temp.right==null) {
					tag.right = temp.left;
				}else {
					Node rightNode = root.right;
					while(rightNode.left!=null) {
						rightNode=rightNode.left;
					}
					rightNode.left = temp.left;
					tag.right = temp.right;
				}
			}
		}
	}
	
	public void display() {
		System.out.print("InOrder traversal is : ");
		inOrder(root);
		System.out.println();
		System.out.print("PreOrder traversal is : ");
		preOrder(root);
		System.out.println();
		System.out.print("PostOrder traversal is : ");
		postOrder(root);
		System.out.println();
	}
}
