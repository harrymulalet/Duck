package drawingTool;

import java.awt.Color;
import java.awt.Point;

public class Duck extends Bird implements LocatedObject{
	
	private Thorax thorax; // composite
	private Abdomen abdomen; // composite
	private int startX;
	private static int width = 489;
	private static int height = 478;
	private int startY;
	
	public Duck(){
		this(1);
	}
	
	/**
	 * ddd
	 * @param scale
	 */
	public Duck(double scale){
		super(scale);
		thorax = new Thorax(super.getScale());
		abdomen = new Abdomen(super.getScale());
		this.startX = 0;
		this.startY = 0;
	}
	
	/**
	 * aaa
	 * @param startX
	 * @param startY
	 * @param scale
	 */
	public Duck(int startX, int startY, double scale){
		super(scale);
		thorax = new Thorax(super.getScale());
		abdomen = new Abdomen(super.getScale());
		this.startX = startX;
		this.startY = startY;
	}
	
	public void drawAt(int left, int bottom) {
		
		super.drawAt(left, bottom);
		thorax.drawAt(left + (int)(119*super.getScale()), bottom + (int)(95*super.getScale()));
		abdomen.drawAt(left + (int)(119*super.getScale()), bottom + (int)(126*super.getScale()));
		
	}
	
	public void draw() {
		
		super.draw(startX, startY);
		thorax.drawAt(startX + (int)(119*super.getScale()), startY + (int)(95*super.getScale()));
		abdomen.drawAt(startX + (int)(119*super.getScale()), startY + (int)(126*super.getScale()));
		
	}
	
	public void draw(double scale) {
		
		super.setScale(scale);
		super.draw(startX, startY);
		thorax.drawAt(startX + (int)(119*super.getScale()), startY + (int)(95*super.getScale()));
		abdomen.drawAt(startX + (int)(119*super.getScale()), startY + (int)(126*super.getScale()));
		
	}
	
	public void setBodyColor(Color c) {
		Thorax.setBellyColor(c);
	}

	@Override
	public Point address() {
		return new Point(startX, startY);
	}
	
	public void changeWidth(int newWidth) {
		Duck.width = newWidth;
	}
	
	public void changeHeight(int newHeight) {
		Duck.height = newHeight;
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}

	@Override
	public int width() {
		return (int)(width*super.getScale());
	}

	@Override
	public int height() {
		return (int)(height*super.getScale());
	}
}