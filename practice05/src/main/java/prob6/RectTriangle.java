package prob6;

public class RectTriangle extends Shape {

	private double width;
	private double heght;
	
	public RectTriangle(double w,double h) {
		this.width=w;
		this.heght=h;
	}

	@Override
	public double getArea() {
		double result = width*heght*0.5 ;
		return result;
	}

	@Override
	public double getPerimeter() {
		double result = width+heght+(Math.sqrt(Math.pow(width, 2)+Math.pow(heght, 2))) ;
		return result;
	}

}
