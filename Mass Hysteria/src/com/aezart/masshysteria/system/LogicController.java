package com.aezart.masshysteria.system;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.aezart.masshysteria.entity.Entity;
import com.aezart.masshysteria.entity.Wanderer;

public class LogicController implements Runnable{
	boolean running;
	boolean upHeld = false;
	boolean downHeld = false;
	boolean leftHeld = false;
	boolean rightHeld = false;
	GameCoordinate relpx_mousePosition = new GameCoordinate(0,0);
	GameCoordinate direction = new GameCoordinate(0,0);
	int relpx_xMouse;
	int relpx_yMouse;	
	
	public void start(){
		running = true;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void stop(){
		running = false;
	}
	@Override
	public void run() {
		while (running){
			int px_xPan = 0;
			int px_yPan = 0;
			int px_xDir = 0;
			int px_yDir = 0;
			if (leftHeld){
				px_xPan -= 2;
				px_xDir -= 1;
			}
			if (rightHeld){
				px_xPan += 2;
				px_xDir += 1;
			}
			if (upHeld){
				px_yPan -= 2;
				px_yDir -= 1;
			}
			if (downHeld){
				px_yPan += 2;
				px_yDir += 1;
			}
			if (px_xPan != 0 || px_yPan != 0){
				//
			}
			direction.setX(px_xDir);
			direction.setY(px_yDir);
			Game.leader().setDirection(direction); 
			//System.out.println("xDirection: " + direction.x());
			//System.out.println("yDirection: " + direction.y());

			for (Entity e: Game.gameEntities()){
				e.tick();
			}
			Game.leader().tick();
			Game.window().screen().centerScreenAt_abspx(Game.leader().abspx_xPos(), Game.leader().abspx_yPos());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void alertKeyPress(KeyEvent pressedKey) {
		switch (pressedKey.getKeyCode()){
		case KeyEvent.VK_UP:
			upHeld = true;
			break;
		case KeyEvent.VK_DOWN:
			downHeld = true;
			break;
		case KeyEvent.VK_LEFT:
			leftHeld = true;
			break;
		case KeyEvent.VK_RIGHT:
			rightHeld =true;
			break;
		}
	}
	
	public void alertKeyRelease(KeyEvent releasedKey){
		switch (releasedKey.getKeyCode()){
		case KeyEvent.VK_UP:
			upHeld = false;
			break;
		case KeyEvent.VK_DOWN:
			downHeld = false;
			break;
		case KeyEvent.VK_LEFT:
			leftHeld = false;
			break;
		case KeyEvent.VK_RIGHT:
			rightHeld = false;
			break;
		}
	}
	
	public void alertClick(MouseEvent clickEvent){
		int relpx_xClick = clickEvent.getX();
		int relpx_yClick = clickEvent.getY();
		
		GameCoordinate abspx_coords = Game.window().screen().abspx_from_relpx(relpx_xClick, relpx_yClick);
		for (Wanderer w: Game.gameEntities()){
			w.setDestination_abspx(abspx_coords.x(), abspx_coords.y());
		}
		
	}
	
	public void alertMouseMove(MouseEvent mouseMoveEvent){
		relpx_mousePosition.setX(mouseMoveEvent.getX());
		relpx_mousePosition.setY(mouseMoveEvent.getY());

	}
	
	public GameCoordinate relpx_mousePosition(){
		return relpx_mousePosition;
		
	}
}
