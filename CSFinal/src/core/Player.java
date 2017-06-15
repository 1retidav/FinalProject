package core;
import graphics.Camera;
import graphics.Graphics3D;

public class Player extends Character 
{
	private Camera playerCamera = new Camera();
	private Graphics3D graphicsHandler;
	
	public Player()
	{
		
	}
	
	public Player(Graphics3D graphicsHandlerIn)
	{
		playerCamera.setUniverse(graphicsHandlerIn.getUniverse());
		graphicsHandler = graphicsHandlerIn;
		update();
	}
	
	public void addToScene()
	{
		characterObject.setMaterial("Images//TestImage.png");
		graphicsHandler.AddObject(characterObject);
	}
	
	@Override
	public void move(double x, double y, double z)
	{
		playerCamera.move(x, y, z);
		characterObject.move(x, y, z);
	}
	
	public void update()
	{
		playerCamera.SetRotation(getRotation().y);
		playerCamera.Update();
	}
}
