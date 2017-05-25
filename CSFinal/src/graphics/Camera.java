package graphics;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;

import com.sun.j3d.utils.universe.SimpleUniverse;

public class Camera 
{
	SimpleUniverse gameUniverse = null;
	
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
	
	public void SetPosition(Vector3d position)
	{
		if(!gameUniverse.equals(null))
		{
			TransformGroup viewTransform = gameUniverse.getViewingPlatform().getViewPlatformTransform();
			Transform3D newTransform = new Transform3D();
			newTransform.setTranslation(position);
			viewTransform.setTransform(newTransform);
		}
	}
}
