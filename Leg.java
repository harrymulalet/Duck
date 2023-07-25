package drawingTool;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Leg extends ColorClass{
	
	private double scale;
	private Color beakColor;
	private Color borderColor;
//	private static int height;
	
	public Leg() {
		
		this(1);
		
	}
	
	public Leg(double scale) {
		
		this.scale = scale;
		this.beakColor = super.getBeakColor();
		this.borderColor = super.getBorderColor();
		
	}
	
//	public static int getHeight() {
//		return height;
//	}
//	
//	public void setHeight(int yStart, int yStop) {
//		Leg.height = yStop - yStart;
//	}
	
	public void drawAt(int left, int bottom) {
		
		int[] polygonXCoordinatesArray = {66,70,36,0,7,53,57,28,35,57,77,77,65,82,97,96,87,84};
		int[] polygonYCoordinatesArray = {0,36,48,68,67,47,49,74,72,55,47,62,96,79,44,37,31,0};
		Integer[] polygonXCoordinatesArrays = new Integer[polygonXCoordinatesArray.length];
		Integer[] polygonYCoordinatesArrays = new Integer[polygonYCoordinatesArray.length];
		for(int i=0; i<polygonXCoordinatesArray.length; i++){
			polygonXCoordinatesArrays[i] = left + (int)(scale * polygonXCoordinatesArray[i]);
	    }
		for(int i=0; i<polygonYCoordinatesArray.length; i++){
			polygonYCoordinatesArrays[i] = bottom + (int)(scale * polygonYCoordinatesArray[i]);
	    }
//		setHeight(startY,polygonYCoordinatesArrays[12]);
		ArrayList<Integer> polygonXCoordinates = new ArrayList<Integer>(Arrays.asList(polygonXCoordinatesArrays));
		ArrayList<Integer> polygonYCoordinates = new ArrayList<Integer>(Arrays.asList(polygonYCoordinatesArrays));
		
		Drawing.pen().setColor(beakColor);
		Drawing.pen().fillPolygon(polygonXCoordinates.stream().mapToInt(i -> i).toArray(), polygonYCoordinates.stream().mapToInt(i -> i).toArray(), polygonXCoordinates.size());
		Drawing.pen().setColor(borderColor);
		Drawing.pen().drawPolyline(polygonXCoordinates.stream().mapToInt(i -> i).toArray(), polygonYCoordinates.stream().mapToInt(i -> i).toArray(), polygonXCoordinates.size());
		
		polygonXCoordinates = new ArrayList<Integer>(polygonXCoordinates.subList(4, 13));
		polygonYCoordinates = new ArrayList<Integer>(polygonYCoordinates.subList(4, 13));
		polygonXCoordinates.add(polygonXCoordinatesArrays[8]);
		polygonXCoordinates.add(polygonXCoordinatesArrays[7]);
		polygonXCoordinates.add(polygonXCoordinatesArrays[4]);
		polygonYCoordinates.add(polygonYCoordinatesArrays[8]);
		polygonYCoordinates.add(polygonYCoordinatesArrays[7]);
		polygonYCoordinates.add(polygonYCoordinatesArrays[4]);
		
		Drawing.pen().setColor(super.darkenBeakColor(beakColor));
		Drawing.pen().fillPolygon(polygonXCoordinates.stream().mapToInt(i -> i).toArray(), polygonYCoordinates.stream().mapToInt(i -> i).toArray(), polygonXCoordinates.size());
		Drawing.pen().setColor(borderColor);
		Drawing.pen().drawPolyline(polygonXCoordinates.stream().mapToInt(i -> i).toArray(), polygonYCoordinates.stream().mapToInt(i -> i).toArray(), polygonXCoordinates.size());
		
	}
	
}

