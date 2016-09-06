package proc;

import java.awt.Rectangle;

import engine.GameObject;
import engine.Key;
import engine.Sprite;

public class MenuRoom extends engine.GameRoom {
	
	private class StartButton extends GameObject{

		public StartButton(int x, int y, int width, int height, Sprite spr) {
			super(x, y, width, height, spr);
		}

		@Override
		public void behavior() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void collisionEvent(GameObject other){}

		@Override
		public void eventKeyPress(Key k) {}

		@Override
		public void eventClick() {
			this.changeRoom(0);
		}
		
	}

	public MenuRoom() {
		super(600, 450);
		
		addObject( new StartButton(250, 150, 100, 50, Sprites.startButton));
		
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
