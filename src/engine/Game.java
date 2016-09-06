package engine;

import java.util.ArrayList;
import java.util.TreeMap;

public abstract class Game {
	
	private TreeMap<Integer,GameRoom> rooms;
	public boolean isGameOver;
	private GameRoom currentRoom;
	
	public Game(GameRoom mainRoom){
		this.currentRoom = mainRoom;
		this.rooms = new TreeMap();
		this.rooms.put(0,mainRoom);
		
	}
	
	public Game(){
		this.rooms = new TreeMap<>();
		
	}
	
	public void addRoom(GameRoom room, int pos){
		this.rooms.put(pos, room);
	}
	
	public void changeRoom(int pos){
		
		if(pos >= this.rooms.size())
			throw new ArrayIndexOutOfBoundsException("No existe el cuarto");
		
		this.currentRoom = this.rooms.get(pos);
	}
	
	public ArrayList<Drawable> getDrawables(){
		return this.currentRoom.getDrawables();
	}

	
	public void step(){
		this.isGameOver = this.currentRoom.isGameOver();
		
		if(this.currentRoom.changeRoom)changeRoom(currentRoom.roomNumber);
		
		this.behavior();
		this.currentRoom.step();
		
	}
	
	public void eventKeyPress(Key k){
		this.currentRoom.eventKeyPress(k);
	}
	
	public void eventClick(int x, int y){
		this.currentRoom.eventClick(x, y);
		
	}
	
	public abstract void behavior();
}
