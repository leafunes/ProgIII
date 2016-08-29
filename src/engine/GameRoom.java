package engine;

import java.util.ArrayList;

public class GameRoom {
	
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
	}
	
	public ArrayList<Drawable> getDrawables(){
		return this.drawables;
	}

}
