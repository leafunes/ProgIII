package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class NewJPanel extends JPanel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<BufferedImage> imgagesToDraw = new ArrayList<>();
	private ArrayList<Integer> xImg = new ArrayList<>();
	private ArrayList<Integer> yImg = new ArrayList<>();
	
	 /*@Override
        public void paintComponent(Graphics g) {
			
			
			
			super.paintComponent(g);
			 
			for(int i = 0; i < this.imgagesToDraw.size(); i++){
				if(this.imgagesToDraw.get(i) != null){
					
					BufferedImage toDraw = this.imgagesToDraw.get(i);
					int x = this.xImg.get(i);
					int y = this.yImg.get(i);
					
			 		g.drawImage(toDraw, x, y, null);
				}
			}
			
			
			this.imgagesToDraw.clear();
			this.xImg.clear();
			this.yImg.clear();
			
			//char a[] = {'a','s','d'};
			//g.drawChars(a, 0, 3, 0, 0);
            
        }*/
	 
	 public void paintImage(Graphics g, BufferedImage image, int x, int y){
		
         g.drawImage(image, x, y, null);
         this.paint(g);
	 }
	 
	 public void addImageToDraw(BufferedImage imageToDraw, int x, int y){
		 this.imgagesToDraw.add(imageToDraw);
		 this.xImg.add(x);
		 this.yImg.add(y);
	 }
	 

}
