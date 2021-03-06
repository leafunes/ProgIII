package objects;

import data.GlobalVariables;
import engine.GameObject;
import engine.Key;
import proc.Sprites;

public class Cell extends GameObject {
	

	private int spriteIndex;
	private int value;
	private boolean destroyAndMove;
	private boolean moveAndValue;

	public Cell(int x ,int y, int value) {
		super(x, y, 64, 64, Sprites.cells.get(value));
		
		this.value = value;
		this.spriteIndex = value;
		
		this.drawable.actualizeFont(GlobalVariables.largeFont);
		
	}

	@Override
	public void behavior() {
		
		this.drawable.actualizeText(super.posX+(width/2)-16, super.posY+height/2, String.valueOf(this.value));
		
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
		spriteIndex = spriteIndex * 2;
		
		if(spriteIndex > 2048)spriteIndex = 2;
		
		this.drawable.actualizeSprite(Sprites.cells.get(this.spriteIndex));
		
		if(this.value >= 1024) this.drawable.actualizeFont(GlobalVariables.smallFont);
		
		if(this.value >= 16348) this.drawable.actualizeFont(GlobalVariables.smallerFont);
		
	}
	
	public void moveAndsetValue() {
		this.moveAndValue = true;
		
	}
	@Override
	public void collisionEvent(GameObject other) {}

	@Override
	public void eventKeyPress(Key k) {}

	@Override
	public void eventClick() {}



}
