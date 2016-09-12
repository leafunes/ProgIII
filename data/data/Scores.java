package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Scores{
	
	public static ArrayList<Integer> getScores(){
		 ArrayList<Integer> ret = new ArrayList<>();
		 File file = new File( GlobalVariables.scoresRoute );
		
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextInt()) ret.add(scanner.nextInt());
			
			scanner.close();
		} 
		catch (FileNotFoundException  e) {
			
			Scores.newFile();
			ret = Scores.getScores();
			
		}
			 
		Collections.sort(ret);
		Collections.reverse(ret);
		
		for (Integer integer : ret) {
			System.out.println(integer);
		}
		
		return ret;
	}


	public static void putScore(int newScore){
	
		ArrayList<Integer> scoresList = Scores.getScores();
		
		scoresList.add(newScore);
		
		Collections.sort(scoresList);
		Collections.reverse(scoresList);
		
		scoresList.remove( scoresList.size() - 1 );
		
		Scores.writeScores(scoresList);
		
	}


	private static void newFile() {
		
		PrintWriter writer;
		try {
			writer = new PrintWriter( GlobalVariables.scoresRoute );
			
			for (int i = 0; i < 10; i++) {
				writer.println(0);
			}
			
			writer.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void writeScores(ArrayList<Integer> scoresList) {
		
		PrintWriter writer;
		try {
			writer = new PrintWriter( GlobalVariables.scoresRoute );
			
			for (Integer score : scoresList) {
				writer.println(score);
			}
			
			writer.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		
	}
	
}
