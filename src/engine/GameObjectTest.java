package engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameObjectTest {

	@Test
	public void actualizePositionTest() {
		GameObject obj = new GameObject(10,10,1,1) {
			
			@Override
			public void behavior() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Drawable draw = obj.getDrawable();
		
		assertEquals(10, draw.x);
		assertEquals(10, draw.y);
		
		obj.move(50, 50, 1);
		
		for (int i = 0; i < 100; i++)
			obj.step();
		
		assertFalse(obj.isMoving);
		draw = obj.getDrawable();	
		assertEquals(50, draw.x);
		assertEquals(50, draw.y);
		
		obj.move(50, 100, 1);
		
		for (int i = 0; i < 100; i++)
			obj.step();
		
		assertFalse(obj.isMoving);
		draw = obj.getDrawable();	
		assertEquals(50, draw.x);
		assertEquals(100, draw.y);
		
		obj.move(0, 100, 1);
		
		for (int i = 0; i < 100; i++)
			obj.step();
		
		assertFalse(obj.isMoving);
		draw = obj.getDrawable();	
		assertEquals(0, draw.x);
		assertEquals(100, draw.y);
	}

}
