package j2ee_patterns;

class Student {
	private int rollNo;
	private String name;

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

class StudentView {
	public void showRollNo(int rollNo) {
		System.out.println("rollNo: " + rollNo);
	}

	public void showName(String name) {
		System.out.println("name: " + name);
	}

}

class StudentController {
	private Student student;
	private StudentView studentView;

	public StudentController(Student student, StudentView studentView) {
		this.student = student;
		this.studentView = studentView;
	}

	public void changeName(String name) {
		student.setName(name);
	}

	public void changeRollNo(int rollNo) {
		student.setRollNo(rollNo);
	}

	public void showStudent() {
		studentView.showName(student.getName());
		studentView.showRollNo(student.getRollNo());
	}

}

public class MVCPattern {

	private static Student retriveStudentFromDatabase() {
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo(10);
		return student;
	}

	public static void main(String[] args) {

		Student model = retriveStudentFromDatabase();
		StudentView view = new StudentView();
		StudentController sc = new StudentController(model, view);
		sc.showStudent();
		sc.changeName("zhanghui");
		sc.changeRollNo(22);
		sc.showStudent();

	}

}
