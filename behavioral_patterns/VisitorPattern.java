package behavioral_patterns;

interface ComputerPartVisitor {
	public void visit(Computer computer);

	public void visit(Mouse mouse);

	public void visit(Keyboard keyboard);

	public void visit(Monitor monitor);
}

interface ComputerPart {
	public void accept(ComputerPartVisitor computerPartVisitor);

}

class Keyboard implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}

}

class Mouse implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}

}

class Monitor implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}

}

class Computer implements ComputerPart {

	ComputerPart[] parts;
	{
		parts = new ComputerPart[] { new Monitor(), new Mouse(), new Keyboard() };
	}

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {

		for (ComputerPart part : parts) {
			part.accept(computerPartVisitor);
		}
		computerPartVisitor.visit(this);
	}

}

class ComputerPartDisplayVisitor implements ComputerPartVisitor {

	@Override
	public void visit(Computer computer) {
		System.out.println("display computer!");
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println("display mouse!");
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("display keyboard!");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("display monitor!");
	}

}

public class VisitorPattern {

	public static void main(String[] args) {

		ComputerPart computer = new Computer();
		ComputerPartVisitor visitor = new ComputerPartDisplayVisitor();
		computer.accept(visitor);
	}

}
