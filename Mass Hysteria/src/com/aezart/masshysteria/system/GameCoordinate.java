package com.aezart.masshysteria.system;

public class GameCoordinate {
	private int x;
	private int y;
	
	public int x(){
		return x;
	}
	public int y(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public GameCoordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
}
