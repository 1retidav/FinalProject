package core;

import com.sun.j3d.utils.universe.SimpleUniverse;

import graphics.Camera;

public class Player extends Character 
{
	private Camera playerCamera = new Camera();
	private SimpleUniverse universe;
	
	public Player()
	{
		
	}
	
	public Player(SimpleUniverse gameUniverse)
	{
		universe = gameUniverse;
		playerCamera.setUniverse(gameUniverse);
		update();
	}
	
	public void update()
	{
		playerCamera.SetPosition(getPosition());
	}
}
