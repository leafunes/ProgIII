package proc;

import java.util.Random;

import engine.GameRoom;

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
	
	@Override
	public void init(){
		
	}

	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventKeyPress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventClick() {
		// TODO Auto-generated method stub
		
	}

}
