package ds.tree;

public class TestTree {
public static void main(String[] args) {
	BinaryTree tree=new BinaryTree();
	TreeNode root=new TreeNode(1);
	tree.setRoot(root);
	root.left = new TreeNode(2);
	root.right=new TreeNode(3);
	root.left.left=new TreeNode(4);
	root.left.right=new TreeNode(5);
	root.right.left=new TreeNode(6);
	root.right.right=new TreeNode(7);
	System.out.println("Level Order:");
	tree.printLevelOrderTraversal(root);
	System.out.println("\nIn Order:");
	tree.printInOrderTraversal(root);
	System.out.println("\nPre Order:");
	tree.printPreOrderTraversal(root);
	System.out.println("\nPost Order:");
	tree.printPostOrderTraversal(root);
}
}
