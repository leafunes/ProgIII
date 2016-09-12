package data;

import java.awt.Font;
import java.io.File;

public class GlobalVariables {
	
	public static Integer GRID_MENU_DIMENSION = 4;
	
	//Constants
	public static final Font defaultFont = new Font("Default", Font.PLAIN, 12);
	
	public static final Font largeFont = new Font("Open Sans", Font.BOLD, 18);
	
	public static final Font smallFont = new Font("Open Sans", Font.BOLD, 15);
	
	public static final Font smallerFont = new Font("Open Sans", Font.BOLD, 12);
	
	
	public static final String scoresRoute = "." + File.separator + "scores.dat";

}
