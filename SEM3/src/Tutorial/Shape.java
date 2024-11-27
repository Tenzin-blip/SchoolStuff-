package Tutorial;

public class Shape {
	String color;
	public void area() {
		
	}
	
	public Shape(String color) {
		this.color = color;
	}
}
class Rectangle extends Shape{
	int length;
	int width;


public Rectangle(String color,int length, int width){
	super(color);
	this.length = length;
	this.width = width;
	
}
}

