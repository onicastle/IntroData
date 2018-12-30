package dataStructures.Fundaments;

public class cloningArrays {

	//ARRAYS
	
	//Let's define an array
	
	int[] data = {2, 3, 5 , 7, 11, 13 , 17, 19};
	//backup = data; //warning not a copy
	int[] backup = data.clone();
	
	
	
	/*
	 * The clone() method produces a shallow copy of the array, 
	 * producing a new array whose cells refer to the same objects referenced by the first array.
	 * This makes a shallow copy, which is basically a copy of the content of the copied array
	 * 
	 * If you want a deep copy that can be done iteratively, 
	 * which can only be done is the class is declared clonable
	 */
	
	

}
