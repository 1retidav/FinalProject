package graphics;
import java.awt.Cursor;
import java.awt.GraphicsConfiguration;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;
import javax.swing.Timer;

import com.sun.j3d.utils.universe.SimpleUniverse;


public class Graphics3D 
{
	static SimpleUniverse universe;
	static BranchGroup objects;
	static Timer refreshTimer = new Timer(60, null);
	static Vector<GUI> GUIImages = new Vector<GUI>();
	static Viewport3D viewport;
	static JFrame frame;
	
	public Graphics3D()
	{
		frame = new JFrame();
		objects = new BranchGroup();
		viewport = new Viewport3D(SimpleUniverse.getPreferredConfiguration());
	    universe = new SimpleUniverse(viewport);
		universe.getViewingPlatform().setNominalViewingTransform();
		universe.getViewer().getView().setBackClipDistance(100.0);
		universe.getViewer().getView().setFrontClipDistance(0.1);
		frame.add(viewport);
		frame.setVisible(true);
	}
	
	public JFrame getWindow()
	{
		return frame;
	}
	
	public Canvas3D getCanvas()
	{
		return universe.getCanvas();
	}
	
	public SimpleUniverse getUniverse()
	{
		return universe;
	}
	
	public void AddObject(BoxObject toAdd)
	{
		objects.addChild(toAdd.getShape());		
	}
	
	public void compileObjects()
	{
		objects.compile();
		universe.addBranchGraph(objects);
	}
	
	public void AddGUIImage(GUI toAdd)
	{
		GUIImages.add(toAdd);
	}
	
	public void AddGUIButton(Button toAdd)
	{
		GUIImages.add(toAdd);
	}
	
	public void Repaint()
	{
		universe.getCanvas().getView().repaint();		
	}
	
	public void HideMouse()
	{
		BufferedImage blankImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(blankImg, new Point(0, 0), "blank");
				
		getCanvas().setCursor(blankCursor);
	}
	
	public void clearGUI()
	{
		GUIImages.clear();
	}
	
	public class Viewport3D extends Canvas3D   
	{
        public Viewport3D(GraphicsConfiguration arg0) 
        {
			super(arg0);
		}

		private static final long serialVersionUID = 7144426579917281131L;
        
        @Override
        public void postRender()
        {
        	for(int i = 0; i < GUIImages.size(); i++)
    		{
        		if(GUIImages.get(i).getIsVisible())
        		{
        			this.getGraphics2D().drawImage(GUIImages.get(i).getImage(), (int)GUIImages.get(i).getPosition().x, (int)GUIImages.get(i).getPosition().y, null);
        			this.getGraphics2D().flush(false);
        		}
        	}
        }
    };
}
