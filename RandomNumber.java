package drawingTool;

public class RandomNumber {

	public static double between(double min, double max) {
		return (Math.random() * (max - min) + min);
	}

	public static int betweenInt(int min, int max) {
		return (int) between(min, max + 1);
	}
	
	public static int upTo(int max) {
		return (int) between(0, max + 1);
	}
}
