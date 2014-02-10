package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class mob extends gameThing{
	
	int gpos = 0;
	boolean lookLeft1 = true,lookSide = false;
	static int mobJumpCounter = 0;
	static boolean mobGravity = false,mobJumping = false;
	
	@SuppressWarnings("unused")
	private Graphics g;

	
	static double jumpAmt = 10.5;

	boolean killed = false;
	boolean focusing = false;
	
	protected int leftLimit;
	protected int rightLimit;
	protected int mX,mY;
	protected static int moveAmount = 3;
	protected int mobMoveCounter = 50;
	
	int deathItem = 10;
	
	Random rand = new Random();
	int itemType;
	
	static int aggroRange = 100;
	

	
	public mob(Graphics g,int x, int y, int left, int right)
	{
		super(g);	
		isActive = false;
		this.mX = x;
		this.mY = y;
		hitBox = new Rectangle(mX,mY,40,40);
		this.leftLimit = left;
		this.rightLimit = right;
		healthPoints = 30;
		
		switch(rand.nextInt(5))
		{
		case 0: deathItem = 0; break;
		case 1: deathItem = 1;break;
		case 2: deathItem = 2;break;
		case 3: deathItem = 3;break;
		default: deathItem = 10;
		}
		
	}
	
	public mob(Graphics g, int x, int y, int left, int right, boolean active)
	{
		super(g);
		isActive = false;
		this.mX = x;
		this.mY = y;
		hitBox = new Rectangle(mX,mY,40,40);
		this.leftLimit = left;
		this.rightLimit = right;
		healthPoints = 30;
		if(active)this.setActive();
		
		switch(rand.nextInt(5))
		{
		case 0: deathItem = 0; break;
		case 1: deathItem = 1;break;
		case 2: deathItem = 2;break;
		case 3: deathItem = 3;break;
		default: deathItem = 10;
		}
	}


	
	
	public void move(Graphics g)
	{
		if(!getActive())
		{

			return;
		}
		if( healthPoints <= 0)
		{

			switch(deathItem)
			{
			case 0: gameFrame.frame.items.add(new item(g,"star",mX,mY)); gameFrame.frame.items.get(gameFrame.frame.items.size()-1).drop(); break;
			case 1: gameFrame.frame.items.add(new item(g,"wepPowerup",mX,mY)); gameFrame.frame.items.get(gameFrame.frame.items.size()-1).drop(); break;
			case 2: gameFrame.frame.items.add(new item(g,"speed",mX,mY)); gameFrame.frame.items.get(gameFrame.frame.items.size()-1).drop(); break;
			case 3: gameFrame.frame.items.add(new item(g,"jump",mX,mY)); gameFrame.frame.items.get(gameFrame.frame.items.size()-1).drop(); break;
			default: 
			
			}
			hitBox.setLocation(0,0);
			setInactive();
			setDead();
			return;
		}
		if(Math.abs(character.getPlayerX() - mX) >= aggroRange && !focusing)
		{
			//position
			if(mX>rightLimit)
			{
				gpos = 0;
				lookLeft1 = true;
			}
			if(mX<leftLimit)
			{
				gpos = 1;
				lookLeft1 = false;
			}
			if(gpos == 0)
			{
				mobJumpCounter++;
				mX -= moveAmount;
				hitBox.setLocation(mX,mY);
				mobMoveCounter++;
			}
			if(gpos == 1)
			{
				mobJumpCounter++;
				mX += moveAmount;
				hitBox.setLocation(mX,mY);
				mobMoveCounter++;
			}
			
			if(hitBox.contains(character.getPlayerX() +40,character.getPlayerY() + 20) && mobMoveCounter > 50 && character.getDashCounter() == 1)
			{
				character.subHP(10);
				mobMoveCounter = 0;
			}
			
			
			//jumping
			if(mobJumpCounter%100 == 0)
			{
				mobJumping = true;
			}
			if(mY <490)
			{
				mobGravity = true;
			}
			else
			{
				mobGravity  = false;
			}
			if (mobGravity)
			{
				mY +=5;
				hitBox.setLocation(mX,mY);
			}
			if (mobJumping)
			{
				if (jumpAmt > 0.0)
				{
					mY -= jumpAmt;
					jumpAmt -= 0.75;
					hitBox.setLocation(mX,mY);
				}
				else
				{
					mobJumping = false;
					jumpAmt = 10.5;
				}

			}
			
			//moving
			if(lookLeft1)
			{
				if(!lookSide)
				{
					g.drawImage(mobStillLeft,mX,mY,null);
					lookSide = true;
				} else 
				{
					g.drawImage(mobMoveLeft,mX,mY,null);
					lookSide = false;
				}
			} else{
				if(!lookSide)
				{
					g.drawImage(mobStillRight,mX,mY,null);
					lookSide = true;
				} else{
					g.drawImage(mobMoveRight,mX,mY,null);
					lookSide = false;
				}
			}
		}	else
			{
				if(character.getPlayerX() - mX > 0)
				{
					
					//AI right
						focusing = true;
						lookLeft1 = false;
						mobJumpCounter++;
						mX += moveAmount;
						hitBox.setLocation(mX,mY);
						mobMoveCounter++;
					
					
					if(hitBox.contains(character.getPlayerX() +40,character.getPlayerY() + 20) && mobMoveCounter > 50 && character.getDashCounter() == 1)
					{
						character.subHP(10);
						mobMoveCounter = 0;
					}
					
					
					//jumping
					if(mobJumpCounter%100 == 0)
					{
						mobJumping = true;
					}
					if(mY <490)
					{
						mobGravity = true;
					}
					else
					{
						mobGravity  = false;
					}
					if (mobGravity)
					{
						mY +=5;
						hitBox.setLocation(mX,mY);
					}
					if (mobJumping)
					{
						if (jumpAmt > 0.0)
						{
							mY -= jumpAmt;
							jumpAmt -= 0.75;
							hitBox.setLocation(mX,mY);
						}
						else
						{
							mobJumping = false;
							jumpAmt = 10.5;
						}

					}
					
					//moving
					if(lookLeft1)
					{
						if(!lookSide)
						{
							g.drawImage(mobStillLeft,mX,mY,null);
							lookSide = true;
						} else 
						{
							g.drawImage(mobMoveLeft,mX,mY,null);
							lookSide = false;
						}
					} else{
						if(!lookSide)
						{
							g.drawImage(mobStillRight,mX,mY,null);
							lookSide = true;
						} else{
							g.drawImage(mobMoveRight,mX,mY,null);
							lookSide = false;
						}
					}
				}
				else if(character.getPlayerX() - mX < 0)
				{
						// AI Left
						focusing = true;
						lookLeft1  = true;
						mobJumpCounter++;
						mX -= moveAmount;
						hitBox.setLocation(mX,mY);
						mobMoveCounter++;

					
					if(hitBox.contains(character.getPlayerX() +40,character.getPlayerY() + 20) && mobMoveCounter > 50 && character.getDashCounter() == 1)
					{
						character.subHP(10);
						mobMoveCounter = 0;
					}
					
					
					//jumping
					if(mobJumpCounter%100 == 0)
					{
						mobJumping = true;
					}
					if(mY <490)
					{
						mobGravity = true;
					}
					else
					{
						mobGravity  = false;
					}
					if (mobGravity)
					{
						mY +=5;
						hitBox.setLocation(mX,mY);
					}
					if (mobJumping)
					{
						if (jumpAmt > 0.0)
						{
							mY -= jumpAmt;
							jumpAmt -= 0.75;
							hitBox.setLocation(mX,mY);
						}
						else
						{
							mobJumping = false;
							jumpAmt = 10.5;
						}

					}
					
					//moving
					if(lookLeft1)
					{
						if(!lookSide)
						{
							g.drawImage(mobStillLeft,mX,mY,null);
							lookSide = true;
						} else 
						{
							g.drawImage(mobMoveLeft,mX,mY,null);
							lookSide = false;
						}
					} else{
						if(!lookSide)
						{
							g.drawImage(mobStillRight,mX,mY,null);
							lookSide = true;
						} else{
							g.drawImage(mobMoveRight,mX,mY,null);
							lookSide = false;
						}
					}
				}else 
				{
					focusing = false;
					if(mX < rightLimit)
					{
						lookLeft1 = true;
					}else 
					lookLeft1 = false;
				}
			}
				
			
			
		}
	
	
	
	
	
	
	public void setMobLocation(int x, int y)
	{
		this.mX = x;
		this.mY = y;
		hitBox.setLocation(mX,mY);
	}
	public int getMobX()
	{
		return mX;
	}
	public int getMobY()
	{
		return mY;
	}
	
	public void setActive()
	{
		this.isActive = true;
	}
	
	public void setInactive()
	{
		this.isActive = false;
	}
	
	public boolean getActive()
	{
		return isActive;
	}
	
	public boolean getDefeated()
	{
		return killed;
	}
	public void setDead()
	{
		killed = true;
	}
	
	public void setAggroRange(int x)
	{
		aggroRange = x;
	}
	public void setMoveAmount(int x)
	{
		moveAmount = x;
	}
	
	public void setLeftLimit(int x)
	{
		this.leftLimit = x;
	}
	
	public void setRightLimit(int x)
	{
		this.rightLimit = x;
	}
	
	public void setHP(int HP)
	{
		healthPoints = HP;
	}
	
	public int getHP()
	{
		return healthPoints;
	}
	
	public void addHP(int HP)
	{
		healthPoints += HP;
	}
	
	public void subHP(int HP)
	{
		healthPoints -= HP;
	}
	

}
