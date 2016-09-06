package proc;

import engine.GameObject;
import engine.Key;
import engine.Sprite;

public class Cell extends GameObject {
	
	private int value;
	private boolean destroyAndMove;
	private boolean moveAndValue;

	public Cell(int x ,int y, int value, Sprite spr) {
		super(x, y, 64, 64,spr);
		
		this.value = value;
		
	}

	@Override
	public void behavior() {
		this.drawable.actualizeText(super.posX+32, super.posY+32, String.valueOf(this.value));
		
		if(destroyAndMove && !isMoving()) this.destroyMe = true;
		if(moveAndValue && !isMoving()) {
			this.setValue();
			moveAndValue = false;
		}

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
	
	public void moveAndsetValue() {
		this.moveAndValue = true;
		
	}
	@Override
	public void collisionEvent(GameObject other) {
		
	}

	@Override
	public void eventKeyPress(Key k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventClick() {
		// TODO Auto-generated method stub
		
	}



}
