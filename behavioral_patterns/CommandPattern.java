package behavioral_patterns;

abstract class Command {

	public abstract void execute();
}

class Receiver {
	public void doSomething() {
		System.out.println("do something");
	}

	public void doSomething2() {
		System.out.println("do something2");
	}

}

class ConcreteCommand extends Command {

	private Receiver receiver;

	public ConcreteCommand(Receiver rc) {
		receiver = rc;
	}

	@Override
	public void execute() {
		receiver.doSomething();
		receiver.doSomething2();
	}

}

class Invoker {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void action() {
		command.execute();
	}
}

public class CommandPattern {

	public static void main(String[] args) {
		ConcreteCommand cc = new ConcreteCommand(new Receiver());
		Invoker invoker = new Invoker();

		invoker.setCommand(cc);
		invoker.action();
	}

}
