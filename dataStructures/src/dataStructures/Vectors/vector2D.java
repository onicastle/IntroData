package dataStructures.Vectors;


public class vector2D implements Vector{
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


}
