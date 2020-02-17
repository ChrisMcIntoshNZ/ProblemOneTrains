package KiwilandTrains;

import java.util.ArrayList;
import java.util.List;

public class Route {
	private List<Edge> path;

	public Route() {
		path = new ArrayList<Edge>();
	}

	/**
	 * 
	 * @return the sum of the distance of all edges in the route
	 */
	public int getDistance() {
		int distance = 0;
		for (Edge edge : path) {
			distance += edge.distance;
		}

		return distance;
	}

	public void add(Edge connection) {
		path.add(connection);
	}

	public List<Edge> getPath() {
		return path;
	}

}
