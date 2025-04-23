package csc223.eh;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeightedGraphTest {

    private WeightedGraph graph;
    private String expectedGraph;

    @BeforeEach
    public void setUp() {
        graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(3, 1, 3);
        graph.addEdge(3, 2, 9);
        graph.addEdge(2, 4, 4);
        graph.addEdge(4, 0, 7);

        expectedGraph =
            "0: 0.0 10.0 ∞ 5.0 7.0\n" +
            "1: 10.0 0.0 1.0 3.0 ∞\n" +
            "2: ∞ 1.0 0.0 9.0 4.0\n" +
            "3: 5.0 3.0 9.0 0.0 ∞\n" +
            "4: 7.0 ∞ 4.0 ∞ 0.0\n";
    }
    
    @Test 
    public void addEdgeTest() {
        graph.addEdge(2,7, 7.0);
        
        String newExpected =
        "0: 0.0 10.0 ∞ 5.0 7.0\n" +
        "1: 10.0 0.0 1.0 3.0 ∞\n" +
        "2: ∞ 1.0 0.0 9.0 7.0\n" + // updated weight here!
        "3: 5.0 3.0 9.0 0.0 ∞\n" +
        "4: 7.0 ∞ 7.0 ∞ 0.0\n";

        assertEquals(newExpected, graph.printGraph());
        
    }


    @Test 
    public void removeEdgeTest() {
        String newExpected =
        "0: 0.0 10.0 ∞ 5.0 7.0\n" +
        "1: 10.0 0.0 1.0 3.0 ∞\n" +
        "2: ∞ 1.0 0.0 9.0 7.0\n" + // updated weight here!
        "3: 5.0 3.0 9.0 0.0 ∞\n" +
        "4: 7.0 ∞ 7.0 ∞ 0.0\n";
        assertEquals(newExpected, graph.printGraph());

        graph.removeEdge(2,7);
        assertEquals(expectedGraph, graph.printGraph());
    }

    @Test 
    public void hasEdgeTest() {
        // Existing edge
        assertEquals(true, graph.hasEdge(0, 1));
        assertEquals(true, graph.hasEdge(0, 3));
        assertEquals(true, graph.hasEdge(1, 2));
        assertEquals(true, graph.hasEdge(3, 1));
        assertEquals(true, graph.hasEdge(3, 2));
        assertEquals(true, graph.hasEdge(2, 4));
        assertEquals(true, graph.hasEdge(4, 0));

        // Non-existing edge
        assertEquals(false, graph.hasEdge(1, 4));
        assertEquals(false, graph.hasEdge(1, 4));
        assertEquals(false, graph.hasEdge(1, 4));
        assertEquals(false, graph.hasEdge(1, 4));
        
    }

    @Test 
    public void getNeighborsTest() {
        int[] expectedNeighbors = {1, 3, 4};
        int[] actualNeighbors = graph.getNeighbors(0);

        assertEquals(expectedNeighbors.length, actualNeighbors.length);
        for (int i = 0; i < expectedNeighbors.length; i++) {
            assertEquals(expectedNeighbors[i], actualNeighbors[i]);
        }
       
    }

    @Test 
    public void numVerticesTest() {
        assertEquals(5, graph.getNumVertices());
        
    }


    @Test 
    public void printGraphTest() {
        assertEquals(expectedGraph, graph.printGraph());
    }

    @Test 
    public void getEdgeWeightTest() {
        double weight01 = 10.0;
        assertEquals(weight01, graph.getEdgeWeight(0, 1));

        double weight03 = 5.0;
        assertEquals(weight03, graph.getEdgeWeight(0, 3));

        double weight12 = 1.0;
        assertEquals(weight12, graph.getEdgeWeight(1, 2));

        double weight31 = 3.0;
        assertEquals(weight31, graph.getEdgeWeight(3, 1));

        double weight32 = 9.0;
        assertEquals(weight32, graph.getEdgeWeight(3, 2));

        double weight24 = 4.0;
        assertEquals(weight24, graph.getEdgeWeight(2, 4));

        double weight40 = 7.0;
        assertEquals(weight40, graph.getEdgeWeight(4, 0));
    }

    @Test 
    public void shortestPathTest() {
        String expected = "Path: [0, 3, 1, 2, 4], Distance: 13";
        String actual = graph.shortestPath(0, 4);
        assertEquals(expected, actual);
        
    }
        
}
