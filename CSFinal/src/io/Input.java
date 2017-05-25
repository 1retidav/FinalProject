package io;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Input 
{
	private static Vector<Character> keysDown = new Vector<Character>();
	
	public static class keyHandler implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{	
			keysDown.add(new Character(e.getKeyChar()));
			System.out.println(e.getKeyChar());
		}

		@Override
		public void keyReleased(KeyEvent e) 
		{
			for(int i = 0; i < keysDown.size(); i++)
			{
				if(keysDown.get(i).charValue() == e.getKeyChar())
				{
					keysDown.remove(i);
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) 
		{	
			
		}		
	}
	
	public static boolean IsKeyDown(char keyToCheck)
	{
		if(keysDown.contains(new Character(keyToCheck)))
		{
			return true;
		}
		return false;
	}
}
