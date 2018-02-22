package structural_patterns;

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

	@Override
	public String toString() {
		return String.format("[name:%s, gender:%s, martialStatus:%s]", name, gender, martialStatus);
	}
}

interface PersonFilter {
	public List<Person> filter(List<Person> persons);

}

public class FilterPattern {

	public static void main(String[] args) {

	}

}
