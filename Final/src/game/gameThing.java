package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import javax.imageio.ImageIO;

abstract public class gameThing {

	protected boolean isActive;
	protected static Graphics g;
	static Image mobMoveLeft,mobStillLeft;
	static Image mobMoveRight,mobStillRight;
	static Image spriteStillRight,spriteRight;
	static Image spriteStillLeft,spriteLeft;
	static Image fireBallLeft,fireBallRight;
	static Image dashLeft,dashRight;
	static Image titleBackground;
	static Image meteorDown;
	static Image speedPowerUp,jumpPowerUp,damagePowerUp;
	
	protected Rectangle hitBox;
	protected int healthPoints;
	protected static Rectangle dashHitBox;
	


		
	public gameThing(Graphics g)
	{
		isActive = true;
		gameThing.g = g; 
		mobMoveRight = getImage("mobMoveRight.png");
		mobMoveLeft = getImage("mobMoveLeft.png");
		mobStillLeft = getImage("mobStillLeft.png");
		mobStillRight = getImage("mobStillRight.png");
		spriteStillRight = getImage("spriteLookRight.png");
		spriteRight = getImage("spriteMoveRight.png");
		spriteStillLeft = getImage("spriteLookLeft.png");
		spriteLeft = getImage("spriteMoveLeft.png");
		fireBallLeft = getImage("fireBallLeft.png");
		fireBallRight = getImage("fireBallRight.png");
		dashLeft = getImage("dashLeft.png");
		dashRight = getImage("dashRight.png");
		titleBackground = getImage("titleBackground.png");
		meteorDown = getImage("meteorDown.png");
		speedPowerUp = getImage("speedPowerUp.png");
		jumpPowerUp = getImage("jumpPowerUp.png");
		damagePowerUp = getImage("swordPowerUp.png");

		healthPoints = 100;
	}
	public static Image getImage(String s){
		try{
			return ImageIO.read(new File(s));
		}
		catch(Exception e) {}
		return null;
	}
	
	public boolean isActive()  		{ return isActive;  	}
}
