
package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class gameFrame {

	public static Mechanics frame;
	public static void main(String[] args) {
		frame = new Mechanics();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

}

class Mechanics extends Frame implements KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Mechanics instance;
	
	int appletWidth, appletHeight;
	
	static int numMob = 10;
	public mob mobList[];
	public int counter = 0;
	public ArrayList<mob> mobs = new ArrayList<mob>();
	public ArrayList<item> items = new ArrayList<item>();
	
	static String swordType;
	
	private character P1;
	static Image heavySwordRight,heavySwordLeft,lightSwordRight,lightSwordLeft,mediumSwordRight,mediumSwordLeft,swordRight,swordLeft;
	public boolean titleScreen = true;
	
	static Image largeExplosion1,largeExplosion2, largeExplosion3,largeExplosion4;
	public boolean counterTimer = false;
	private Image virtualMem;
	private Graphics gBuffer;
	public static Boolean gfxApp = false;
	Debugger debugger;
	grfx g2 = new grfx();
	
	static int moveAmt = 7;
	static boolean swordSelect = false;
	static int stageCounter = 1;
	static int level = 1;
	
	
	public Mechanics()
	{
		super("Lee vs. The Army of Darkness");
		instance = this;
		setSize(1010,685);
		setVisible(true);
		addKeyListener(this);
		
		
		largeExplosion1 = gameThing.getImage("largeExplosion1.png");
		largeExplosion2 = gameThing.getImage("largeExplosion2.png");
		largeExplosion3 = gameThing.getImage("largeExplosion3.png");
		largeExplosion4 = gameThing.getImage("largeExplosion4.png");
		heavySwordLeft = gameThing.getImage("heavySwordLeft.png");
		heavySwordRight = gameThing.getImage("heavySwordRight.png");
		lightSwordLeft = gameThing.getImage("lightSwordLeft.png");
		lightSwordRight = gameThing.getImage("lightSwordRight.png");
		mediumSwordLeft = gameThing.getImage("swordLeft.png");
		mediumSwordRight = gameThing.getImage("swordRight.png");
		
		
		P1 = new character(gBuffer);
		
		try {
			appletWidth = getWidth();
			appletHeight = getHeight();
			virtualMem = new BufferedImage(appletWidth, appletHeight,BufferedImage.TYPE_INT_RGB);
			gBuffer = virtualMem.getGraphics();

		} catch (NullPointerException e) {
		}
		Graphics2D g2D = (Graphics2D) gBuffer;
		g2D.translate(8, 30);


		star s1 = new star(0, 0, 0,"",0);
		
		debugger = new Debugger(gBuffer);


		
		
		String s = JOptionPane.showInputDialog("Fast Sword with Low Damage\n+5 Damage +10 Speed\nEnter A\nModerateSpeed with Medium Damage\n+10damage +5 Speed\nEnter B\nSlow Sword with Heavy Damage\n+20 Damage -2 Speed\nEnter C");
		if(s.toLowerCase().equals("a"))
		{
			character.swordCooldown = 5;
			character.damageAmount = 5;
			swordLeft = lightSwordLeft;
			swordRight = lightSwordRight;
			swordType = "a";
		}else if(s.toLowerCase().equals("b"))
		{
			swordLeft = mediumSwordLeft;
			swordRight = mediumSwordRight;
			character.swordCooldown = 10;
			character.damageAmount = 10;
			swordType = "b";
		}else if(s.toLowerCase().equals("c"))
		{
			character.swordCooldown = 20;
			character.damageAmount = 20;
			swordLeft = heavySwordLeft;
			swordRight = heavySwordRight;
			swordType = "c";
		}


		gfxApp = true;
		appropriateMobs();
		repaint();
	}
	

	
	public void paint(Graphics g){		
		if(gfxApp)
		{
			if(!swordSelect)
			{

				swordSelect = true;
			}
			
//			if(titleScreen)
//			{	
//				counter++;
//				grfx.Title(gBuffer);
//
//				if(counterTimer && counter <274)
//				{
//					if(counter<175)
//					drawMeteors(gBuffer);
//					if(counter >150)
//					{
//						if(counter>125 && counter <150)
//						{
//						gBuffer.drawImage(largeExplosion1,700,300,null);
//						}
//						if(counter>150 && counter < 175)
//						{
//						gBuffer.drawImage(largeExplosion2,625,225,null);
//						}
//						if(counter>175 && counter<200)
//						{
//						gBuffer.drawImage(largeExplosion3,575,175,null);
//						}
//						if(counter>200 && counter<225)
//						{
//						gBuffer.drawImage(largeExplosion4,500,100,null);
//						}
//					}
//					
//				}else if(counterTimer && counter > 275)
//				{
//					titleScreen = false;
//					counterTimer = false;
//				}
//				g.drawImage(virtualMem, 0, 0, null);
//				delay(50);
//				repaint();
//			}else
//			{
			
			

			grfx.drawLevels(gBuffer,stageCounter);
			checkBoundaries();		
			grfx.Background1(gBuffer, character.getHP());
			drawMobs(gBuffer);

			drawItems();
			
			character.drawCharacter(gBuffer);	
			character.addFireBallCounter();
			character.subSwordCounter();
			character.addDashCounter();
			gBuffer.setColor(Color.white);
			gBuffer.drawString(String.valueOf(character.getHP()), 100, 100);
			
			
			
			
			
			super.paint(gBuffer);
			g.drawImage(virtualMem, 0, 0, null);	
			counter++;
			delay(50);
			repaint();
		}else
		{
			delay(50);
			repaint();
		}
 		}
//	}
	

	
	public void keyPressed(KeyEvent e)
	{
		/*
		 *  'w' = 87  leftArrow = 37
		 *  'a' = 65  rightArrow = 39
		 *  's' = 83  upArrow = 38
		 *  'd' = 68  downArrow = 40
		 *  '1' = 49  '2' = 50
		 *  '3' = 51  '4' = 53
		 *  '5' = 53  '6' = 54
		 *  '7' = 55  '8' = 56
		 *  '9' = 57  '0' = 48
		 *  '-' = 45  '=' = 61
		 *  spaceBar = 32
		 *  'f' = 32
		 *  */
		int keyCode = e.getKeyCode();
//		System.out.println(keyCode);
		
		if(keyCode == 38)
		{ // up
			character.addPosY(-7);
		} else if(keyCode == 37)
		{ // left			
			character.addPosX(-moveAmt);
			character.setLook(false);
			character.addDirection();
		} else if(keyCode == 40)
		{ // down
			character.addPosY(7);
		} else if(keyCode == 39)
		{ // right
			character.addDirection();
			character.addPosX(moveAmt);
			character.setLook(true);
		} else if(keyCode == 32)
		{ // space bar
			if(character.getJumpCounter()<=2)
			{
			character.setJumping(true);
			character.addJumpCounter();
			}
		} else if(keyCode == 70)
		{ // F
			if(character.getSwordCounter()<=0)
			{
			character.setSwordCounter(0);
			}
		} else if(keyCode == 68)
		{	// D
			if(character.getFireBallAllowedCounter()>40)
			{
			character.setFireBallDir(character.getLook());
			character.setRightFireBall(character.playerxCoord + 30,character.playeryCoord + 20);
			character.setLeftFireBall(character.playerxCoord - 30, character.playeryCoord + 20);
			character.setFireBallCounter(0);
			}
			
		} else if(keyCode == 83)
		{   // S
			character.useDash();
		} else if(keyCode == 61)
		{
			if(gfxApp)
			{
				gfxApp = false;
				
				debugger.show(true);
			}else
			{
				gfxApp = true;
				debugger.show(false);
				repaint();
			}

		} else if(keyCode == 45)
		{

			
		}
		else if(keyCode == 48)
		{
			counterTimer = true;
			counter = 0;
		}
	}
	
	

		
	
	
	public void keyReleased(KeyEvent e)
	{
		
	}
	
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	
	public void update(Graphics g)
	{
		paint(g);
	}
	
	
	
	public static void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.currentTimeMillis();
	}

	public void checkBoundaries()
	{
		if(character.getPlayerX() >1000)
		{
			if(stageCounter == 5 && level == 1)
			{
				level++;
				stageCounter = 1;
			}
			
			
			stageCounter++;
			character.playerxCoord = 10;
			for(int c = 0; c<items.size(); c++)
			{
				if(items.get(c).isActive)
				items.get(c).isActive = false;
			}
			
			for(int j = 0; j<mobs.size(); j++)
			{
				if(mobs.get(j).getActive())
				mobs.get(j).setInactive();
			}
			appropriateMobs();
		} 
		if(character.getPlayerX() <= 0 && stageCounter > 1)
		{
			stageCounter--;
			character.setPosX(1000);
		}
	}
	public void appropriateMobs()
	{
		if(level == 1)
		{
			if(stageCounter == 1)
			{
				mobs.add(new mob(gBuffer,300,480,0,900));
				mobs.get(mobs.size()-1).setActive();
				mobs.get(mobs.size()-1).setAggroRange(100);
			} else if(stageCounter == 2)
			{
				mobs.add(new mob(gBuffer,500,480,300,800));
				mobs.get(mobs.size()-1).setActive();
				mobs.add(new mob(gBuffer,300,480,200,500));
				mobs.get(mobs.size()-1).setActive();
				
			} else if(stageCounter == 3)
			{
				mobs.add(new mob(gBuffer,300,480,200,700));
				mobs.get(mobs.size()-1).setActive();
				mobs.add(new mob(gBuffer,800,480,500,900));
				mobs.get(mobs.size()-1).setActive();
				mobs.add(new mob(gBuffer,500,480,600,800));
				mobs.get(mobs.size()-1).setActive();
			} else if(stageCounter == 4)
			{
				mobs.add(new mob(gBuffer,300,480,200,700));
				mobs.get(mobs.size()-1).setActive();
				mobs.add(new mob(gBuffer,800,480,500,900));
				mobs.get(mobs.size()-1).setActive();
				mobs.add(new mob(gBuffer,500,480,600,800));
				mobs.get(mobs.size()-1).setActive();
			}
		}
	}
	
	public void drawMobs(Graphics g)
	{
		for(int j = 0; j<mobs.size(); j++)
		{
			if(mobs.get(j).getActive())
			mobs.get(j).move(gBuffer);
			int health = mobs.get(j).getHP();
			int x = mobs.get(j).getMobX();
			int y = mobs.get(j).getMobY();
			if(mobs.get(j).getActive())
			{
			gBuffer.setColor(Color.white);
			gBuffer.drawString(String.valueOf(health), x+20, y-30);	
			}

			
		}
	}
	
	public void drawItems()
	{
		try{
		for(int j= 0; j<=items.size(); j++)
		{
			if(items.get(j).isActive)
			{
				items.get(j).drop();
			}
		}}
		catch(IndexOutOfBoundsException e){}

	}
	
	public void drawMeteors(Graphics g)
	{
		g2.meteors.get(0).action(gBuffer,0);
		g2.meteors.get(1).action(gBuffer,g2.meteors.get(0).getMeteorsX());
		g2.meteors.get(2).action(gBuffer,g2.meteors.get(0).getMeteorsX());
		g2.meteors.get(3).action(gBuffer,g2.meteors.get(0).getMeteorsX());
		g2.meteors.get(4).action(gBuffer,g2.meteors.get(0).getMeteorsX());
	}

	public void pause(boolean t)
	{
		gfxApp = t;
		
	}
	
}