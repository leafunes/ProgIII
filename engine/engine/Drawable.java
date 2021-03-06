package engine;

import java.awt.Font;
import java.awt.image.BufferedImage;

import data.GlobalVariables;


public class Drawable implements Comparable<Drawable>{
	
	public int x;
	public int y;
	
	public BufferedImage actualFrame;
	
	public String string = "";
	public int xStr;
	public int yStr;
	public Font font;
	
	private Sprite sprite;
	private int spriteIndex;
	public int zIndex; 

	public Drawable(int x, int y, int zIndex, Sprite sprite){
		this.x = x;
		this.y = y;
		this.zIndex = zIndex;
		this.sprite = sprite;
		
		
		this.spriteIndex = 0;
		if(sprite != null)this.actualFrame = sprite.getFrame(0);
	
		this.font = GlobalVariables.defaultFont;
	
	}
	
	public void actualizeFont(Font font){
		
		this.font = font;
		
	}
	
	public void actualizePosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void actualizeZIndex(int z){
		this.zIndex = z;
	}
	
	public void actualizeText(int x, int y, String str){
		this.xStr = x;
		this.yStr = y;
		this.string = str;
	}
	
	public void actualizeSprite(Sprite spr){
		this.sprite = spr;
		this.spriteIndex = 0;
		this.actualFrame = sprite.getFrame(0);
		
	}
	
	protected void nextFrame(){
		if(this.sprite != null){
			
			if(this.spriteIndex == this.sprite.length())
				this.spriteIndex = 0;
		
			this.actualFrame = this.sprite.getFrame(this.spriteIndex);
		
		}
	}
	
	protected void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public boolean hasImage() {
		return this.sprite != null;
	}

	public boolean hasText() {
		return this.string != "";
	}

	@Override
	public int compareTo(Drawable other) {
		return  this.zIndex - other.zIndex;
	}
	

}
