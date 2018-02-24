package j2ee_patterns;

import java.util.ArrayList;

interface Service {
	public String name();

	public void execute();

}

class Service1 implements Service {
	public void execute() {
		System.out.println("Executing Service1");
	}

	@Override
	public String name() {
		return "Service1";
	}
}

class Service2 implements Service {
	public void execute() {
		System.out.println("Executing Service2");
	}

	@Override
	public String name() {
		return "Service2";
	}
}

class Cache extends ArrayList<Service> {

}

class InitialContext {

	public Service lookup(String name) {
		if (name.toLowerCase().equals("service1")) {
			System.out.println("Looking up and creating a new service1 object");
			return new Service1();
		}
		if (name.toLowerCase().equals("service2")) {
			System.out.println("Looking up and creating a new service2 object");
			return new Service2();
		}
		return null;
	}
}

class ServiceLocator {
	private static Cache cache = new Cache();
	private static InitialContext initialContext = new InitialContext();

	public static Service getService(String name) {
		for (Service service : cache) {
			if (service.name().equalsIgnoreCase(name)) {
				System.out.println("Returning cached  " + name + " object");
				return service;
			}
		}
		Service service = initialContext.lookup(name);
		if (service != null) {
			cache.add(service);

		} else {
			System.out.println("No such service is located!");
		}
		return service;
	}

}

public class ServiceLocatorPattern {

	public static void main(String[] args) {

		Service service = ServiceLocator.getService("service1");
		service.execute();
		service = ServiceLocator.getService("service2");
		service.execute();
		service = ServiceLocator.getService("service1");
		service.execute();
		service = ServiceLocator.getService("service2");
		service.execute();

		// a strange result after toLowerCase() operation.
		// Maybe different "Ss1".toLowerCase() is a object not a StringConstant.
		System.out.println("Ss1".toLowerCase() == "ss1");
		System.out.println("ss1".toLowerCase() == "Ss1".toLowerCase());

	}

}
