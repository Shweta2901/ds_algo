package ds.tree;

public class TestTree {
public static void main(String[] args) {
	BinaryTree tree=new BinaryTree();
	TreeNode root=new TreeNode(10);
	tree.setRoot(root);
	root.left = new TreeNode(5);
	root.right=new TreeNode(5);
	root.left.left=new TreeNode(2);
	root.left.right=new TreeNode(3);
	root.right.left=new TreeNode(2);
	//root.right.right=new TreeNode(3);
	/*System.out.println("Level Order:");
	tree.printLevelOrderTraversal(root);
	System.out.println("\nIn Order:");
	tree.printInOrderTraversal(root);
	System.out.println("\nPre Order:");
	tree.printPreOrderTraversal(root);
	System.out.println("\nPost Order:");
	tree.printPostOrderTraversal(root);
	System.out.println("\nMorris Inorder Order:");
	tree.printMorrisInorderTraversal(root);
	System.out.println("\nInorder Order Using Stack:");
	tree.printInOrderWithStack(root);
	//System.out.println("\nPreOrder Order Using Stack:");
	//tree.printPreOrderWithStack(root);
	//System.out.println("\nPreOrder Morris Traversal of tree");
	tree.printMorrisPreOrderTraversal(root);
	System.out.println("\nIterative Post Order Traversal using two stacks");
	tree.printPostOrder2Stack(root);
	System.out.println("\nReversal Level Order Traversal Recurssive ");
	tree.ReverseLevelOrderTraversalRecurssive(root);
	System.out.println("\nReversal Level Order Traversal ");*/
	//tree.printDiagonalTreeTraversal(root);
	System.out.println(tree.checkRootSumOfLeftRight(root));
	
}
}
