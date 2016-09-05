package proc;

import java.util.Random;

import engine.GameRoom;
import engine.Key;

public class MainRoom extends GameRoom {
	
	private Grid grid;
	
	public MainRoom(int cellDimension, int gridDimesion, int xOffset, int yOffset, Random gen) {
		super(800, 600);
		
		this.grid = new Grid(4,0,0,64);
		
		//Crea los objetos iniciales
		
		this.init();
	}

	public MainRoom(int cellDimension, int dimension, int xOffset, int yOffset) {
		this(cellDimension, dimension, xOffset, yOffset, new Random());
		
	}
	
	private void rigthKey(){
		
		grid.moveRigth();
		
	}
	
	private void leftKey(){
		
		
	}
	
	private void addCells(int howMany){
		//TODO
		
	}

	
	@Override
	public void init(){
		
		this.addCells(2);
		
	}

	@Override
	public void behavior() {
		grid.step();
		this.drawables.addAll(grid.getDrawables());
	}
		

	@Override
	public void eventKeyPress(Key k) {
		switch(k){
			case K_RIGHT:
				this.rigthKey();
				break;
				
			case K_LEFT:
				this.leftKey();
				break;
				
			default:
				break;
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
