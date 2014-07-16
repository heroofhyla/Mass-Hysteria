package com.aezart.masshysteria.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.aezart.masshysteria.system.Game;
import com.aezart.masshysteria.system.GameCoordinate;

public class Entity {
	protected int xDirection = 0;
	protected int yDirection = 0;
	private BufferedImage sprite;
	protected GameCoordinate abspx_destination;
	
	protected int abspx_xPos;
	protected int abspx_yPos;
	
	public int abspx_xPos(){
		return abspx_xPos;
	}
	public int abspx_yPos(){
		return abspx_yPos;
	}
	
	public Entity(){
		this(0,0,null);
	}
	
	public Entity(int abspx_x, int abspx_y){
		this(abspx_x,abspx_y,null);
	}
	
	public Entity(BufferedImage sprite){
		this(0,0,sprite);
	}
	
	public Entity(int abspx_x, int abspx_y, BufferedImage sprite){
		abspx_xPos = abspx_x;
		abspx_yPos = abspx_y;
		this.sprite = sprite;
		abspx_destination = new GameCoordinate(abspx_xPos,abspx_yPos);
	}
	
	public void draw(Graphics g){
		g.drawImage(sprite, abspx_xPos - Game.window().screen().px_xOffset(), abspx_yPos - Game.window().screen().px_yOffset(), null);

	}
	
	
	public void tick(){
		abspx_xPos += xDirection;
		abspx_yPos += yDirection;
		
		
		if (abspx_xPos < 0){
			abspx_xPos = Game.currentMap().px_xSize() - 1;
		}
		if (abspx_xPos >= Game.currentMap().px_xSize()){
			abspx_xPos = 0;
		}
		
		if (abspx_yPos < 0){
			abspx_yPos = Game.currentMap().px_ySize() - 1;
		}
		if (abspx_yPos >= Game.currentMap().px_ySize()){
			abspx_yPos = 0;
		}
		
	}
	
	public void setDirection(GameCoordinate coords){
		
		xDirection = coords.x();
		yDirection = coords.y();
	}
	
}
