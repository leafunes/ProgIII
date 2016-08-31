package engine;

import java.awt.image.BufferedImage;


public class Drawable {
	
	public int x;
	public int y;
	
	public BufferedImage actualFrame;
	
	private Sprite sprite;
	private int spriteIndex; 

	public Drawable(int x, int y, Sprite sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.spriteIndex = 0;
		this.actualFrame = sprite.getFrame(0);
	}
	
	public void actualizePosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	protected void nextFrame(){
		
		if(this.spriteIndex == this.sprite.length())
			this.spriteIndex = 0;
		
		this.actualFrame = this.sprite.getFrame(this.spriteIndex);
		
	}
	
	protected void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

}
