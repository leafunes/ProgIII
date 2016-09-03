package proc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import engine.GameRoom;
import engine.Key;

public class MainRoom extends GameRoom {
	
	private Random gen;
	private Cell[][] grid;
	
	private boolean somethingActualized;
	private int freePlaces;
	
	private HashSet<Cell> cellsToDestroy;
	
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
		
		this.cellsToDestroy = new HashSet<>();
		
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
		
		for(int i = 0; i < GRID_DIMENSION; i++){
			for(int j = GRID_DIMENSION -1; j >= 0; j--){
				moveCellRigth(i, j);
			}
		}
		
		
	}
	
	private void leftKey(){
		
		
	}
	
	private void moveCellRigth(int i, int j){
		Cell cell = grid[i][j];
		
		if(cell == null && j > 0){
			for(int k = GRID_DIMENSION - 1; k >= 0; k--){
				if(grid[i][k] != null){
					this.somethingActualized = true;
					moveCell(i, j, i, k);
				}
			}
		}
		
		else if(j < GRID_DIMENSION -1){
			Cell otherCell = grid[i][j+1];
		}
		
	}
	
	private void addCells(int howMany){
		
		int counter = 0;
		
		while(counter < howMany){
			int randI = this.gen.nextInt(this.GRID_DIMENSION);
			int randJ = this.gen.nextInt(this.GRID_DIMENSION);
			
			if(this.grid[randI][randJ] == null){
				int cellValue = (this.gen.nextInt(1) + 1) * 2;
				
				Cell newCell = new Cell(GRID_X_OFFSET + (CELL_DIMENSION * randJ) ,GRID_Y_OFFSET + (CELL_DIMENSION * randI), cellValue, Sprites.cellSprite);
				
				this.addObject(newCell);
				
				this.grid[randI][randJ] = newCell;
				this.freePlaces --;
				counter++;
			}
		}
		
	}
	
	private void moveCell(int iFrom, int jFrom, int iTo, int jTo){
		

		grid[iFrom][jFrom] = grid[iTo][jTo];
		grid[iTo][jTo] = null;
		grid[iFrom][jFrom].move(jFrom*CELL_DIMENSION + GRID_X_OFFSET, iFrom*CELL_DIMENSION + GRID_Y_OFFSET, 1);
		
	}
	
	@Override
	public void init(){
		
		this.addCells(2);
		
	}

	@Override
	public void behavior() {
		if(this.somethingActualized){
			this.somethingActualized = false;
			
			int howManyCells = this.gen.nextInt(1)+1;
			
			this.addCells(howManyCells);
			
			}
		
		
		
		for(Cell toDestroy: this.cellsToDestroy){
			if(!toDestroy.isMoving()){
				this.destroyObject(toDestroy);
				this.freePlaces++;
			}
		}
		
		this.cellsToDestroy.clear();
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
