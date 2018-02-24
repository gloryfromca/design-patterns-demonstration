package j2ee_patterns;

interface View {
	public void show();
}

class HomeView implements View {

	@Override
	public void show() {
		System.out.println("Home");
	}

}

class LinksView implements View {

	@Override
	public void show() {
		System.out.println("Links");
	}

}

class Dispatcher {
	private HomeView homeView = new HomeView();
	private LinksView linksView = new LinksView();

	public void dispatch(String request) {
		if (request == "Home")
			homeView.show();
		else if (request == "Links") {
			linksView.show();
		} else {
			System.err.println("No such webpage!");
		}
	}

}

class FrontController {
	private Dispatcher dispatcher;

	public FrontController(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public boolean isAuthenticUser() {
		System.out.println("User is authenticated successfully");
		return true;
	}

	public void trackRequest(String request) {
		System.out.println("Page requested: " + request);
	}

	public void dispatchRequest(String request) {
		trackRequest(request);
		if (isAuthenticUser()) {
			dispatcher.dispatch(request);
		} else {
			System.out.println("Refused: you are not a authenticUser!");
		}
	}

}

public class FrontControllerPattern {

	public static void main(String[] args) {
		Dispatcher dispatcher = new Dispatcher();
		FrontController fc = new FrontController(dispatcher);
		fc.dispatchRequest("Home");
		fc.dispatchRequest("Won");

	}

}
