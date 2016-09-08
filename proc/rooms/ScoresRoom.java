package rooms;

import engine.Drawable;
import engine.GameObject;
import engine.GameRoom;
import engine.Key;
import objects.Buttons;
import proc.Sprites;

public class ScoresRoom extends GameRoom{

	public ScoresRoom() {
		super(600, 450);
		
		this.background = new Drawable(0, 0, -1, Sprites.scoresBackground);
		
		addObject(new Buttons.MenuButton(480, 380));
	}

	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventKeyPress(Key k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eventClick(int x, int y) {
		
		for(GameObject obj: objects){
			
			if(obj.collisionShape.contains(x, y)){
				obj.eventClick();
			}
			
		}
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
