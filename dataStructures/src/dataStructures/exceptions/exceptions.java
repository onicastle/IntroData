package dataStructures.exceptions;

public class exceptions {
	static int DEFAULT =1;
	
	public void ensurePositive(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("Not positive."); //Creating an exception to be thrown as a  result of the method
		}
	}
	
	public static void main (String[] args) {
		int n = DEFAULT;
		
		
		
		try {
			n = Integer.parseInt(args[0]);
			if(n <= 0) {
				System.out.println("n must be positive. Using default.");
				n = DEFAULT;
			}
		} catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
			System.out.println("Using default value for n.");
		}
		
	}
}
