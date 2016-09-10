package objects;

import data.GlobalVariables;
import engine.GameObject;
import engine.Key;
import proc.Sprites;

public class Buttons {
	
	public static class LeftButton extends GameObject{

		public LeftButton(int x, int y) {
			super(x, y, 32, 32, Sprites.left);
			
		}

		@Override
		public void behavior() {}

		@Override
		public void collisionEvent(GameObject other){}

		@Override
		public void eventKeyPress(Key k) {}

		@Override
		public void eventClick() {
			
			if(GlobalVariables.GRID_MENU_DIMENSION.equals(3)) 
				GlobalVariables.GRID_MENU_DIMENSION = 5;
			else
				GlobalVariables.GRID_MENU_DIMENSION --;
			
			
		}
		
	}

	
	public static class RigthButton extends GameObject{

		public RigthButton(int x, int y) {
			super(x, y, 32, 32, Sprites.rigth);
			
		}

		@Override
		public void behavior() {}

		@Override
		public void collisionEvent(GameObject other){}

		@Override
		public void eventKeyPress(Key k) {}

		@Override
		public void eventClick() {
			
			if(GlobalVariables.GRID_MENU_DIMENSION.equals(5)) 
				GlobalVariables.GRID_MENU_DIMENSION = 3;
			else
				GlobalVariables.GRID_MENU_DIMENSION ++;
			
		}
		
	}
	
	
	public static class ScoreButton extends GameObject{

		public ScoreButton(int x, int y) {
			super(x, y, 150, 70, Sprites.scoresButton);
		}

		@Override
		public void behavior() {}

		@Override
		public void collisionEvent(GameObject other){}

		@Override
		public void eventKeyPress(Key k) {}

		@Override
		public void eventClick() {
			changeRoom(4);
		}
	
	}
	
	
	public static class StartButton extends GameObject{

		public StartButton(int x, int y) {
			super(x, y, 150, 70, Sprites.startButton);
		}

		@Override
		public void behavior() {}

		@Override
		public void collisionEvent(GameObject other){}

		@Override
		public void eventKeyPress(Key k) {}

		@Override
		public void eventClick() {
			if(GlobalVariables.GRID_MENU_DIMENSION.equals(3))
				this.changeRoom(0);
			else if(GlobalVariables.GRID_MENU_DIMENSION.equals(4))
				this.changeRoom(1);
			else if(GlobalVariables.GRID_MENU_DIMENSION.equals(5))
				this.changeRoom(2);
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
			changeRoom(3);
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
			changeRoom(3);
		}
		
	}
	
	
}
