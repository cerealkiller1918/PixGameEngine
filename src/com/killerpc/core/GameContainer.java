package com.killerpc.core;

public class GameContainer implements Runnable{
	
	private Thread thread;
	private AbstractGame game;
	private Window window;
	private Renderer renderer;
	private Input input;
	
	private Runtime runtime = Runtime.getRuntime();
	private boolean debugMode = false;
	private boolean showFPS = false;
	private int fps =0;
	private boolean isRunning = false;
	private int width =320, height = 240;
	private int scale = 2;
	private String Title = "Pix Engine V1.0";
	
	public GameContainer(AbstractGame game)
	{
		this.game = game;

	}
	
	public void start()
	{
		if(isRunning)
			return;
		//Initialize engine components
		window = new Window(this);
		renderer = new Renderer(this);
		input = new Input(this);
		
		thread = new Thread(this);
		thread.run();
	}
	
	public void stop()
	{
		if(!isRunning)
			return;
		
		isRunning=false;
	}
	
	public void run()
	{
		isRunning =true;
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(isRunning){
			boolean render = true;
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				game.update(this, (float)delta);
				input.update();
				render = true;
				updates++;
				delta--;
				
			}
			
			if(render){
			renderer.clear();
			game.render(this, renderer);
			if(showFPS){
				renderer.drawString("FPS "+fps, 0xffffff00, 0, 0);
			}
			window.update();
			
			frames++;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				if(debugMode){
					long menory = runtime.totalMemory() - runtime.freeMemory();
					long mega = menory/1048576;
					System.out.println("Ticks " + updates + " | FPS " + frames + " | Menory "+mega+" MB "+menory+" bytes " +runtime.maxMemory()/1048576+" MB Total");
				}
				fps = frames;
				updates = 0;
				frames = 0;
			}
			
			
			
			
			
				
			
		}
		cleanUp();
	}
	
	private void cleanUp()
	{
		window.cleanUp();
		
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

	public boolean isDebugMode() {
		return debugMode;
	}

	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}


}
