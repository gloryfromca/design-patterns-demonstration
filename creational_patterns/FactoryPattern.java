package creational_patterns;

interface Shape {
	void draw();
}

class ShapeWithdraw implements Shape {

	@Override
	public void draw() {
		System.out.println("draw a " + getClass().getName());
	}

}

class Rectangle extends ShapeWithdraw {
}

class Circle extends ShapeWithdraw {

}

class Square extends ShapeWithdraw {

}

class ShapeFactory {
	public Shape newShape(Class<? extends Shape> classType) {
		try {
			return classType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("CRITICAL ERROR");

	}
}

public class FactoryPattern {

	public static void main(String[] args) {
		ShapeFactory sf = new ShapeFactory();
		Shape rectangle = sf.newShape(Rectangle.class);
		rectangle.draw();
		Shape circle = sf.newShape(Circle.class);
		circle.draw();
		Shape square = sf.newShape(Square.class);
		square.draw();

	}

}
