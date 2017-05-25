package graphics;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;
import javax.swing.Timer;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Graphics3D 
{
	static SimpleUniverse universe;
	static BranchGroup objects;
	static Timer refreshTimer = new Timer(60, null);
	
	public Graphics3D()
	{
		universe = new SimpleUniverse();
		objects = new BranchGroup();
		
		universe.getViewingPlatform().setNominalViewingTransform();
		universe.getViewer().getView().setBackClipDistance(1000.0);
		universe.getViewer().getView().setFrontClipDistance(1.0);
		AddObject(null);
	}
	
	public JFrame getWindow()
	{
		return universe.getViewer().getJFrame(0);
	}
	
	public Canvas3D getCanvas()
	{
		return universe.getCanvas();
	}
	
	public SimpleUniverse getUniverse()
	{
		return universe;
	}
	
	public void AddObject(RenderObject toAdd)
	{
		objects.addChild(new ColorCube(0.3));
		objects.compile();
		universe.addBranchGraph(objects);
	}
	
	public void Repaint()
	{
		universe.getCanvas().getView().repaint();
	}
}
