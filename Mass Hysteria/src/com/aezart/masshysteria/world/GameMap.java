package com.aezart.masshysteria.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.aezart.masshysteria.system.Game;

public class GameMap {
	private int px_xSize;
	private int px_ySize;
	
	BufferedImage backgroundImage = null;
	
	public GameMap(int px_x, int px_y){
		px_xSize = px_x;
		px_ySize = px_y;
	}
	
	public GameMap(int ti_x, int ti_y, int tileDim){
		px_xSize = ti_x * tileDim;
		px_ySize = ti_y * tileDim;
	}
	
	public GameMap(BufferedImage backgroundImage){
		px_xSize = backgroundImage.getWidth();
		px_ySize = backgroundImage.getHeight();
		this.backgroundImage = backgroundImage;
	}
	public int px_xSize(){
		return px_xSize;
	}
	public int px_ySize(){
		return px_ySize;
	}
	
	public void setBackgroundImage(BufferedImage image){
		backgroundImage = image;
	}
	
	public void draw(Graphics g){
		g.drawImage(backgroundImage, -1 * Game.window().screen().px_xOffset(), -1 * Game.window().screen().px_yOffset(), null);
	}
}
