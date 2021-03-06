package com.killerpc.core.fx;

public class Light {
	
	private int[] lm;
	private int color, radius, diameter;
	
	public Light (int color, int radius){
		this.color = color;
		this.radius = radius;
		this.diameter = radius * 2;
		lm = new int[diameter * diameter];
		for(int x = 0; x < diameter; x++){
			for(int y = 0; y < diameter; y++){
				float distance = (float)Math.sqrt((x-radius) * (x-radius) + (y - radius) * (y - radius));
				if(distance < radius)
					lm[x + y * diameter] = Pixel.getColorPower(color, 1 - distance / radius);
				else
					lm[x + y * diameter] = 0xff000000;
			}
		}
	}
	public int getLightValue(int x, int y){
		if(x < 0 || x >= diameter || y < 0 || y >= diameter)
			return 0xff000000;
		return lm[x + y * diameter];
	}
	public int[] getLm() {
		return lm;
	}
	
	public int getColor() {
		return color;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getDiameter() {
		return diameter;
	}

}
