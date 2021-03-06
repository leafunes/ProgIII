package engine;

import java.util.ArrayList;
import java.util.TreeMap;

public abstract class Game {
	
	private TreeMap<Integer,GameRoom> rooms;
	public boolean isGameOver;
	private GameRoom currentRoom;
	
	public Game(GameRoom mainRoom){
		this.currentRoom = mainRoom;
		this.rooms = new TreeMap<Integer,GameRoom>();
		this.rooms.put(0,mainRoom);
		
	}
	
	public Game(){
		this.rooms = new TreeMap<>();
		
	}
	
	public void addRoom(int pos, GameRoom room){
		this.rooms.put(pos, room);
	}
	
	public void changeRoom(int pos){
		
		if(!this.rooms.containsKey(pos))
			throw new ArrayIndexOutOfBoundsException("No existe el cuarto: " + pos);
		
		if(this.currentRoom != null)this.currentRoom.exitRoomEvent();
		
		this.currentRoom = this.rooms.get(pos);
		
		this.currentRoom.enterRoomEvent();
	}
	
	public ArrayList<Drawable> getDrawables(){
		return this.currentRoom.getDrawables();
	}

	
	public void step(){
		this.isGameOver = this.currentRoom.isGameOver();
		
		if(this.currentRoom.changeRoom){
			this.currentRoom.changeRoom = false;
			
			changeRoom(currentRoom.roomNumber);
		}
		
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
