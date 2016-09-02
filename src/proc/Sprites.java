package proc;

import engine.Sprite;

//En esta clase se guardan todos los sprites 
//para que todos los objetos puedan hacer uso de ellos

final class CellSprite extends Sprite{

	public CellSprite() {
		super(".\\sprites\\cell", 1);
	}
	
}
public class Sprites {
	
	static CellSprite cellSprite = new CellSprite();

}
