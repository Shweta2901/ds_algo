package ds.linklist;

public class LinkedList {

	private Node head;
	
	LinkedList() {
		this.head=null;
	}
	
	public void insertAtEnd(int data) {
		//create new node
		Node newNode = new Node(data);
		//if head is null, make new node as head
		if(this.head == null) {
			head =newNode;
			return;
		}
		//else append new node to end of the list
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
		return;
	}
	
	public void insertInFront(int data) {
		//create new node
		Node newNode = new Node(data);
		//if head is null, make new node as head
		if(this.head == null) {
			head =newNode;
			return;
		}
		//else append new node to start of the list
		newNode.next=head;
		this.head=newNode;
		return;
	}
	
	public void deleteList() {
		this.head=null;
	}
	
	/*
	 * Given a linked list, write a function to reverse every k nodes 
	 * (where k is an input to the function).
	 * Time Complexity:O(n) Space Complexity: 0
	 * 
	 * Can be done using stack also push first k nodes to satck 
	 * and pop the nodes and change their next pointers (Time Complexity: O(n) Space Complexity: O(k)
	 * */
	public Node reverseKNodes(Node head,int k) {
		if(head == null)
			return head;
		Node current=head;
		Node pre=null;
		Node next=null;
		
		int count=0;
		//reverse k nodes
		while(count<k && current!=null) {
			next=current.next;
			current.next=pre;
			pre=current;
			current=next;
			count++;
		}
		head.next = reverseKNodes(next,k);
		
		return pre;
	}
	
	public void printLinkedList(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		return;
	}
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.printLinkedList(list.head);
		list.head=list.reverseKNodes(list.head, 3);
		System.out.println("\nAfter reverse");
		list.printLinkedList(list.head);
	}
}
