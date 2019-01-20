package dataStructures.Recursion;

public class linealRecursion {

	public static int linealSum(int[] data, int n) {
		if(n == 0) {
			return 0;
		}
		else {
			return linealSum(data, n-1) + data[n-1];
		}
	}
	
	//O(n)
	public static void reverseArray(int[] data, int low, int high) {
		if(low < high) {
			int temp = data[low];
			data[low] = data[high];
			data[high] = temp;
			reverseArray(data, low + 1, high -1);
		}
	}
	
	public static double power(double x, int n) {
		if(n == 0)
			return 1;
		else
			return n* power(x, n-1);
	}
	
}
