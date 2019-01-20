package dataStructures.Recursion;

public class binarySearch {
/*
 * This search algorithm is mostly used to 
 * search for a given number of elements in an array
 * 
 * If an array is unsorted, we would probably use a for loop
 * to search withing the array till finding the data we want
 * 
 * That algortithm is called the lineal search algorithm . sequencial search
 * However when sorted is betther to used the most efficient algorithm
 * 
 * This algorithm hs 2 parameters, those being the high and the low
 * low being 0
 * high being n -1
 * 
 * Then we create a median candidate, we call it mid
 * 
 * mid = (low + high)/2
 * 
 * if low > high it wont work since it's empty
 * 
 * when the mid == target we found what we where looking for and stop
 * 
 * if the target < mid  we recur on the first half of the sequence, that is if the interval 
 * indices form low to mid - 1 
 * 
 * if the target > mid then we go to the second half of the sequence where mid+1 to high
 * 
 * the binary search runs in O(log(n)) time rather that O(n) (linear search)
 */
	
	public static boolean binarySearch(int[] data, int target, int low, int high) {
		if(low > high)
			return false;
		else {
			int mid =  (low + high)/2;
			if(target == data[mid]) {
				return true;
			}
			else if(target<data[mid]){
				return binarySearch(data, target, low, mid -1);
			}
			else {
				return binarySearch(data, target, mid+1, high);
			}
		}
	}
}
