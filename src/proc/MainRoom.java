package proc;

import engine.Drawable;
import engine.GameObject;
import engine.GameRoom;
import engine.Key;

public class MainRoom extends GameRoom {
	
	private Grid grid;
	private Drawable score;
	private int scorePoints;
	
	private class MenuButton extends GameObject{


		public MenuButton(int x, int y, int width, int height) {
			super(x, y, 2 ,width, height,Sprites.menuButton);
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
	
	public MainRoom(int cellDimension, int gridDimesion, int xOffset, int yOffset) {
		super(600, 450);
		background = new Drawable(0, 0,-1, Sprites.mainBackground);
		
		addObject(new MenuButton(50, 20, 150, 70));
		
		this.grid = new Grid(gridDimesion,xOffset,yOffset,64);
		this.score = new Drawable(0, 0, 0,null);
		
		//Crea los objetos iniciales
		
		this.init();
	}

	
	@Override
	public void init(){
		
	}

	@Override
	public void behavior() {
		grid.step();
		
		scorePoints = grid.getScore();
		
		score.actualizeText(450,65, String.valueOf(scorePoints));
		
		this.drawables.addAll(grid.getDrawables());
		this.drawables.add(score);
	}
		

	@Override
	public void eventKeyPress(Key k) {
		if(!grid.somethingIsMoving()){
			
			switch(k){
				case K_RIGHT:
					grid.moveRigth();
					break;
					
				case K_LEFT:
					grid.moveLeft();
					break;
					
				case K_UP:
					grid.moveUp();
					break;
					
				case K_DOWN:
					grid.moveDown();
					break;
					
				default:
					break;
			}
		}
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
	public boolean isGameOver() {
		return false;
		//TODO
	}

}
