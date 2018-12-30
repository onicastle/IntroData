package dataStructures.Fundaments;



/*To support a broader notion of equivalence, 
 * all object types support a method named equals.
 * 
 * Users of reference types should rely on the syntax a.equals(b), unless they have a specific need 
 * to test the more narrow notion of identity. The equals method is formally defined in the Object class, 
 * which serves as a superclass for all reference types,
 *  but that implementation reverts to returning the value of expression a == b.
 *  
 *  Java’s libraries depends upon the equals method defining what is 
 *  known as an equivalence relation in mathematics,
 *   satisfying the following properties:
 *   
 *   Treatment of Null
 *   Reflexivity
 *   Symmetry
 *   Transivity
 *   
 *  - Where ToN works for any nun null reference 
 *   variable that the call x.equals(null) should return null
 *   
 *   *Since null is only equal to null
 *   
 *  - Reflexivity is when a nonnull variable such as x.equals(x) should return true if the 
 *   object equals itself
 *   
 *  - Symmetry is like reflexity instead we use x.equals(y) where is only true
 *  
 *  - Transivity works for For any nonnull reference variables x, y, and z, if both calls
 *  x.equals(y) and y.equals(z) return true, then call x.equals(z) must return true as well.
 *   
 */

/*
 * Equivalences in arrays work like this:
 * 
 * a==b is a test where the a and b are underlying array instances
 * 
 * a.equals(b) is identical to a==b 
 * Arrays are not a true class type and do not override the Object.equals method
 * 
 * Arrays.equals(a,b) this is more intutive since it returns true if the arrays are the same size
 * all the apirs of correspong elements are equal to each other.  If elements of the arrays are a reference type, 
 * then it makes pairwise comparisons a[k].equals(b[k]) in evaluating the equivalence
 */

//Compound Objects
/*
 * compound objects, which are objects—like a two-dimensional array—that are made up of other objects.
 * 
 * Thus, if we have a two-dimensional array, a, and another two-dimensional array, b, that has the same entries 
 * as a, we probably want to think that a is equal to b. 
 * 
 * But the one-dimensional arrays that make up the rows of a and b (such as a[0] and b[0]) are stored in different memory locations, 
 * even though they have the same internal content. Therefore, a call to the method java.util.Arrays.equals(a,b) will return false in this case, 
 * because it tests a[k].equals(b[k]), which invokes the Object class’s definition of equals.
 * 
 * To support the more natural notion of multidimensional 
 * arrays being equal if they have equal contents,
 *  the class provides an additional method:
 */


//Arrays.deepEquals(a,b);

/*
 * Identical to Arrays.equals(a,b) except when the elements of a and b are themselves arrays, 
 * in which case it calls Arrays.deepEquals(a[k],b[k]) for corresponding entries,
 * rather than a[k].equals(b[k]).
 */

/*Equivalence on LinkedList
 * 
 */
public class equivalenceTesting{


	public class SinglyLinkedList<E>{
		//I got rid of the Static in the private class node
		private class Node<E>{
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
		//Equivalence Testing With Linked List Method

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

	}

}
