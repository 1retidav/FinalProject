package graphics;
import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

import com.sun.j3d.utils.universe.SimpleUniverse;

public class Camera 
{
	SimpleUniverse gameUniverse = null;
	Vector3d position = new Vector3d(0, 0, 0);
	Vector3d forward = new Vector3d(0, 0, 1);
	double rotationDegrees = 0.0;
	
	
	public Camera()
	{
		
	}
	
	public Camera(SimpleUniverse universe)
	{
		gameUniverse = universe;
	}
	
	public void setUniverse(SimpleUniverse toSet)
	{
		gameUniverse = toSet;
	}
	
	public void SetPosition(Vector3d positionNew)
	{
		position = positionNew;
	}
	
	public void move(double x, double y, double z)
	{
		position.add(new Vector3d(x * 0.25, y, z));
	}
	
	public void SetRotation(double rotation)
	{
		rotationDegrees = rotation;
	}
	
	public void Update()
	{
		if(!gameUniverse.equals(null))
		{
			Transform3D rotationTransform = new Transform3D();
			Transform3D positionTransform = new Transform3D();
			rotationDegrees = Math.min(rotationDegrees, 0.1);
			rotationDegrees = Math.max(-0.1, rotationDegrees);
			//rotationTransform.rotY(-rotationDegrees);
			positionTransform.setTranslation(new Vector3d(position.x, 0, 5));
			Transform3D newTransform = positionTransform;
			newTransform.mul(rotationTransform);
			gameUniverse.getViewingPlatform().getViewPlatformTransform().setTransform(newTransform);
		}
	}
}
