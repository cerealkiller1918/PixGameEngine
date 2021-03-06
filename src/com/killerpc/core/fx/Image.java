package com.killerpc.core.fx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
	
	private int width, height;
	private int[] pixels;
	private ShadowType shadowType = ShadowType.NONE;
	
	public Image(String path){
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(Image.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
		
		
		image.flush();
	}
	public Image(int width, int height, int[]pixels){
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getPixels() {
		return pixels;
	}
	public ShadowType getShadowType() {
		return shadowType;
	}
	

}
