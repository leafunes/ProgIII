package proc;

import engine.GameObject;
import engine.Sprite;

public class Cell extends GameObject {
	
	private int value;

	public Cell(int x ,int y, int value, Sprite spr) {
		super(x, y, 64, 64,spr);
		
		this.value = value;
		
	}

	@Override
	public void behavior() {
		this.drawable.actualizeText(super.posX+32, super.posY+32, String.valueOf(this.value));

	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
