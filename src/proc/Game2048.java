package proc;

import engine.Game;
import engine.GameRoom;

public class Game2048 extends Game {

	public Game2048() {
		
		super();
		GameRoom mainRoom = new MainRoom(64, 4, 0, 0);
		super.addRoom(mainRoom,0);
		super.changeRoom(0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		
	}

}
