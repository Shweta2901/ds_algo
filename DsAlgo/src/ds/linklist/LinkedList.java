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
	
	
}
