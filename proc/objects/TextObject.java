package objects;

import engine.GameObject;
import engine.Key;

public class TextObject extends GameObject{

	public TextObject(int x, int y, String text) {
		super(x, y, 1, 0, 0, null);
		
		this.drawable.actualizeText(x, y, text);
		
	}

	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collisionEvent(GameObject other) {
		// TODO Auto-generated method stub
		
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
