package proc;

import java.util.ArrayList;
import java.util.Random;

import engine.Drawable;

public class Grid {
	
	private Cell grid[][];
	
	private Random gen;
	
	private final int DIMENSION;
	private final int X_OFFSET;
	private final int Y_OFFSET;
	private final int CELL_DIMENSION;
	private final int CELL_VEL = 10;
	ArrayList<Drawable> drawables = new ArrayList<>();
	
	
	public Grid(int dimension, int xOffset, int yOffset, int cellDimension){
		
		this.gen = new Random();
		
		this.grid = new Cell[dimension][dimension];
		this.DIMENSION = dimension;
		this.X_OFFSET = xOffset;
		this.Y_OFFSET = yOffset;
		this.CELL_DIMENSION = cellDimension;
		
		this.addCells(6);
		
	}
	
	private void addCells(int howMany){
		
		int randI = gen.nextInt(DIMENSION);
		int randJ = gen.nextInt(DIMENSION);
		int cellValue = (gen.nextInt(1)*2)+2;
		
		int counter = 0;
		
		while(counter < howMany ){
			if(grid[randI][randJ] == null){
				grid[randI][randJ] = new Cell(randJ*CELL_DIMENSION + X_OFFSET, randI * CELL_DIMENSION + Y_OFFSET, cellValue, Sprites.cellSprite);
				counter++;
			}
			else{
				randI = gen.nextInt(DIMENSION);
				randJ = gen.nextInt(DIMENSION);
			}
		}
		
		
	}
	
	
	public void moveRigth(){

		int notNull;
		
		for (int i = 0; i < DIMENSION; i++)
		for (int j = DIMENSION -1 ; j > 0; j--)
		for(notNull = j-1; notNull >= 0; notNull--) if( grid[i][notNull] != null){
			
			if(grid[i][j] == null){
				grid[i][notNull].move(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				grid[i][j] = grid[i][notNull];
				grid[i][notNull] = null;
				j++;
				
			}
			else if(grid[i][j].getValue() == grid[i][notNull].getValue()){
				grid[i][j].moveAndsetValue();
				grid[i][notNull].moveAndDestroy(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				
			}
				
			else{
				grid[i][j] = grid[i][notNull];
				grid[i][notNull].move((j - 1) *CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				grid[i][notNull] = null;
			
			}
			break;
			
			
		}
			
	}
	
	public void moveUp(){

		int notNull;
		
		for (int j = 0; j < DIMENSION; j++)
		for (int i = 0 ; i < DIMENSION - 1; i++)
		for(notNull = i+1; notNull < DIMENSION ; notNull++)if( grid[notNull][j] != null){
			
			if(grid[i][j] == null){
				grid[notNull][j].move(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				grid[i][j] = grid[notNull][j];
				grid[notNull][j] = null;
				i--;
				
			}
			else if(grid[i][j].getValue() == grid[notNull][j].getValue()){
				grid[i][j].moveAndsetValue();
				grid[notNull][j].moveAndDestroy(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
					
				
			}
				
			else{
				grid[i][j] = grid[notNull][j];
				grid[notNull][j].move( j *CELL_DIMENSION + X_OFFSET, (i-1)*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				grid[notNull][j] = null;
			
			}
			break;
			
			
		}
			
	}
	
	
	public void moveLeft(){

		int notNull;
		
		for (int i = 0; i < DIMENSION; i++)
		for (int j = 0 ; j < DIMENSION - 1; j++)
		for(notNull = j + 1; notNull < DIMENSION; notNull++) if( grid[i][notNull] != null){
			
			if(grid[i][j] == null){
				grid[i][notNull].move(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				grid[i][j] = grid[i][notNull];
				grid[i][notNull] = null;
				j--;
				
			}
			else if(grid[i][j].getValue() == grid[i][notNull].getValue()){
				grid[i][j].moveAndsetValue();
				grid[i][notNull].moveAndDestroy(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
					
				
			}
				
			else{
				grid[i][j] = grid[i][notNull];
				grid[i][notNull].move((j + 1) *CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				grid[i][notNull] = null;
			
			}
			break;
			
			
		}
			
	}
	
	public void moveDown(){

		int notNull;
		
		for (int j = 0; j < DIMENSION; j++)
		for (int i = DIMENSION -1 ; i > 0; i--)
		for(notNull = i-1; notNull >= 0; notNull--) if( grid[notNull][j] != null){
			
			if(grid[i][j] == null){
				grid[notNull][j].move(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				grid[i][j] = grid[notNull][j];
				grid[notNull][j] = null;
				i++;
				
			}
			else if(grid[i][j].getValue() == grid[i][notNull].getValue()){
				grid[i][j].moveAndsetValue();
				grid[notNull][j].moveAndDestroy(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				
			}
				
			else{
				grid[i][j] = grid[i][notNull];
				grid[notNull][j].move(j*CELL_DIMENSION + X_OFFSET, (i+1)*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				grid[notNull][j] = null;
			
			}
			break;
			
			
		}
			
	}
	
	public void step(){
		
		for (int i = 0; i < DIMENSION; i++){
			

			System.out.println();
			for(int j = 0; j < DIMENSION ; j++){
				
				if(grid[i][j] == null) System.out.print("n");
				else System.out.print(grid[i][j].getValue());
				
				
			}
		}
		System.out.println("----------------");
		
		drawables.clear();
		
		for (int i = 0; i < DIMENSION; i++)
		for(int j = 0; j < DIMENSION ; j++)if(grid[i][j] != null){
				
			if(grid[i][j].destroyMe) grid[i][j] = null;
			
			else{
				grid[i][j].step();
				drawables.add(grid[i][j].getDrawable());
			}
		
		}
		
		
	}
	
	public ArrayList<Drawable> getDrawables(){
		return drawables;
	}


	public boolean somethingIsMoving() {
		for (int i = 0; i < DIMENSION; i++)
		for(int j = 0; j < DIMENSION ; j++)if(grid[i][j] != null){
			
			if(grid[i][j].isMoving())return false;
			
		}
		
		return true;
	}



}
