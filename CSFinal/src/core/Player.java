package core;

import com.sun.j3d.utils.universe.SimpleUniverse;

import graphics.Camera;

public class Player extends Character 
{
	private Camera playerCamera = new Camera();
	
	public Player()
	{
		
	}
	
	public Player(SimpleUniverse gameUniverse)
	{
		playerCamera.setUniverse(gameUniverse);
		update();
	}
	
	@Override
	public void move(double x, double y, double z)
	{
		playerCamera.move(x, y, z);
	}
	
	public void update()
	{
		playerCamera.SetRotation(getRotation().y);
		playerCamera.Update();
	}
}
