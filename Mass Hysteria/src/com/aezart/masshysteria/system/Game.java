package com.aezart.masshysteria.system;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.aezart.masshysteria.entity.Entity;
import com.aezart.masshysteria.gui.GameWindow;
import com.aezart.masshysteria.world.GameMap;

public class Game {
	private static GameWindow window;
	private static GameMap currentMap;
	private static ArrayList<Entity> gameEntities = new ArrayList<Entity>();
	private static LogicController logicController;
	private static GraphicsController graphicsController;
	private static GameCoordinate abspx_targetCoordinate;

	public static void main(String args[]){
		window = new GameWindow();
		currentMap = new GameMap(1280, 1024);
		graphicsController = new GraphicsController();
		logicController = new LogicController();
		abspx_targetCoordinate = new GameCoordinate(640,512);
		BufferedImage guySprite = null;
		try{
			guySprite = ImageIO.read(new File("littleguy.png"));
			for (int i = 0; i < 128; i++){
				gameEntities.add(new Entity((int)(Math.random() * 1280), (int)(Math.random() * 1024),guySprite));
			}
		}catch (IOException e){
			
		}
		graphicsController.start();
		logicController.start();
	}
	
	public static GameWindow window(){
		return window;
	}
	
	public static GameMap currentMap(){
		return currentMap;
	}
	
	public static ArrayList<Entity> gameEntities(){
		return gameEntities;
	}
	
	public static LogicController logicController(){
		return logicController;
	}
	
	public static GraphicsController graphicsController(){
		return graphicsController;
	}
	
	public static GameCoordinate abspx_targetCoordinate(){
		return abspx_targetCoordinate;
	}
}
