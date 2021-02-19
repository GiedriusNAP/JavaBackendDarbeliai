
public class Shape {
	private String color;
	private boolean filled;

	public Shape() {
		this.color = "red";
		this.filled = true;
	}

	public Shape(String arg1, boolean arg2) {
		this.color = arg1;
		this.filled = arg2;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String arg1) {
		this.color = arg1;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean arg1) {
		this.filled = arg1;
	}
	public double getArea(){
		return 0;
	}
	public double getPerimeter() {
		return 0;
	}

	@Override
	public String toString() {
		return "Shape color=" + this.color + ", filled=" + this.filled;
	}
}
