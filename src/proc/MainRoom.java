package proc;

import java.util.Random;

import engine.Drawable;
import engine.GameRoom;
import engine.Key;

public class MainRoom extends GameRoom {
	
	private Grid grid;
	
	public MainRoom(int cellDimension, int gridDimesion, int xOffset, int yOffset) {
		super(600, 450);
		background = new Drawable(0, 0, Sprites.mainBackground);
		
		this.grid = new Grid(4,xOffset,yOffset,64);
		
		//Crea los objetos iniciales
		
		this.init();
	}

	
	@Override
	public void init(){
		
	}

	@Override
	public void behavior() {
		this.drawables.add(background);
		grid.step();
		this.drawables.addAll(grid.getDrawables());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGameOver() {
		return false;
		//TODO
	}

}
