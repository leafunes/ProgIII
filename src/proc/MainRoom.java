package proc;

import java.util.Random;

import engine.GameRoom;
import engine.Key;


public class MainRoom extends GameRoom {
	
	private Random gen;
	private Cell[][] grid;
	
	private boolean somethingActualized;
	private int freePlaces;
	
	private final int GRID_DIMENSION;
	private final int GRID_X_OFFSET;
	private final int GRID_Y_OFFSET;
	private final int CELL_DIMENSION;
	
	public MainRoom(int cellDimension, int gridDimesion, int xOffset, int yOffset, Random gen) {
		super(800, 600);
		
		this.GRID_DIMENSION = gridDimesion;
		this.CELL_DIMENSION = cellDimension;
		this.GRID_X_OFFSET = xOffset;
		this.GRID_Y_OFFSET = yOffset;
		
		this.freePlaces = gridDimesion*gridDimesion;
		
		this.grid = new Cell[gridDimesion][gridDimesion];
		
		this.gen = gen;
		//Crea los objetos iniciales
		
		this.init();
	}

	public MainRoom(int cellDimension, int dimension, int xOffset, int yOffset) {
		this(cellDimension, dimension, xOffset, yOffset, new Random());
		
	}
	
	private void rigthKey(){
		
		for(int i = 0; i < this.GRID_DIMENSION; i++){
			
			//Recorro el grid por fila, pero sin iterar sobre la primer columna
			
			for(int j = this.GRID_DIMENSION - 1; j >= 1; j--){			
				if(this.grid [i][j] == null){
					this.somethingActualized = true;
					
					this.grid[i][j] = this.grid[i][j-1];
					this.grid[i][j-1].move(GRID_X_OFFSET + (CELL_DIMENSION * j) ,GRID_Y_OFFSET + (CELL_DIMENSION * i), 1);
					this.grid[i][j-1] = null;
				}
			}
		}
		
	}
	
	private void leftKey(){
		
	}
	
	@Override
	public void init(){
		
	}

	@Override
	public void behavior() {
		if(this.somethingActualized){
			this.somethingActualized = false;
			
			while(true){
				int randI = this.gen.nextInt(this.GRID_DIMENSION);
				int randJ = this.gen.nextInt(this.GRID_DIMENSION);
				
				if(this.grid[randI][randJ] == null){
					int cellValue = (this.gen.nextInt(1) + 1) * 2;
					this.grid[randI][randJ] = new Cell(GRID_X_OFFSET + (CELL_DIMENSION * randJ) ,GRID_Y_OFFSET + (CELL_DIMENSION * randI), cellValue, Sprites.cellSprite);
					this.freePlaces --;
					break;
				}
			}
		}
		
	}

	@Override
	public void eventKeyPress(Key k) {
		switch(k){
			case K_RIGHT:
				this.rigthKey();
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
		if(this.freePlaces > 0)
			return false;
		else{
			
			for(int i = 0; i < this.GRID_DIMENSION; i++){
				
				for(int j = 0; j < this.GRID_DIMENSION; j++){
					
					if(i < this.GRID_DIMENSION - 1)
						if(this.grid[i][j].getValue() == this.grid[i+1][j].getValue()) return false;
					
					if(j < this.GRID_DIMENSION - 1)
						if(this.grid[i][j].getValue() == this.grid[i][j+1].getValue()) return false;
					
				}
				
			}
			
		}
		
		return true;
		
		
	}

}
