package behavioral_patterns;

abstract class Game {
	protected abstract void initialize();

	protected abstract void startPlay();

	protected abstract void endPlay();

	public final void play() {
		initialize();
		startPlay();
		endPlay();
	}
}

class Football extends Game {

	@Override
	protected void initialize() {
		System.out.println("initialize " + getClass().getSimpleName() + "!");
	}

	@Override
	protected void startPlay() {
		System.out.println("startPlay " + getClass().getSimpleName() + "!");
	}

	@Override
	protected void endPlay() {
		System.out.println("endPlay " + getClass().getSimpleName() + "!");
	}

}

public class TemplatePattern {

	public static void main(String[] args) {
		Game football = new Football();
		football.play();
	}

}
