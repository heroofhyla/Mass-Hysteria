package com.aezart.masshysteria.entity;

import java.awt.image.BufferedImage;

import com.aezart.masshysteria.system.Game;

public class Leader extends Entity {
	public void tick(){
		super.tick();
		Game.window().setTitle("X: " + abspx_xPos + "Y: " + abspx_yPos);
	}
	
	public Leader(){
		super();
	}
	public Leader(int x, int y){
		super(x,y);
	}
	public Leader(BufferedImage sprite){
		super(sprite);
	}
	public Leader(int x, int y, BufferedImage sprite){
		super(x,y,sprite);
		System.out.println("Leader created.");

	}
	
}
