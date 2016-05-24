package com.killerpc.core;

import java.awt.image.DataBufferByte;

import com.killerpc.core.gfx.Color;

public class Renderer {
	
	private int width, height;
	private byte[] pixels;
	
	public Renderer(GameContainer gc){
		this.width = gc.getWidth();
		this.height= gc.getHeight();
		this.pixels = ((DataBufferByte)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void setPixel(int x, int y,Color c){
		if((x < 0 || x >= width || y < 0 || y >= height)|| c.getA()==0)
			return;
		int index = (x+y*width)*4;
		pixels[index]=(byte)((c.getA()*255f)+ 0.5f);
		pixels[index+1]=(byte)((c.getB()*255f)+ 0.5f);
		pixels[index+2]=(byte)((c.getG()*255f)+ 0.5f);
		pixels[index+3]=(byte)((c.getR()*255f)+ 0.5f);
	}
	
	
	public void clear(){
		for (int x=0; x<width; x++){
			for(int y=0; y< height; y++){
				setPixel(x, y,Color.BLACK);
			}
		}
	}

}
