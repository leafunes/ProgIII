package objects;

import engine.GameObject;
import engine.Key;
import proc.Sprites;

public class Buttons {
	
	public static class LeftButton extends GameObject{

		public LeftButton(int x, int y) {
			super(x, y, 32, 32, Sprites.left);
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

	
	public static class RigthButton extends GameObject{

		public RigthButton(int x, int y) {
			super(x, y, 32, 32, Sprites.rigth);
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

		public ScoreButton(int x, int y) {
			super(x, y, 150, 70, Sprites.scoresButton);
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
			changeRoom(2);
		}
	
	}
	
	
	public static class StartButton extends GameObject{

		public StartButton(int x, int y) {
			super(x, y, 150, 70, Sprites.startButton);
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
	
	
	public static class MenuButton extends GameObject{


		public MenuButton(int x, int y) {
			super(x, y, 100, 45, Sprites.menuButton);
		}

		@Override
		public void behavior() {}

		@Override
		public void collisionEvent(GameObject other){}

		@Override
		public void eventKeyPress(Key k) {}

		@Override
		public void eventClick() {
			changeRoom(1);
		}
		
	}
	
	public static class GameOverButton extends GameObject{


		public GameOverButton(int x, int y) {
			super(x, y, 2 ,500, 250, Sprites.gameOver);
		}

		@Override
		public void behavior() {}

		@Override
		public void collisionEvent(GameObject other){}

		@Override
		public void eventKeyPress(Key k) {}

		@Override
		public void eventClick() {
			changeRoom(1);
		}
		
	}
	
	
}
