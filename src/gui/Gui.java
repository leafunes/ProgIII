package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import engine.Drawable;
import proc.Game2048;

public class Gui {

	private JFrame frame;
	private Game2048 newGame = new Game2048();
	NewJPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
					
					window.mainLoop();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Gui() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new NewJPanel();
		panel.setBounds(12, 12, 424, 251);
		frame.getContentPane().add(panel);
		
		
	}
	
	private void mainLoop() throws IOException, InterruptedException{
		//Aca se hace el while true, haciendo los steps del game2048
		
		Graphics g = this.panel.getGraphics();
		
		//creo un arreglo donde voy a guardar todos los drawables a dibujar
		ArrayList<Drawable> drawablesList= new ArrayList<>();
		
		while(true){
			newGame.step(); //actualizo el juego

			//le pido al juego en curso cuales son sus drawables
			drawablesList=newGame.getDrawables();
			System.out.println(drawablesList.size());
			//toDraw no es un indice sino algo de tipo drawable, que tiene un frame, un x e y
			//recorro el arreglo de drawables y los voy dibujando
			for (Drawable toDraw : drawablesList){
				
				
				this.panel.paintImage(g, toDraw.actualFrame, toDraw.x, toDraw.y);
			}
			
			Thread.sleep(33);
			
			this.panel.actualize(g);
			
		}
		

	}
}
