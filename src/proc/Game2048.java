package proc;

import java.awt.image.BufferedImage;

import engine.Game;
import engine.GameRoom;

public class Game2048 extends Game {

	public Game2048() {
		
		super();
		GameRoom mainRoom = new MainRoom(64, 4, 170, 123);
		GameRoom menu = new MenuRoom();
		super.addRoom(mainRoom,0);
		super.addRoom(menu,1);
		super.changeRoom(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		
	}

}
