package j2ee_patterns;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.beans.binding.StringBinding;

class StudentVO {
	private int rollNo;
	private String name;

	public StudentVO(int rollNo, String name) {
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

}

class StudentBO {
	HashMap<Integer, String> fakeDatabase = new HashMap<Integer, String>();

	public StudentVO fillAStudent(int rollNo, String name) {
		return new StudentVO(rollNo, name);
	}

	public void updateStudent(StudentVO vehicle) {
		fakeDatabase.put(vehicle.getRollNo(), vehicle.getName());
	}

}

public class TransferObjectPattern {

	public static void main(String[] args) {
		StudentBO sb = new StudentBO();
		StudentVO vehicle = sb.fillAStudent(100, "zhanghui");
		System.out.println("vehicle serializing...");
		System.out.println("vehicle derializing...");
		sb.updateStudent(vehicle);

	}

}
