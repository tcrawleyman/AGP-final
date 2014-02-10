package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class star
{
	public int x;
	public int xCoord;
	public int y;
	public int yCoord;
	public int num;
	Color starColor;
	public int size;
	public int rate;
	public int fallingX;
	public String type;
	static Image meteorDown,meteorFalling;
	
	public star(int index,int x,int y,String s,int fall)
	{
		
		num = index;
		xCoord = x;
		yCoord = y;
		type = s;
		fallingX = fall;
		meteorDown = getImage("meteorDown.png");
		meteorFalling = getImage("meteorFalling.png");
	}
	public void setCoords()
	{
		x = (int) (Math.random() * 1000);
		y = (int) (Math.random() * 650);
		if(num%20 == 0)
		{
			starColor = Color.yellow;
			size = 2;
			
		}
		else if(num%10 == 0)
		{
			starColor = Color.white;
			size = 7;
			rate = 4;
		}
		else if(num%5 == 0)
		{
			starColor = new Color(109,98,249);
			size = 5;
			rate = 3;
		} else if(num%4 == 0)
		{
			starColor = new Color(163,166,184);
			size = 3;
			rate = 2;
		} else if(num % 3 == 0)
		{
			starColor = new Color(191,189,123);
			size = 2;
			rate = 1;
		}
	}
	

	
	
	
	public void drawAStar(Graphics g)
	{	
		if(x>1000)
		{
			x = 0;
			
		}
		if(y< 0)
		{
			y=650;
		}
		
		int points= 5;
		points *= 2;
		double twoPI = (Math.PI * 2);
		double halfPI = (Math.PI / 2);
		int xCoord[] = new int[points];
		int yCoord[] = new int[points];
		int currentRadius;
		for (int k = 0; k < points; k++)
		{
			int radius = size;
			if (k % 2 == 0)
				currentRadius = radius;
			else
				currentRadius = radius / 2;

			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/points - halfPI) * currentRadius) + x;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/points - halfPI) * currentRadius) + y;
		}
		g.setColor(starColor);
		if(num%20 != 0)
		{
		g.fillPolygon(xCoord, yCoord, points);

		x+=rate;
		y-=rate;
		}else
		{
			g.drawLine(x,y,x,y);
		}
	}
	
	public void action(Graphics g,int X)
	{
		if(type.equals("crashingMeteor"))
		{
			crashMoon(g);
		}else if(type.equals("fallingMeteor"))
		{
			if(fallingX == 200 && X >= 200)
			{
				fallingMeteor(g);
			}else if(fallingX == 300 && X >= 300)
			{
				fallingMeteor(g);
			} else if(fallingX == 400 && X >=400)
			{
				fallingMeteor(g);
			}else if(fallingX == 500 && X >=500)
			{
				fallingMeteor(g);
			}
		}
	}
	
	
	
	public void crashMoon(Graphics g)
	{
		
		g.drawImage(meteorDown,xCoord,yCoord,null);
		xCoord+=5;
		yCoord+=1;
		
	}
	public void fallingMeteor(Graphics g)
	{
		g.drawImage(meteorFalling,xCoord,yCoord,null);
		yCoord+=3;
	}
	public void addMeteorsX(int x)
	{
		xCoord += x;
	}
	public void addMeteorsY(int y)
	{
		yCoord += y;
	}
	public int getMeteorsX()
	{
		return xCoord;
	}
	public int getMeteorsY()
	{
		return yCoord;
	}
	
	public Image getImage(String s){
		try{
			return ImageIO.read(new File(s));
		}
		catch(Exception e) {}
		return null;
	}
	
	
}



