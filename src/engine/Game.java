package engine;

import java.util.ArrayList;

public abstract class Game {
	
	private ArrayList<GameRoom> rooms;
	private int currentRoomPtr;
	public boolean isGameOver;
	private GameRoom currentRoom;
	
	public Game(GameRoom mainRoom){
		this.currentRoom = mainRoom;
		this.rooms = new ArrayList<>();
		this.rooms.add(mainRoom);
		
		this.currentRoomPtr = 0;
	}
	
	public Game(){
		this.rooms = new ArrayList<>();
		
		this.currentRoomPtr = 0;
	}
	
	public void addRoom(GameRoom room){
		this.rooms.add(room);
	}
	
	public void nextRoom(){
		this.currentRoomPtr++;
		
		if(this.currentRoomPtr >= this.rooms.size())
			throw new ArrayIndexOutOfBoundsException("No hay siguiente room");
		
		this.currentRoom = this.rooms.get(this.currentRoomPtr);
	}
	
	public ArrayList<Drawable> getDrawables(){
		return this.currentRoom.getDrawables();
	}

	
	public void step(){
		this.isGameOver = this.currentRoom.isGameOver();
		this.behavior();
		this.currentRoom.step();
		
	}
	
	public void eventKeyPress(Key k){
		this.currentRoom.eventKeyPress(k);
	}
	
	public abstract void behavior();
}
