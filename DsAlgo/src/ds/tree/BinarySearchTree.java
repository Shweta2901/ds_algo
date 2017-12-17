package ds.tree;

public class BinarySearchTree extends BinaryTree {

	TreeNode pre;
	/* Given a binary tree, return true if it is BST, else false. 
	 * */
	public boolean isBST(TreeNode root) {
		if(root == null)
			return true;
		if(!isBST(root.left))
			return false;
		if(pre!=null && root.data<=pre.data) 
			return false;
		pre= root;
		return isBST(root.right);
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree=new BinarySearchTree();
		TreeNode root=new TreeNode(10);
		tree.setRoot(root);
		root.left = new TreeNode(5);
		root.right=new TreeNode(18);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(20);
		//root.right.left=new TreeNode(2);
		System.out.println(tree.isBST(root));
		
	}
}
