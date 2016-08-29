package misc;

import java.util.ArrayList;

public class Grid<T> {
	
	private ArrayList< ArrayList<T> > matrix;
	private ArrayList< ArrayList<T> > matrixTransp;
	private ArrayList< ArrayList<T> > matrixReverse;
	private ArrayList< ArrayList<T> > matrixTranspReverse;
	private int cols;
	private int rows;
	
	public Grid(int rows, int cols){
		
		this.cols = cols;
		this.rows = rows;
		
		this.matrix = new ArrayList< ArrayList<T> >(rows);
		this.matrixTransp = new ArrayList< ArrayList<T> >(rows);
		this.matrixReverse = new ArrayList< ArrayList<T> >(rows);
		this.matrixTranspReverse = new ArrayList< ArrayList<T> >(rows);
		
		for (int i = 0; i< rows; i++){
			
			this.matrix.add(new ArrayList<T>(cols));
			this.matrixTransp.add(new ArrayList<T>(cols));
			this.matrixReverse.add(new ArrayList<T>(cols));
			this.matrixTranspReverse.add(new ArrayList<T>(cols));
			
			for(int j = 0; j < cols; j++){
				
				this.matrix.get(i).add(null);
				this.matrixTransp.get(i).add(null);
				this.matrixReverse.get(i).add(null);
				this.matrixTranspReverse.get(i).add(null);
			
			}
		}
	}
	
	public void put(int i, int j, T obj){
		this.checkBounds(i, j);
		
		this.matrix.get(i).set(j, obj);
		
	}
	
	public void remove(int i, int j){
		this.checkBounds(i, j);
		
		this.matrix.get(i).set(j, null);
	}
	
	public boolean isEmpty(int i, int j){
		this.checkBounds(i, j);
		
		return this.matrix.get(i).get(j) == null;
	}
	
	public ArrayList<ArrayList <T> > getRows(){
		return this.matrix;
	}
	
	public ArrayList<ArrayList <T> > getRowsReverse(){
		return this.matrixReverse;
	}
	
	public ArrayList<ArrayList <T> > getColumns(){
		return this.matrixTransp;
	}
	
	public ArrayList<ArrayList <T> > getColumnsReverse(){
		return this.matrixTranspReverse;
	}
	
	public void checkBounds(int i, int j){
		if(i < 0 || j < 0 || i >= this.rows || j >= this.cols)
			throw new IllegalArgumentException("Out of bounds: " + i + ", "+ j);
	}

}
