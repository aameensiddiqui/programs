package prog02_LevelWize;

public class BinaryTree {
	public NodeTree root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int data) {
		NodeTree newNode = new NodeTree(data);
		root = newNode;
	}
	
	public void addBaddBalancedNodeR(NodeTree move,NodeTree newNode) {
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
	
	public void inOrder(NodeTree move) {
		if(move!=null) {
			inOrder(move.left);
			System.out.print(move.data + " ");
			inOrder(move.right);
		}
	}
	
	public void preOrder(NodeTree move) {
		if(move!=null) {
			System.out.print(move.data + " ");
			preOrder(move.left);
			preOrder(move.right);
		}
	}
	
	public void postOrder(NodeTree move) {
		if(move!=null) {
			postOrder(move.left);
			postOrder(move.right);
			System.out.print(move.data + " ");
		}
	}
	
	public void display() {
		System.out.print("InOrder traversal is : ");
		inOrder(root);
		System.out.println();
	}
	
	public void levelOrderDisp(NodeTree move) {
		NodeQueue newNode = new NodeQueue(move);
		Queue q = new Queue(newNode);
		
		while(!q.isEmpty()) {
			NodeTree levelNode = q.deQueue();
			System.out.print(levelNode.data+" ");
			if(levelNode.left!=null) {
				NodeQueue leftNode = new NodeQueue(levelNode.left);
				q.enQueue(leftNode);
			}
			if(levelNode.right!=null) {
				NodeQueue rightNode = new NodeQueue(levelNode.right);
				q.enQueue(rightNode);
			}
		}
	}
}