package dataStructures.Vectors;


public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double wow[] = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0};
		
		double lol[] = {3.0,5.0,6.0,8.0,9.0,9.0,1.0,2.0,3.0,11.0};
		vectorND wigless = new vectorND(wow);
		
		Vector wig = new vectorND(lol);
		
		System.out.println(wigless.getCoordinate(0));
		System.out.println(wigless.sum(wig).toString());
		System.out.println(wigless.substract(wig).toString());
		System.out.println(wigless.scalarProduct(9));
		System.out.println(wigless.innerProduct(wig));
		System.out.println(wigless.toString());
		
		System.out.println(wig.toString());
	}

}
