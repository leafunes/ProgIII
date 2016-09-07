package rooms;

import engine.GameObject;
import engine.Key;
import proc.Sprites;

public class MenuRoom extends engine.GameRoom {
	
	private class StartButton extends GameObject{

		public StartButton(int x, int y, int width, int height) {
			super(x, y, width, height, Sprites.startButton);
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
	
	private class ScoreButton extends GameObject{

		public ScoreButton(int x, int y, int width, int height) {
			super(x, y, width, height, Sprites.scoresButton);
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
			System.out.println("TODO");
		}
		
	}

	public MenuRoom() {
		super(600, 450);
		
		addObject( new StartButton(250, 150, 150, 70));
		addObject( new ScoreButton(250, 250, 150, 70));
		
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
