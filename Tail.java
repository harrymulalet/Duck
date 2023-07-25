package drawingTool;

public class Tail extends ColorClass{
	
	private double scale;
//	private static int width;
	
	public Tail() {
		this(1);
	}
	
	public Tail(double scale) {
		this.scale = scale;
//		Tail.width = getDuckWidth();
	}
	
//	public static int getDuckWidth() {
//		return width;
//	}
//	
//	public void setDuckWidth(int xStart, int xStop) {
//		Tail.width = xStop - xStart;
//	}
	
	public void drawAt(int left, int bottom) {
		
		int[] polygonXCoordinate = {0,21,41,35,28,35,57,82,72,55,81,80,77,80,93,98,84,94,110,93,83};
		int[] polygonYCoordinate = {78,36,18,47,54,47,16,0,28,46,23,32,37,32,19,32,71,50,46,101,112};
		int[] polygonXCoordinates = new int[polygonXCoordinate.length];
		int[] polygonYCoordinates = new int[polygonYCoordinate.length];
	    for(int i=0; i<polygonXCoordinate.length; i++){
	    	polygonXCoordinates[i] = left + (int)(scale * polygonXCoordinate[i]);
	    }
	    for(int i=0; i<polygonYCoordinate.length; i++){
	    	polygonYCoordinates[i] = bottom + (int)(scale * polygonYCoordinate[i]);
	    }
//	    setDuckWidth(startX,polygonXCoordinates[18]);
		Drawing.pen().setColor(super.getBodyColor());
		Drawing.pen().fillPolygon(polygonXCoordinates, polygonYCoordinates, polygonXCoordinates.length);
		Drawing.pen().setColor(super.getBorderColor());
		Drawing.pen().drawPolyline(polygonXCoordinates, polygonYCoordinates, polygonXCoordinates.length);
	}
}