package KiwilandTrains;

public class Edge {
	public Node start;
	public Node end;
	public int distance;

	public Edge(Node start, Node end, int distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}
}
