package com.aezart.masshysteria.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.aezart.masshysteria.entity.Entity;
import com.aezart.masshysteria.input.GameKeyListener;
import com.aezart.masshysteria.input.GameMouseListener;
import com.aezart.masshysteria.input.GameMouseMotionListener;
import com.aezart.masshysteria.system.Game;
import com.aezart.masshysteria.system.GameCoordinate;

public class GameScreen extends JPanel{
	public static final int px_DEFAULT_SCREEN_WIDTH = 640;
	public static final int px_DEFAULT_SCREEN_HEIGHT = 480;
	private GameMouseListener mouseListener;
	private GameMouseMotionListener mouseMotionListener;
	
	private int px_xOffset;
	private int px_yOffset;
	
	public int px_xOffset(){
		return px_xOffset;
	}
	public int px_yOffset(){
		return px_yOffset;
	}
	
	public int abspx_xScreenCenter(){
		return px_xOffset + px_DEFAULT_SCREEN_WIDTH/2;
	}
	public int abspx_yScreenCenter(){
		return px_yOffset + px_DEFAULT_SCREEN_HEIGHT/2;
	}
	
	public GameCoordinate abspx_from_relpx(int relpx_x, int relpx_y){
		return new GameCoordinate(relpx_x + px_xOffset, relpx_y + px_yOffset);
	}
	
	public void centerScreenAt_abspx(int x, int y){
		
		px_xOffset = x - px_DEFAULT_SCREEN_WIDTH/2;
		px_yOffset = y - px_DEFAULT_SCREEN_HEIGHT/2;
		
		//Don't want camera to show stuff past the edges of the screen
		px_xOffset = Math.max(0, px_xOffset);
		px_xOffset = Math.min(Game.currentMap().px_xSize() - px_DEFAULT_SCREEN_WIDTH, px_xOffset);
		px_yOffset = Math.max(0, px_yOffset);
		px_yOffset = Math.min(Game.currentMap().px_ySize() - px_DEFAULT_SCREEN_HEIGHT, px_yOffset);
		System.out.println("Recentering view " + px_xOffset + ", " + px_yOffset);
	}
	
	public void panScreenToward_abspx(int abspx_x, int abspx_y, int px_speed){
		int px_xDelta = abspx_x - abspx_xScreenCenter();
		int px_yDelta = abspx_y - abspx_yScreenCenter();
		
		//cap the maximum change in x and y based on px_speed
		//Don't care exactly how accurate speed is, so simply moves up to speed along each axis instead of doing trig
		if (px_xDelta < 0){
			px_xDelta = Math.max(px_xDelta, -1*px_speed);
		}
		if (px_xDelta > 0){
			px_xDelta = Math.min(px_xDelta, px_speed);
		}
		if (px_yDelta < 0){
			px_yDelta = Math.max(px_yDelta, -1*px_speed);
		}
		if (px_yDelta > 0){
			px_yDelta = Math.min(px_yDelta, px_speed);
		}
		
		centerScreenAt_abspx(px_xDelta + px_xOffset, px_yDelta + px_yOffset);
	}
	
	public void panScreen_abspx(int abspx_x, int abspx_y){
		centerScreenAt_abspx(abspx_x + px_xOffset + px_DEFAULT_SCREEN_WIDTH/2, abspx_y + px_yOffset + px_DEFAULT_SCREEN_HEIGHT/2);
	}
	public GameScreen(){
		this.setPreferredSize(new Dimension(px_DEFAULT_SCREEN_WIDTH, px_DEFAULT_SCREEN_HEIGHT));
		mouseListener = new GameMouseListener();
		mouseMotionListener = new GameMouseMotionListener();
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseMotionListener);

	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, px_DEFAULT_SCREEN_WIDTH, px_DEFAULT_SCREEN_HEIGHT);
		for (Entity e: Game.gameEntities()){
			e.draw(g);
		}
		g.setColor(Color.red);
		g.fillRect(Game.logicController().relpx_mousePosition().x(), Game.logicController().relpx_mousePosition().y(), 2, 2);
	}
}
