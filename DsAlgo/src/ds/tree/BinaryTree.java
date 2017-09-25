package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Binary Tree Properties:
 * 
 * The maximum number of nodes at level ‘l’ of a binary tree is 2l-1.
 * Here level is number of nodes on path from root to the node (including root and node). Level of root is 1.
 * 
 * Maximum number of nodes in a binary tree of height ‘h’ is 2h – 1.
 * Here height of a tree is maximum number of nodes on root to leaf path. Height of a leaf node is considered as 1.
 * 
 * In a Binary Tree with N nodes, minimum possible height or minimum number of levels is  ⌈ Log2(N+1) ⌉   
 * 
 * A Binary Tree with L leaves has at least   ⌈ Log2L ⌉ + 1   levels
 * 
 * In Binary tree, number of leaf nodes is always one more than nodes with two children.
 * 
 * Types of Binary trees:
 * 
 * 1) Full Binary Tree: 
 * A Binary Tree is full if every node has 0 or 2 children.
 * In a Full Binary, number of leaf nodes is number of internal nodes plus 1
 * 
 * 2) Complete Binary Tree: 
 * A Binary Tree is complete Binary Tree if all levels are completely filled except possibly the last level 
 * and the last level has all keys as left as possible
 * 
 * 3) Perfect Binary Tree 
 * A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all leaves are at same level.
 * A Perfect Binary Tree of height h (where height is number of nodes on path from root to leaf) has 2h – 1 node.
 * Example of Perfect binary tree is ancestors in family. 
 * Keep a person at root, parents as children, parents of parents as their children.
 * 
 * 4) Balanced Binary Tree
 * A binary tree is balanced if height of the tree is O(Log n) where n is number of nodes.
 * For Example, AVL tree maintain O(Log n) height by making sure that the difference between heights of left and right subtrees is 1. 
 * Red-Black trees maintain O(Log n) height by making sure that the number of Black nodes on every root to leaf paths are same 
 * and there are no adjacent red nodes. 
 * Balanced Binary Search trees are performance wise good as they provide O(log n) time for search, insert and delete.
 * 
 * 5) A degenerate (or pathological) tree 
 * A Tree where every internal node has one child. Such trees are performance-wise same as linked list.
 * 
 * Handshaking lemma is about undirected graph. 
 * In every finite undirected graph number of vertices with odd degree is always even.
 * The handshaking lemma is a consequence of the degree sum formula (also sometimes called the handshaking lemma)
 * 
 * Following are some interesting facts that can be proved using Handshaking lemma.
 * 1) In a k-ary tree where every node has either 0 or k children, following property is always true.
 * L = (k - 1)*I + 1
 * Where L = Number of leaf nodes
 *       I = Number of internal nodes 
 * 2) In Binary tree, number of leaf nodes is always one more than nodes with two children.
 *  L = T + 1
 *  Where L = Number of leaf nodes
 *        T = Number of internal nodes with two children
 *        
 * A Binary Tree is labeled if every node is assigned a label and
 * a Binary Tree is unlabeled if nodes are not assigned any label.
 * 
 * How many different Unlabeled Binary Trees can be there with n nodes?
 * T(n) = (2n)! / (n+1)!n!
 * Number of Binary Search Trees (BST) with n nodes is also same as number of unlabeled trees.
 * The reason for this is simple, in BST also we can make any key as root,
 * If root is i’th key in sorted order, then i-1 keys can go on one side and (n-i) keys can go on other side.
 * 
 * How many labeled Binary Trees can be there with n nodes?
 * To count labeled trees, we can use above count for unlabeled trees. 
 * The idea is simple, every unlabeled tree with n nodes can create n! different labeled trees by assigning different permutations of labels to all nodes.
 * Therefore,
 * Number of Labeled Trees = (Number of unlabeled trees) * n!
 *                       = [(2n)! / (n+1)!n!]  × n!
 *                       
 * */
public class BinaryTree {

	private TreeNode root;
	
	BinaryTree() {
		this.root=null;
	}
	public void setRoot(TreeNode root) {
		this.root=root;
	}
	public void printInOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		printInOrderTraversal(root.left);
		System.out.print(root.data+"\t");
		printInOrderTraversal(root.right);
		return;
	}
	public void printPreOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+"\t");
		printPreOrderTraversal(root.left);
		printPreOrderTraversal(root.right);
		return;
	}
	public void printPostOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		printPostOrderTraversal(root.left);
		printPostOrderTraversal(root.right);
		System.out.print(root.data+"\t");
		return;
	}
	public void printReverseInOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		printReverseInOrderTraversal(root.right);
		System.out.print(root.data+"\t");
		printReverseInOrderTraversal(root.left);
		return;
	}
	public void printReversePreOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+"\t");
		printReversePreOrderTraversal(root.right);
		printReversePreOrderTraversal(root.left);
		return;
	}
	public void printReversePostOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		printReversePostOrderTraversal(root.right);
		printReversePostOrderTraversal(root.left);
		System.out.print(root.data+"\t");
		return;
	}
	
	public void printLevelOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			TreeNode element= queue.poll();
			if(element==null) {
				if(!queue.isEmpty()) {
					System.out.println("");
					queue.add(null);	
				}
			} else {
				System.out.print(element.data+"\t");
				if(element.left!=null) {
					queue.add(element.left);
				}
				if(element.right!=null) {
					queue.add(element.right);
				}
			}
		}
		
	}
	
	/**
	 * Using Morris Traversal, we can traverse the tree without using stack and recursion.
	 * The idea of Morris Traversal is based on Threaded Binary Tree.
	 * In this traversal, we first create links to Inorder successor 
	 * and print the data using these links, and finally revert the changes to restore original tree.
	 * 
	 * @param root
	 */
	public void printMorrisInorderTraversal(TreeNode root) {
		if(root == null){
			return;
		}
		TreeNode current = root;
		TreeNode predecessor = null;
		while(current!=null) {
			if(current.left == null) {
				System.out.print(current.data+"\t");
				current=current.right;
			} else {
				predecessor = current.left;
				
				//find the predecessor of the current(rightmost node of the left child)
				while(predecessor.right!=null && predecessor.right!=current)
					predecessor=predecessor.right;
				/* Revert the changes made in if part to restore the 
                original tree i.e.,fix the right child of predecssor*/
				if(predecessor.right==current) {
					predecessor.right=null;
					System.out.print(current.data+"\t");
					current=current.right;
				} else{
					predecessor.right=current;
					current=current.left;
				}
			}
		}
	}
	/**
	 * Using Stack is the obvious way to traverse tree without recursion. 
	 * Below is an algorithm for traversing binary tree using stack. 
	 * 1) Create an empty stack S.
	 * 2) Initialize current node as root
	 * 3) Push the current node to S and set current = current->left until current is NULL
	 * 4) If current is NULL and stack is not empty then 
	 * 		a) Pop the top item from stack.
	 * 		b) Print the popped item, set current = popped_item->right 
	 * 		c) Go to step 3.
	 * 5) If current is NULL and stack is empty then we are done.
	 * 
	 * @param root
	 */
	public void printInOrderWithStack(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode current = root.left;
		while(current!=null) {
			stack.push(current);
			current=current.left;
		}
		while(!stack.isEmpty()) {
			current=stack.pop();
			System.out.print(current.data+"\t");
			current=current.right;
			while(current!=null) {
				stack.push(current);
				current=current.left;
			}
		}
	}
}
