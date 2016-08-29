package engine;

import java.util.ArrayList;

public class Game {
	
	private ArrayList<GameRoom> rooms;
	private int currentRoomPtr;
	private GameRoom currentRoom;
	
	public Game(GameRoom mainRoom){
		this.currentRoom = mainRoom;
		this.rooms = new ArrayList<>();
		this.rooms.add(mainRoom);
		
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
		this.currentRoom.step();
		
	}

}
