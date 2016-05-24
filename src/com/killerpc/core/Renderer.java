package com.killerpc.core;


import java.awt.image.DataBufferInt;

import com.killerpc.core.fx.Font;
import com.killerpc.core.fx.Image;

public class Renderer {
	
	private int width, height;
	private int[] pixels;
	private Font font = Font.STANDARD;
	
	public Renderer(GameContainer gc){
		this.width = gc.getWidth();
		this.height= gc.getHeight();
		this.pixels = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void setPixel(int x, int y, int color){
		if((x < 0 || x >= width || y < 0 || y >= height)|| color == 0xffff00ff)
			return;
		pixels[x+y*width]= color;
		
	}
	
	public void drawString(String text, int color, int offX, int offY){
		
		text = text.toUpperCase();
		int offset=0;
		for(int i = 0; i < text.length(); i++){
			int unicode = text.codePointAt(i) - 32;
			
			for (int x = 0; x < font.getWidths()[unicode]; x++){
				for(int y = 1; y < font.getImage().getHeight(); y++){
					if(font.getImage().getPixels()[(x+font.getOffsets()[unicode])+y*font.getImage().getWidth()] == 0xffffffff)
						setPixel(x+offX+offset, y+offY-1, color );
				}
			}
			offset+= font.getWidths()[unicode];
		}
		
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
