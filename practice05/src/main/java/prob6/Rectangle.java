package prob6;

public class Rectangle extends Shape implements Resizable{
	
	private double width;
	private double heght;
	
	public Rectangle(double w,double h) {
		this.width=w;
		this.heght=h;
	}

	@Override
	public double getArea() {
		double result = width*heght ;
		return result;
	}

	@Override
	public double getPerimeter() {
		double result = (width+heght)*2 ;
		return result;
	}
	
	@Override
	public void resize(double s) {
		this.width=width*s;
		this.heght=heght*s;
	}

}
