package drawingTool;

import java.awt.Color;

public class Crown extends ColorClass{
	private int width;
	private int height;
	
	public Crown() {
		this(1,135,135);
	}
	
	public Crown(double scale) {
		this(scale,135,135);
	}
	
	public Crown(double scale, int width, int height) {
		this.width = (int)(width*scale);
		this.height = (int)(height*scale);
	}
	
	public void drawAt(int left, int bottom) {
		
		Drawing.pen().setColor(Color.WHITE);
		//Drawing.pen().setColor(Abdomen.getBodyColor());
		Drawing.pen().fillOval(left, bottom, width, height);
		Drawing.pen().setColor(super.getBorderColor());
		Drawing.pen().drawArc(left, bottom, width, height, -17, 287);
	}
}
