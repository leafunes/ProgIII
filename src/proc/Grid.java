package proc;

import java.util.ArrayList;

import engine.Drawable;

public class Grid {
	
	private Cell grid[][];
	private final int DIMENSION;
	private final int X_OFFSET;
	private final int Y_OFFSET;
	private final int CELL_DIMENSION;
	ArrayList<Drawable> drawables = new ArrayList<>();
	
	
	public Grid(int dimension, int xOffset, int yOffset, int cellDimension){
		this.grid = new Cell[dimension][dimension];
		this.DIMENSION = dimension;
		this.X_OFFSET = xOffset;
		this.Y_OFFSET = yOffset;
		this.CELL_DIMENSION = cellDimension;
		
		this.grid[0][0] = new Cell((0)*CELL_DIMENSION + X_OFFSET, 0*CELL_DIMENSION + Y_OFFSET,2 ,Sprites.cellSprite);
		this.grid[0][2] = new Cell((2)*CELL_DIMENSION + X_OFFSET, 0*CELL_DIMENSION + Y_OFFSET,2,Sprites.cellSprite);
		this.grid[1][1] = new Cell((1)*CELL_DIMENSION + X_OFFSET, 1*CELL_DIMENSION + Y_OFFSET,2 ,Sprites.cellSprite);
		
	}
	
	
	public void moveRigth(){

		int notNull;
		
		for (int i = 0; i < DIMENSION; i++)
		for (int j = DIMENSION -1 ; j > 0; j--)
		for(notNull = j-1; notNull >= 0; notNull--) if( grid[i][notNull] != null){
			
			if(grid[i][j] == null){
				grid[i][notNull].move(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, 5);
				grid[i][j] = grid[i][notNull];
				grid[i][notNull] = null;
				j++;
				
			}
			else if(grid[i][j].getValue() == grid[i][notNull].getValue()){
				grid[i][j].moveAndsetValue();
				grid[i][notNull].moveAndDestroy(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, 5);
					
				
			}
				
			else{
				grid[i][j] = grid[i][notNull];
				grid[i][notNull].move((j - 1) *CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, 5);
				grid[i][notNull] = null;
			
			}
			break;
			
			
		}
		
		System.out.println("------");
		

		for (int i = 0; i < DIMENSION; i++){
			System.out.println();
			for(int j = 0; j < DIMENSION ; j++){
				if(grid[i][j] == null) System.out.print("n ");
				else System.out.print("2");
			}
		}
		
		
	}
	
	public void step(){
		
		drawables.clear();
		
		for (int i = 0; i < DIMENSION; i++)
		for(int j = 0; j < DIMENSION ; j++){
			if(grid[i][j] != null){
				
				if(grid[i][j].destroyMe) grid[i][j] = null;
				
				else{
					grid[i][j].step();
					drawables.add(grid[i][j].getDrawable());
				}
			}
		}
		
		
	}
	
	public ArrayList<Drawable> getDrawables(){
		return drawables;
	}



}
