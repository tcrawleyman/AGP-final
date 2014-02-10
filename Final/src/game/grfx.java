
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;






public class grfx extends gameThing{
	
	static	star stars[] = new star[500];
	public ArrayList<star> meteors = new ArrayList<star>();

	
	public grfx(){
		super(g);
		
		for(int c = 0; c<stars.length; c++)
		{
			
			stars[c] = new star(c,0,0,"star",0);
			stars[c].setCoords();
		}
		meteors.add(new star(0,0,50,"crashingMeteor",0));
		meteors.add(new star(1,200,100,"fallingMeteor",200));
		meteors.add(new star(2,300,125,"fallingMeteor",300));
		meteors.add(new star(3,400,150,"fallingMeteor",400));
		meteors.add(new star(4,500,175,"fallingMeteor",500));
		
	}

	
	public static void Background1(Graphics g, int health)
	{

		drawLifeStars(g,health);

	}
	
	public static void Title(Graphics g)
	{
		g.setColor(new Color(20,15,83));
		g.fillRect(0, 0, 1000, 650);
		for(int j = 0; j<stars.length; j++)
		{
			stars[j].drawAStar(g);

		}


		
		
		g.drawImage(titleBackground,0,0,null);
		g.drawImage(spriteStillRight,400,500,null);

	}
	public static void drawLevels(Graphics g, int stage)
	{
		if(stage == 1)
		Level1.drawStage1(g);
		else if(stage == 2)
		Level1.drawStage2(g);
		else if(stage == 3)
		Level1.drawStage3(g);
		else if(stage == 4)
		Level1.drawStage4(g);
		else if(stage == 5)
		Level1.drawStage5(g);
		



	}

	

	
	public static void drawLifeStars(Graphics g, int hp)
	{	int x = 400;
		int y = 100;
		int amount = hp/10;
		for(int k = 1; k<=amount; k++)
		{
			drawAStar(g,x,y,10);
			x += 20;
		}
	}
	
	public static void drawAStar(Graphics g,int x, int y, int rad)
	{	int points= 5;
		points *= 2;
		double twoPI = (Math.PI * 2);
		double halfPI = (Math.PI / 2);
		int xCoord[] = new int[points];
		int yCoord[] = new int[points];
		int currentRadius;
		for (int k = 0; k < points; k++)
		{
			int radius = rad;
			if (k % 2 == 0)
				currentRadius = radius;
			else
				currentRadius = radius / 2;

			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/points - halfPI) * currentRadius) + x;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/points - halfPI) * currentRadius) + y;
		}
		g.setColor(Color.yellow);
		g.fillPolygon(xCoord, yCoord, points);
		
	}

	
	


}




