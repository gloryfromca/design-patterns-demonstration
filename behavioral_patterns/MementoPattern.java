package behavioral_patterns;

import java.util.ArrayList;
import java.util.List;

class Memento {
	private String something;

	public Memento(String something) {
		this.something = something;
	}

	public String getSomething() {
		return something;
	}
}

class Caretaker {
	List<Memento> mementos = new ArrayList<Memento>();

	public void add(Memento memento) {
		mementos.add(memento);
	}

	public Memento getMemento() {
		Memento memento = mementos.get(0);
		mementos.remove(0);
		return memento;
	}

}

class OlderPerson {
	String something;

	public OlderPerson(String something) {
		this.something = something;
	}

	public Memento saveSomethingToMemento() {
		Memento memento = new Memento(something);
		something = null;
		return memento;
	}

	public void getSomethingFromMemento(Memento memento) {
		something = memento.getSomething();
	}

	public String getSomething() {
		return something;
	}

}

public class MementoPattern {

	public static void main(String[] args) {
		Caretaker caretaker = new Caretaker();
		OlderPerson olderPerson = new OlderPerson("wash hand!");
		caretaker.add(olderPerson.saveSomethingToMemento());
		System.out.println(olderPerson.getSomething());
		System.out.println("===========================");
		olderPerson.getSomethingFromMemento(caretaker.getMemento());
		System.out.println(olderPerson.getSomething());

	}

}
