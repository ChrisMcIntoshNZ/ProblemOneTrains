package KiwilandTrains;

import java.util.ArrayList;

public class Node {
	private String name;
	private ArrayList<Edge> edges;
	private int dijkstraWeight = Integer.MAX_VALUE;
	public boolean visited;


	public Node(String name, ArrayList<Edge> edges) {
		this.name = name;
		this.edges = edges;
	}

	public Node(String name) {
		this(name, new ArrayList<Edge>());
	}

	/**
	 * Adds an Edge with this node as the start node and the argument as the End.
	 * 
	 * @param end
	 * @param lenght
	 */
	public void addEdge(Node end, int lenght) {
		edges.add(new Edge(this, end, lenght));
	}

	/**
	 * Finds any Edge between this node and the argument Node and otherwise returns
	 * null.
	 * 
	 * @param destination
	 * @return
	 */
	public Edge getEdge(Node destination) {
		for (Edge edge : edges) {
			if (edge.end.equals(destination)) {
				return edge;
			}
		}
		return null;
	}

	public boolean equals(String name) {
		return name.equals(this.name);
	}

	public boolean equals(Node node) {
		return node.name.equals(this.name);
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public String getName() {
		return name;
	}

	public int getDijkstraWeight() {
		return dijkstraWeight;
	}

	public void setDijkstraWeight(int weight) {
		dijkstraWeight = weight;
	}

}