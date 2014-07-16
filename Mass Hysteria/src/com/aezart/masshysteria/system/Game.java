package com.aezart.masshysteria.system;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.aezart.masshysteria.entity.Leader;
import com.aezart.masshysteria.entity.Wanderer;
import com.aezart.masshysteria.gui.GameWindow;
import com.aezart.masshysteria.world.GameMap;

public class Game {
	private static GameWindow window;
	private static GameMap currentMap;
	private static ArrayList<Wanderer> wanderers = new ArrayList<Wanderer>();
	private static LogicController logicController;
	private static GraphicsController graphicsController;
	private static GameCoordinate abspx_targetCoordinate;
	private static Leader leader;

	public static void main(String args[]){
		window = new GameWindow();
		
		abspx_targetCoordinate = new GameCoordinate(640,512);
		BufferedImage guySprite = null;
		BufferedImage leaderSprite = null;
		BufferedImage backgroundGrass = null;
		try{
			guySprite = ImageIO.read(new File("littleguy.png"));
			leaderSprite = ImageIO.read(new File("littleleader.png"));
			backgroundGrass = ImageIO.read(new File("greenborder.png"));
			for (int i = 0; i < 128; i++){
				wanderers.add(new Wanderer((int)(Math.random() * 1280), (int)(Math.random() * 1024),guySprite));
			}
			leader = new Leader(256,256,leaderSprite);
			currentMap = new GameMap(backgroundGrass);
		}catch (IOException e){
			
		}
		window.init();
		graphicsController = new GraphicsController();
		logicController = new LogicController();
		graphicsController.start();
		logicController.start();
	}
	
	public static GameWindow window(){
		return window;
	}
	
	public static GameMap currentMap(){
		return currentMap;
	}
	
	public static ArrayList<Wanderer> gameEntities(){
		return wanderers;
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
	public static Leader leader(){
		return leader;
	}
}
