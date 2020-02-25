package KiwilandTrains;

import java.util.ArrayList;

public class Graph {
	ArrayList<Node> nodes;

	public Graph() {
		this.nodes = new ArrayList<Node>();
	}

	/**
	 * This takes a graph as a string and
	 * 
	 * @param input is a comma separated list of Routes. Where routes are two one
	 *              letter names then an integer distance. e.g. AB6, BA5, AC5
	 * @throws IllegalArgumentException
	 */
	public Graph(String input) throws IllegalArgumentException {
		this.nodes = new ArrayList<Node>();
		// Split out the edges.
		String[] splitInput = input.split(",");
		for (String s : splitInput) {
			s = s.trim();
			String startName = s.substring(0, 1);
			String endName = s.substring(1, 2);
			int dist = Integer.parseInt(s.substring(2));
			Node start = null;
			Node end = null;

			if (startName.equals(endName))
				throw new IllegalArgumentException("A Node can't be connected to itself");

			// Find the nodes if they exist.
			for (Node n : nodes) {
				if (n.equals(startName))
					start = n;
				if (n.equals(endName))
					end = n;
			}
			// Otherwise create them.
			if (start == null) {
				start = new Node(startName);
				nodes.add(start);
			}
			if (end == null) {
				end = new Node(endName);
				nodes.add(end);
			}
			// Now add the edge
			start.addEdge(end, dist);
		}
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	/**
	 * 
	 * @param a string of - separated nodes e.g. A-B-C
	 * @return the distance of that path.
	 */
	public int getDistance(String path) {
		String[] nodeNames = path.split("-");
		Route route = new Route();
		ArrayList<Node> routeNodes = new ArrayList<Node>();

		// If there is an invalid node then no route exists.
		for (String name : nodeNames) {
			if (name.length() > 1)
				return -1;
		}

		// Get the list of node objects for each label in our input.
		for (String name : nodeNames) {
			routeNodes.add(getNode(name));
		}

		// Go through our list of nodes and add each edge in it to the route
		for (int i = 0; i < routeNodes.size() - 1; i++) {
			// Check if the edge exists if not return no such route
			if (routeNodes.get(i).getEdge(routeNodes.get(i + 1)) == null)
				return -1;
			route.add(routeNodes.get(i).getEdge(routeNodes.get(i + 1)));
		}

		return route.getDistance();
	}

	public Node getNode(String name) {
		for (Node node : nodes) {
			if (node.equals(name))
				return node;
		}
		return null;
	}

	public int getDistance(Route route) {
		return route.getDistance();
	}

	/**
	 * This method converts gets the nodes from the node labels and calls the
	 * getNumTrips method
	 * 
	 */
	public int getNumTrips(String start, String end, int minStops, int maxStops) {
		return getNumTrips(getNode(start), getNode(end), minStops, maxStops);
	}

	/**
	 * 
	 * this method adds working arguments and calls the recursive method.
	 */
	private int getNumTrips(Node start, Node end, int minStops, int maxStops) {
		return getNumTrips(start, end, minStops, maxStops, 0, false);
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @param minEdges
	 * @param maxEdges
	 * @param curEdges
	 * @param useDistance if true this method counts distance instead of number of
	 *                    edges.
	 * @return the number of trips that meets the conditions.
	 */
	private int getNumTrips(Node start, Node end, int minEdges, int maxEdges, int curEdges, boolean useDistance) {
		// If we are past the max number of edges return
		if (curEdges > maxEdges)
			return 0;

		int numTrips = 0;
		// if we are at at least the minimum number of edges and have reached the end
		// node increase the count.
		if (curEdges >= minEdges && start.equals(end)) {
			numTrips++;
		}

		// Now add one to the current number of edges and call this method for each node
		// we have an edge to.
		for (Edge edge : start.getEdges()) {
			numTrips += getNumTrips(edge.end, end, minEdges, maxEdges, curEdges + (useDistance ? edge.distance : 1),
					useDistance);
		}

		return numTrips;
	}

	public int getShortestRoute(String start, String end) {
		return getShortestRoute(getNode(start), getNode(end));
	}

	private int getShortestRoute(Node start, Node end) {
		for (Node n : nodes) {
			n.setDijkstraWeight(Integer.MAX_VALUE);
			n.visited = false;
		}
		// We need to do this set up so that you need at least edge
		Node nextNode = null;
		for (Edge e : start.getEdges()) {
			e.end.setDijkstraWeight(e.distance);
			if (nextNode == null || e.distance < nextNode.getDijkstraWeight())
				nextNode = e.end;
		}

		// If there isn't a route there isn't a shortest route
		if (this.getNumTrips(start, end, 0, nodes.size()) <= 0)
			return -1;

		return dijkstras(nextNode, end);
	}

	public int dijkstras(Node start, Node end) {
		Node nextNode = null;
		if (start.equals(end))
			return start.getDijkstraWeight();
		// Set the current node to visited
		nextNode.visited = true;
		// For each unvisited node we have an edge to update it's weight to the current
		// nodes weight plus the length of that edge if it's shorter than the current
		// node;
		for (Edge e : start.getEdges()) {
			if (!e.end.visited && e.end.getDijkstraWeight() > e.distance + start.getDijkstraWeight()) {
				e.end.setDijkstraWeight(e.distance + start.getDijkstraWeight());
			}
		}

		// Get the next node. This would be more efficiently implemented on a larger
		// scale by maintaining a priority queue than iterating through each time but
		// due to the small expected size of graphs the overhead of maintaining it would
		// cause it to be less efficient
		for (Node n : nodes) {
			if (!n.visited) {
				if (nextNode == null || nextNode.getDijkstraWeight() > n.getDijkstraWeight()) {
					nextNode = n;
				}
			}

		}
		return dijkstras(nextNode, end);
	}

	public int getTripsUnderDistance(String start, String end, int underLenght) {
		// MinEdges = 1 as we need at least one edge for it to be considered a trip.
		// MaxEdges = underLenght-1 as we want trips under the distance and it is an int
		// so we can just subtract 1 and the math checking less than or equal to will
		// work
		return getNumTrips(getNode(start), getNode(end), 1, underLenght - 1, 0, true);
	}

}
