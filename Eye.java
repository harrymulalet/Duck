package drawingTool;

import java.awt.Color;

public class Eye extends ColorClass{
	private int width;
	private int height;
	private double scale;
	
	public Eye() {
		this(1, 17, 22);
	}
	
	public Eye(double scale) {
		this(scale, 17, 22);
	}
	
	public Eye(double scale, int width, int height) {
		this.scale = scale;
		this.width = (int)(width * scale);
		this.height = (int)(height * scale);
	}
	
	public void drawAt(int left, int bottom) {
		
		Drawing.pen().setColor(super.getBorderColor());
		Drawing.pen().fillOval(left, bottom, width, height);
		Drawing.pen().setColor(Color.WHITE);
		Drawing.pen().fillOval(left + (int)(3*scale), bottom + (int)(3*scale), width/3, height/3);
	}
}