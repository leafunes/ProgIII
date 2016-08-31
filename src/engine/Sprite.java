package engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Sprite {
	
	private ArrayList<BufferedImage> frames;
	private int length;
	
	public Sprite(String folderRoute, int framesLen){
		
		this.frames = new ArrayList<>(framesLen);
		
		File file = null;
		this.length = 0;
		
		while(this.length < framesLen){
			file = new File(folderRoute + "/"+this.length+".png");
			
			if(!file.exists())
				throw new IllegalArgumentException("No se encontro el archivo, " + file.getAbsolutePath());
			
			try {
				final BufferedImage frame = ImageIO.read(file);
				this.frames.add(frame);
				this.length++;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public BufferedImage getFrame(int i) {
		return this.frames.get(i);
	}

	public int length() {
		return this.length;
	}

}
