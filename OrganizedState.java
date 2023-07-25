package drawingTool.graphicState;

import drawingTool.Scene;

public class OrganizedState extends State{
	
	private static OrganizedState instance;

	private OrganizedState(Scene aScene) {
		 this.aScene = aScene;
		 organizedDucks = this;
	}

	public static State getInstance(Scene aScene) {
		if (instance == null) {
			instance = new OrganizedState(aScene);
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
		return this;
	}

	@Override
	public State generateRandomDucks() {
		aScene.generateDucksRandomSameSize();;
		return RandomState.getInstance(aScene);
	}

}
