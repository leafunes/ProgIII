package rooms;

import engine.Drawable;
import engine.GameObject;
import engine.Key;
import proc.Sprites;

import objects.Buttons;

public class MenuRoom extends engine.GameRoom {
	
	public MenuRoom() {
		super(600, 450);
		
		this.background = new Drawable(0, 0, -1, Sprites.menuBackground);
		
		addObject( new Buttons.StartButton(225, 250, 150, 70));
		addObject( new Buttons.ScoreButton(225, 350, 150, 70));
		addObject( new Buttons.RigthButton(375, 190, 32, 32));
		addObject( new Buttons.LeftButton(200, 190, 32, 32));
		
		
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
