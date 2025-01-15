/* Requirement:
	(1) Complete the following codes, and you may add auxiliary functions if necessary
	(2) You are NOT allowed to modify the code originally given in AVLTree.java, BST.java, Node.java and BinaryTreePrinter.java 
	(3) You are NOT allowed to modify the filename of AVLTree.java, BST.java, Node.java and BinaryTreePrinter.java 
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in AVLTree.java:
	
		The initial tree is empty:
		Empty tree!

		After inserting 10, 5:
			  10|1      
			┌───┘       
		   5|0          

		After inserting 3: (case 1)
			   5|1      
			┌───┴───┐   
		   3|0    10|0  

		After inserting 13, 18: (case 4)
					   5|2              
				┌───────┴───────┐       
			   3|0            13|1      
							┌───┴───┐   
						  10|0    18|0  

		After inserting 12: (case 3)
					  10|2              
				┌───────┴───────┐       
			   5|1            13|1      
			┌───┘           ┌───┴───┐   
		   3|0            12|0    18|0  

		After inserting 4: (case 2)
					  10|2              
				┌───────┴───────┐       
			   4|1            13|1      
			┌───┴───┐       ┌───┴───┐   
		   3|0     5|0    12|0    18|0  

		After inserting 11, 22, 16:
									  10|3                              
						┌───────────────┴───────────────┐               
					   4|1                            13|2              
				┌───────┴───────┐               ┌───────┴───────┐       
			   3|0             5|0            12|1            18|1      
											┌───┘           ┌───┴───┐   
										  11|0            16|0    22|0  

		After inserting 20: (case 4)
									  13|3                              
						┌───────────────┴───────────────┐               
					  10|2                            18|2              
				┌───────┴───────┐               ┌───────┴───────┐       
			   4|1            12|1            16|0            22|1      
			┌───┴───┐       ┌───┘                           ┌───┘       
		   3|0     5|0    11|0                            20|0          

		After inserting 8:
																	  13|4                                                              
										┌───────────────────────────────┴───────────────────────────────┐                               
									  10|3                                                            18|2                              
						┌───────────────┴───────────────┐                               ┌───────────────┴───────────────┐               
					   4|2                            12|1                            16|0                            22|1              
				┌───────┴───────┐               ┌───────┘                                                       ┌───────┘               
			   3|0             5|1            11|0                                                            20|0                      
								└───┐                                                                                                   
								   8|0                                                                                                  

		Searching for 10, 5, 13, 18, 21:
		true
		true
		true
		true
		true

		After deleting 16 (case 3, case 1):
									  10|3                              
						┌───────────────┴───────────────┐               
					   4|2                            13|2              
				┌───────┴───────┐               ┌───────┴───────┐       
			   3|0             5|1            12|1            20|1      
								└───┐       ┌───┘           ┌───┴───┐   
								   8|0    11|0            18|0    22|0  

		After deleting 3 (case 4):
									  10|3                              
						┌───────────────┴───────────────┐               
					   5|1                            13|2              
				┌───────┴───────┐               ┌───────┴───────┐       
			   4|0             8|0            12|1            20|1      
											┌───┘           ┌───┴───┐   
										  11|0            18|0    22|0  

		After deleting 5, 8 (case 4):
									  13|3                              
						┌───────────────┴───────────────┐               
					  10|2                            20|1              
				┌───────┴───────┐               ┌───────┴───────┐       
			   4|0            12|1            18|0            22|0      
							┌───┘                                       
						  11|0                                          

		After deleting 20, 18 (case 2):
					  12|2              
				┌───────┴───────┐       
			  10|1            13|1      
			┌───┴───┐           └───┐   
		   4|0    11|0            22|0  

		
	*/
public class AVLTree extends BST {
	public AVLTree() {
		super();
	}

	public int getBalanceFactor(Node node) {
		if (node == null) {
			return 0; // The balance factor of a null node is 0
		}
		return Node.getHeight(node.getLeft()) - Node.getHeight(node.getRight());
	}

	public Node leftRotation(Node root) {
		Node newRoot = root.getRight();
		root.setRight(newRoot.getLeft());
		newRoot.setLeft(root);

		// Update heights
		root.updateHeight();
		newRoot.updateHeight();

		return newRoot;
	}

	public Node rightRotation(Node root) {
		Node newRoot = root.getLeft();
		root.setLeft(newRoot.getRight());
		newRoot.setRight(root);

		// Update heights
		root.updateHeight();
		newRoot.updateHeight();

		return newRoot;
	}

	public Node rotation(Node root) {
		int balanceFactor = getBalanceFactor(root);

		// Left-heavy
		if (balanceFactor > 1) {
			if (getBalanceFactor(root.getLeft()) < 0) {
				root.setLeft(leftRotation(root.getLeft()));
			}
			return rightRotation(root);
		}

		// Right-heavy
		if (balanceFactor < -1) {
			if (getBalanceFactor(root.getRight()) > 0) {
				root.setRight(rightRotation(root.getRight()));
			}
			return leftRotation(root);
		}

		return root; // Already balanced
	}

	@Override
	public Node insertNode(Node root, int x) {
		root = super.insertNode(root, x); // Standard BST insertion
		if (root == null) {
			return new Node(x);
		}
		root.updateHeight(); // Update height after insertion
		return rotation(root); // Rebalance the tree
	}

	@Override
	public Node deleteNode(Node root, int x) {
		root = super.deleteNode(root, x); // Standard BST deletion
		if (root == null) {
			return null;
		}
		root.updateHeight(); // Update height after deletion
		return rotation(root); // Rebalance the tree
	}

	
	public static void main(String[] args) {
		AVLTree avl = new AVLTree();
		System.out.println("The initial tree is empty:");
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 13:");
		avl.insertNode(13);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 7:");
		avl.insertNode(7);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 25:");
		avl.insertNode(25);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 58:");
		avl.insertNode(58);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 80:");
		avl.insertNode(80);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 15:");
		avl.insertNode(15);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 82:");
		avl.insertNode(82);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 6:");
		avl.insertNode(6);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 65:");
		avl.insertNode(65);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 71:");
		avl.insertNode(71);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 30:");
		avl.insertNode(30);
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 60:");
		avl.insertNode(60);
		BinaryTreePrinter.printTree(avl);

//		System.out.println("After inserting 10, 5:");
//		avl.insertNode(10);
//		avl.insertNode(5);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nAfter inserting 3: (case 1)");
//		avl.insertNode(3);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nAfter inserting 13, 18: (case 4)");
//		avl.insertNode(13);
//		avl.insertNode(18);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nAfter inserting 12: (case 3)");
//		avl.insertNode(12);
//		BinaryTreePrinter.printTree(avl);
//		System.out.println("\nAfter inserting 4: (case 2)");
//		avl.insertNode(4);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nAfter inserting 11, 22, 16:");
//		avl.insertNode(11);
//		avl.insertNode(22);
//		avl.insertNode(16);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nAfter inserting 20: (case 4)");
//		avl.insertNode(20);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nAfter inserting 8:");
//		avl.insertNode(8);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nSearching for 10, 5, 13, 18, 21:");
//		System.out.println(avl.findNode(10) != null && avl.findNode(10).getKey() == 10 ? "true" : "false");
//		System.out.println(avl.findNode(5) != null && avl.findNode(5).getKey() == 5 ? "true" : "false");
//		System.out.println(avl.findNode(13) != null && avl.findNode(13).getKey() == 13 ? "true" : "false");
//		System.out.println(avl.findNode(18) != null && avl.findNode(18).getKey() == 18 ? "true" : "false");
//		System.out.println(avl.findNode(21) == null ? "true" : "false");
//
//		System.out.println("\nAfter deleting 16 (case 3, case 1):");
//		avl.deleteNode(16);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nAfter deleting 3 (case 4):");
//		avl.deleteNode(3);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nAfter deleting 5, 8 (case 4):");
//		avl.deleteNode(5);
//		avl.deleteNode(8);
//		BinaryTreePrinter.printTree(avl);
//
//		System.out.println("\nAfter deleting 20, 18 (case 2):");
//		avl.deleteNode(20);
//		avl.deleteNode(18);
//		BinaryTreePrinter.printTree(avl);
	}
}
