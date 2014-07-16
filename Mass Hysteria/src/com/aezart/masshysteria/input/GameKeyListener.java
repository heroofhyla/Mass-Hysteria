package com.aezart.masshysteria.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.aezart.masshysteria.system.Game;

public class GameKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent pressedKey) {
		Game.logicController().alertKeyPress(pressedKey);
	}

	@Override
	public void keyReleased(KeyEvent releasedKey) {
		Game.logicController().alertKeyRelease(releasedKey);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
