package drawingTool.graphicState;

import drawingTool.Scene;

public abstract class State {
	
	 protected Scene aScene;

	 protected static BlankState noDucks;
	 protected static OrganizedState organizedDucks;
	 protected static RandomState randomDucks;

	 public abstract State clearDucks();

	 public abstract State organizeDucks();

	 public abstract State generateRandomDucks();

}
