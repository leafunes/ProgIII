package proc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import engine.Drawable;
import objects.Cell;

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
	private int score;
	
	private enum direction{RIGTH, LEFT, UP, DOWN};
	
	
	public Grid(int dimension, int xOffset, int yOffset, int cellDimension){
		

		this.grid = new Cell[dimension][dimension];
		
		this.gen = new Random();
		this.toDestroy = new HashSet<>();
		
		this.DIMENSION = dimension;
		this.X_OFFSET = xOffset;
		this.Y_OFFSET = yOffset;
		this.CELL_DIMENSION = cellDimension;
		
		//Se agregan las celdas iniciales
		this.addCells(2);
		
	}
	
	public void step(){
		
		drawables.clear();
		
		actualizeDrawables();
		
		if(this.somethingActualized && !somethingIsMoving()){
			addCells(1);
			this.somethingActualized = false;
		}
		
		
	}
	
	public void moveRigth(){
		
		for (int i = 0; i < DIMENSION; i++){
			moveCell(i, 0, direction.RIGTH);
			combineCell(i, DIMENSION - 1, direction.RIGTH);
			moveCell(i, 0, direction.RIGTH);
		}
			
	}
	
	public void moveLeft(){
		
		for (int i = 0; i < DIMENSION; i++){
			moveCell(i, DIMENSION -1 , direction.LEFT);
			combineCell(i, 0, direction.LEFT);
			moveCell(i, DIMENSION -1 , direction.LEFT);
		}
			
	}
	
	public void moveUp(){
		
		for (int j = 0; j < DIMENSION; j++){
			moveCell(DIMENSION - 1, j, direction.UP);
			combineCell(0, j, direction.UP);
			moveCell(DIMENSION - 1, j, direction.UP);
		}
			
	}
	
	public void moveDown(){
		
		for (int j = 0; j < DIMENSION; j++){
			moveCell(0, j, direction.DOWN);
			combineCell(DIMENSION - 1, j, direction.DOWN);
			moveCell(0, j, direction.DOWN);
		}
			
	}
	
	private void actualizeDrawables(){
		
		//Actualizo los drawables de la matriz
		for (int i = 0; i < DIMENSION; i++)
			for(int j = 0; j < DIMENSION ; j++)if(grid[i][j] != null){	
					grid[i][j].step();
					drawables.add(grid[i][j].getDrawable());
			}
			
		//Actualizo los drawables de los objetos que se van a destruir
			for (Iterator<Cell> i = toDestroy.iterator(); i.hasNext();) {
			    Cell cell = i.next();
				cell.step();
				
				if(cell.destroyMe){
					i.remove();//Elimino la Cell de la lista
				}
				
				else drawables.add(cell.getDrawable());
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
			newI = i;
			newJ = j + 1;
			break;
		case LEFT:
			newI = i;
			newJ = j - 1;
			break;
		//Itero por fila
		case DOWN:
			newI = i + 1;
			newJ = j;
			break;
		case UP:
			newI = i - 1;
			newJ = j ;
			break;
		}
		
		//Out of bounds
		if(outOfBounds(newI, newJ))return false;
		
		//Si soy nulo muevo la celda siguiente
		if(isEmpty(i, j))return moveCell(newI, newJ, dir);
		
		//Si la siguiente es nula, o la siguiente se puede mover, me muevo
		if(isEmpty(newI, newJ) || moveCell(newI, newJ, dir)){
			
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
			newI = i;
			newJ = j - 1;
			break;
		case LEFT:
			newI = i;
			newJ = j + 1;
			break;
		//Itero por fila
		case DOWN:
			newI = i - 1;
			newJ = j;
			break;
		case UP:
			newI = i + 1;
			newJ = j ;
			break;
		}
		
		
		if(!outOfBounds(newI, newJ)){
			if(grid[i][j] != null && grid[newI][newJ] != null && grid[newI][newJ].getValue() == grid[i][j].getValue()){
				//Si la celda sobre la que estoy coincide en valor con la celda vecina
					
				score += grid[i][j].getValue()*2;
				
				//Muevo la celda graficamente, cuando se termine de mover esta sera destruida
				Cell cell = grid[newI][newJ];
				cell.moveAndDestroy(j*CELL_DIMENSION + X_OFFSET, i*CELL_DIMENSION + Y_OFFSET, CELL_VEL);
				this.toDestroy.add(cell);
				
				//Destruyo la celda de la matriz
				grid[newI][newJ] = null;
				
				//Actualizo los valores de la celda actual
				grid[i][j].setValue();
				
				this.somethingActualized = true;
				
			}
			
			combineCell(newI, newJ, dir);//Se combina la celda vecina
			
		}
		
	}
	
	private void addCells(int howMany){

		int counter = 0;
		
		do{
			int randI = gen.nextInt(DIMENSION);
			int randJ = gen.nextInt(DIMENSION);
			int cellValue = (gen.nextInt(2)*2)+2;
			
			if(isEmpty(randI, randJ)){
				grid[randI][randJ] = new Cell(randJ*CELL_DIMENSION + X_OFFSET, randI * CELL_DIMENSION + Y_OFFSET, cellValue);
				counter++;
			}
			
		}while(counter < howMany );
		
		
	}

	public boolean somethingIsMoving() {
		
		for(Cell cell : this.toDestroy)if(cell.isMoving()) return true;
		
		for (int i = 0; i < DIMENSION; i++)
		for(int j = 0; j < DIMENSION ; j++)if(grid[i][j] != null){
			
			if(grid[i][j].isMoving())return true;
			
		}
		
		return false;
	}
	
	private boolean outOfBounds(int i, int j) {
		return j >= DIMENSION  || j < 0 || i >= DIMENSION || i < 0;
	}

	private boolean isEmpty(int i, int j) {
		return grid[i][j] == null;
	}

	public ArrayList<Drawable> getDrawables(){
		return drawables;
	}

	public int getScore() {
		return this.score;
	}

}
