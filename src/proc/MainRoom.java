package proc;

import java.util.Random;

import engine.GameRoom;
import engine.Key;

public class MainRoom extends GameRoom {
	
	private Grid grid;
	
	public MainRoom(int cellDimension, int gridDimesion, int xOffset, int yOffset, Random gen) {
		super(800, 600);
		
		this.grid = new Grid(4,xOffset,yOffset,64);
		
		//Crea los objetos iniciales
		
		this.init();
	}

	public MainRoom(int cellDimension, int dimension, int xOffset, int yOffset) {
		this(cellDimension, dimension, xOffset, yOffset, new Random());
		
	}

	
	@Override
	public void init(){
		
	}

	@Override
	public void behavior() {
		grid.step();
		this.drawables.addAll(grid.getDrawables());
	}
		

	@Override
	public void eventKeyPress(Key k) {
		if(grid.somethingIsMoving()){
			
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
