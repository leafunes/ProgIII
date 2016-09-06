package proc;

import java.io.File;
import java.util.TreeMap;

import engine.Sprite;

//En esta clase se guardan todos los sprites 
//para que todos los objetos puedan hacer uso de ellos



public class Sprites {
	private final static String spritesPath = "."+File.separator+"sprites"+File.separator;
	
	public static TreeMap<Integer, Sprite> cells = new TreeMap<>();
	
	static{
		cells.put(2, new Sprite(spritesPath + "2Cell" ,1));
		cells.put(4, new Sprite(spritesPath + "4Cell" ,1));
		cells.put(8, new Sprite(spritesPath + "8Cell" ,1));
		cells.put(16, new Sprite(spritesPath + "16Cell" ,1));
		cells.put(32, new Sprite(spritesPath + "32Cell" ,1));
		cells.put(64, new Sprite(spritesPath + "64Cell" ,1));
		cells.put(128, new Sprite(spritesPath + "128Cell" ,1));
		cells.put(256, new Sprite(spritesPath + "256Cell" ,1));
		cells.put(512, new Sprite(spritesPath + "512Cell" ,1));
		cells.put(1024, new Sprite(spritesPath + "1024Cell" ,1));
		cells.put(2048, new Sprite(spritesPath + "2048Cell" ,1));
	}

	public static Sprite startButton = new Sprite(spritesPath + "startButton" ,1);
	
	public static Sprite mainBackground = new Sprite(spritesPath + "background" ,1);

}
