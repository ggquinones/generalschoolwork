package quingg01_lab09;
/*
 * <Gabriel Quiñones-Sanchez>
 * CS160-01 Fall 2014
 * Lab 9
 */
// Class which constructs a Rectangle object
public class Rectangle {
	
	private double length;
	private double width;
	// Accessor method that returns the length of the rectangle
	public double getLength(){
		return length;
	}
	// Accessor method that returns the width of the rectangle
	public double getWidth(){
		return width;
	}
	//Mutator method which sets the length of the rectangle
	public void setLength(double len){
		length = len;
	}	
	//Mutator method which sets the width of the rectangle
	public void setWidth(double w){
		width = w;
	}
	// Class constructor that takes two doubles,length and width respectively, as parameters
	public Rectangle(double l, double w){
		length = l;
		width = w;
	}
	// Class constructor which takes another rectangle object as a parameter
	public Rectangle(Rectangle other){
		length = other.length;
		width = other.width;
	}
}

