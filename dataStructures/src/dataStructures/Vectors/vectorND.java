package dataStructures.Vectors;

public class vectorND implements Vector{

	private double[] elements;
	
	public vectorND (double elements[]){
		if((elements == null) || elements.length < 2) {
			throw new IllegalArgumentException("Array doesn't have enough values");
		}
		this.elements = elements.clone();

	}
	@Override
	public double magnitud() {

		return Math.sqrt(this.innerProduct(this));
	}
	
	@Override
	public int getDimensions() {
		// TODO Auto-generated method stub
		return this.elements.length;
	}
	
	@Override
	public double getCoordinate(int coordinateNumber) {
		if((coordinateNumber < 0) || (coordinateNumber >= this.getDimensions())) {
			throw new IllegalArgumentException("Invalid Argument");
		}
		else{
			return this.elements[coordinateNumber];
		}
	}
	
	@Override
	public Vector sum(Vector v2) {
		double[] temp = new double[v2.getDimensions()];
	 	if(this.getDimensions() == v2.getDimensions()) {
		
			for (int i = 0; i < this.getDimensions(); i++) {
				temp[i] = this.getCoordinate(i) + v2.getCoordinate(i);
			}
			return new vectorND(temp);
		}
		throw new IllegalArgumentException("Array doesn't have enough values");
	}
	
	@Override
	public Vector substract(Vector v2) {
		double[] temp = new double[v2.getDimensions()];
		if(this.getDimensions() == v2.getDimensions()) {
			for (int i = 0; i < elements.length; i++) {
				temp[i] = this.getCoordinate(i) + -v2.getCoordinate(i);
			}
			return new vectorND(temp);
		}
		throw new IllegalArgumentException("Array doesn't have enough values");
	}
	
	@Override
	public double innerProduct(Vector v2) {
		double temp = 0.0;
		
		if(this.getDimensions() == v2.getDimensions()) {
			for (int i = 0; i < elements.length; i++) {
				temp += this.getCoordinate(i) * v2.getCoordinate(i);
			}
			return temp;
		}
		throw new IllegalArgumentException("Array doesn't have enough values");
	}
	
	@Override
	public Vector scalarProduct(double number) {
		double temp[] = new double[this.getDimensions()];
		for (int i = 0; i < this.getDimensions(); i++) {
			temp[i] = number*this.getCoordinate(i);
		}
		return new vectorND(temp);
	}

	@Override
	public String toString() {
		String result = "(";
		for (int i = 0; i < this.getDimensions()-1; i++) {
			result += this.getCoordinate(i) + ", ";
		}
		result += this.getCoordinate(this.getDimensions()-1) +")";
		return result;
	}
}
