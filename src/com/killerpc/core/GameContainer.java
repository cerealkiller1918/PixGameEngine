package com.killerpc.core;

import com.killerpc.debuging.Debug;
import com.killerpc.debuging.DebugWindow;

public class GameContainer implements Runnable {

	private Thread thread;
	private AbstractGame game;
	private Window window;
	private Renderer renderer;
	private Input input;
	private Debug debug = new Debug();
	private DebugWindow debugWindow;

	private Runtime runtime = Runtime.getRuntime();
	private boolean showFPS = false;
	private int fps = 0;
	private boolean isRunning = false;
	private int width = 320, height = 240;
	private int scale = 2;
	private String Title = "Pix Engine V1.0";
	private boolean isAllWaysOnTop = false;
	private boolean isFullScreen = false;
	private String iconFileName;

	public GameContainer(AbstractGame game) {
		this.game = game;

	}

	public void start() {
		if (isRunning)
			return;
		// Initialize engine components
		window = new Window(this);
		renderer = new Renderer(this);
		input = new Input(this);
		
		debugWindow = new DebugWindow();
		thread = new Thread(this);
		thread.run();
		
	}
	
	

	public void stop() {
		if (!isRunning)
			return;
		
		isRunning = false;
	}

	public void run() {
		isRunning = true;
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		

		while (isRunning && window.isWindowOpen()) {
			boolean render = true;
			long now = System.nanoTime();
			
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				game.update(this, (float) delta);
				input.update();
				render = true;
				updates++;
				delta--;

			}
			
			if (render) {
				renderer.clear();
				game.render(this, renderer);
				if (showFPS) {
					renderer.drawString("FPS " + fps, 0xffffff00, 0, 0);
				}
				window.update();

				frames++;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				debug.setDebugData(updates, frames, runtime.totalMemory() - runtime.freeMemory());
				debugWindow.update(updates, frames);
				debugWindow.setDebugStates(debug.isDebugMode(), debug.isConsoleMode(), debug.isLoggerMode());
				fps = frames;
				updates = 0;
				frames = 0;
			}

		}
		debug.setError("Closing");
		cleanUp();
	}

	private void cleanUp() {
		window.cleanUp();
		debug.Logercleanup();
		debugWindow.cleanup();
		

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Window getWindow() {
		return window;
	}

	public void setShowFPS(boolean showFPS) {
		this.showFPS = showFPS;
	}


	public boolean isAllWaysOnTop() {
		return isAllWaysOnTop;
	}

	public void setAllWaysOnTop(boolean isAllWaysOnTop) {
		this.isAllWaysOnTop = isAllWaysOnTop;
	}

	public boolean isFullScreen() {
		return isFullScreen;
	}

	public void setFullScreen(boolean isFullScreen) {
		this.isFullScreen = isFullScreen;
	}

	public String getIconFileName() {
		return iconFileName;
	}

	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}
	
	public void startDebugWindow(){
		debugWindow.Window();
	}
	public void setDebugMode(boolean mode){
		debug.setDebugMode(mode);
	}
	public void setConsoleMode(boolean mode){
		debug.setConsoleMode(mode);
	}
	public void setLoggerMode(boolean mode){
		debug.setLoggerMode(mode);
	}

}
