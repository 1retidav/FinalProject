package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import core.Player;
import graphics.Graphics3D;
import io.Input;

public class Main 
{
	static Graphics3D graphicsHandler;
	static Player player;
	
	
	public static void main(String[] args) 
	{	
		graphicsHandler = new Graphics3D();
		graphicsHandler.getWindow().setSize(1280, 720);
		graphicsHandler.getWindow().setTitle("Game Title");
		graphicsHandler.getWindow().setResizable(false);
		
		graphicsHandler.getCanvas().addKeyListener(new Input.keyHandler());
		new Timer(2, new ActionListener(){@Override public void actionPerformed(ActionEvent arg0) {mainGameLoop();}}).start();
		
		player = new Player(graphicsHandler.getUniverse());
	}
	
	public static void mainGameLoop()
	{
		graphicsHandler.Repaint();
		player.update();
		
		if(Input.IsKeyDown('w'))
		{
			player.move(0, 0, 1);
		}
		
		if(Input.IsKeyDown('s'))
		{
			player.move(0, 0, -1);
		}
		
		if(Input.IsKeyDown('a'))
		{
			player.move(-1, 0, 0);
		}
		
		if(Input.IsKeyDown('d'))
		{
			player.move(1, 0, 1);
		}
	}
}
