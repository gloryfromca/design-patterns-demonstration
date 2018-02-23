package structural_patterns;

class Wex {
	public void wexing() {
		System.out.println("Wexing!");
	};
}

class Clean {
	public void cleaning() {
		System.out.println("Cleaning!");
	};
}

class Polish {
	public void polishing() {
		System.out.println("Polishing!");
	};
}

class Car {

}

class Maintenance {
	private Clean clean = new Clean();
	private Polish polish = new Polish();
	private Wex wex = new Wex();

	public Maintenance(Car car) {
		clean.cleaning();
		wex.wexing();
		polish.polishing();
	}
}

public class FacadePattern {

	public static void main(String[] args) {
		Car car = new Car();
		new Maintenance(car);
	}

}
