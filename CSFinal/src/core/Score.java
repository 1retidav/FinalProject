package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Score {
	private int score = 0;
	private String highScore = "";
	
	//Initializes HighScore here
	public void UpdateHighScore(){
		if (highScore.equals("")){
			highScore = this.GetHighScore();
		}
	}
	
	//Gets high Score
	public String GetHighScore(){
		FileReader readFile = null;
		BufferedReader reader = null;
		try {
			readFile = new FileReader("highscore.dat");
			reader = new BufferedReader(readFile);
			return reader.readLine();
		} catch (Exception e) {
			return "0";
		}
		finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
