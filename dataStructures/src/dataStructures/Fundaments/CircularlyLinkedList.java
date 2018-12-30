package dataStructures.Fundaments;
/*
 * Circularly linked list, which is essentially a singularly linked list in which the next 
 * reference of the tail node is set to refer back to the head of the list (rather than null). 
 * 
 * supports all of the public behaviors of our 
 * SinglyLinkedList class and one additional update method:
 * 
 * rotate(): Moves the first element to the end of the list.
 * 
 * Maintaining only the tail reference not only saves a bit on memory usage, it makes the code simpler 
 * and more efficient, as it removes the need to perform additional operations to keep a 
 * head reference current.
 * 
 * We do not move any nodes or elements, we simply advance 
 * the tail reference to point to the node that follows it (the implicit head of the list).
 */



public class CircularlyLinkedList<E>{

	//(nested node class identical to that of the SinglyLinkedList class)
	
	private static class Node<E>{
		private E element;
		
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext(){
			return next;
		}
		 
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	private Node<E>tail = null;
	private int size = 0;
	
	public CircularlyLinkedList() { }
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	public E first() {
		if(isEmpty()) return null;
		return tail.getNext().getElement();
	}
	
	public E last() {
		if(isEmpty()) return null;
		return tail.getElement();
	}
	
	public void rotate() {
		if(tail != null) {
			tail = tail.getNext();
		}
	}
	
	public void addFirst(E e) {
		if(size ==0) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		}else{
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}
	
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst(E e) {
		if(isEmpty()) return null;
		Node<E> head = tail.getNext();
		if(head == tail) {
			tail = null;
		}else {
			tail.setNext(head.getNext());
			size--;
		}
		return head.getElement();
	}
	
}
