package com.aezart.masshysteria.entity;

import java.awt.image.BufferedImage;

public class Wanderer extends Entity {
	private boolean hasDestination = false;
	
	public void setDestination_abspx(int abspx_x, int abspx_y){
		abspx_destination.setX(abspx_x + 16 - (int)(Math.random()*32));
		abspx_destination.setY(abspx_y + 16 - (int)(Math.random()*32));
		hasDestination = true;
	}

	public void tick(){
		super.tick();
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
	}
	
	public Wanderer(){
		super();
	}
	public Wanderer(int x, int y){
		super(x,y);
	}
	public Wanderer (BufferedImage spr){
		super(spr);
	}
	public Wanderer(int x, int y, BufferedImage spr){
		super(x,y,spr);
	}
}
