package structural_patterns;

interface DrawAPI {
	public void drawCircle(int radius, int x, int y);

	public void drawSquare(int length, int left_buttom_x, int left_buttom_y);
}

abstract class Shape {
	protected DrawAPI drawAPI;

	public Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}

	public abstract void draw();

}

class DrawAPIImp1 implements DrawAPI {

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out
				.println("[" + getClass().getName() + ":drawCircle, radius:" + radius + ", x:" + x + ", y:" + y + "]");
	}

	@Override
	public void drawSquare(int length, int left_buttom_x, int left_buttom_y) {
		System.out.println("I can't draw a square");
	}

}

class DrawAPIImp2 implements DrawAPI {

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("I can't draw a circle");
	}

	@Override
	public void drawSquare(int length, int left_buttom_x, int left_buttom_y) {

		System.out.println("[" + getClass().getName() + ":drawCircle, length:" + length + ", left_buttom_x:"
				+ left_buttom_x + ", left_buttom_y:" + left_buttom_y + "]");

	}

}

class Circle extends Shape {
	private int radius, x, y;

	public Circle(DrawAPI drawAPI, int radius, int x, int y) {
		super(drawAPI);
		this.radius = radius;
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw() {
		drawAPI.drawCircle(radius, x, y);
	}

}

class Square extends Shape {
	private int length, left_buttom_x, left_buttom_y;

	public Square(DrawAPI drawAPI, int length, int left_buttom_x, int left_buttom_y) {
		super(drawAPI);
		this.left_buttom_x = left_buttom_x;
		this.left_buttom_y = left_buttom_y;
		this.length = length;
	}

	@Override
	public void draw() {
		drawAPI.drawSquare(length, left_buttom_x, left_buttom_y);
	}

}

public class BridgePattern {

	public static void main(String[] args) {
		new Square(new DrawAPIImp1(), 10, 1, 1).draw();
		new Square(new DrawAPIImp2(), 10, 1, 1).draw();
		new Circle(new DrawAPIImp1(), 5, 3, 4).draw();
		new Circle(new DrawAPIImp2(), 5, 3, 4).draw();

	}

}
