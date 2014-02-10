package game;

import java.awt.Graphics;
import java.awt.Polygon;

public class utility {

	
	
	public static void fillArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;

		if (finish < start)
			finish += 360;
		int newStart  = 90 - start;   // shifts starting position from 3:00 to 12:00
		int newFinish = start-finish; // as oppose to finish-start.  Subtracting backwards changes from counter-clockwise to clockwise.

		g.fillArc(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter, newStart, newFinish);
	}
	public static void drawArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;

		if (finish < start)
			finish += 360;
		int newStart  = 90 - start;   // shifts starting position from 3:00 to 12:00
		int newFinish = start-finish; // as oppose to finish-start.  Subtracting backwards changes from counter-clockwise to clockwise.

		g.fillArc(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter, newStart, newFinish);
	}
	public static void fillOval(Graphics g, int centerX, int centerY, int hRadius, int vRadius)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;
		g.fillOval(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter);
	}
	
	
	 public static void fillPolygon(Graphics g,int... x1)
	 {
	   Polygon myPoly = new Polygon();
	   for(int k = 0; k<x1.length; k+=2)   
	 myPoly.addPoint(x1[k],x1[k+1]);
	   g.fillPolygon(myPoly);
	 }
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	g.fillPolygon(myPoly);
//	}
//
//
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	myPoly.addPoint(x4,y4);
//	 	g.fillPolygon(myPoly);
//	}
//
//
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,int x5,int y5)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	myPoly.addPoint(x4,y4);
//	 	myPoly.addPoint(x5,y5);
//	 	g.fillPolygon(myPoly);
//	}
//
//
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
//											  int x5,int y5,int x6,int y6)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	myPoly.addPoint(x4,y4);
//	 	myPoly.addPoint(x5,y5);
//	 	myPoly.addPoint(x6,y6);
//	 	g.fillPolygon(myPoly);
//	}
//
//
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
//											  int x5,int y5,int x6,int y6,int x7,int y7)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	myPoly.addPoint(x4,y4);
//	 	myPoly.addPoint(x5,y5);
//	 	myPoly.addPoint(x6,y6);
//	 	myPoly.addPoint(x7,y7);
//	 	g.fillPolygon(myPoly);
//	}
//
//
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
//											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	myPoly.addPoint(x4,y4);
//	 	myPoly.addPoint(x5,y5);
//	 	myPoly.addPoint(x6,y6);
//	 	myPoly.addPoint(x7,y7);
//	 	myPoly.addPoint(x8,y8);
//	 	g.fillPolygon(myPoly);
//	}
//
//
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
//											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8,
//											  int x9,int y9)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	myPoly.addPoint(x4,y4);
//	 	myPoly.addPoint(x5,y5);
//	 	myPoly.addPoint(x6,y6);
//	 	myPoly.addPoint(x7,y7);
//	 	myPoly.addPoint(x8,y8);
//	 	myPoly.addPoint(x9,y9);
//	 	g.fillPolygon(myPoly);
//	}
//
//
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
//											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8,
//											  int x9,int y9,int x10,int y10)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	myPoly.addPoint(x4,y4);
//	 	myPoly.addPoint(x5,y5);
//	 	myPoly.addPoint(x6,y6);
//	 	myPoly.addPoint(x7,y7);
//	 	myPoly.addPoint(x8,y8);
//	 	myPoly.addPoint(x9,y9);
//	 	myPoly.addPoint(x10,y10);
//	 	g.fillPolygon(myPoly);
//	}
//
//
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
//											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8,
//											  int x9,int y9,int x10,int y10,int x11,int y11)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	myPoly.addPoint(x4,y4);
//	 	myPoly.addPoint(x5,y5);
//	 	myPoly.addPoint(x6,y6);
//	 	myPoly.addPoint(x7,y7);
//	 	myPoly.addPoint(x8,y8);
//	 	myPoly.addPoint(x9,y9);
//	 	myPoly.addPoint(x10,y10);
//	 	myPoly.addPoint(x11,y11);
//	 	g.fillPolygon(myPoly);
//	}
//
//
//	public static void fillPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
//											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8,
//											  int x9,int y9,int x10,int y10,int x11,int y11,int x12,int y12)
//	{
//	 	Polygon myPoly = new Polygon();
//	 	myPoly.addPoint(x1,y1);
//	 	myPoly.addPoint(x2,y2);
//	 	myPoly.addPoint(x3,y3);
//	 	myPoly.addPoint(x4,y4);
//	 	myPoly.addPoint(x5,y5);
//	 	myPoly.addPoint(x6,y6);
//	 	myPoly.addPoint(x7,y7);
//	 	myPoly.addPoint(x8,y8);
//	 	myPoly.addPoint(x9,y9);
//	 	myPoly.addPoint(x10,y10);
//	 	myPoly.addPoint(x11,y11);
//	 	myPoly.addPoint(x12,y12);
//	 	g.fillPolygon(myPoly);
//	}

	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	g.drawPolygon(myPoly);
	}


	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	myPoly.addPoint(x4,y4);
	 	g.drawPolygon(myPoly);
	}


	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,int x5,int y5)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	myPoly.addPoint(x4,y4);
	 	myPoly.addPoint(x5,y5);
	 	g.drawPolygon(myPoly);
	}


	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
											  int x5,int y5,int x6,int y6)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	myPoly.addPoint(x4,y4);
	 	myPoly.addPoint(x5,y5);
	 	myPoly.addPoint(x6,y6);
	 	g.drawPolygon(myPoly);
	}


	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
											  int x5,int y5,int x6,int y6,int x7,int y7)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	myPoly.addPoint(x4,y4);
	 	myPoly.addPoint(x5,y5);
	 	myPoly.addPoint(x6,y6);
	 	myPoly.addPoint(x7,y7);
	 	g.drawPolygon(myPoly);
	}


	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	myPoly.addPoint(x4,y4);
	 	myPoly.addPoint(x5,y5);
	 	myPoly.addPoint(x6,y6);
	 	myPoly.addPoint(x7,y7);
	 	myPoly.addPoint(x8,y8);
	 	g.drawPolygon(myPoly);
	}


	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8,
											  int x9,int y9)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	myPoly.addPoint(x4,y4);
	 	myPoly.addPoint(x5,y5);
	 	myPoly.addPoint(x6,y6);
	 	myPoly.addPoint(x7,y7);
	 	myPoly.addPoint(x8,y8);
	 	myPoly.addPoint(x9,y9);
	 	g.drawPolygon(myPoly);
	}


	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8,
											  int x9,int y9,int x10,int y10)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	myPoly.addPoint(x4,y4);
	 	myPoly.addPoint(x5,y5);
	 	myPoly.addPoint(x6,y6);
	 	myPoly.addPoint(x7,y7);
	 	myPoly.addPoint(x8,y8);
	 	myPoly.addPoint(x9,y9);
	 	myPoly.addPoint(x10,y10);
	 	g.drawPolygon(myPoly);
	}


	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8,
											  int x9,int y9,int x10,int y10,int x11,int y11)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	myPoly.addPoint(x4,y4);
	 	myPoly.addPoint(x5,y5);
	 	myPoly.addPoint(x6,y6);
	 	myPoly.addPoint(x7,y7);
	 	myPoly.addPoint(x8,y8);
	 	myPoly.addPoint(x9,y9);
	 	myPoly.addPoint(x10,y10);
	 	myPoly.addPoint(x11,y11);
	 	g.drawPolygon(myPoly);
	}


	public static void drawPolygon(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,
											  int x5,int y5,int x6,int y6,int x7,int y7,int x8,int y8,
											  int x9,int y9,int x10,int y10,int x11,int y11,int x12,int y12)
	{
	 	Polygon myPoly = new Polygon();
	 	myPoly.addPoint(x1,y1);
	 	myPoly.addPoint(x2,y2);
	 	myPoly.addPoint(x3,y3);
	 	myPoly.addPoint(x4,y4);
	 	myPoly.addPoint(x5,y5);
	 	myPoly.addPoint(x6,y6);
	 	myPoly.addPoint(x7,y7);
	 	myPoly.addPoint(x8,y8);
	 	myPoly.addPoint(x9,y9);
	 	myPoly.addPoint(x10,y10);
	 	myPoly.addPoint(x11,y11);
	 	myPoly.addPoint(x12,y12);
	 	g.drawPolygon(myPoly);
	}
}
