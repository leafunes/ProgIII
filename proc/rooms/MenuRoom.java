package rooms;

import engine.Drawable;
import engine.GameObject;
import data.GlobalVariables;
import engine.Key;
import proc.Sprites;

import objects.Buttons;
import objects.TextObject;

public class MenuRoom extends engine.GameRoom {

	
	Integer dimension = new Integer(4);
	private GameObject dimText = new TextObject(50, 50, dimension.toString(), GlobalVariables.largeFont);
	
	public MenuRoom() {
		super(600, 450);
		
		this.background = new Drawable(0, 0, -1, Sprites.menuBackground);
		
		addObject( new Buttons.StartButton(225, 250));
		addObject( new Buttons.ScoreButton(225, 350));
		addObject( new Buttons.RigthButton(375, 190));
		addObject( new Buttons.LeftButton(200, 190));
		addObject(dimText);
		
		
		
	}

	@Override
	public void behavior() {
		
		String dim = GlobalVariables.GRID_MENU_DIMENSION.toString();
		
		dimText.getDrawable().actualizeText(270, 215, dim + " x "+dim);
		
	}

	@Override
	public void eventKeyPress(Key k) {}

	@Override
	public boolean isGameOver() {
		return false;
	}

	@Override
	public void eventClick(int x, int y) {
		for(GameObject obj: objects){
			
			if(obj.collisionShape.contains(x, y)){
				obj.eventClick();
			}
			
		}
		
	}

	@Override
	public void exitRoomEvent() {}

	@Override
	public void enterRoomEvent() {
		GlobalVariables.GRID_MENU_DIMENSION = 4;
		
	}

	@Override
	public void gameOverEvent() {}


}
