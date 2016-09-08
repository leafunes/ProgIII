package objects;

import engine.GameObject;
import engine.Key;
import proc.Sprites;

public class Buttons {

	
	public static class RigthButton extends GameObject{

		public RigthButton(int x, int y, int width, int height) {
			super(x, y, width, height, Sprites.rigth);
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
			System.out.println("derecha");
		}
		
	}
	
	
	public static class ScoreButton extends GameObject{

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
	
	
	public static class StartButton extends GameObject{

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
	
	
	public static class LeftButton extends GameObject{

		public LeftButton(int x, int y, int width, int height) {
			super(x, y, width, height, Sprites.left);
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
			System.out.println("left");
		}
		
	}
	
	
}
