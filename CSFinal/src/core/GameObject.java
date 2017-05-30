package core;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

public class GameObject 
{
	private Transform3D transform = new Transform3D();
	private Vector3d position = new Vector3d(0, 0, 0);
	private Vector3d rotation = new Vector3d(0, 0, 0);
	private Vector3d scale = new Vector3d(0, 0, 0);
	
	public GameObject() 
	{
		position = new Vector3d(0, 0, 0);
	}
	
	public void move(double x, double y, double z)
	{
		position.x += x;
		position.y += y;
		position.z += z;
		rebuildTransform();
	}
	
	public void rotate(double x, double y, double z)
	{
		rotation.x += x;
		rotation.y += y;
		rotation.z += z;
		rebuildTransform();
	}
	
	public void scale(double x, double y, double z)
	{
		scale.x += x;
		scale.y += y;
		scale.z += z;
		rebuildTransform();
	}
	
	public void setPosition(double x, double y, double z)
	{
		position.x = x;
		position.y = y;
		position.z = z;
		rebuildTransform();
	}
	
	public void setRotation(double x, double y, double z)
	{
		rotation.x = x;
		rotation.y = y;
		rotation.z = z;
		rebuildTransform();
	}
	
	public void setScale(double x, double y, double z)
	{
		scale.x = x;
		scale.y = y;
		scale.z = z;
		rebuildTransform();
	}
	
	public void move(Vector3d toMove)
	{
		position.x += toMove.x;
		position.y += toMove.y;
		position.z += toMove.z;
		rebuildTransform();
	}
	
	public void setPosition(Vector3d newPosition)
	{
		position.x = newPosition.x;
		position.y = newPosition.y;
		position.z = newPosition.z;
		rebuildTransform();
	}
	
	private void rebuildTransform()
	{
		Transform3D pos = new Transform3D();
		Transform3D rot = new Transform3D();
		Transform3D scl = new Transform3D();
		pos.setTranslation(position);
		scl.setScale(scale);
		transform = new Transform3D();
		transform.mul(pos);
		transform.mul(rot);
		transform.mul(scl);
	}
	
	public Transform3D getTransform()
	{
		return transform;
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