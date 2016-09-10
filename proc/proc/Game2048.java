package proc;


import engine.Game;
import engine.GameRoom;
import rooms.MainRoom;
import rooms.MenuRoom;
import rooms.ScoresRoom;

public class Game2048 extends Game {

	public Game2048() {
		
		super();
		
		GameRoom mainRoom3 = new MainRoom(64, 3, 205, 185);
		GameRoom mainRoom4 = new MainRoom(64, 4, 170, 123);
		GameRoom mainRoom5 = new MainRoom(64, 5, 140, 103);
		
		GameRoom menu = new MenuRoom();
		GameRoom scores = new ScoresRoom();
		
		super.addRoom(0,mainRoom3);
		super.addRoom(1,mainRoom4);
		super.addRoom(2,mainRoom5);
		
		super.addRoom(3,menu);
		super.addRoom(4,scores);
		
		super.changeRoom(3);
	}

	@Override
	public void behavior() {}

}
