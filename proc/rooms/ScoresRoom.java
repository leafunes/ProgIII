package rooms;

import java.util.ArrayList;

import data.GlobalVariables;
import data.Scores;
import engine.Drawable;
import engine.GameObject;
import engine.GameRoom;
import engine.Key;
import objects.Buttons;
import objects.TextObject;
import proc.Sprites;

public class ScoresRoom extends GameRoom{

	public ScoresRoom() {
		super(600, 450);
		
		this.background = new Drawable(0, 0, -1, Sprites.scoresBackground);
	}

	@Override
	public void behavior() {}

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
	public void exitRoomEvent() {
		this.objects.clear();
		
	}

	@Override
	public void enterRoomEvent() {
		
		addObject(new Buttons.MenuButton(480, 380));
		
		ArrayList<Integer> scores = Scores.getScores();
		
		for (int i = 1; i <= scores.size(); i++) {
			
			addObject(new TextObject(330, 73 + (i*33), scores.get(i - 1).toString(), GlobalVariables.largeFont));
			addObject(new TextObject(200, 73 + (i*33), i + ".", GlobalVariables.largeFont));
			
		}
		
	}

	@Override
	public void gameOverEvent() {}

}
