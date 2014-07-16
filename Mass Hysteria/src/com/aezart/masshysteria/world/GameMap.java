package com.aezart.masshysteria.world;

public class GameMap {
	private int px_xSize;
	private int px_ySize;
	
	public GameMap(int px_x, int px_y){
		px_xSize = px_x;
		px_ySize = px_y;
	}
	
	public GameMap(int ti_x, int ti_y, int tileDim){
		px_xSize = ti_x * tileDim;
		px_ySize = ti_y * tileDim;
	}
	
	public int px_xSize(){
		return px_xSize;
	}
	public int px_ySize(){
		return px_ySize;
	}
}
