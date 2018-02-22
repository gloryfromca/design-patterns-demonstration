package creational_patterns;

class SingleObject {
	private static SingleObject singleton = new SingleObject();

	private SingleObject() {
	}

	public SingleObject getInstance() {
		return singleton;
	}

}

class SingleInnerClass {
	// loading static SingletonHolder just happens once and is just before the
	// static method getInstance() call.
	private static class SingletonHolder {

		private static final SingleInnerClass SINGLETON = new SingleInnerClass();
	}

	static {
		System.out.println("static block");
	}

	private SingleInnerClass() {
		System.out.println("new SingleInnerClass()");
	}

	public static SingleInnerClass getInstance() {
		return SingletonHolder.SINGLETON;
	}

	public static void show() {
		System.out.println("a static method call");
	}

}

class HavingInnerClass {

	{
		System.out.println("HavingInnerClass block");
	}

	private class InstanceClass {
		{
			System.out.println("InstanceClass instance block");
		}
	}

	public void Instance() {
		new InstanceClass();
	}
}

enum SingletonEnum {
	INSTANCE;
	public void whateverMethod() {
	};
}

public class SingletonPattern {

	public static void main(String[] args) {
		// won't initiate SINGLETON
		SingleInnerClass.show();

		// will initiate SINGLETON
		SingleInnerClass.getInstance();

		System.out.println("======================");

		HavingInnerClass hic = new HavingInnerClass();
		hic.Instance();

		System.out.println("======================");

		SingletonEnum instance = SingletonEnum.INSTANCE;
		System.out.println(instance);

	}

}
