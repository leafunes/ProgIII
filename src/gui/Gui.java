package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

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
		
		
		//Esto es un ejemplo de como imprimir BufferedImages
		final BufferedImage image = ImageIO.read(new File(".\\sprites\\cell\\0.png"));
		final BufferedImage image2 = ImageIO.read(new File(".\\sprites\\cell\\0.png"));
		
		Graphics g = this.panel.getGraphics();
		//Hola
		for(int i = 0; i<500; i++){

			this.panel.paintImage(g,image, 20+i, 20+i);
			this.panel.paintImage(g,image2, 160+i, 160);

			Thread.sleep(33);
			this.panel.actualize(g);
			
		}
	}
}
