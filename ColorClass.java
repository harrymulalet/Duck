package drawingTool;

import java.awt.Color;

public  class ColorClass {
	
	private Color beakColor = new Color(0xf9b747);
	private Color bodyColor = new Color(0xd5d6d8);
	private Color borderColor = new Color(0x5c2f10);
//	private Color beakColor = new Color(249, 183, 71);
//	private Color bodyColor = new Color(213, 214, 216);
//	private Color borderColor = new Color(92, 47, 16);

	public Color getBeakColor() {
		return new Color(RandomNumber.betweenInt(471862,beakColor.getRGB()));
	}
	
	public Color darkenBeakColor() {
		return darkenBeakColor(getBeakColor());
	}
	
	// Overloading the darkenBeakColor method
	public Color darkenBeakColor(Color c) {
		return new Color(c.getRGB() - 471862);
//		return new Color(0xf28411);
	}
	
	public Color getBodyColor() {
		return new Color(RandomNumber.upTo(bodyColor.getRGB()));
	}
	
	public Color getBorderColor() {
		return new Color(RandomNumber.upTo(borderColor.getRGB()));
	}
}
