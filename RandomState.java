package drawingTool.graphicState;

import drawingTool.Scene;

public class RandomState extends State{
	
	private static RandomState instance;

	private RandomState(Scene aScene) {
		 this.aScene = aScene;
		 randomDucks = this;
	}

	public static State getInstance(Scene aScene) {
		if (instance == null) {
			instance = new RandomState(aScene);
		}
		return instance;
	}

	@Override
	public State clearDucks() {
		aScene.removeDucks();
		return BlankState.getInstance(aScene);
	}

	@Override
	public State organizeDucks() {
		aScene.generateDucksTraversalSameSize();
		return OrganizedState.getInstance(aScene);
	}

	@Override
	public State generateRandomDucks() {
		aScene.generateDucksRandomSameSize();
		return this;
	}

}
