package core;


public class Health {

	//Remember to initize it in the games class
	public int lives = 3;
	
	public boolean damage(){
		//Update once you have all the variables
		//if ()
			--lives;
		return isDead();
	}
	public boolean isDead(){
		return lives < 1;
	}
}
