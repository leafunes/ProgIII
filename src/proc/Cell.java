package proc;

import engine.GameObject;

public class Cell extends GameObject {
	
	private int value;

	public Cell(int x ,int y, int value) {
		super(x, y, 32, 32);
		
		this.value = value;
		
	}

	@Override
	public void behavior() {
		// TODO Auto-generated method stub

	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
