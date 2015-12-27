package DataStructures;

public class LinkedList<T>{
	
	private LinkedListNode<T> head = null;
	private LinkedListNode<T> tail = null;

	public LinkedList(){}

	public LinkedList(T data){
		appendToTail(data);	
	}

	public LinkedListNode getHead(){
		return this.head;
	}

	public void setHead(LinkedListNode node){
		this.head = node;
	}

	public LinkedListNode getTail(){
		return this.tail;
	}

	public void setTail(LinkedListNode node){
		this.tail = node;
	}

	public LinkedListNode appendToTail(T data){
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);

		if(head==null){
			setHead(newNode);
			setTail(newNode);
			return newNode;	
		}
		
		newNode.setPrev(this.tail);
		this.tail.setNext(newNode);
		setTail(newNode);

		return this.head;
	}
	
	public LinkedListNode appendToHead(T data){
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);

		if(head==null){
			setHead(newNode);
			setTail(newNode);
			return newNode;
		}

		newNode.setNext(this.head);
		this.head.setPrev(newNode);
		setHead(newNode);

		return this.head;
	}

	public LinkedListNode search(T data){
		LinkedListNode<T> runner = head;

		while(runner != null && runner.getData() != data){
			runner = runner.getNext();
		}

		return runner;
	}

	public LinkedListNode remove(T data){
		LinkedListNode<T> node = search(data);

		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());

		return node;
	}

}
