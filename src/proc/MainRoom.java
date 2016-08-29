package proc;

import java.util.Random;

import engine.GameRoom;

public class MainRoom extends GameRoom {
	
	private Random gen;

	public MainRoom() {
		super(800, 600);
		
		this.gen = new Random();
		//Crea los objetos iniciales
		
		this.init();
	}
	
	public MainRoom(Random gen) {
		super(800, 600);
		
		this.gen = gen;
		//Crea los objetos iniciales
		
		this.init();
	}
	
	@Override
	public void init(){
		
	}

	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		
	}

}
