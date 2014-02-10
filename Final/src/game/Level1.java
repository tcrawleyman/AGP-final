package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Level1 {
	
	static Random rand;
	
	
	public static void drawStage1(Graphics g)
	{
		g.setColor(new Color(104,132,255));
		g.fillRect(0, 0, 1000, 650);
		drawCloud(g,100,150);
		drawCloud(g,400,200);
		drawCloud(g,500,300);
		drawCloud(g,700,150);
		drawCloud(g,900,250);
		flowers(g);
		for(int c = 0;c<17;c++)
		{
		drawGrassBlock(g,0+(c*60),530,60);
		drawDirtBlock(g,0+(c*60),590,60);
		}
//		drawTree(g,200,140);

	}
	
	public static void drawStage2(Graphics g)
	{
		g.setColor(new Color(104,132,255));
		g.fillRect(0, 0, 1000, 650);
		drawCloud(g,50,300);
		drawCloud(g,250,175);
		drawCloud(g,375,225);
		drawCloud(g,450,150);
		drawCloud(g,575,300);
		drawCloud(g,700,200);
		drawCloud(g,850,150);
		flowers(g);
		for(int c = 0;c<17;c++)
		{
		drawGrassBlock(g,0+(c*60),530,60);
		drawDirtBlock(g,0+(c*60),590,60);
		}
	}
	public static void drawStage3(Graphics g)
	{
		g.setColor(new Color(104,132,255));
		g.fillRect(0, 0, 1000, 650);
		drawCloud(g,0,150);
		drawCloud(g,125,250);
		drawCloud(g,250,200);
		drawCloud(g,375,100);
		drawCloud(g,450,150);
		drawCloud(g,575,225);
		drawCloud(g,700,150);
		drawCloud(g,825,300);
		flowers(g);
		for(int c = 0;c<17;c++)
		{
		drawGrassBlock(g,0+(c*60),530,60);
		drawDirtBlock(g,0+(c*60),590,60);
		}
	}
	public static void drawStage4(Graphics g)
	{
		g.setColor( new Color(104,132,255));
		g.fillRect(0, 0, 1000, 650);
		drawCloud(g,50,200);
		drawCloud(g,150,300);
		drawCloud(g,400,150);
		drawCloud(g,525,225);
		drawCloud(g,650,175);
		drawCloud(g,775,250);
		flowers(g);
		for(int c = 0;c<17;c++)
		{
		drawGrassBlock(g,0+(c*60),530,60);
		drawDirtBlock(g,0+(c*60),590,60);
		}
	}
	public static void drawStage5(Graphics g)
	{
		g.setColor(new Color(104,132,255));
		g.fillRect(0, 0, 1000, 650);
		drawTree(g,850,140);
		for(int c = 0;c<17;c++)
		{
		drawGrassBlock(g,0+(c*60),530,60);
		drawDirtBlock(g,0+(c*60),590,60);
		}
		Polygon sign = new Polygon();
		sign.addPoint(450, 450);
		sign.addPoint(450, 375);
		sign.addPoint(600, 375);
		sign.addPoint(650, 418);
		sign.addPoint(600, 450);
		g.setColor(new Color(109,54,0));
		g.fillPolygon(sign);
		g.fillRect(500, 325, 50, 205);
		g.setColor(Color.black);
		Font signFont = new Font("Miriam",Font.BOLD,35);
		g.setFont(signFont);
		g.drawString("To Forest!", 455, 427);
		g.drawPolygon(sign);
		
	}
	
	public static void flowers(Graphics g)
	{
			g.setColor(new Color(0,143,14));
		utility.fillPolygon(g,420,530,480,470,540,470,600,530);
		utility.fillArc(g,510,500,42,42,315,45);
		g.setColor(new Color(0,56,14));
		g.drawLine(420,530,480,470);
		g.drawLine(600,530,540,470);
		utility.drawArc(g,510,500,42,42,315,45);
		utility.fillOval(g,530,480,4,8);
		utility.fillOval(g,522,488,3,6);
		g.setColor(Color.green);
		utility.fillPolygon(g,390,530,   400,520,   385,505,   375,515,   345,485,   305,485,   290,500,   275,485,   235,485,   220,500,   220,530);
		utility.fillPolygon(g,220,530,   220,500,   205,485,   165,485,   145,505,   125,515,   133,523,   125,530);
		utility.fillPolygon(g,900,530,885,515,900,500,920,490,925,485,965,485,980,500,985,495,1020,530);
		g.setColor(new Color(0,143,14));
		utility.drawPolygon(g,390,530,   400,520,   385,505,   375,515,   345,485,   305,485,   290,500,   275,485,   235,485,   220,500,   220,530);
		utility.drawPolygon(g,220,530,   220,500,   205,485,   165,485,   145,505,   125,515,   133,523,   125,530);
		utility.drawPolygon(g,900,530,885,515,900,500,920,490,925,485,965,485,980,500,985,495,1020,530);
		g.setColor(Color.green);
		utility.fillArc(g,325,505,28,28,315,45);
		utility.fillArc(g,255,505,28,28,315,45);
		utility.fillArc(g,185,505,28,28,315,45);
		g.drawLine(220,501,220,529);
		g.setColor(new Color(0,56,14));
		utility.drawArc(g,325,505,28,28,315,45);
		utility.drawArc(g,255,505,28,28,315,45);
		utility.drawArc(g,185,505,28,28,315,45);

	}
	
	
	public static void drawCloud(Graphics g, int x, int y)
	{
		g.setColor(Color.white);
		g.fillArc(x,y+10,40,40,0,360);
		g.fillArc(x+40,y,50,50,0,360);
		g.fillRect(x+20,y+10,45,40);
		g.fillArc(x-5,y-5,45,45,0,360);
		g.fillArc(x+15,y-15,45,45,0,360);
	}
	
	public static void drawGrassBlock(Graphics g, int x, int y, int width)
	{
		Polygon grass = new Polygon();
		drawDirtBlock(g,x,y,width);
		grass.addPoint(x, y);
		grass.addPoint(x,y+20);
		grass.addPoint(x+10, y+10);
		grass.addPoint(x+20, y+20);
		grass.addPoint(x+30,y+10);
		grass.addPoint(x+40,y+20);
		grass.addPoint(x+50,y+10);
		grass.addPoint(x+60,y+20);
		grass.addPoint(x+60, y);
		g.setColor(Color.green);
		g.fillPolygon(grass);
		
	}
	
	public static void drawDirtBlock(Graphics g, int x, int y, int width)
	{
		g.setColor(new Color(255,205,56));
		g.fillRect(x, y, width, width);

		int dotX,dotY;
		for(int c = 1; c <=12;c++)
		{
			g.setColor(Color.black);

			for(int m = 1; m<=12;m++)
			{ 
				dotX= x + (m * 6);
				dotY= y + (c * 6);
				g.drawLine(dotX,dotY,dotX,dotY);
			}

			
		}
	}
	
	
	public static void drawTree(Graphics g, int x, int y)
	{
		g.setColor(new Color(163,82,10));
		Polygon trunkTop = new Polygon();
		trunkTop.addPoint(x,y);
		trunkTop.addPoint(x+100,y);
		trunkTop.addPoint(x+88,y+100);
		trunkTop.addPoint(x+12, y+100);
		g.fillPolygon(trunkTop);
		g.fillRect(x+12, y+100, 75,200);
		Polygon trunkBase = new Polygon();
		trunkBase.addPoint(x+12,y+300);
		trunkBase.addPoint(x+88,y+300);
		trunkBase.addPoint(x+100,y+400);
		trunkBase.addPoint(x,y+400);
		g.fillPolygon(trunkBase);
		g.setColor(new Color(38,89,52));
		g.fillOval(x-30,y-10,40,40);
		g.fillOval(x-10,y+10,40,40);
		g.fillOval(x, y+15, 40, 40);
		g.fillOval(x+10, y+20, 40, 40);
		g.fillOval(x+20, y+20, 40, 40);
		g.fillOval(x+30, y+20, 40, 40);
		g.fillOval(x+40, y+20, 40, 40);
		g.fillOval(x+50, y+20, 40, 40);
		g.fillOval(x+60, y+20, 40, 40);
		g.fillOval(x+70, y+15, 40, 40);
		g.fillOval(x+80, y+10, 40, 40);
		g.fillOval(x+90, y-10, 40, 40);
		g.fillOval(x+90, y-15, 40, 40);
		g.fillOval(x+90, y-20, 40, 40);
		g.fillOval(x+90, y-25, 40, 40);
		g.fillOval(x+90, y-20, 40, 40);
		g.fillOval(x+90, y-15, 40, 40);
		g.fillOval(x+80, y-40, 40, 40);
		g.fillOval(x+70, y-45, 40, 40);
		g.fillOval(x+60, y-50, 40, 40);
		g.fillOval(x+50, y-50, 40, 40);
		g.fillOval(x+40, y-50, 40, 40);
		g.fillOval(x+30, y-50, 40, 40);
		g.fillOval(x+20, y-50, 40, 40);
		g.fillOval(x+10, y-45, 40, 40);
		g.fillOval(x, y-40, 40, 40);
		g.fillOval(x-10, y-30, 40, 40);
		g.fillOval(x-20, y-20, 40, 40);
		g.fillRect(x, y, 100, 50);
		g.fillRect(x+20, y-20, 75, 50);
		
	}

}
