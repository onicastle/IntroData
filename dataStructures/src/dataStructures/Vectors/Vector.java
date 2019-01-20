package dataStructures.Vectors;


public interface Vector {

	public double magnitud();
	public int getDimensions();
	public double getCoordinate(int coordinateNumber);
	public Vector sum(Vector v2);
	public Vector substract(Vector v2);
	public double innerProduct(Vector v2);
	public Vector scalarProduct(double number);
	public String toString();
}
