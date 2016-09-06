package proc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import engine.Drawable;

public class Grid {
	
	private Cell grid[][];
	private HashSet<Cell> toDestroy;
	
	private Random gen;
	
	private boolean somethingActualized;
	private final int DIMENSION;
	private final int X_OFFSET;
	private final int Y_OFFSET;
	private final int CELL_DIMENSION;
	private final int CELL_VEL = 15;
	ArrayList<Drawable> drawables = new ArrayList<>();
	
	private enum direction{RIGTH, LEFT, UP, DOWN};
	
	
	public Grid(int dimension, int xOffset, int yOffset, int cellDimension){
		
		this.gen = new Random();
		this.toDestroy = new HashSet<>();
		this.grid = new Cell[dimension][dimension];
		this.DIMENSION = dimension;
		this.X_OFFSET = 10;
		this.Y_OFFSET = 10;
		this.CELL_DIMENSION = cellDimension;
		
		this.addCells(4);
		
	}
	
	private void addCells(int howMany){
		
		int randI = gen.nextInt(DIMENSION);
		int randJ = gen.nextInt(DIMENSION);
		int cellValue = (gen.nextInt(1)*2)+2;
		
		int counter = 0;
		
		while(counter < howMany ){
			if(grid[randI][randJ] == null){
				grid[randI][randJ] = new Cell(randJ*CELL_DIMENSION + X_OFFSET, randI * CELL_DIMENSION + Y_OFFSET, cellValue);
				counter++;
			}
			else{
				randI = gen.nextInt(DIMENSION);
				randJ = gen.nextInt(DIMENSION);
			}
		}
		
		
	}
	
	private boolean moveCell(int i, int j, direction dir){
		int newI = 0;
		int newJ = 0;
		
		//Se busca la posicion de la"Siguiente" celda. 
		//esta depende de en que direccion me este moviendo
		
		switch(dir){
		//Itero por columna
		case RIGTH:
			//Para adelante
			newI = i;
			newJ = j + 1;
			break;
		case LEFT:
			//apara atras
			newI = i;
			newJ = j - 1;
			break;
		//Itero por fila
		case DOWN:
			//Para abajo
			newI = i + 1;
			newJ = j;
			break;
		case UP:
			//para arriba
			newI = i - 1;
			newJ = j ;
			break;
		}
		
		//Out of bounds
		if(newJ >= DIMENSION  || newJ < 0 || newI >= DIMENSION || newI < 0)return false;
		
		//Si soy nulo muevo la celda siguiente
		if(grid[i][j] == null)return moveCell(newI, newJ, dir);
		
		//Si la siguiente es nula, o la siguiente se puede mover, me muevo
		if(grid[newI][newJ] == null || moveCell(newI, newJ, dir)){
			
			//Se mueve la celda graficamente
			grid[i][j].move(newJ*CELL_DIMENSION + X_OFFSET, newI*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
			
			//Se actualiza la matriz
			grid[newI][newJ] = grid[i][j];
			grid[i][j] = null;
			
			//Se mueve la celda de alado
			moveCell(newI, newJ, dir);
			this.somethingActualized = true;
			return true;
		}
		
		
		else return false;
		
		
	}
	
	private void combineCell(int i, int j, direction dir){
		int newI = 0;
		int newJ = 0;
		
		//Se busca la posicion de la"Siguiente" celda. 
		//esta depende de en que direccion me este moviendo
		
		switch(dir){
		//Itero por columna
		case RIGTH:
			//Para adelante
			newI = i;
			newJ = j - 1;
			break;
		case LEFT:
			//apara atras
			newI = i;
			newJ = j + 1;
			break;
		//Itero por fila
		case DOWN:
			//Para abajo
			newI = i - 1;
			newJ = j;
			break;
		case UP:
			//para arriba
			newI = i + 1;
			newJ = j ;
			break;
		}
		
		//Out of bounds
		if(!(newJ >= DIMENSION  || newJ < 0 || newI >= DIMENSION || newI < 0)){
			if(grid[i][j] != null && grid[newI][newJ] != null){
				if(grid[newI][newJ].getValue() == grid[i][j].getValue()){
					
					Cell cell = grid[newI][newJ];
					cell.moveAndDestroy(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
					
					this.toDestroy.add(cell);
					grid[newI][newJ] = null;
					
					grid[i][j].setValue();
					this.somethingActualized = true;
				}
			}
			
			combineCell(newI, newJ, dir);
			
		}
		
	}
	
	public void moveRigth(){
		
		for (int i = 0; i < DIMENSION; i++){
			moveCell(i, 0, direction.RIGTH);
			combineCell(i, DIMENSION - 1, direction.RIGTH);
			moveCell(i, 0, direction.RIGTH);
		}
			
	}
	
	public void moveUp(){
		
		for (int j = 0; j < DIMENSION; j++){
			moveCell(DIMENSION - 1, j, direction.UP);
			combineCell(0, j, direction.UP);
			moveCell(DIMENSION - 1, j, direction.UP);
		}
			
	}
	
	
	public void moveLeft(){
		
		for (int i = 0; i < DIMENSION; i++){
			moveCell(i, DIMENSION -1 , direction.LEFT);
			combineCell(i, 0, direction.LEFT);
			moveCell(i, DIMENSION -1 , direction.LEFT);
		}
			
	}
	
	public void moveDown(){
		
		for (int j = 0; j < DIMENSION; j++){
			moveCell(0, j, direction.DOWN);
			combineCell(DIMENSION - 1, j, direction.DOWN);
			moveCell(0, j, direction.DOWN);
		}
			
	}
	
	public void step(){
		
		drawables.clear();
		
		for (int i = 0; i < DIMENSION; i++)
		for(int j = 0; j < DIMENSION ; j++)if(grid[i][j] != null){	
				grid[i][j].step();
				drawables.add(grid[i][j].getDrawable());
		}
		
		for (Iterator<Cell> i = toDestroy.iterator(); i.hasNext();) {
		    Cell cell = i.next();
			cell.step();
			if(cell.destroyMe){
				i.remove();
			}
			else drawables.add(cell.getDrawable());
		}
		
		if(this.somethingActualized && !somethingIsMoving()){
			addCells(1);
			this.somethingActualized = false;
		}
		
		
	}
	
	public ArrayList<Drawable> getDrawables(){
		return drawables;
	}


	public boolean somethingIsMoving() {
		
		for(Cell cell : this.toDestroy)if(cell.isMoving()) return false;
		
		for (int i = 0; i < DIMENSION; i++)
		for(int j = 0; j < DIMENSION ; j++)if(grid[i][j] != null){
			
			if(grid[i][j].isMoving())return false;
			
		}
		
		return true;
	}



}
