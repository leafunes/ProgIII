package proc;

import engine.GameObject;
import engine.Sprite;

public class Cell extends GameObject {
	
	private int value;
	private boolean destroyAndMove;

	public Cell(int x ,int y, int value, Sprite spr) {
		super(x, y, 64, 64,spr);
		
		this.value = value;
		
	}

	@Override
	public void behavior() {
		this.drawable.actualizeText(super.posX+32, super.posY+32, String.valueOf(this.value));
		
		if(destroyAndMove && !isMoving()) this.destroyMe = true;

	}
	
	public void moveAndDestroy(int x, int y, int vel){
		this.move(x, y, vel);
		this.destroyAndMove = true;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue() {
		this.value = this.value*2;
	}

	@Override
	public void collisionEvent(GameObject other) {
		
	}

}
