package dataStructures.Fundaments;
/*
 * A linked list, in its simplest form, is a collection of nodes that collectively form a linear sequence.
 * 
 * In a singly linked list, each node stores a reference to an object that is an element of the 
 * sequence, as well as a reference to the next node of the list
 * 
 * First node of the list, known as the head.
 * The last node of the list is known as the tail.
 * 
 * We can identify the tail as the node having null as its next reference.
 * 
 * it is common for a linked list instance to keep a count of the total number of nodes that comprise the list 
 * (also known as the size of the list), to avoid traversing the list to count the nodes.
 */



//When using a singly linked list, we can easily insert an element at the head of the list
/*Algorithm	 
			addFirst(e):
					newest = Node(e);
					newest.next = head;
					head = newest;
					size = size +1;*/


//We can also easily insert an element at the tail of the list,
//provided we keep a reference to the tail node

/*In this case, we create a new node, assign its next reference to null, 
	set the next reference of the tail to point to this new node, 
	and then update the tail reference itself to this new node.*/


/*Algorithm 
 * addLast(e):
			newest=Node(e) {createnewnodeinstancestoringreferencetoelemente}
			newest.next = null {set new node’s next to reference the null object}
			tail.next = newest {make old tail node point to new node}
			tail = newest {set variable tail to reference the new node}
			size = size + 1  {increment the node count}*/

/*Removing an element from the head of a singly linked list is essentially 
 * the reverse operation of inserting a new element at the head. 
 * This operation is illustrated in
 * 
 * Algorithm removeFirst():
 *	if (head == null) then the list is empty.
 *  head = head.next {make head point to next node (or null)} 
 *	size = size − 1
 */

//Methods

/*
 * size(): Returns the number of elements in the list. 
 * isEmpty(): Returns true if the list is empty, and false otherwise.
 * first(): Returns(butdoesnotremove)thefirstelementinthelist. 
 * last(): Returns (but does not remove) the last element in the list.
 * addFirst(e): Adds a new element to the front of the list. 
 * addLast(e): Adds a new element to the end of the list.
 * removeFirst(): Removes and returns the first element of the list.
 */

//If first, last or removeFirst are called and the list is empty it will return null.

/*The elements stored don't matter since we use the generic Framework
 *Our implementation also takes advantage of Java’s support for nested classes
 *
 *We define a private Node class within the scope of the pub- lic SinglyLinkedList class
 *
 *Having Node as a nested class provides strong encapsulation, 
 *shielding users of our class from the 
 *underlying details about nodes and links. 
 *This design also allows Java to differentiate this node 
 *type from forms of nodes we may define for use in other structures.
 */

public class SinglyLinkedList<E> implements Cloneable{

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

	private Node<E> head = null;

	private Node<E> tail = null;

	private int size = 0;

	public SinglyLinkedList() { }

	public int size() { 
		return size; 
	}

	public boolean isEmpty() { 
		return size == 0; 
	}

	public E first() {
		if(isEmpty()) {
			return null;
		}
		return head.getElement();
	}

	public E last() {
		if(isEmpty()) {
			return null;
		}
		return tail.getElement();
	}

	//Updated Methods

	public void addFirst(E e) {
		head = new Node<>(e,head);
		if(size ==0) {
			tail = head;
			size++;
		}
	}

	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if(isEmpty()) {
			head = newest;
		}
		else{
			tail.setNext(newest);
			tail = newest;
			size ++;
		}
	}

	public E removeFirst() {
		if (isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;

		if(size == 0) tail = null;
		return answer;
	}

	//Equivalence Testing With Linked List Method in-depth view in equivalenceTesting

	public boolean equals(Object o) {
		if(o != null) {


			if(getClass() != o.getClass()) return false;
			SinglyLinkedList other = (SinglyLinkedList) o;
			if(size != other.size()) {
				Node walkA = head;
				Node walkB = other.head;

				while(walkA != null) {
					if(!walkA.getElement().equals(walkB.getElement())) return false;
					walkA = walkA.getNext();
					walkB = walkB.getNext();
				}
				return true;
			}
		}
		return false;
	}
	/*To clone Singly Linked List we have to declare it clonable by implementing 
	 * the Cloneable interface.
	 * 
	 * By convention the method should beging with creating a new instance usinf the super.clone()
	 * which in this case envolves the Object class.
	 * 
	 * The clonable returns a Object so we well need to type cast to an SinglyLinkedList<E>
	 * At this point the other list has been created as a shallow copy.
	 * 
	 * since our link class has 2 fields those being the size and the head. we have to:
	 * other.size = this.size
	 * other.head = this head
	 * 
	 * The assigment of the size might be correct but the new list's head cannot have the same value as 
	 * the other unless it's null
	 * 
	 * For nonempty list we have an independent state, it must have an entirely new chain of nodes, each one storinf
	 * a reference to the corresponding element of the list for that reason we creata new head node in the X marked line
	 * and then perform a walk through the remainder of the list
	 * 
	 */
	
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException{
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); //This is a safe casting
		if(size > 0) {
			other.head = new Node<>(head.getElement(), null); //X
			Node<E> walk = head.getNext(); // Walk through remainfer of the original list
			Node<E> otherTail = other.head; //This remembers the most recently created node
			
			while(walk != null) {
				Node<E> newest = new Node<>(walk.getElement(), null);
				otherTail.setNext(newest);
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}
	
}


