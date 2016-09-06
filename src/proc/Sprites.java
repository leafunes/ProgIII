package proc;

import java.io.File;

import engine.Sprite;

//En esta clase se guardan todos los sprites 
//para que todos los objetos puedan hacer uso de ellos



public class Sprites {
	private final static String spritesPath = "."+File.separator+"sprites"+File.separator;
	
	public static Sprite cell = new Sprite(spritesPath + "cell" ,1);;
	public static Sprite startButton = new Sprite(spritesPath + "startButton" ,1);

}
