package drawingTool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import drawingTool.graphicState.State;
import drawingTool.graphicState.OrganizedState;
import drawingTool.graphicState.RandomState;

public class Scene{
	
	private static State graphicState;
	private ArrayList<Duck> ducks;
	private double scale;
	private boolean bool;
	
//	public Scene(boolean bool) {
////		setBool(bool);
//		this.scale = 0.0;
//		ducks = new ArrayList<Duck>();
//		if(bool == true) { // If option is true, then it is traversal
//			generateDucksTraversalDifSize();
//		}
//		else if(bool == false) { // If option is true, then it is random positioned
//			generateDucksRandomDifSize();
//		}
//	}
	
	public Scene(boolean bool, double scale) {
		setScene(bool,scale);
		ducks = new ArrayList<Duck>();
		if(this.bool == true && this.scale == 0.0) { // If option is true, then it is traversal
			generateDucksTraversalDifSize();
		}
		else if(this.bool == false && this.scale == 0.0) { // If option is true, then it is traversal
			generateDucksRandomDifSize();
		}
		else if(this.bool == true) { // If option is true, then it is traversal
			generateDucksTraversalSameSize();
		}
		else if(this.bool == false) { // If option is true, then it is random positioned
			generateDucksRandomSameSize();
		}
	}
	
	public Scene(DrawingArea drawingArea) {
		graphicState = OrganizedState.getInstance(this);
	}
	
	public void setBlank() {
		 graphicState = graphicState.clearDucks();
	}
	
	public void setOrganized() {
		 graphicState = graphicState.organizeDucks();
	}
	
	public void setRandom() {
		 graphicState = graphicState.generateRandomDucks();
	}

	public void removeDucks() {
		ducks.clear();
	}
	
	public void setColDucks(Color c) {
		for (int i = 0; i < ducks.size(); i++) {
            Duck duck = ducks.get(i);
            duck.setBodyColor(c);
        }
	}

	public void setScene(boolean bool, double scale) {
		this.bool = bool;
		this.scale = scale;
	}
	
	public void setScale(double scale) {
		this.scale = scale;
	}
	
	public void generateDucksRandomDifSize() {  // by default it's the generateDucks() method
		ducks = new ArrayList<Duck>();
		for (int numbersOfDuck = 0; numbersOfDuck <42; numbersOfDuck++) {
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double scale = RandomNumber.between(0, 0.5);
			int xMax = RandomNumber.upTo(screenSize.width-(int)(Duck.getWidth()*scale));
			int yMax = RandomNumber.upTo(screenSize.height-(int)(Duck.getHeight()*scale));
			Duck duck = new Duck(xMax, yMax, scale);
			addDuck(duck);
//			try {
//				addDuckRandom(duck);
//	        } catch (IndexOutOfBoundsException ex) {
//	            System.out.println("An error occurred: " + ex.getMessage());
//	            break;
//	        }
		}
	}
	
	public void generateDucksRandomSameSize() {
		ducks = new ArrayList<Duck>();
//		double scale = RandomNumber.between(0, 0.5);
		if(scale == 0.0) {
			scale = 0.3;
		}
		for (int numbersOfDuck = 0; numbersOfDuck <42; numbersOfDuck++) {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int xMax = RandomNumber.upTo(screenSize.width-(int)(Duck.getWidth()*scale));
			int yMax = RandomNumber.upTo(screenSize.height-(int)(Duck.getHeight()*scale));
			Duck duck = new Duck(xMax, yMax, scale);
			addDuck(duck);
		}
	}
	
	public void generateDucksTraversalSameSize() {
		ducks = new ArrayList<Duck>();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		double scale = RandomNumber.between(0, 0.5);
		if(scale == 0.0) {
			scale = 0.2;
		}
		for (int nOfDuckInRow = 0; nOfDuckInRow < screenSize.width; nOfDuckInRow+=(int)(Duck.getWidth()*scale)) {
			for (int nOfDuckInColumn = 0; nOfDuckInColumn < screenSize.height; nOfDuckInColumn+=(int)(Duck.getHeight()*scale)) {
				Duck duck = new Duck(nOfDuckInRow, nOfDuckInColumn, scale);
				addDuck(duck);
			}
		}
		
	}
	
	public void generateDucksTraversalDifSize() {
		ducks = new ArrayList<Duck>();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double scale = RandomNumber.between(0, 0.5);
		for (int nOfDuckInColumn = 0; nOfDuckInColumn < screenSize.height; nOfDuckInColumn+=(int)(Duck.getHeight()*scale)) {
			scale = RandomNumber.between(0, 0.5);
			for (int nOfDuckInRow = 0; nOfDuckInRow < screenSize.width; nOfDuckInRow+=(int)(Duck.getWidth()*scale)) {
				Duck duck = new Duck(nOfDuckInRow, nOfDuckInColumn, scale);
				addDuck(duck);
			}
		}
	}
	
//	public void generateDucksWithOrderDifSize() {
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		double scale = 0.0;
//		for (int nOfDuckInRow = 0; nOfDuckInRow < screenSize.width; nOfDuckInRow+=(int)(Duck.getStaticWidth()*(scale = RandomNumber.between(0, 0.5)))) {
//			for (int nOfDuckInColumn = 0; nOfDuckInColumn < screenSize.height; nOfDuckInColumn+=(int)(Duck.getStaticHeight()*(scale = RandomNumber.between(0, 0.5)))) {
//				Duck duck = new Duck(nOfDuckInRow, nOfDuckInColumn, scale);
//				addDuck(duck);
//			}
//		}
//	}
	
	public void draw() {
		for (Duck duck : ducks) {
			duck.draw();
		}
	}
	
	public void draw(int no_of_ducks) { // Overloading the draw method

		for (Duck duck : ducks) {
			duck.draw();
			if(duck.equals(ducks.get(no_of_ducks - 1))) {
				break;
			}
		}
	}
	
	public void addDuck(Duck newDuck) {
		boolean intersection = false;
		
		for (Duck duck : ducks) {

			intersection = intersection || duck.intersects(newDuck);
		}
		if (!intersection) {
			ducks.add(newDuck);
		}
	}
	
	public void addDuckBuffer(Duck newDuck) {
		boolean intersection = false;
		
		for (Duck duck : ducks) {
			if (newDuck.width() > duck.width()) {
				duck.changeWidth(newDuck.width());
			}
//			else if (newDuck.width() < duck.width()) {
//				newDuck.changeWidth(duck.width());
//				System.out.println("duck.width() is greater than newDuck.width(): " + duck.width() + "||" + newDuck.width());
//			}
			if (newDuck.height() > duck.height()) {
				duck.changeHeight(newDuck.height());
			} 
//			else if (newDuck.height() < duck.height()) {
//				newDuck.changeHeight(duck.height());
//			}

			intersection = intersection || duck.intersects(newDuck);
		}
		if (!intersection) {
			ducks.add(newDuck);
		}
	}
	
}
