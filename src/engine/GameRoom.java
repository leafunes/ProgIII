package engine;

import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class GameRoom {
	
	public boolean changeRoom;
	public int roomNumber;
	
	protected ArrayList<GameObject> objects;
	protected ArrayList<Drawable> drawables;
	private int width;
	private int height;
	
	public GameRoom(int width, int height){
		this.width = width;
		this.height = height;
		
		this.objects = new ArrayList<>();
		this.drawables = new ArrayList<>();
	}
	
	public void addObject(GameObject obj){
		this.objects.add(obj);
		this.drawables.add(obj.getDrawable());
	}
	
	public void step(){
		this.drawables.clear();
		for (GameObject obj:this.objects){
			obj.step();
			
			if(obj.changeRoom){
				this.changeRoom = true;
				this.roomNumber = obj.roomNumber;
			}
			
			this.drawables.add(obj.getDrawable());
		}
		this.checkCollision();
		this.behavior();
	}
	
	public ArrayList<Drawable> getDrawables(){
		return this.drawables;
	}
	
	public void destroyObject(GameObject object){
		
		this.objects.remove(object);
		object = null;
		
	}
	
	private void checkCollision(){
		
		for (int i = 0; i < this.objects.size(); i++){
			
			GameObject obj = this.objects.get(i);
			Rectangle objRec =  obj.collisionShape;
			
			for (GameObject other : this.objects.subList(i, this.objects.size())){
				
				Rectangle otherRec = other.collisionShape;
						
				if(objRec.intersects(otherRec)){
					obj.collisionEvent(other);
					other.collisionEvent(obj);
				}
	
				
			}
		}
	}
	
	public abstract void behavior();
	
	public abstract void eventKeyPress(Key k);
	
	public abstract boolean isGameOver();
	
	public abstract void eventClick(int x, int y);
	
	public abstract void init();

}
