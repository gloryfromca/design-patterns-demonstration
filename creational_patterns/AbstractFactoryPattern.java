package creational_patterns;

interface Color {
	void fill();

}

class ColorWithfill implements Color {

	@Override
	public void fill() {
		System.out.println("fill with " + getClass().getName());
	}

}

class Red extends ColorWithfill {

}

class Blue extends ColorWithfill {

}

class Green extends ColorWithfill {

}

abstract class AbstractFactory {
	abstract Color getColor(Class<? extends Color> colorType);

	abstract Shape getShape(Class<? extends Shape> shapeType);

}

class ShapeFactoryA extends AbstractFactory {

	@Override
	Color getColor(Class<? extends Color> colorType) {
		return null;
	}

	@Override
	Shape getShape(Class<? extends Shape> shapeType) {
		try {
			return shapeType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("CRITICAL ERROR");
	}

}

class ColorFactory extends AbstractFactory {

	@Override
	Color getColor(Class<? extends Color> colorType) {
		try {
			return colorType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("CRITICAL ERROR");
	}

	@Override
	Shape getShape(Class<? extends Shape> shapeType) {
		return null;
	}
}

class FactoryProducter {
	AbstractFactory getFactory(Class<? extends AbstractFactory> factoryType) {
		try {
			return factoryType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("CRITICAL ERROR");

	}
}

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		FactoryProducter fp = new FactoryProducter();
		AbstractFactory colorfactory = fp.getFactory(ColorFactory.class);
		Color red = colorfactory.getColor(Red.class);
		red.fill();
		AbstractFactory shapefactory = fp.getFactory(ShapeFactoryA.class);
		Shape square = shapefactory.getShape(Square.class);
		square.draw();

	}

}
