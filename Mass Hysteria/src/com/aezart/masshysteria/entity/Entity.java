package com.aezart.masshysteria.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.aezart.masshysteria.system.Game;
import com.aezart.masshysteria.system.GameCoordinate;

public class Entity {
	private int xDirection = 0;
	private int yDirection = 0;
	private BufferedImage sprite;
	private GameCoordinate abspx_destination;
	private boolean hasDestination = false;
	
	private int abspx_xPos;
	private int abspx_yPos;
	
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
	
	public void setDestination_abspx(int abspx_x, int abspx_y){
		abspx_destination.setX(abspx_x + 16 - (int)(Math.random()*32));
		abspx_destination.setY(abspx_y + 16 - (int)(Math.random()*32));
		hasDestination = true;
	}
	public void tick(){
		abspx_xPos += xDirection;
		abspx_yPos += yDirection;
		
		
		if (!hasDestination){
			abspx_destination.setX((int)(Math.random()*1280)); 
			abspx_destination.setY((int)(Math.random()*1024));
			hasDestination = true;
		}else{
			xDirection = 0;
			yDirection = 0;
			if (abspx_destination.x() - abspx_xPos > 0){
				xDirection = 1;
			}
			if (abspx_destination.x() - abspx_xPos < 0){
				xDirection = -1;
			}
			if (abspx_destination.y() - abspx_yPos > 0){
				yDirection = 1;
			}
			if (abspx_destination.y() - abspx_yPos < 0){
				yDirection = -1;
			}
			if (abspx_destination.x() == abspx_xPos && abspx_destination.y() == abspx_yPos){
				hasDestination = false;
			}
		}
		
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
	
}
