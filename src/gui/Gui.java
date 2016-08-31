package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
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
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//TODO
		//TODO: Asi se dibuja una imagen. Game2048 va a devolver Drawables con imagenes y (x,y)
		//TODO: Las imagenes se deben dibujar sobre el Jpanel.
		
		final BufferedImage image = ImageIO.read(new File("/home/leandro/workspace/TpProgIII/todraw.png"));
		
		JPanel panel = new JPanel(){
			 @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(image, 0, 0, null);
	            }
		};
		panel.setBounds(12, 12, 424, 251);
		frame.getContentPane().add(panel);
	}

}
