package engine;

import java.util.ArrayList;

public abstract class Game {
	
	private ArrayList<GameRoom> rooms;
	public boolean isGameOver;
	private GameRoom currentRoom;
	
	public Game(GameRoom mainRoom){
		this.currentRoom = mainRoom;
		this.rooms = new ArrayList<>();
		this.rooms.add(mainRoom);
		
	}
	
	public Game(){
		this.rooms = new ArrayList<>();
		
	}
	
	public void addRoom(GameRoom room, int pos){
		this.rooms.add(pos, room);
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
		this.behavior();
		this.currentRoom.step();
		
	}
	
	public void eventKeyPress(Key k){
		this.currentRoom.eventKeyPress(k);
	}
	
	public abstract void behavior();
}
