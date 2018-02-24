package j2ee_patterns;

import java.util.ArrayList;

interface Filter {
	public void execute(String request);
}

class AuthenticationFilter implements Filter {

	@Override
	public void execute(String request) {
		System.out.println("Authenticating request: " + request);
	}

}

class DebugFilter implements Filter {
	public void execute(String request) {
		System.out.println("request log: " + request);
	}
}

class Target {
	public void execute(String request) {
		System.out.println("Executing request: " + request);
	}
}

class FilterChain extends ArrayList<Filter> {
	private Target target;

	public void setTarget(Target target) {
		this.target = target;
	}

	public void addFilter(Filter filter) {
		add(filter);
	}

	public void execute(String request) {
		for (Filter filter : this) {
			filter.execute(request);
		}
		target.execute(request);
	}
}

class FilterManager {
	private FilterChain fc;

	public FilterManager(Target target, FilterChain fc) {
		this.fc = fc;
		setTarget(target);

	}

	public void setTarget(Target target) {
		fc.setTarget(target);
	}

	public void execute(String request) {
		fc.execute(request);
	}

}

public class InterceptingFilterPattern {

	public static void main(String[] args) {
		FilterChain fc = new FilterChain();
		fc.add(new DebugFilter());
		fc.add(new AuthenticationFilter());
		FilterManager fm = new FilterManager(new Target(), fc);
		fm.execute("Home");

	}

}
