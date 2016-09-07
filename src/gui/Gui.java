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
import java.awt.Font;
import java.awt.Panel;

public class Gui{

	private JFrame frmUngs;
	private Game2048 newGame = new Game2048();
	private static Gui window;
	
	NewJPanel panel;
	NewJPanel panelBackground;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Gui();
					
					window.frmUngs.setVisible(true);
					
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
		frmUngs = new JFrame();
		frmUngs.setResizable(false);
		frmUngs.setTitle("2048 UNGS");
		
		frmUngs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == 39)
					newGame.eventKeyPress(Key.K_RIGHT);
				else if(e.getKeyCode() == 37)
					newGame.eventKeyPress(Key.K_LEFT);
				else if(e.getKeyCode() == 38)
					newGame.eventKeyPress(Key.K_UP);
				else if(e.getKeyCode() == 40)
					newGame.eventKeyPress(Key.K_DOWN);
			}
			
		});
		frmUngs.setBounds(100, 100, 600, 450);
		frmUngs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUngs.getContentPane().setLayout(null);
		
		panel = new NewJPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent click) {
				newGame.eventClick(click.getX(),click.getY());
			}
		});
		panel.setBounds(0, 0, 598, 421);
		panel.setFont(new Font("Open Sans", Font.BOLD, 18));
		frmUngs.getContentPane().add(panel);
		
		panelBackground = new NewJPanel();
		panelBackground.setBounds(0, 0, 598, 421);
		frmUngs.getContentPane().add(panelBackground);
		
		  new javax.swing.Timer(30, new ActionListener() {
			     public void actionPerformed(ActionEvent e) {
			    	 newGame.step(); //actualizo el juego
			        
			     }
			  }).start();
		
		  new javax.swing.Timer(50, new ActionListener() {
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
		
		//le pido al juego en curso cuales son sus drawables
		drawablesList=newGame.getDrawables();
		//toDraw no es un indice sino algo de tipo drawable, que tiene un frame, un x e y
		//recorro el arreglo de drawables y los voy dibujando

		
		if(newGame.backgroundHasChanged()){
			Drawable background = newGame.getBackground();
			Graphics gBack = window.panelBackground.getGraphics();
			
			window.panelBackground.paint(gBack);
			
			if(background != null){
				
				window.panelBackground.paintImage(g, background.actualFrame, 0, 0);
				
			}
		}
		
		
		//Se borra las imagenes anteriores
		this.panel.paint(g);
		
		for (Drawable toDraw : drawablesList){
			window.panel.paintImage(g, toDraw.actualFrame, toDraw.x, toDraw.y);
			window.panel.paintText(g, toDraw.string, toDraw.xStr, toDraw.yStr);
		}
		

	}
}


