package game;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Rectangle;

public class character extends gameThing{
	
	private static Boolean jumping = false;
	private static Boolean gravity = false;
	private static Boolean lookRight = true;
	static double jumpAmt = 15.5;
	public static int playerxCoord = 0;
	public static int playeryCoord = 470;
	public static int direction = 2;
	Boolean sword = false;
	static int jumpCounter=0;
	int gpos = 0;
	static int swordCounter = 1;
	static int swordAllowedCounter = 0;
	static int fireBallCounter = 1;
	static int fireBallAllowedCounter = 500;
	static Boolean fireBallDir = true;
	static int dashCounter = 1;
	static int dashAllowedCounter = 50;
	static int swordCooldown=5;
	static int damageAmount = 10;
	static int rightFireX = playerxCoord + 30;
	static int rightFireY = playeryCoord + 20;
	static int leftFireX = playerxCoord - 30;
	static int leftFireY = playeryCoord + 20;
	int swordX;
	int swordY;
	static Rectangle charHitBox;
	private static int HP;
	
	
	private static Boolean isAlive = true;
	

	
	public character(Graphics g)
	{
		super(g);
		healthPoints = 100;
		HP = healthPoints;
		dashHitBox = new Rectangle(-100,-100,200,30);
		charHitBox = new Rectangle(-100,-100,44,50);
	}
	
	public static void drawCharacter(Graphics g) throws NullPointerException
	{
		if(isAlive)
		{
			
		if(getHP()<=0)
		{
			isAlive = false;
			return;
		}
		charHitBox.setLocation(playerxCoord,playeryCoord);
		
		shootSword(playerxCoord,playeryCoord, g, lookRight);
		shootFireball(playerxCoord,playeryCoord, g);
		dashAttack(playerxCoord,playeryCoord,g);
		
		checkItems();
		
		
		if(playeryCoord <480)
		{
			gravity = true;
		}
		else
		{
			gravity  = false;
			jumpCounter = 0;
		}
		if (gravity)
		{
			playeryCoord +=4;

		}	



	if (jumping)
	{
		if (jumpAmt > 4.0)
		{
			playeryCoord -= jumpAmt;
			jumpAmt -= 0.75;
		}
		else
		{
			jumping = false;
			jumpAmt = 15.5;
		}
		

	}
	
		
		
		if(direction%2==0 && lookRight == true)
		g.drawImage(spriteStillRight,playerxCoord,playeryCoord,null);
		if(direction%2 !=0 && lookRight == true)
		g.drawImage(spriteRight,playerxCoord,playeryCoord,null);
		
		if(direction%2==0 && lookRight == false)
		g.drawImage(spriteStillLeft,playerxCoord,playeryCoord,null);
		if(direction%2 !=0 && lookRight == false)
		g.drawImage(spriteLeft,playerxCoord,playeryCoord,null);
		

		}
		else 
		{
			return;
		}
		
	}
	
	
	public static void shootSword(int playerX, int playerY, Graphics g, boolean lookRight)
	{
		
		int rightswordX = playerX + 30;
		int rightswordY = playerY + 30;
		int leftswordX = playerX - 30;
		int leftswordY = playerY + 30;
		
		if(swordCounter == 0 && isAlive)
		{
		if(Mechanics.swordType.equals("b"))
		{
		rightswordX = playerX + 30;
		rightswordY = playerY + 30;
		leftswordX = playerX - 30;
		leftswordY = playerY + 30;
		}else if(Mechanics.swordType.equals("a"))
		{
			rightswordX = playerX + 40;
			rightswordY = playerY + 30;
			leftswordX = playerX - 25;
			leftswordY = playerY + 30;
		}else if(Mechanics.swordType.equals("c"))
		{
			rightswordX = playerX + 40;
			rightswordY = playerY + 30;
			leftswordX = playerX - 50;
			leftswordY = playerY + 30; 
		}

		if(lookRight)
		g.drawImage(Mechanics.swordRight,rightswordX,rightswordY,null);
		else
		g.drawImage(Mechanics.swordLeft,leftswordX,leftswordY,null);
		
		if(Mechanics.swordType.equals("b"))
		for(int c = 0; c<gameFrame.frame.mobs.size(); c++)
		{
			if(gameFrame.frame.mobs.get(c).hitBox.contains(playerX + 84,playerY + 30)||gameFrame.frame.mobs.get(c).hitBox.contains(playerX +74,playerY + 30) 
					||gameFrame.frame.mobs.get(c).hitBox.contains(playerX + 64,playerY + 30)||gameFrame.frame.mobs.get(c).hitBox.contains(playerX + 54,playerY + 30)
					&& lookRight && swordCounter == 0)
			{
				gameFrame.frame.mobs.get(c).subHP(damageAmount);
				for(int k = 0; k<=10; k++)
				{
					gameFrame.frame.mobs.get(c).setMobLocation((gameFrame.frame.mobs.get(c).getMobX() + 4),(gameFrame.frame.mobs.get(c).getMobY()-2)); 
				}
			}
			else if(gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 30,playerY + 30)|| gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 20,playerY + 30)
					||gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 10,playerY + 30)&& swordCounter == 0 && !lookRight)
			{
				gameFrame.frame.mobs.get(c).subHP(damageAmount);
				for(int k = 0; k<=10; k++)
				{
					gameFrame.frame.mobs.get(c).setMobLocation((gameFrame.frame.mobs.get(c).getMobX() - 4),(gameFrame.frame.mobs.get(c).getMobY()-2)); 
				}
			}
		}
		if(Mechanics.swordType.equals("a"))
		{
			for(int c = 0; c<gameFrame.frame.mobs.size(); c++)
			{
				if(gameFrame.frame.mobs.get(c).hitBox.contains(playerX + 73,playerY + 30)||gameFrame.frame.mobs.get(c).hitBox.contains(playerX +63,playerY + 30) 
						||gameFrame.frame.mobs.get(c).hitBox.contains(playerX + 53,playerY + 30)&& lookRight && swordCounter == 0)
				{
					gameFrame.frame.mobs.get(c).subHP(damageAmount);
					for(int k = 0; k<=5; k++)
					{
						gameFrame.frame.mobs.get(c).setMobLocation((gameFrame.frame.mobs.get(c).getMobX() + 2),(gameFrame.frame.mobs.get(c).getMobY()-2)); 
					}
				}
				else if(gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 32,playerY + 30)|| gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 22,playerY + 30)
						||gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 12,playerY + 30)&& swordCounter == 0 && !lookRight)
				{
					gameFrame.frame.mobs.get(c).subHP(damageAmount);
					for(int k = 0; k<=5; k++)
					{
						gameFrame.frame.mobs.get(c).setMobLocation((gameFrame.frame.mobs.get(c).getMobX() + 2),(gameFrame.frame.mobs.get(c).getMobY()-2)); 
					}
				}
			}
			
		}
		if(Mechanics.swordType.equals("c"))
		{
			for(int c = 0; c<gameFrame.frame.mobs.size(); c++)
			{
				if(gameFrame.frame.mobs.get(c).hitBox.contains(playerX + 93,playerY + 30)||gameFrame.frame.mobs.get(c).hitBox.contains(playerX +83,playerY + 30) 
						||gameFrame.frame.mobs.get(c).hitBox.contains(playerX + 73,playerY + 30)
						||gameFrame.frame.mobs.get(c).hitBox.contains(playerX + 63,playerY + 30)&& lookRight && swordCounter == 0)
				{
					gameFrame.frame.mobs.get(c).subHP(damageAmount);
					for(int k = 0; k<=15; k++)
					{
						gameFrame.frame.mobs.get(c).setMobLocation((gameFrame.frame.mobs.get(c).getMobX() + 5),(gameFrame.frame.mobs.get(c).getMobY()-2)); 
					}
				}
				else if(gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 49,playerY + 30)|| gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 39,playerY + 30)
						||gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 29,playerY + 30)
						||gameFrame.frame.mobs.get(c).hitBox.contains(playerX - 19,playerY + 30)&& swordCounter == 0 && !lookRight)
				{
					gameFrame.frame.mobs.get(c).subHP(damageAmount);
					for(int k = 0; k<=15; k++)
					{
						gameFrame.frame.mobs.get(c).setMobLocation((gameFrame.frame.mobs.get(c).getMobX() - 5),(gameFrame.frame.mobs.get(c).getMobY()-2)); 
					}
				}
			}
		}
		swordCounter = 1;
		swordAllowedCounter = swordCooldown;
		}

	}
	public static void shootFireball(int playerX, int playerY, Graphics g)
	{
		if(fireBallCounter == 0 && isAlive)
		{
			fireBallAllowedCounter = 0;
			
			if(fireBallDir)
			{
				g.drawImage(fireBallRight,rightFireX,rightFireY,null);
				rightFireX += 10;
			} else
			{
				g.drawImage(fireBallLeft,leftFireX,leftFireY,null);
				leftFireX-=10;
			}
		
		for(int c = 0; c<gameFrame.frame.mobs.size(); c++)
		{
			if(gameFrame.frame.mobs.get(c).hitBox.contains(rightFireX,rightFireY) && fireBallDir)
			{
				fireBallCounter = 1;
				fireBallAllowedCounter = 0;
				gameFrame.frame.mobs.get(c).subHP(10);
				setRightFireBall(-100,-100);
				setLeftFireBall(-100,-100);

			}
			else if(gameFrame.frame.mobs.get(c).hitBox.contains(leftFireX,leftFireY) && !fireBallDir)
			{
				fireBallCounter = 1;
				fireBallAllowedCounter = 0;
				gameFrame.frame.mobs.get(c).subHP(10);
				setRightFireBall(-100,-100);
				setLeftFireBall(-100,-100);

			}
		}
		if(rightFireX >= 1100 || leftFireX <= -100)
		{
			fireBallCounter = 1;
			fireBallAllowedCounter = 0;
		}
		}
	}
	
	public static void dashAttack(int playerX, int playerY, Graphics g) throws NullPointerException
	{
		if(dashCounter == 0 && isAlive && dashAllowedCounter >=50)
		{
			if(lookRight)
			{
				dashAllowedCounter = 0;
				g.drawImage(dashRight,playerxCoord+ 30, playeryCoord+10,null);
				dashHitBox.setLocation(playerxCoord + 30,playeryCoord+10);
				playerxCoord += 144;
			} else if(!lookRight && playerxCoord - 144 > 0)
			{
				dashAllowedCounter = 0;
				g.drawImage(dashLeft,playerxCoord-144,playeryCoord+10,null);
				dashHitBox.setLocation(playerxCoord-200,playeryCoord+10);
				playerxCoord -=144;
			}	
			
		}
		try{
		for(int c = 0; c<gameFrame.frame.mobs.size(); c++)
		{
			if(dashHitBox.contains(gameFrame.frame.mobs.get(c).getMobX() + 40,gameFrame.frame.mobs.get(c).getMobY() + 20)
					|| dashHitBox.contains(gameFrame.frame.mobs.get(c).getMobX(),gameFrame.frame.mobs.get(c).getMobY()+20)&& lookRight)
			{
				dashAllowedCounter = 0;
				gameFrame.frame.mobs.get(c).subHP(10);
			}
			else if(dashHitBox.contains(gameFrame.frame.mobs.get(c).getMobX(),gameFrame.frame.mobs.get(c).getMobY() + 20) && !lookRight)
			{
				dashAllowedCounter = 0;
				gameFrame.frame.mobs.get(c).subHP(10);

			}
		}
		}catch(NullPointerException e)
		{
			
		}
		dashHitBox.setLocation(-100,-100);
		dashCounter = 1;
	}
	
	public static void checkItems()
	{
		try{
			try{
		for(int x = 0; x<=gameFrame.frame.items.size();x++)
		if(charHitBox.intersects(gameFrame.frame.items.get(x).hitBox))
		{
			String powerUpType = gameFrame.frame.items.get(x).itemType;;
			gameFrame.frame.items.get(x).hitBox.setLocation(-100,-100);
			if(powerUpType.equals("star") && HP>=90)
			{}
			else
			gameFrame.frame.items.get(x).isActive = false;

			switch(powerUpType)
			{
			case "star": 
				if(HP<90)
				addHP(20);
				else if(HP == 90)
				addHP(10);
				break;
				
			case "jump" :
				jumpAmt += 1.0; break;
			case "speed" :
				Mechanics.moveAmt++; break;
			case "wepPowerUp" :
				damageAmount +=5;
				
			}
			
		}}catch(NullPointerException f){}
		}catch(IndexOutOfBoundsException e){}
	}
	
	
	
	
	public static void addPosX(int x)
	{
		playerxCoord += x;
	}
	public static void setPosX(int x)
	{
		playerxCoord = x;
	}
	public static void setPosY(int y)
	{
		playeryCoord = y;
	}
	
	public static int getSwordCounter()
	{
		return swordAllowedCounter;
	}
	
	public static void addPosY(int y)
	{
		playeryCoord += y;
	}
	
	public static void subSwordCounter()
	{
		swordAllowedCounter--;
	}
	public static void addFireBallCounter()
	{
		fireBallAllowedCounter++;
	}
	
	public static void addDirection()
	{
		direction++;
	}
	public static void setRightFireBall(int x, int y)
	{
		rightFireX = x;
		rightFireY = y;
	}
	public static void setLeftFireBall(int x, int y)
	{
		leftFireX = x;
		leftFireY = y;
	}
	public static int getFireBallAllowedCounter()
	{
		return fireBallAllowedCounter;
	}
	public static void setFireBallCounter(int num)
	{
		fireBallCounter = 0;
	}
	public static void setFireBallDir(Boolean right)
	{
		fireBallDir = right;
	}
	public static void addDashCounter()
	{
		dashAllowedCounter++;
	}
	public static void useDash()
	{
		dashCounter = 0;
	}
	public static int getDashCounter()
	{
		return dashCounter;
	}
	
	public static void dir(boolean dir)
	{
		lookRight = dir;
	}
	
	public static int getPlayerX()
	{
		return playerxCoord;
	}
	public static int getPlayerY()
	{
		return playeryCoord;
	}
	
	public static int getJumpCounter()
	{
		return jumpCounter;
	}
	
	public static void setJumping(Boolean jump)
	{
		jumping = jump;
	}
	
	public static void addJumpCounter()
	{
		jumpCounter++;
		
	}
	
	public static void setLook(Boolean right)
	{
		lookRight = right;
	}
	
	public static Boolean getLook()
	{
		return lookRight;
	}
	
	public static void setSwordCounter(int count)
	{
		swordCounter = count;
	}
	
	public static void setAlive(Boolean A)
	{
		isAlive = A;
		setHP(50);
	}
	
	public static void setHP(int hp)
	{
		HP = hp;
	}
	
	public static int getHP()
	{
		
		return HP;
	}
	
	public static void subHP(int hp)
	{
		HP -= hp;
	}
	
	public static void addHP(int hp)
	{
		HP += hp;
	}

}
