package drawingTool;

import java.util.ArrayList;
import java.util.Arrays;

public class Beak extends ColorClass{
	
	private double scale;
	//private static Color beakColor;
	
	public Beak() {
		this(1);
	}
	
	public Beak(double scale) {
		this.scale = scale;
		//beakColor = new Color(249, 183, 71);
	}
	
	public void drawAt(int left, int bottom) {
		ArrayList<Integer> polygonXCoordinates = new ArrayList<Integer>(Arrays.asList(left, left + (int)(74*scale), left + (int)(98*scale), left + (int)(117*scale), left + (int)(144*scale), left + (int)(141*scale), left + (int)(113*scale), left + (int)(49*scale)));
		ArrayList<Integer> polygonYCoordinates = new ArrayList<Integer>(Arrays.asList(bottom + (int)(63*scale), bottom + (int)(31*scale), bottom, bottom + (int)(29*scale), bottom + (int)(45*scale), bottom + (int)(73*scale), bottom + (int)(82*scale), bottom + (int)(77*scale)));
		//Color lightOrange = new Color(249, 183, 71);
		//Color darkOrange = new Color(lightOrange.getRed()-7,lightOrange.getGreen()-51,lightOrange.getBlue()-54);
		
		Drawing.pen().setColor(super.getBeakColor());
		Drawing.pen().fillPolygon(polygonXCoordinates.stream().mapToInt(i -> i).toArray(), polygonYCoordinates.stream().mapToInt(i -> i).toArray(), polygonXCoordinates.size());
		Drawing.pen().setColor(super.getBorderColor());
		Drawing.pen().drawPolygon(polygonXCoordinates.stream().mapToInt(i -> i).toArray(), polygonYCoordinates.stream().mapToInt(i -> i).toArray(), polygonXCoordinates.size());
	
		polygonXCoordinates.subList(5, 7).clear();
		polygonXCoordinates.add(5, (int)(left + 142*scale));
		polygonYCoordinates.subList(5, 7).clear();
		polygonYCoordinates.add(5, (int)(bottom + 62*scale));
		
		Drawing.pen().setColor(super.darkenBeakColor());
		Drawing.pen().fillPolygon(polygonXCoordinates.stream().mapToInt(i -> i).toArray(), polygonYCoordinates.stream().mapToInt(i -> i).toArray(), polygonXCoordinates.size());
		
		Drawing.pen().setColor(super.getBorderColor());
		Drawing.pen().drawPolygon(polygonXCoordinates.stream().mapToInt(i -> i).toArray(), polygonYCoordinates.stream().mapToInt(i -> i).toArray(), polygonXCoordinates.size());
		Drawing.pen().fillOval((int)(left + 86*scale), (int)(bottom + 22*scale), (int)(6*scale), (int)(12*scale));
		
	}

//	public static Color getBeakColor() {
//		return beakColor;
//	}
}
