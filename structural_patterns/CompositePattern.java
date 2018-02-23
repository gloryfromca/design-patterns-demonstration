package structural_patterns;

import java.util.ArrayList;
import java.util.List;

class Employee {
	String name;
	String position;
	int salary;
	List<Employee> subordinates = new ArrayList<Employee>();

	public Employee(String name, String position, int salary) {
		this.name = name;
		this.salary = salary;
		this.position = position;
	}

	public void addSubordinate(Employee e) {
		subordinates.add(e);
	}

	public void removeSubordinate(Employee e) {
		subordinates.remove(e);
	}

	@Override
	public String toString() {
		return String.format("[name:%s, position:%s, salary:%s]", name, position, salary);
	}

	public void showAll() {
		for (Employee e : subordinates) {
			System.out.println(e);
			if (!e.getSubordinates().isEmpty()) {
				e.showAll();
			}
		}
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

}

public class CompositePattern {

	public static void main(String[] args) {
		Employee CEO = new Employee("John", "CEO", 30000);

		Employee headSales = new Employee("Robert", "Head Sales", 20000);

		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

		CEO.addSubordinate(headSales);
		CEO.addSubordinate(headMarketing);

		headSales.addSubordinate(salesExecutive1);
		headSales.addSubordinate(salesExecutive2);

		headMarketing.addSubordinate(clerk1);
		headMarketing.addSubordinate(clerk2);

		CEO.showAll();

	}

}
