package j2ee_patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Customer {
	private int rollNo;
	private String name;

	public Customer(int rollNo, String name) {
		this.name = name;
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return String.format("[rollNo: %s, name: %s]", rollNo, name);
	}

}

interface CustomerDao {
	public List<Customer> getAllCustomers();

	public Customer getCustomerByrollNo(int rollNo);

	public List<Customer> getCustomerByName(String name);

	public void deleteCustomer(Customer customer);

	public void updateCustomer(Customer customer);

}

class CustomerDaoImpl implements CustomerDao {

	// fake database.
	HashMap<Integer, String> customerTable = new HashMap<Integer, String>();
	{
		customerTable.put(1, "zhanghui");
		customerTable.put(2, "yilong");
		customerTable.put(3, "saiya");
		customerTable.put(4, "yilong");

	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> all = new ArrayList<Customer>();
		for (Entry<Integer, String> entry : customerTable.entrySet()) {
			Customer customer = new Customer(entry.getKey(), entry.getValue());
			all.add(customer);
		}

		return all;
	}

	@Override
	public Customer getCustomerByrollNo(int rollNo) {

		String name = customerTable.get(rollNo);
		if (name == null)
			return null;

		return new Customer(rollNo, name);
	}

	@Override
	public List<Customer> getCustomerByName(String name) {

		List<Customer> sameName = new ArrayList<Customer>();
		for (Entry<Integer, String> entry : customerTable.entrySet()) {
			if (entry.getValue() == name) {
				Customer customer = new Customer(entry.getKey(), entry.getValue());
				sameName.add(customer);
			}
		}

		return sameName;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerTable.remove(customer.getRollNo());
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerTable.put(customer.getRollNo(), customer.getName());
	}

}

public class DataAccessObjectPattern {

	public static void main(String[] args) {
		CustomerDao cd = new CustomerDaoImpl();
		System.out.println(cd.getAllCustomers());
		System.out.println(cd.getCustomerByName("yilong"));
		cd.updateCustomer(new Customer(4, "yilong2"));
		System.out.println(cd.getAllCustomers());
	}

}
