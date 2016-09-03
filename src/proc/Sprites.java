package proc;

import java.io.File;

import engine.Sprite;

//En esta clase se guardan todos los sprites 
//para que todos los objetos puedan hacer uso de ellos

final class CellSprite extends Sprite{
	
	private final static String spritesPath = "."+File.separator+"sprites"+File.separator;

	public CellSprite() {
		super(spritesPath + "cell" ,1);
	}
	
}
public class Sprites {
	
	static CellSprite cellSprite = new CellSprite();

}
