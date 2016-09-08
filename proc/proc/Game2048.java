package proc;


import engine.Game;
import engine.GameRoom;
import rooms.MainRoom;
import rooms.MenuRoom;
import rooms.ScoresRoom;

public class Game2048 extends Game {

	public Game2048() {
		
		super();
		GameRoom mainRoom = new MainRoom(64, 4, 170, 123);
		GameRoom menu = new MenuRoom();
		GameRoom scores = new ScoresRoom();
		super.addRoom(0,mainRoom);
		super.addRoom(1,menu);
		super.addRoom(2,scores);
		super.changeRoom(1);
	}

	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		
	}

}
