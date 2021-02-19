import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Shape> figuros = new ArrayList<Shape>();

		figuros.add(new Circle());
		figuros.add(new Rectangle());
		figuros.add(new Square());
		figuros.add(new Circle(7, "zalias", true));
		figuros.add(new Rectangle(10, 10, "melyna", false));
		figuros.add(new Square(7, "melsvas", true));
		double plotas = 0;
		for (int i = 0; i < figuros.size(); i++) {
			System.out.println(figuros.get(i));
		}
		for (Shape shape : figuros) {
			System.out.println("Plotas: " + shape.getArea());  //kitose klasese owerridinam shape klases getArea ir taip gaunam duomenis is objekto
			//System.out.println("Perimetras: " + shape.getPerimeter());
			plotas = plotas + shape.getArea();
		}
	System.out.println("Visu figuru bendras plotas: " + plotas);
	}

}
