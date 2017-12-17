package ds.tree;

import java.util.Stack;

public class BinarySearchTree extends BinaryTree {

	TreeNode root;
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
	
	/* Given a Binary Search Tree (BST) and a range [min, max],
	 * remove all keys which are outside the given range. 
	 * The modified tree should also be BST.
	 * 
	 * */
	public TreeNode removeOutOfRangeKeys(TreeNode root,int min,int max) {
		if(root == null)
			return null;
		root.left = removeOutOfRangeKeys(root.left,min,max);
		root.right = removeOutOfRangeKeys(root.right,min,max);
		
		if(root.data<min) 
			return root.right;
		if(root.data>max)
			return root.left;
		return root;
	}
	public TreeNode insert(TreeNode root,int data) {
		if(root == null){
			return new TreeNode(data);
		}	
		if(data<root.data){
			root.left=insert(root.left,data);
		} else
			root.right=insert(root.right,data);
		return root;
			
	}
	/* Given two Binary Search Trees(BST), print the elements of both BSTs in sorted form. 
	 * The expected time complexity is O(m+n) where m is the number of nodes in first tree 
	 * and n is the number of nodes in second tree.
	 * Maximum allowed auxiliary space is 
	 * O(height of the first tree + height of the second tree).
	 * 
	 * **/
	public void printTwoBST(TreeNode bst1,TreeNode bst2) {
		//if any of the tree is empty print the other in inder traversal
		if(bst1==null){
			printInOrderTraversal(bst2);
			return;
		}
		if(bst2==null){
			printInOrderTraversal(bst1);
			return;
		}
		//stack for storing nodes of both the trees
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		TreeNode current1=bst1;
		TreeNode current2=bst2;
		
		while(current1!=null || current2!=null || !stack1.isEmpty() || !stack2.isEmpty()) {
			//push all left subtree nodes to corresponding stacks
			if(current1!=null || current2!=null) {
				if(current1!=null) {
					stack1.push(current1);
					current1=current1.left;
				}
				if(current2!=null) {
					stack2.push(current2);
					current2=current2.left;
				}
			} else {
				//if(any of the stack is empty, it is exhausted, 
				//print inorder traversal for each node in other tree)
				if(stack1.isEmpty()) {
					while(!stack2.isEmpty()) {
						current2=stack2.pop();
						//as we have already printed the subtreee, make it's left child null
						current2.left=null;
						printInOrderTraversal(current2);
					}
					return;
				}
				if(stack2.isEmpty()) {
					while(!stack1.isEmpty()) {
						current1=stack1.pop();
						//as we have already printed the subtreee, make it's left child null
						current1.left=null;
						printInOrderTraversal(current1);
					}
					return;
				}
				current1=stack1.peek();
				current2=stack2.peek();
				
				if(current1.data<current2.data) {
					current1=stack1.pop();
					System.out.print(current1.data+"\t");
					current1=current1.right;
					current2=null;
				} else {
					current2=stack2.pop();
					System.out.print(current2.data+"\t");
					current2=current2.right;
					current1=null;
				}
			}
		}
		
	}
	/* Given a root of a tree, and an integer k. 
	 * Print all the nodes which are at k distance from root.
	 * */
	public void printNodesAtDistanceKFromRoot(TreeNode root,int k) {
		if(root==null)
			return;
		if(k==0){
			System.out.print(root.data+"\t");
			return;
		}
		printNodesAtDistanceKFromRoot(root.left,k-1);
		printNodesAtDistanceKFromRoot(root.right,k-1);
	}
	/*
	 * Given a binary tree, a target node in the binary tree, and an integer value k, 
	 * print all the nodes that are at distance k from the given target node. 
	 * No parent pointers are available.
	 * */
	public int printNodesAtDistanceKFromTarget(TreeNode root, TreeNode target, int k) {
		if (root == null)
			return -1;
		// whenever we find the target node print all nodes at dstance k from
		// target node in it's subtree
		if (root == target) {
			printNodesAtDistanceKFromRoot(target, k);
			return 0;
		}
		// find distance of target node(if present in left subtree) from root
		int leftDistance = printNodesAtDistanceKFromTarget(root.left, target, k);
		// if target node is present in left sub tree
		// print all nodes in it's ancestor subtree which are at distance
		// k-ancestor distance
		if (leftDistance != -1) {
			// if current ancestor itself is at distance k from root print it's
			// data
			if (leftDistance + 1 == k) {
				System.out.print(root.data + "\t");
			} else {
				// print all nodes at distance k-leftDistance(distance of
				// root)-2(1 for ancestor, 1 for right child)
				// in it's right subtree
				printNodesAtDistanceKFromRoot(root.right, k - leftDistance - 2);
			}
			return leftDistance + 1;
		}
		// if target not there in left sub tree. repeat the same for right
		// subtree
		// find distance of target node(if present in left subtree) from root
		int rightDistance = printNodesAtDistanceKFromTarget(root.right, target, k);
		// if target node is present in left sub tree
		// print all nodes in it's ancestor subtree which are at distance
		// k-ancestor distance
		if (rightDistance != -1) {
			// if current ancestor itself is at distance k from root print it's
			// data
			if (rightDistance + 1 == k) {
				System.out.print(root.data + "\t");
			} else {
				// print all nodes at distance k-leftDistance(distance of
				// root)-2(1 for ancestor, 1 for right child)
				// in it's right subtree
				printNodesAtDistanceKFromRoot(root.right, k - rightDistance - 2);
			}
			return rightDistance + 1;
		}
		// If target was neither present in left nor in right subtree
        return -1;
	}
	public static void main(String[] args) {
		BinarySearchTree tree=new BinarySearchTree();
		BinarySearchTree tree1=new BinarySearchTree();
		tree.root=tree.insert(tree.root,6);
		tree.insert(tree.root,-13);
		tree.insert(tree.root,-8);
		tree.insert(tree.root,14);
		tree.insert(tree.root,13);
		tree.insert(tree.root,15);
		tree.insert(tree.root,7);
		//tree.insert(tree.root,16);
		//tree.insert(tree.root,17);
		//tree.insert(tree.root,8);
		//tree.insert(tree.root,9);
		tree1.root=tree1.insert(tree1.root, 4);
		tree1.insert(tree1.root, 2);
		tree1.insert(tree1.root, 8);
		//tree.printInOrderTraversal(tree.root);
		//tree.removeOutOfRangeKeys(tree.root, -10, 8);
		//tree.printTwoBST(tree.root, tree1.root);
		//tree.printNodesAtDistanceKFromRoot(tree.root, 2);
		//tree.printBoundary(tree.root);
		//System.out.println(tree.findLCA(tree.root, 15, 17).data);
		System.out.println(tree.isBalanced(tree.root));
	}
}
