package com.aezart.masshysteria.gui;

import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.aezart.masshysteria.input.GameKeyListener;

public class GameWindow extends JFrame{
	private GameScreen screen;
	private GameKeyListener keyListener;

	
	public GameWindow(){
		keyListener = new GameKeyListener(); 
		this.addKeyListener(keyListener);
		screen = new GameScreen();
		this.setTitle("Mass Hysteria");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(screen);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public GameScreen screen(){
		return screen;
	}	
}
