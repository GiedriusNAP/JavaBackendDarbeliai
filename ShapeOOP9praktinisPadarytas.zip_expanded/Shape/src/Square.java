
public class Square extends Rectangle {
//	private double side;

	public Square() {
		super();
	}

	public Square(double side) {
		super(side,side);
	}

	public Square(double side, String color, boolean filled) {
		super(side,side,color,filled);		
	}

	public double getSide() {
		return super.getWidth();
	}

	public void setSide(double side) {
		super.setWidth(side);
		super.setLength(side);
	}

	@Override
	public void setWidth(double width) {
		this.setSide(width);;
	}

	@Override
	public void setLength(double length) {
		this.setSide(length);;
	}

	@Override
	public String toString() {
		return "Square [side=" + this.getSide() + " " + super.toString() + "]";
	}
}
