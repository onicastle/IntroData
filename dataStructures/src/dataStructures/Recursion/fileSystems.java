package dataStructures.Recursion;

import java.io.File;

public class fileSystems {

	/*To implement a recursive algorithm for computing disk usage in Java, 
	 *we rely on the java.io.File class. An instance of this class represents an
	 *abstract pathname in the operating system and allows for properties of that 
	 *operating system entry to be queried. We will rely on the following methods
	 *of the class:
	 */
	
	//new File(pathString) or new File(parentFile, childString)
	
	/*A new File instance can be constructed either by providing the full path as a string,
	 *or by providing an existing File instance that represents a directory and a string that 
	 *designates the name of a child entry within that directory.
	 */
	
	//file.length()
	
	/*Return the immediate disk usage in bytes
	 */
	
	//file.isDirectory()
	
	/*returns true id the file is an instance of the directory
	 */
	
	//file.list
	
	/*Returns an array of strings designating the names of all entries within 
	 *the given directory. In our sample file system, if we call this method 
	 *on the File associated with path /user/rt/courses/cs016,
	 *it returns an array with contents: {"grades","homeworks","programs"}.
	 */
	
	public static long diskUsage(File root) {
		long total = root.length();
		if(root.isDirectory()) {
			for(String childname : root.list()) {
				File child = new File(root,childname);	//Makes path to child
				total += diskUsage(child);
			}
		}
		System.out.println(total + "\t" + root);
		return total;
	}
}
