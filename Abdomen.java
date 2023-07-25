package drawingTool;

import java.awt.Color;

public class Abdomen {
	
	private Belly belly; // composite
	private Wing wing; // composite
	private Tail tail; // composite
	private Leg leg; // composite
	private double scale; // composite
//	private static Color bodyColor;
	
	public Abdomen(){
		this(1);
	}
	
	public Abdomen(double scale){
		this.scale = scale;
		belly = new Belly(scale);
		wing = new Wing(scale);
		tail = new Tail(scale);
		leg = new Leg(scale);
//		bodyColor = new Color(213, 214, 216);
	}
	
	public void drawAt(int left, int bottom) {
		
		leg.drawAt(left + (int)(51*scale), bottom + (int)(256*scale));
		leg.drawAt(left + (int)(147*scale), bottom + (int)(256*scale));
		belly.drawAt(left, bottom);
		tail.drawAt(left + (int)(260*scale), bottom + (int)(66*scale));
		wing.drawAt(left + (int)(75*scale), bottom + (int)(60*scale));
		
	}
}
