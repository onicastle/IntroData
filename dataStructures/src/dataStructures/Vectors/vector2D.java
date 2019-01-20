package dataStructures.Vectors;

import java.util.StringTokenizer;

public class vector2D implements Vector, VectorFactory{
	double x ,y;
	public vector2D(double x, double y) {
		this.x = x;
		this.y = y;	
	}

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double magnitud() {

		return Math.sqrt(this.x*this.x + this.y*this.y);
	}

	public int getDimensions() {

		return 2;
	}
	@Override
	public double getCoordinate(int coordinateNumber) {

		return 0;
	}
	@Override
	public Vector sum(Vector v2) {
		if(v2.getDimensions() == 2) {
			return new vector2D(this.x + v2.getCoordinate(0), this.y +this.getCoordinate(1));
		}
		else {
			throw new IllegalArgumentException("this aint it");
		}
	}


	@Override
	public Vector substract(Vector v2) {
		if(v2.getDimensions() == 2) {
			 return new vector2D(this.x + -v2.getCoordinate(0), this.y + -this.getCoordinate(1));
		}
		else {
			throw new IllegalArgumentException("this aint it");
		}
	}
	@Override
	public double innerProduct(Vector v2) {
		if(v2.getDimensions() == 2) {
			return this.getCoordinate(0) * v2.getCoordinate(0) + this.getCoordinate(1) * v2.getCoordinate(1);
		}
		else{
			throw new IllegalArgumentException("This ain't it.");
		}

	}
	@Override
	public Vector scalarProduct(double number) {

		return new vector2D(this.x * number, this.y * number);
	}
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	@Override
	public Vector newInstance(double[] coordinates) {
		if(coordinates == null || coordinates.length != 2){
			throw new IllegalArgumentException("this aint it");
		}
		return new vector2D(coordinates[0], coordinates[1]);
	}

	@Override
	public Vector newInstace(String coordinates) {
		if(coordinates == null) {
			throw new IllegalArgumentException("so... this is null and it can't be one");
		}
		double x = 0.0, y =0.0;
		String token = null;
	
		StringTokenizer strTok = new StringTokenizer(coordinates,",");
		
		//To get X
		if(!strTok.hasMoreTokens()) {
			throw new IllegalArgumentException("not enough tokens");
		}
		else {
			token = strTok.nextToken();
			x = Double.parseDouble(token);
		}
		
		if(!strTok.hasMoreTokens()) {
			throw new IllegalArgumentException("not enough tokens");
		}
		else {
			token = strTok.nextToken();
			y = Double.parseDouble(token);
		}
		
		return new vector2D(x,y);
	}


}
