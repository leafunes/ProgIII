package rooms;

import data.GlobalVariables;
import data.Scores;
import engine.Drawable;
import engine.GameObject;
import engine.GameRoom;
import engine.Key;
import objects.Buttons;
import proc.Grid;
import proc.Sprites;

public class MainRoom extends GameRoom {
	
	private Grid grid;
	private Drawable score;
	private int scorePoints;
	
	private int gridDimension;
	private int xOffset;
	private int yOffset;
	private int cellDimension;
	

	public MainRoom(int cellDimenson, int gridDimension, int xOffset, int yOffset) {
		super(600, 450);
		
		this.cellDimension = cellDimenson;
		
		this.gridDimension = gridDimension;
		
		this.xOffset = xOffset;
		
		this.yOffset = yOffset;
		
		background = new Drawable(0, 0,-1, Sprites.mainBackgrounds.get(gridDimension));
		
	}

	@Override
	public void behavior() {
		grid.step();
		
		scorePoints = grid.getScore();
		
		score.actualizeText(450,65, String.valueOf(scorePoints));
		
		this.drawables.addAll(grid.getDrawables());
		this.drawables.add(score);
		
	}
		

	@Override
	public void eventKeyPress(Key k) {
		if(!grid.somethingIsMoving()){
			
			switch(k){
				case K_RIGHT:
					grid.moveRigth();
					break;
					
				case K_LEFT:
					grid.moveLeft();
					break;
					
				case K_UP:
					grid.moveUp();
					break;
					
				case K_DOWN:
					grid.moveDown();
					break;
					
				default:
					break;
			}
		}
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
	public boolean isGameOver() {
		return grid.isGameOver();
	}


	@Override
	public void exitRoomEvent() {

		Scores.putScore(scorePoints);
		
		this.grid = null;;
		this.score = null;
		
		
		this.objects.clear();
		
	}


	@Override
	public void enterRoomEvent() {
		
		addObject(new Buttons.MenuButton(480, 380));
		
		this.grid = new Grid(gridDimension,xOffset,yOffset,cellDimension);
		this.score = new Drawable(0, 0, 0,null);
		this.score.actualizeFont(GlobalVariables.largeFont);
		
	}

	@Override
	public void gameOverEvent() {
		addObject(new Buttons.GameOverButton(70, 70));
		
		Scores.putScore(scorePoints);
		
	}

}
