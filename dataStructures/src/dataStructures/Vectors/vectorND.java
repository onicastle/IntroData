package dataStructures.Vectors;

import java.util.StringTokenizer;

public class vectorND implements Vector, VectorFactory{

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
	@Override
	public Vector newInstance(double[] coordinates) {
		if((coordinates == null) || (coordinates.length < 2)) {
			throw new IllegalArgumentException("Only vectors with atleast 2 coordinates are supported");
		}
		return new vectorND(coordinates);
	}
	@Override
	public Vector newInstace(String coordinates) {

		if(coordinates == null) {
			throw new IllegalArgumentException("so... this is null and it can't be one");
		}
		String token = null;
		StringTokenizer strTok = new StringTokenizer(coordinates, ",");
		int count = strTok.countTokens();
		if(count < 2) {
			throw new IllegalArgumentException("Not enought coordinates");
		}
		double temp[] = new double[count];

		int i = 0;

		while(strTok.hasMoreTokens()) {
			token = strTok.nextToken();
			temp[i++] = Double.parseDouble(token);
		}

		return vectorND(temp);
	}
	private Vector vectorND(double[] elements) {
		if((elements == null) || elements.length < 2) {
			throw new IllegalArgumentException("Array doesn't have enough values");
		}
		this.elements = elements.clone();

		return null;
	}
}
