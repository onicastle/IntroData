package dataStructures.CastingAndGenerics;

public class casting {
	
	//Defining the interface Person gives us access to these methods shared bu any class that implements this.	
	
	public interface Person{
		public boolean equals(Person other);
		public String getName();
		public int getAge();
	}
	
	public class Student implements Person{
		String id;
		String name;
		int age;
		
		//Constructor
		public Student(String i, String n, int a) {
			id = i;
			name = n;
			age = a;
		}
		
		protected int studyHours() {
			return age/2;
		}
		
		public String getID() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public int getAge() {
			return age;
		}
		
	
		
		public String toString() {
			return"Student(ID:"+ id + ",Name:" + name + ",Age" + age + ")";
		}

		@Override
		public boolean equals(Person other) {
			if(!(other instanceof Student)) {
			return false;
			}
			Student s = (Student) other; //Casting
			
			return id.equals(s.id);
		}
		
	}
	
	//Generic is the ability that classes and methods have so can operate on a variety of data types while often avoiding the need for explicit casts.
	//To create Generic classes and method we use Object
	public class ObjectPair{
		Object first;
		Object second;
		
		public ObjectPair(Object a, Object b) {
			first = a;
			second = b;
		}
		
		public Object getFirst() {
			return first;
		}
		
		public Object getSecond() {
			return second;
		}
		
		/*This represents a narrowing conversion from the declared return type of Object to
		the variable of type String. Instead, an explicit cast is required, as follows:*/
		
		//String stock = (String) bid.getFirst(); this is narrowing casting from Object to String
	}
	
	//There is also a Java Genetics Framework we can implement
	
	public class Pair<A,B>{
		//Angle brackets are used at line 1 to enclose the sequence of formal type parameters.
		A first;
		B second;
		//For example, we declare instance variable, first, to have type A; we similarly use A as the declared type for the first constructor parameter and for the return type of method, getFirst
		public Pair(A a, B b) {
			first = a;
			second = b;
		}
		
		//we must explicitly specify actual type parameters that will take the place of the generic formal type parameters. 
		//For example
				
		//We can subsequently instantiate the generic class using the following syntax:
		Pair<String, Double> bid = new Pair<String,  Double>("ORCL",32.07);
		//bid = new Pair<>("ORCL", 32.07);
		
		//generic arrays
		
		//Pair<String, Double>[] holdings = new Pair[25]; //correct but problematic
		
		//holding[0] = newPair<>("ORCL", 32.07); //valid element assigment
		
		public A getFirst() {
			return first;
		}
		
		public B getSecond() {
			return second;
		}
		
	}
	
	//Let's create a generic porfolio
	
	public class Porfolio<T>{
		T[] data;
		
		public Porfolio(int capacity) {
			data = (T[]) new Object[capacity]; // legal but problematic
		}
		
		public T get(int index) {
			return data[index];
		}
	}
	
	//Generic Method
	
	public class GenericDemo {
		public <T> void reverse(T[] data) {
		int low = 0;
		int high = data.length -1;
		
		while(low < high) { //swap data
			T temp = data[low]; 
			data[low++] = data[high]; //increment
			data[high--] = temp; //decrement
			}
		}
	}
}

