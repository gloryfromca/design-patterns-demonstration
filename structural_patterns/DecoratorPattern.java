package structural_patterns;

interface Worker {
	public String name();

	public void work();
}

class Teacher implements Worker {
	private String name;

	public Teacher(String n) {
		name = n;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public void work() {
		System.out.println("teaching!");
	}

}

class EnglishTeacher implements Worker {

	private Worker decorated;

	public EnglishTeacher(Worker w) {
		decorated = w;
	}

	@Override
	public String name() {
		return decorated.name();
	}

	@Override
	public void work() {
		decorated.work();
		System.out.println("English!");
	}

}

public class DecoratorPattern {

	public static void main(String[] args) {
		Worker teacher = new Teacher("Laura");
		Worker englishteacher = new EnglishTeacher(teacher);
		englishteacher.work();

	}

}
