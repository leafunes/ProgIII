package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Scores{

	public static ArrayList<Integer> getScores(){
		ArrayList<Integer> a = new ArrayList<>();
		
		Random gen = new Random();
		
		for (int i = 0; i < 10; i++) {
			a.add(gen.nextInt(100000));
			
		}
		
		Collections.sort(a);
		
		Collections.reverse(a);
		
		return a;
		
	}
	
	public static void putScore(int score){
		
	}
	
}
