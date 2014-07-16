package com.aezart.masshysteria.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.aezart.masshysteria.system.Game;

public class GameMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent clickEvent) {
		//System.out.println("Mouse click at " + clickEvent.getX() + ", " + clickEvent.getY());
		//Game.logicController().alertClick(clickEvent);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent clickEvent) {
		System.out.println("Mouse release at " + clickEvent.getX() + ", " + clickEvent.getY());
		Game.logicController().alertClick(clickEvent);		
	}
	
}
