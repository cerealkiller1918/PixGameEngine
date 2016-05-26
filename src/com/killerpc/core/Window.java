package com.killerpc.core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;


public class Window {
	
	private JFrame frame;
	private Canvas canvas;
	private BufferedImage image;
	private Graphics g;
	private BufferStrategy bs;
	private int width,height,scale;
	
	
	public Window(GameContainer gc){
		image =new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_INT_RGB);
		canvas = new Canvas();
		Dimension s;
		if(!gc.isFullScreen()){
			s = new Dimension(gc.getWidth()* gc.getScale(), gc.getHeight()* gc.getScale());
		}
		else{
			s = new Dimension(width*scale, height*scale);
		}
		canvas.setPreferredSize(s);
		canvas.setMaximumSize(s);
		canvas.setMinimumSize(s);
		frame = new JFrame(gc.getTitle());
		frame.setUndecorated(gc.isFullScreen());
		frame.setAlwaysOnTop(gc.isAllWaysOnTop());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas.createBufferStrategy(2);
		bs = canvas.getBufferStrategy();
		g = bs.getDrawGraphics();
	}
	
	public void update(){
		
		g.drawImage(image, 0, 0, canvas.getWidth(),canvas.getHeight(), null);
		bs.show();
		
	}
	
	public void cleanUp(){
		
		g.dispose();
		bs.dispose();
		image.flush();
		frame.dispose();
		
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public void setFullScreen(){
		Toolkit tk = Toolkit.getDefaultToolkit();
		double tempWidth = tk.getScreenSize().getWidth();
		double tempHeight = (int)tk.getScreenSize().getHeight();
		double tempScale = (tempWidth-tempHeight)/16.0;
		
		this.width = (int)(tempWidth/tempScale);
		this.height = (int)(tempHeight/tempScale);
		this.scale = (int)tempScale;
		
	}
}
