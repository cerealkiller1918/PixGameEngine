package com.killerpc.core;


import java.awt.image.DataBufferInt;

import com.killerpc.core.gfx.Image;

public class Renderer {
	
	private int width, height;
	private int[] pixels;
	
	public Renderer(GameContainer gc){
		this.width = gc.getWidth();
		this.height= gc.getHeight();
		this.pixels = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void setPixel(int x, int y, int color){
		if(x < 0 || x >= width || y < 0 || y >= height)
			return;
		pixels[x+y*width]= color;
		
	}
	
	
	public void clear(){
		for (int x=0; x<width; x++){
			for(int y=0; y< height; y++){
				setPixel(x, y,0xff000000);
			}
		}
	}
	
	public void drawImage(Image image, int offX, int offY){
		for (int x=0; x<image.getWidth(); x++){
			for(int y=0; y< image.getHeight(); y++){
				setPixel(x+offX, y+offY,image.getPixels()[x+y*image.getWidth()]);
			}
		}
	}

}
