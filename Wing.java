package drawingTool;

import java.awt.Color;

public class Wing extends ColorClass{
	
	private double scale;
	
	public Wing() {
		this(1);
	}
	
	public Wing(double scale) {
		this.scale = scale;
	}
	
	public void drawAt(int left, int bottom) {
		
		int[] polygonXCoordinate = {9,22,58,149,223,206,156,198,186,109,94,109,186,176,148,71,38,56,15,11,0};
		int[] polygonYCoordinate = {13,4,0,45,113,119,102,127,135,124,117,124,135,134,144,134,109,133,102,108,77};
		int[] polygonXCoordinates = new int[polygonXCoordinate.length];
		int[] polygonYCoordinates = new int[polygonYCoordinate.length];
		for(int i=0; i<polygonXCoordinate.length; i++){
			polygonXCoordinates[i] = left + (int)(scale * polygonXCoordinate[i]);
	    }
		for(int i=0; i<polygonYCoordinate.length; i++){
			polygonYCoordinates[i] = bottom + (int)(scale * polygonYCoordinate[i]);
	    }
		Drawing.pen().setColor(Color.WHITE);
		//Drawing.pen().setColor(Abdomen.getBodyColor());
		Drawing.pen().fillPolygon(polygonXCoordinates, polygonYCoordinates, polygonXCoordinates.length);
		Drawing.pen().setColor(super.getBorderColor());
		Drawing.pen().drawPolyline(polygonXCoordinates, polygonYCoordinates, polygonXCoordinates.length);
	}
	
}
