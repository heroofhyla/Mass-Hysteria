package com.aezart.masshysteria.system;

public class GraphicsController implements Runnable {
	boolean running = false;
	
	public void start() {	
		running = true;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		int forceQuit = 0;
		long startTime;
		long elapsedTime;
		long toSleep;
		while (running){
			//System.out.println("Graphics update");
			startTime = System.nanoTime();
			Game.window().repaint();
			elapsedTime = System.nanoTime() - startTime;
			toSleep = 33333333 - (elapsedTime);
			if (toSleep > 0){
				try {
					Thread.sleep(toSleep/1000000, (int)toSleep%1000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
