package drawingTool;

import java.awt.Color;

public class Thorax extends ColorClass{
	private double scale;
	private static Color bellyColor;
	
	public Thorax() {
		this.scale = 1;
	}
	
	public Thorax(double scale) {
		this.scale = scale;
		this.bellyColor = super.getBodyColor();
	}
	
	public static Color getBellyColor() {
		return bellyColor;
	}
	
	public static void setBellyColor(Color c) {
		bellyColor = c;
	}
	
	public void drawAt(int left, int bottom) {
		int[] xCoordinateOfThorax = {51,115,97,97,0};
		int[] yCoordinateOfThorax = {47,0,95,163,163};
		int[] xCoordinatesOfThoraxs = new int[xCoordinateOfThorax.length];
		int[] yCoordinatesOfThoraxs = new int[yCoordinateOfThorax.length];
		for(int i=0; i<xCoordinateOfThorax.length; i++){
			xCoordinatesOfThoraxs[i] = left + (int)(scale * xCoordinateOfThorax[i]);
	    }
		for(int i=0; i<yCoordinateOfThorax.length; i++){
			yCoordinatesOfThoraxs[i] = bottom + (int)(scale * yCoordinateOfThorax[i]);
	    }
		
		Drawing.pen().setColor(getBellyColor());
		Drawing.pen().fillPolygon(xCoordinatesOfThoraxs, yCoordinatesOfThoraxs, 5);
		Drawing.pen().setColor(super.getBorderColor());
		
		Drawing.pen().drawLine(xCoordinatesOfThoraxs[0], yCoordinatesOfThoraxs[0], xCoordinatesOfThoraxs[4], yCoordinatesOfThoraxs[4]);
		Drawing.pen().drawLine(xCoordinatesOfThoraxs[1], yCoordinatesOfThoraxs[1], xCoordinatesOfThoraxs[2], yCoordinatesOfThoraxs[2]);
	}
}
