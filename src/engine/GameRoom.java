package engine;

import java.util.ArrayList;

public abstract class GameRoom {
	
	private ArrayList<GameObject> objects;
	private ArrayList<Drawable> drawables;
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
		for (GameObject obj:this.objects){
			obj.step();
		}
		this.behavior();
	}
	
	public ArrayList<Drawable> getDrawables(){
		return this.drawables;
	}
	
	public abstract void behavior();
	
	public abstract void eventKeyPress(Key k);
	
	public abstract void eventClick(int x, int y);
	
	public abstract void init();

}
