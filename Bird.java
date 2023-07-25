package drawingTool;

public class Bird {
	
	private Head head; // composite
	private double scale;
	
	public Bird(double scale) {
		head = new Head(scale);
		this.scale = scale;
	}
	
	public double getScale() {
		return scale;
	}
	
	public void setScale(double scale) {
		this.scale = scale;
	}
	
	public void drawAt(int left, int bottom) {
		
		head.drawAt(left + (int)(8*scale), bottom + (int)(8*scale));
		
	}
	
	public void draw(int startX, int startY) {
	
		head.drawAt(startX + (int)(8*scale), startY + (int)(8*scale));
		
	}
}
