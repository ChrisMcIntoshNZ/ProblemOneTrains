package KiwilandTrains;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTests {

	public Graph graph;

	public JUnitTests() {
		try {
			graph = new Graph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		} catch (IllegalArgumentException e) {

		}

	}

	@Test
	public void test01() {
		assertEquals(9, graph.getDistance("A-B-C"));
	}

	@Test
	public void test02() {
		assertEquals(5, graph.getDistance("A-D"));
	}

	@Test
	public void test03() {
		assertEquals(13, graph.getDistance("A-D-C"));
	}

	@Test
	public void test04() {
		assertEquals(22, graph.getDistance("A-E-B-C-D"));
	}

	@Test
	public void test05() {
		assertEquals(-1, graph.getDistance("A-E-D"));
	}

	@Test
	public void test06() {
		assertEquals(2, graph.getNumTrips("C", "C", 1, 3));
	}

	@Test
	public void test07() {
		assertEquals(3, graph.getNumTrips("A", "C", 4, 4));
	}

	@Test
	public void test08() {
		assertEquals(9, graph.getShortestRoute("A", "C"));
	}

	@Test
	public void test09() {
		assertEquals(9, graph.getShortestRoute("B", "B"));
	}

	@Test
	public void test10() {
		assertEquals(7, graph.getTripsUnderDistance("C", "C", 30));
	}

}
