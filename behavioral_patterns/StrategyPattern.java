package behavioral_patterns;

interface Strategy {
	public int doOperation(int x, int y);

}

class AddStrategy implements Strategy {

	@Override
	public int doOperation(int x, int y) {
		return x + y;
	}
}

class SubStrategy implements Strategy {

	@Override
	public int doOperation(int x, int y) {
		return x - y;
	}
}

class StrateContext {
	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public int execute(int x, int y) {
		return strategy.doOperation(x, y);
	}

}

public class StrategyPattern {

	public static void main(String[] args) {

		StrateContext sc = new StrateContext();
		sc.setStrategy(new AddStrategy());
		System.out.println(sc.execute(1, 2));

	}

}
