package drawingTool;

import java.awt.Color;

public class Head extends ColorClass{
	
	private Eye eye; // composite
	private Beak beak; // composite
	private Crown crown; // composite
	private double scale;
//	private static Color borderColor;
	
	public Head(){
		this(1);
	}
	
	public Head(double scale){
		this.scale = scale;
		crown = new Crown(scale);
		eye = new Eye(scale);
		beak = new Beak(scale);
//		borderColor = new Color(92, 47, 16);
	}
	
	public void drawAt(int left, int bottom) {
		
		crown.drawAt(left + (int)(95*scale), bottom);
		eye.drawAt(left + (int)(138*scale), bottom + (int)(55*scale));
		beak.drawAt(left, bottom + (int)(53*scale));
	}
	
//	public static Color getBorderColor() {
//		return borderColor;
//	}
}
