package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class item extends gameThing {

	
	String itemType;
	int itemX,itemY;
	boolean isActive;
	
	
	public item(Graphics g,String type, int x, int y)
	{
		super(g);
		itemType = type;
		itemX = x;
		itemY = y;
		hitBox = new Rectangle(itemX,itemY,40,40);
		isActive = true;	
	}
	
	public void drop()
	{
		if(isActive)
		{
		if(itemType.equals("star"))
		{
		grfx.drawAStar(g,itemX,itemY,20);
		}
		if(itemType.equals("wepPowerUp"))
		{	
			g.drawImage(damagePowerUp,itemX,itemY,null);
		}
		if(itemType.equals("speed"))
		{
			g.drawImage(speedPowerUp,itemX,itemY,null);
		}
		if(itemType.equals("jump"))
		{
			g.drawImage(jumpPowerUp,itemX,itemY,null);
		}
		
		}
	}
	
	
	
	
	
	
	
	

}
