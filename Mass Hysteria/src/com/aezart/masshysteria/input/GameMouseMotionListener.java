package com.aezart.masshysteria.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import com.aezart.masshysteria.system.Game;

public class GameMouseMotionListener implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent mouseMoveEvent) {
		Game.logicController().alertMouseMove(mouseMoveEvent);
	}
	

}
