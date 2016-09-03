package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import engine.Drawable;
import engine.Key;
import proc.Game2048;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui{

	private JFrame frame;
	private Game2048 newGame = new Game2048();
	private static Gui window;
	
	NewJPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Gui();
					
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
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent click) {
				newGame.eventClick(click.getX(),click.getY());
				
			}
		});
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				newGame.eventKeyPress(Key.K_RIGHT);
			}
			
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new NewJPanel();
		panel.setBounds(0, 0, 442, 273);
		frame.getContentPane().add(panel);
		
		  new javax.swing.Timer(10, new ActionListener() {
			     public void actionPerformed(ActionEvent e) {

			        try {
						mainLoop();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     }
			  }).start();
		
	}
	
	private void mainLoop() throws InterruptedException{
		
		Graphics g = window.panel.getGraphics();
		
		//creo un arreglo donde voy a guardar todos los drawables a dibujar
		ArrayList<Drawable> drawablesList= new ArrayList<>();
		
			
		newGame.step(); //actualizo el juego
		
		
		//le pido al juego en curso cuales son sus drawables
		drawablesList=newGame.getDrawables();
		//toDraw no es un indice sino algo de tipo drawable, que tiene un frame, un x e y
		//recorro el arreglo de drawables y los voy dibujando
		for (Drawable toDraw : drawablesList){
			window.panel.paintImage(g, toDraw.actualFrame, toDraw.x, toDraw.y);
			window.panel.paintText(g, toDraw.string, toDraw.xStr, toDraw.yStr);
		}
		
		
		Thread.sleep(150);
		
		this.frame.repaint();

	}
}


