package engine;

public abstract class GameObject {
	
	private int posX;
	private int posY;
	
	private int xDest;
	private int yDest;
	private int velocity;
	
	public boolean isMoving;
	
	private int width;
	private int height;
	
	private Drawable drawable;
	
	public GameObject(int x, int y, int width, int height){
		this.posX = x;
		this.posY = y;
		
		this.isMoving = false;
		
		this.width = width;
		this.height = height;
		this.drawable = new Drawable(this.posX, this.posY);
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
	
	public Drawable getDrawable(){
		return this.drawable;
		
	}
	
	public void step(){
		if(this.isMoving)
			this.actualizePosition();
		
		this.drawable.actualize(this.posX, this.posY);
		
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
				delta = Math.toRadians( Math.signum(distY) * 90 );
			else if(distY == 0)
				delta = Math.toRadians( Math.signum(distX) > 0? 0:180 );
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
	
	public abstract void behavior();
	
	

}
