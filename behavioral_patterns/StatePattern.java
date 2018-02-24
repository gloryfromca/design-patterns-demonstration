package behavioral_patterns;

abstract class State {
	protected LiftContext context;

	public State(LiftContext context) {
		this.context = context;
	}

	public abstract void run();

	public abstract void addFloor(int num);

	public abstract void stop();
}

class StopState extends State {

	public StopState(LiftContext context) {
		super(context);
	}

	@Override
	public void run() {
		if (context.getFloor() == -1) {
			System.out.println("you should choose floor first!");
			context.setState(this);
		} else {
			System.out.println("Go!");
			context.setState(context.RUN);
		}
	}

	@Override
	public void addFloor(int num) {
		context.setFloor(num);
		System.out.println("you want to " + num + "!");
		context.setState(this);
	}

	@Override
	public void stop() {
		System.out.println("you has already stopped!");
		context.setState(this);
	}

	@Override
	public String toString() {
		return "now: STOP!";
	}

}

class RunState extends State {

	public RunState(LiftContext context) {
		super(context);
	}

	@Override
	public void run() {
		System.out.println("elevator is running!");
		context.setState(this);
	}

	@Override
	public void addFloor(int num) {
		System.out.println("elevator is running!");
		context.setState(this);
	}

	@Override
	public void stop() {
		context.setState(context.STOP);
		context.setFloor(-1);
		System.out.println("you arrive!");
	}

	@Override
	public String toString() {
		return "now: RUN!";
	}

}

class LiftContext {
	private int floor = -1;
	public final State STOP = new StopState(this);
	public final State RUN = new RunState(this);
	private State state = STOP;

	public int getFloor() {
		return floor;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	// operations for this elevator.
	public void to(int num) {
		state.addFloor(num);
	}

	public void stop() {
		state.stop();
	}

	public void run() {
		state.run();
	}

}

public class StatePattern {

	public static void main(String[] args) {
		LiftContext lift = new LiftContext();
		System.out.println(lift.getState());
		lift.to(5);
		System.out.println(lift.getState());
		lift.run();
		System.out.println(lift.getState());
		lift.to(10);
		lift.run();
		lift.stop();
		System.out.println(lift.getState());

	}

}
