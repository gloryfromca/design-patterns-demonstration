package j2ee_patterns;

class DependentObject1 {
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}

class DependentObject2 {
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}

class CoarseGrainedObject {
	DependentObject1 do1 = new DependentObject1();
	DependentObject2 do2 = new DependentObject2();

	public String[] getData() {
		return new String[] { do1.getData(), do2.getData() };
	}

	public void setData(String data1, String data2) {
		do1.setData(data1);
		do2.setData(data2);
	}
}

class CompositeEntity {
	CoarseGrainedObject cgo = new CoarseGrainedObject();

	public String[] getData() {
		return cgo.getData();
	}

	public void setData(String data1, String data2) {
		cgo.setData(data1, data2);
	}

}

class Client {
	CompositeEntity ce = new CompositeEntity();

	public void printData() {
		for (int i = 0; i < ce.getData().length; i++) {
			System.out.println("Data: " + ce.getData()[i]);
		}
	}

	public void setData(String data1, String data2) {
		ce.setData(data1, data2);
	}

}

public class CompositeEntityPattern {

	public static void main(String[] args) {
		Client client = new Client();
	       client.setData("Test", "Data");
	       client.printData();
	       client.setData("Second Test", "Data1");
	       client.printData();
	}

}
