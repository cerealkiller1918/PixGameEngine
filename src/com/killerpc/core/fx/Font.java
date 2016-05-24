package com.killerpc.core.fx;



public enum Font {
	
	STANDARD("/fonts/standard.png");
	
	private final int NUM_UNICODES = 60;
	private int[] offsets = new int[NUM_UNICODES];
	private int[] widths  = new int[NUM_UNICODES];
	private Image image;
	
	Font(String path) {
		
		image = new Image(path);
		int unicode = -1;
		
		for(int x = 0; x < image.getWidth(); x++){
			int color = image.getPixels()[x];
			
			if(color == 0xff0000ff){
				unicode++;
				offsets[unicode] = x;
			}
			if(color == 0xffffff00){
				widths[unicode]= x - offsets[unicode];
			}
		}
		
	}

	public int[] getOffsets() {
		return offsets;
	}

	public int[] getWidths() {
		return widths;
	}

	public Image getImage() {
		return image;
	}

}
