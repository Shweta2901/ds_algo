package ds.tree;

public class BinarySearchTree {

	/* Given a binary tree, return true if it is BST, else false. 
	 * */
	public static boolean isBST(TreeNode root) {
		if(root==null){
			return true;
		}
		//is leaf node
		if(root.left==null && root.right==null)
			return true;
		boolean leftResult=true,rightResult=true;
		if(root.left!=null)
			leftResult = isBST(root.left) && root.data>root.left.data;
		if(root.right!=null)
			rightResult = isBST(root.right) && root.data<root.right.data;
		return (leftResult && rightResult); 
	}
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		TreeNode root=new TreeNode(10);
		tree.setRoot(root);
		root.left = new TreeNode(5);
		root.right=new TreeNode(18);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(20);
		//root.right.left=new TreeNode(2);
		//System.out.println(BinarySearchTree.isBST(root));
		System.out.println((2+3+4+5+6+7+8)^5);
		System.out.println((2^5+3^5+4^5+5^5+6^5+7^5+8^5));
	}
}
