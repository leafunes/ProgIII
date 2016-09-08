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
		super.addRoom(mainRoom,0);
		super.addRoom(menu,1);
		super.addRoom(scores,2);
		super.changeRoom(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		
	}

}
