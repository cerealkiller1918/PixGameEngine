package com.killerpc.core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Window {
	
	private JFrame frame;
	private Canvas canvas;
	private BufferedImage image;
	private Graphics g;
	private BufferStrategy bs;
	
	
	public Window(GameContainer gc){
		image =new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_INT_RGB);
		canvas = new Canvas();
		Dimension s = new Dimension(gc.getWidth()* gc.getScale(), gc.getHeight()* gc.getScale());
		ImageIcon icon = new ImageIcon(gc.getIconFileName());
		canvas.setPreferredSize(s);
		canvas.setMaximumSize(s);
		canvas.setMinimumSize(s);
		frame = new JFrame(gc.getTitle());
		frame.setIconImage(icon.getImage());
		frame.setUndecorated(gc.isFullScreen());
		frame.setAlwaysOnTop(gc.isAllWaysOnTop());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		try{
		g.dispose();
		bs.dispose();
		image.flush();
		if(frame.isVisible()){
			frame.dispose();
		}
		}catch(Exception e){
			
		}
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public boolean isWindowOpen(){
		return frame.isVisible();
	}

}
