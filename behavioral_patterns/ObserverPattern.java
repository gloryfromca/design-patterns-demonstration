package behavioral_patterns;

import java.util.ArrayList;
import java.util.List;

class Subject {
	private int stage;
	List<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
		notifyAllObserver();
	}

	public void notifyAllObserver() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}

interface Observer {
	public void update(Subject subject);
}

class Observer1 implements Observer {

	@Override
	public void update(Subject subject) {
		System.out.println(getClass().getSimpleName() + ": " + subject.getStage());
	}

}

class Observer2 extends Observer1 {

	@Override
	public void update(Subject subject) {
		System.out.println("I'm observer2!");
		System.out.println(getClass().getSimpleName() + ": " + subject.getStage());
	}
}

public class ObserverPattern {

	public static void main(String[] args) {
		Observer observer1 = new Observer1();
		Observer observer2 = new Observer2();
		Subject subject = new Subject();

		subject.addObserver(observer1);
		subject.addObserver(observer2);

		subject.setStage(100);

	}

}
