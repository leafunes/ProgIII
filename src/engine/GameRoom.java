package engine;

import java.util.ArrayList;

public class GameRoom {
	
	private ArrayList<GameObject> objects;
	private int width;
	private int height;
	
	public GameRoom(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void addObject(GameObject obj){
		this.objects.add(obj);
	}
	
	public void step(){
		for (GameObject obj:this.objects){
			obj.step();
		}
	}
	
	public ArrayList<Drawable> getDrawables(){
		
	}

}
