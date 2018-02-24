package behavioral_patterns;

abstract class AbstractCustomer {
	protected String name;

	public abstract String name();

	public abstract boolean isNull();

}

class NullCustomer extends AbstractCustomer {

	@Override
	public String name() {
		return "NULL CUSTOMER";
	}

	@Override
	public boolean isNull() {
		return true;
	}

}

class Customer extends AbstractCustomer {
	public final static NullCustomer NULL_CUSTOMER = new NullCustomer();

	public Customer(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public boolean isNull() {
		return false;
	}

}

public class NullObjectPattern {

	public static void main(String[] args) {
		AbstractCustomer nullcustomer = Customer.NULL_CUSTOMER;
		System.out.println(nullcustomer.name());
	}

}
