package behavioral_patterns;

import java.util.HashMap;

interface Expression {
	public int interprete(Context context);
}

class Context {
	private HashMap items = new HashMap<>();

	public void addValues(TerminalExpression key, int value) {
		items.put(key, value);
	}

	public int lookupValue(TerminalExpression key) {
		return (int) items.get(key);
	}
}

class TerminalExpression implements Expression {

	@Override
	public int interprete(Context context) {
		return context.lookupValue(this);

	}

}

abstract class NonTerminalExpression implements Expression {
	protected Expression left, right;

	public NonTerminalExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public abstract int interprete(Context context);

}

class Add extends NonTerminalExpression {

	public Add(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int interprete(Context context) {
		return left.interprete(context) + right.interprete(context);
	}

}

class Sub extends NonTerminalExpression {

	public Sub(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int interprete(Context context) {
		return left.interprete(context) - right.interprete(context);
	}

}

class Mul extends NonTerminalExpression {

	public Mul(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int interprete(Context context) {
		return left.interprete(context) * right.interprete(context);
	}

}

class Div extends NonTerminalExpression {

	public Div(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int interprete(Context context) {
		return left.interprete(context) / right.interprete(context);
	}

}

public class InterpreterPattern {

	public static void main(String[] args) {

		Context context = new Context();
		TerminalExpression a = new TerminalExpression();
		TerminalExpression b = new TerminalExpression();
		TerminalExpression c = new TerminalExpression();

		context.addValues(a, 5);
		context.addValues(b, 4);
		context.addValues(c, 1);
		Expression expression = new Add(new Mul(a, b), c);

		System.out.println(expression.interprete(context));
	}

}
