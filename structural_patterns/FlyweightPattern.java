package structural_patterns;

import java.util.HashMap;

interface Cloth {
	public String color();
}

class ColorCloth implements Cloth {
	String color;

	public ColorCloth(String c) {
		color = c;
	}

	@Override
	public String color() {
		return color;
	}

}

class ClothFactory {
	HashMap<String, Cloth> cloths = new HashMap<String, Cloth>();

	public Cloth getCloth(String color) {
		Cloth result = cloths.get(color);
		if (result == null) {
			synchronized (this) {
				if (result == null) {
					System.out.println("cloth of " + color + " is null!");
					result = new ColorCloth(color);
					cloths.put(color, result);
				}
			}
		}
		return result;
	}
}

public class FlyweightPattern {

	public static void main(String[] args) {
		ClothFactory cf = new ClothFactory();
		cf.getCloth("black");
		cf.getCloth("black");
	
	}

}
