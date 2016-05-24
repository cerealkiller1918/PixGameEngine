package com.killerpc.core.gfx;

public class Color {
	
	public static Color BLACK = new Color(1, 0, 0, 0);
	private float a, r, g, b;
	
	public Color(float a,float r,float g,float b){
		this.a = a;
		this.r = r; 
		this.g = g;
		this.b = b;
		
	}

	public float getA() {
		return a;
	}

	public float getR() {
		return r;
	}

	public float getG() {
		return g;
	}

	public float getB() {
		return b;
	}
	
}
