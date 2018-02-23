package behavioral_patterns;

import java.util.Iterator;

class Animal {
	private static int counter;
	private final int id = counter++;

	@Override
	public String toString() {
		return String.format("[animal: %s]", id);
	}
}

class Animals implements Iterable<Animal> {
	Animal[] animals = new Animal[5];
	{
		for (int i = 0; i < 5; i++) {
			animals[i] = new Animal();
		}
	}

	@Override
	public Iterator<Animal> iterator() {
		return new Iterator<Animal>() {
			private int index = -1;

			@Override
			public boolean hasNext() {
				return index < 4;
			}

			@Override
			public Animal next() {
				if (hasNext())
					return animals[++index];
				return null;
			}

		};
	}

}

public class IteratorPattern {
	public static void main(String[] args) {
		Animals animals = new Animals();
		for (Animal animal : animals) {
			System.out.println(animal);
		}
		System.out.println("========================");
		Iterator<Animal> iterator = animals.iterator();
		for (int i = 0; i < 6; i++) {

			System.out.println(iterator.next());
		}

	}
}