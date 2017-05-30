package core;

import javax.vecmath.Vector3d;

public class GameObject 
{
	private Vector3d position = new Vector3d(0, 0, 0);
	private Vector3d rotation = new Vector3d(0, 0, 0);
	
	public GameObject() 
	{
		position = new Vector3d(0, 0, 0);
	}
	
	public void move(double x, double y, double z)
	{
		position.x += x;
		position.y += y;
		position.z += z;
	}
	
	public void rotate(double x, double y, double z)
	{
		rotation.x += x;
		rotation.y += y;
		rotation.z += z;
	}
	
	public void setPosition(double x, double y, double z)
	{
		position.x = x;
		position.y = y;
		position.z = z;
	}
	
	public void setRotation(double x, double y, double z)
	{
		rotation.x = x;
		rotation.y = y;
		rotation.z = z;
	}
	
	public void move(Vector3d toMove)
	{
		position.x += toMove.x;
		position.y += toMove.y;
		position.z += toMove.z;
	}
	
	public void setPosition(Vector3d newPosition)
	{
		position.x = newPosition.x;
		position.y = newPosition.y;
		position.z = newPosition.z;
	}
	
	public Vector3d getPosition()
	{
		return position;
	}
	
	public Vector3d getRotation()
	{
		return rotation;
	}
}
