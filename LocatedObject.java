package drawingTool;

import java.awt.Color;
import java.awt.Point;

public interface LocatedObject {
	public Point address();
	public int width();
	public int height();

	public default boolean intersects(LocatedObject other) {
		return !doesNotIntersect(other, 0);
	}	
	
	public default boolean intersects(LocatedObject other, int margin) {
		return !doesNotIntersect(other, margin);
	}
	
	private boolean doesNotIntersect(LocatedObject other, int margin) {
		return 	leftOf(other, margin) || rightOf(other, margin) || 
				above(other, margin) || below(other, margin);
	}
	
	public default boolean leftOf(LocatedObject other, int margin){
		return this.address().x + this.width() + margin < other.address().x;
	}
	
	public default boolean rightOf(LocatedObject other, int margin){
		return this.address().x > other.address().x + other.width() + margin;
	}
	
	private boolean above(LocatedObject other, int margin) {
		return this.address().y - this.height() - margin > other.address().y;
	}
	
	private boolean below(LocatedObject other, int margin) {
		return this.address().y < other.address().y - other.height() - margin;
	}
}
