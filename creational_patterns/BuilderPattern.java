package creational_patterns;

import java.util.ArrayList;
import java.util.List;

interface Packing {
	public String pack();
}

interface Item {
	public float price();

	public String name();

	public Packing packing();

	public String toString();

}

class Wrapper implements Packing {

	@Override
	public String pack() {
		return "wrapper";
	}

}

class Bottle implements Packing {

	@Override
	public String pack() {
		return "bottle";
	}

}

abstract class Burger implements Item {

	@Override
	public abstract float price();

	@Override
	public abstract String name();

	Packing pack = new Wrapper();

	@Override
	public Packing packing() {
		return pack;
	}

	@Override
	public String toString() {
		return "[name: " + name() + ", price: " + price() + ", packing: " + packing().pack() + "]";
	}
}

abstract class Drink implements Item {

	@Override
	public abstract float price();

	@Override
	public abstract String name();

	Packing pack = new Bottle();

	@Override
	public Packing packing() {
		return pack;
	}

	@Override
	public String toString() {
		return "[name: " + name() + ", price: " + price() + ", packing: " + packing().pack() + "]";
	}

}

class VegBurger extends Burger {

	@Override
	public float price() {
		return 10.0f;
	}

	@Override
	public String name() {
		return "veg burger";
	}

}

class ChickenBurger extends Burger {

	@Override
	public float price() {
		return 20.0f;
	}

	@Override
	public String name() {
		return "chicken burger";
	}

}

class Coca extends Drink {

	@Override
	public float price() {
		return 4f;
	}

	@Override
	public String name() {
		return "Coca Cola";
	}

}

class Water extends Drink {

	@Override
	public float price() {
		return 3f;
	}

	@Override
	public String name() {
		return "Pure Water";
	}

}

class Meal {
	private List<Item> items = new ArrayList<Item>();
	private float cost = 0f;

	public void addItem(Item i) {
		items.add(i);
		cost += i.price();
	}

	public float getCost() {
		return cost;
	}

	public void showItems() {
		for (Item item : items) {
			System.out.println(item);
		}
	}

}

class MealMaker {
	public Meal vegBurgerPlusCoca() {
		Meal meal = new Meal();
		meal.addItem(new Coca());
		meal.addItem(new VegBurger());
		return meal;
	}

	public Meal chickenBurgerPlusPure() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Water());
		return meal;
	}

}

public class BuilderPattern {

	public static void main(String[] args) {
		MealMaker chef = new MealMaker();
		chef.chickenBurgerPlusPure().showItems();
		System.out.println(chef.chickenBurgerPlusPure().getCost());

	}

}
