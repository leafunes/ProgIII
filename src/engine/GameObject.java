package engine;

public abstract class GameObject {
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	private Drawable drawable;
	
	public GameObject(int x, int y, int width, int height){
		this.posX = x;
		this.posY = y;
		
		this.width = width;
		this.height = height;
		this.drawable = new Drawable(this.posX, this.posY);
	}
	
	public void move(int x, int y, boolean absolute){
		if(absolute){
			this.posX = x;
			this.posY = y;
		}
		
		else{
			this.posX += x;
			this.posY += y;
		}
		
	}
	
	public Drawable draw(){
		
		
	}
	
	public abstract void step();
	
	

}
