package drawingTool.graphicState;

import drawingTool.Scene;

public class BlankState extends State{
	
	private static BlankState instance;

	private BlankState(Scene aScene) {
		 this.aScene = aScene;
		 noDucks = this;
	}

	public static State getInstance(Scene aScene) {
		if (instance == null) {
			instance = new BlankState(aScene);
		}
		return instance;
	}

	@Override
	public State clearDucks() {
		aScene.removeDucks();
		return this;
	}

	@Override
	public State organizeDucks() {
		aScene.generateDucksTraversalSameSize();
		return OrganizedState.getInstance(aScene);
	}

	@Override
	public State generateRandomDucks() {
		aScene.generateDucksRandomSameSize();
		return RandomState.getInstance(aScene);
	}

}
