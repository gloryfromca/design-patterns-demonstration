package structural_patterns;

interface Image {
	public void display();
}

class RealImage implements Image {

	public RealImage() {
		loadFromDisk();
	}

	@Override
	public void display() {
		System.out.println("display!");
	}

	public void loadFromDisk() {
		System.out.println("loading from disk!");
	}

}

class ProxyImage implements Image {

	RealImage ri;

	public ProxyImage() {

	}

	@Override
	public void display() {
		if (ri == null) {
			ri = new RealImage();
		}
		ri.display();
	}

}

public class ProxyPattern {

	public static void main(String[] args) {

		RealImage ri = new RealImage();
		ProxyImage pi = new ProxyImage();
		System.out.println("============");
		ri.display();
		pi.display();

	}

}
