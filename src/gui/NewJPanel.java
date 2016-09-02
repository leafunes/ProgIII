package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class NewJPanel extends JPanel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	 public void paintImage(Graphics g, BufferedImage image, int x, int y) throws InterruptedException{

         g.drawImage(image, x, y, null);
		 
	 }
	 
	 public void actualize(Graphics g){
		 this.paint(g);
	 }
	 

}
