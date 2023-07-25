package drawingTool;

public class Belly extends ColorClass {
	private int width;
	private int height;
	private double scale;
	
	public Belly() {
		this(1,355,263);
	}
	
	public Belly(double scale) {
		this(scale,355,263);
	}
	
	public Belly(double scale, int width, int height) {
		this.scale = scale;
		this.width = (int)(width*scale);
		this.height = (int)(height*scale);
	}
	
	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Thorax.getBellyColor());
		Drawing.pen().fillArc(left, bottom, width, height, -16, -164);
		Drawing.pen().setColor(super.getBorderColor());
		Drawing.pen().drawArc(left, bottom, width, height, -16, -164);
		double[] breastSize = {73, 68, 103, 45, 58, 22};
		int[] breastSizes = new int[breastSize.length];
	    for(int i=0; i<breastSize.length; i++){
	    	breastSizes[i] = (int)(scale * breastSize[i]);
	    }
		int[] breastXPosition = {left + (int)(13*scale), left + (int)(26*scale), left + (int)(40*scale)};
		int[] breastYPosition = {bottom + (int)(110*scale), bottom + (int)(128*scale), bottom + (int)(143*scale)};
		Drawing.pen().drawArc(breastXPosition[0], breastYPosition[0], breastSizes[0], breastSizes[1], 180, 71);
		Drawing.pen().drawArc(breastXPosition[1], breastYPosition[1], breastSizes[2], breastSizes[3], 180, 34);
		Drawing.pen().drawArc(breastXPosition[2], breastYPosition[2], breastSizes[4], breastSizes[5], 180, 41);
	}
}
