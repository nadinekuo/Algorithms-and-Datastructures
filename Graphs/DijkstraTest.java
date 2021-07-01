import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class DijkstraTest {


    @Test
    public void small1Example() {
        WeightedGraph g = new WeightedGraph(1);
        WeightedGraph mst = new WeightedGraph(1);
        assertEquals(mst, MSTPrimJarnik.primJarnik(g));
    }

    @Test
    public void small3Example() {
        WeightedGraph g = new WeightedGraph(3);
        g.addEdge(g.getVertex(0),g.getVertex(1),1);
        g.addEdge(g.getVertex(0),g.getVertex(2),2);
        g.addEdge(g.getVertex(1),g.getVertex(2),1);
        WeightedGraph mst = new WeightedGraph(3);
        mst.addEdge(mst.getVertex(0),mst.getVertex(1),1);
        mst.addEdge(mst.getVertex(1),mst.getVertex(2),1);
        assertEquals(mst, MSTPrimJarnik.primJarnik(g));
    }

    /**
     * Tests the following graph with all edges having weight 1
     * 1 - 0 - 3
     *     |   |
     *     2 - 4
     */
    @Test
    public void testUnweighted() {
        WeightedGraph g = new WeightedGraph(5);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(0, 3, 1);
        g.addEdge(3, 4, 1);
        // Path from 0 to 4 should be 2
        assertEquals(2, Dijkstra.shortestPathLength(g, g.getVertex(0), g.getVertex(4)));
        // Path from 1 to 2 should be 2
        assertEquals(2, Dijkstra.shortestPathLength(g, g.getVertex(1), g.getVertex(2)));
        // Path from 3 to 4 should be 1
        assertEquals(1, Dijkstra.shortestPathLength(g, g.getVertex(3), g.getVertex(4)));
        // Path from 3 to 1 should be 2
        assertEquals(2, Dijkstra.shortestPathLength(g, g.getVertex(3), g.getVertex(1)));
    }

    /**
     * Tests the following graph:
     * 0 - 1 - 3
     * |    \  |
     * |     \ |
     * 2  ---  4
     *
     * The weights are as follows:
     * 0 - 1: 1
     * 1 - 3: 6
     * 3 - 4: 4
     * 1 - 4: 1
     * 0 - 2: 7
     * 2 - 4: 4
     */
    @Test
    public void testWeighted() {
        WeightedGraph g = new WeightedGraph(5);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 3, 6);
        g.addEdge(3, 4, 4);
        g.addEdge(1, 4, 1);
        g.addEdge(0, 2, 7);
        g.addEdge(2, 4, 4);
        // Path is 0-1-4
        assertEquals(2, Dijkstra.shortestPathLength(g, g.getVertex(0), g.getVertex(4)));
        // Path is 0-1-4-3
        assertEquals(6, Dijkstra.shortestPathLength(g, g.getVertex(0), g.getVertex(3)));
        // Path is 2-4
        assertEquals(4, Dijkstra.shortestPathLength(g, g.getVertex(2), g.getVertex(4)));
        // Path is 2-4-1-0
        assertEquals(6, Dijkstra.shortestPathLength(g, g.getVertex(2), g.getVertex(0)));
    }

    @Test
     void singleLineTest() {
         WeightedGraph g = new WeightedGraph(2);
         g.addEdge(0, 1, 3);
         System.out.println(Dijkstra.shortestPath(g, g.getVertex(0), g.getVertex(1)));
     }

    @Test
    public void testTwoPathsEqualSum() {
        WeightedGraph g = new WeightedGraph(7);
        g.addEdge(0, 1, 10);
        g.addEdge(1, 2, 13);
        g.addEdge(0, 3, 1);
        g.addEdge(1, 4, 1);
        g.addEdge(4, 5, 2);
        g.addEdge(3, 6, 2);
        g.addEdge(5, 6, 4);
        // Path from 0 to 2 is
        System.out.println(Dijkstra.shortestPath(g, g.getVertex(0), g.getVertex(2)));
        assertEquals(23, Dijkstra.shortestPathLength(g, g.getVertex(0), g.getVertex(2)));
    }

    @Test
    public void testDisconnectedGraph() {
        WeightedGraph g = new WeightedGraph(5);
        g.addEdge(0, 1, 7);
        g.addEdge(0, 2, 11);
        g.addEdge(1, 2, 1);
        g.addEdge(3, 4, 2);
        System.out.println(Dijkstra.shortestPath(g, g.getVertex(0), g.getVertex(3)));
        assertEquals(0, Dijkstra.shortestPathLength(g, g.getVertex(0), g.getVertex(3)));
    }


    /**
     * Tests the following graph with all edges having weight 1
     * 1 - 0 - 2 - 3
     */
    @Test
    public void testUnweightedLine() {
        WeightedGraph g = new WeightedGraph(4);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 3, 1);
        // Path from 1 to 3 is
        List<WeightedVertex> path = new ArrayList<WeightedVertex>();
        path.add(g.getVertex(1));
        path.add(g.getVertex(0));
        path.add(g.getVertex(2));
        path.add(g.getVertex(3));
        assertEquals(path, Dijkstra.shortestPath(g, g.getVertex(1), g.getVertex(3)));
    }

    /**
     * Tests the following graph with all edges having weight 1
     * 1 - 0 - 3 - 5
     *     |     /
     *     2 - 4
     */
    @Test
    public void testUnweightedCycle() {
        WeightedGraph g = new WeightedGraph(6);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(0, 3, 1);
        g.addEdge(3, 5, 1);
        g.addEdge(4, 5, 1);
        // Path from 0 to 4 is
        List<WeightedVertex> path = new ArrayList<WeightedVertex>();
        path.add(g.getVertex(0));
        path.add(g.getVertex(2));
        path.add(g.getVertex(4));
        assertEquals(path, Dijkstra.shortestPath(g, g.getVertex(0), g.getVertex(4)));
        // Path from 1 to 2
        path = new ArrayList<WeightedVertex>();
        path.add(g.getVertex(1));
        path.add(g.getVertex(0));
        path.add(g.getVertex(2));
        assertEquals(path, Dijkstra.shortestPath(g, g.getVertex(1), g.getVertex(2)));
        // Path from 3 to 4
        path = new ArrayList<WeightedVertex>();
        path.add(g.getVertex(3));
        path.add(g.getVertex(5));
        path.add(g.getVertex(4));
        assertEquals(path, Dijkstra.shortestPath(g, g.getVertex(3), g.getVertex(4)));
        // Path from 3 to 1
        path = new ArrayList<WeightedVertex>();
        path.add(g.getVertex(3));
        path.add(g.getVertex(0));
        path.add(g.getVertex(1));
        assertEquals(path, Dijkstra.shortestPath(g, g.getVertex(3), g.getVertex(1)));
    }

}