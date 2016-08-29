package proc;

import java.util.Random;

import engine.GameRoom;
import engine.Key;

public class MainRoom extends GameRoom {
	
	private Random gen;
	private int gridDimension;
	private Cell[][] grid;
	
	public MainRoom(int dimension, Random gen) {
		super(800, 600);
		this.gridDimension = dimension;
		this.grid = new Cell[dimension][dimension];
		
		this.gen = gen;
		//Crea los objetos iniciales
		
		this.init();
	}

	public MainRoom(int dimension) {
		this(dimension, new Random());
		
	}
	
	public void rigthKey(){
		for(int i = 0; i < this.gridDimension; i++){
			for(int j = 0; j < this.gridDimension; j++){
				
			}
		}
		
	}
	
	@Override
	public void init(){
		
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
	public void eventClick(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
