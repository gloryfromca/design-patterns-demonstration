package structural_patterns;

import java.util.ArrayList;
import java.util.List;

class Person {
	private String name;
	private String gender;
	private String martialStatus;

	public Person(String name, String gender, String martialStatus) {
		this.gender = gender;
		this.name = name;
		this.martialStatus = martialStatus;
	}

	public String getGender() {
		return gender;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("[name:%s, gender:%s, martialStatus:%s]", name, gender, martialStatus);
	}
}

interface PersonFilter {
	public List<Person> filter(List<Person> persons);

}

class MaleFilter implements PersonFilter {

	@Override
	public List<Person> filter(List<Person> persons) {
		List<Person> males = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getGender() == "Male") {
				males.add(person);
			}
		}
		return males;
	}

}

class MarriedFilter implements PersonFilter {

	@Override
	public List<Person> filter(List<Person> persons) {
		List<Person> married = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getMartialStatus() == "Married") {
				married.add(person);
			}
		}
		return married;
	}

}

class AndFilter implements PersonFilter {
	PersonFilter aFilter, bFilter;

	public AndFilter(PersonFilter aFilter, PersonFilter bFilter) {
		this.aFilter = aFilter;
		this.bFilter = bFilter;
	}

	@Override
	public List<Person> filter(List<Person> persons) {
		return aFilter.filter(bFilter.filter(persons));
	}

}

class OrFilter implements PersonFilter {
	PersonFilter aFilter, bFilter;

	public OrFilter(PersonFilter aFilter, PersonFilter bFilter) {
		this.aFilter = aFilter;
		this.bFilter = bFilter;
	}

	@Override
	public List<Person> filter(List<Person> persons) {
		List<Person> a = new ArrayList<Person>();
		a = aFilter.filter(persons);
		for (Person person : bFilter.filter(persons))
			if (!a.contains(person)) {
				a.add(person);
			}
		return a;
	}

}

public class FilterPattern {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Robert", "Male", "Single"));
		persons.add(new Person("John", "Male", "Married"));
		persons.add(new Person("Laura", "Female", "Married"));
		persons.add(new Person("Diana", "Female", "Single"));
		persons.add(new Person("Mike", "Male", "Single"));
		persons.add(new Person("Bobby", "Male", "Single"));

		PersonFilter male = new MaleFilter();
		PersonFilter married = new MarriedFilter();
		System.out.println(male.filter(persons));

		PersonFilter and = new AndFilter(male, married);

		System.out.println(and.filter(persons));

	}

}
