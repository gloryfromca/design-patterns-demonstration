package creational_patterns;

import java.util.ArrayList;
import java.util.List;

class Cell implements Cloneable {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("A " + getClass().getName() + " clone!");
		return super.clone();
	}

}

class BodyCell extends Cell {
}

class StomachCell extends Cell {
}

class CellProducer {
	List<Cell> cells = new ArrayList<Cell>();
	{
		cells.add(new BodyCell());
		cells.add(new StomachCell());
	}

	public StomachCell getStomachCell() {
		StomachCell cell = null;
		try {
			cell = (StomachCell) cells.get(1).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cell;
	}

	public BodyCell getBodyCell() {
		BodyCell cell = null;
		try {
			cell = (BodyCell) cells.get(0).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cell;
	}
}

public class PrototypePattern {

	public static void main(String[] args) {
		CellProducer cp = new CellProducer();
		cp.getBodyCell();
		cp.getStomachCell();

	}

}
