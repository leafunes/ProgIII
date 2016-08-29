package misc;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {
	

	@Test
	public void addTest() {
		Grid <Integer> grid = new Grid<>(4,4);
		
		assertTrue(grid.isEmpty(0, 0));
		grid.put(0,0,1);
		assertFalse(grid.isEmpty(0, 0));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void outOfBoundsTest() {
		Grid <Integer> grid = new Grid<>(4,4);
		
		assertTrue(grid.isEmpty(-1, -1));
		
	}
	
	@Test
	public void removeTest(){
		
		Grid <Integer> grid = new Grid<>(4,4);
		
		grid.put(0,0,1);
		grid.remove(0, 0);
		assertTrue(grid.isEmpty(0, 0));
		
	}

}
