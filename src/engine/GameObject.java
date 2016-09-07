package engine;

import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int posX;
	protected int posY;

	public boolean destroyMe;
	public boolean changeRoom;
	public int roomNumber;
	
	private int xDest;
	private int yDest;
	private int velocity;
	
	public Rectangle collisionShape;
	
	private boolean isMoving;
	
	protected int width;
	protected int height;
	
	protected Drawable drawable;
	
	public GameObject(int x, int y, int zIndex, int width, int height, Sprite spr){
		this.posX = x;
		this.posY = y;
		
		this.isMoving = false;
		this.destroyMe = false;
		
		this.width = width;
		this.height = height;
		
		this.collisionShape = new Rectangle(x, y, width, height);
		
		this.drawable = new Drawable(this.posX, this.posY, zIndex,spr);
	}
	
	public GameObject(int x, int y, int width, int height, Sprite spr){
		this(x, y, 1, width, height, spr);
	}
	
	public void translate(int x, int y, boolean absolute){
		if(absolute){
			this.posX = x;
			this.posY = y;
		}
		
		else{
			this.posX += x;
			this.posY += y;
		}
		
	}
	
	public void move(int x, int y, int velocity){
		
		if(velocity < 0)
			throw new IllegalArgumentException("La velocidad no puede ser negativa");
		
		this.xDest = x;
		this.yDest = y;
		this.velocity = velocity;
		
		this.isMoving = true;
	}
	
	public void stopMoving(){
		this.xDest = this.posX;
		this.yDest = this.posY;
	}
	
	public Drawable getDrawable(){
		return this.drawable;
		
	}
	
	public void step(){
		if(this.isMoving)
			this.actualizePosition();
		
		this.drawable.actualizePosition(this.posX, this.posY);
		
		//TODO: Hay que agregarle un speed
		this.drawable.nextFrame();
		
		this.behavior();
		
	}
	
	private void actualizePosition(){
		int distX = this.posX - this.xDest;
		int distY = this.posY - this.yDest;
		
		double delta = 0;
		
		if(distX == 0 && distY == 0){
			this.isMoving = false;
		}
		else{
			if(distX == 0)
				delta = Math.toRadians( Math.signum(distY) * -90 );
			else if(distY == 0)
				delta = Math.toRadians( Math.signum(distX) > 0? 180:0 );
			else{
				delta = Math.atan( (float)(distX/distY) );
				
			}
			
			double velX = Math.cos(delta);
			double velY = Math.sin(delta);
			
			int nextPosX = (int) (this.posX + (velX * this.velocity));
			int nextPosY = (int) (this.posY + (velY * this.velocity));
			
			int nextDistX = nextPosX - this.xDest;
			int nextDistY = nextPosY - this.yDest;
			
			if( Math.abs(nextDistX) < Math.abs(distX) )
				this.posX = nextPosX;
			else
				this.posX = this.xDest;
			
			if( Math.abs(nextDistY) < Math.abs(distY) )
				this.posY = nextPosY;
			else
				this.posY = this.yDest;
		}
		
	}
	
	public void changeRoom(int pos){
		this.changeRoom = true;
		this.roomNumber = pos;
	}
	
	public boolean isMoving(){
		return this.isMoving;
	}
	
	public abstract void behavior();

	public abstract void collisionEvent(GameObject other);
	
	public abstract void eventKeyPress(Key k);
	
	public abstract void eventClick();
	

}
