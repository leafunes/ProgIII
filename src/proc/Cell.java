package proc;

import engine.GameObject;
import engine.Key;

public class Cell extends GameObject {
	
	private int value;
	private boolean destroyAndMove;
	private boolean moveAndValue;

	public Cell(int x ,int y, int value) {
		super(x, y, 64, 64, Sprites.cells.get(value));
		
		this.value = value;
		
	}

	@Override
	public void behavior() {
		
		this.drawable.actualizeText(super.posX+(width/2)-8, super.posY+height/2, String.valueOf(this.value));
		
		if(destroyAndMove && !isMoving()) this.destroyMe = true;
		if(moveAndValue && !isMoving()) {
			this.setValue();
			moveAndValue = false;
		}

	}
	
	public void moveAndDestroy(int x, int y, int vel){
		this.move(x, y, vel);
		this.drawable.actualizeZIndex(0);
		this.destroyAndMove = true;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue() {
		this.value = this.value*2;
		this.drawable.actualizeSprite(Sprites.cells.get(this.value));
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
