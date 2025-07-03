package prog02_LevelWize;

public class Main {

	public static void main(String[] args) {
		BinaryTree bbt = new BinaryTree();
		
		NodeTree newNode1 = new NodeTree(100);
		NodeTree newNode2 = new NodeTree(90);
		NodeTree newNode3 = new NodeTree(110);
		NodeTree newNode4 = new NodeTree(80);
		NodeTree newNode5 = new NodeTree(95);
		NodeTree newNode6 = new NodeTree(105);
		NodeTree newNode7 = new NodeTree(120);
		NodeTree newNode8 = new NodeTree(60);
		NodeTree newNode9 = new NodeTree(85);
		NodeTree newNode10 = new NodeTree(107);
		NodeTree newNode11 = new NodeTree(130);
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
		
		
		bbt.display();
		
		bbt.levelOrderDisp(bbt.root);
	}

}
