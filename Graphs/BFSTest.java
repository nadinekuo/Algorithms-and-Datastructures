import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {


    @Test
    public void testNull() {
        Graph g = new Graph(0);
        Vertex v = null;
        assertEquals(0, CountingVertices.countVertices(g, v));
        g = null;
        v = new Vertex(1);
        assertEquals(0, CountingVertices.countVertices(g, v));
    }

    @Test
    void testSingleVertex() {
        Graph g = new Graph(0);
        Vertex v = new Vertex(0);
        g.addVertex(v);
        assertEquals(1, CountingVertices.countVertices(g, v));
        assertEquals(0, CountingVertices.countVertices(g, null));
    }

    @Test
    void testTwoSingleVertices() {
        Graph g = new Graph(0);
        Vertex v = new Vertex(0);
        Vertex w = new Vertex(1);
        g.addVertex(v);
        g.addVertex(w);
        assertEquals(1, CountingVertices.countVertices(g, v));
        assertEquals(1, CountingVertices.countVertices(g, w));
        assertEquals(0, CountingVertices.countVertices(g, null));
    }

    /**
     * Tests the following graph:
     *         1
     *       / |  \
     *     2---|---3
     *      \  |  /
     *         4
     */
    @Test
    void testAllConnected() {
        Graph graph = new Graph(0);
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(a, d);
        graph.addEdge(b, c);
        graph.addEdge(b, d);
        graph.addEdge(c, d);
        assertEquals(4, CountingVertices.countVertices(graph, a));
        assertEquals(4, CountingVertices.countVertices(graph, b));
        assertEquals(4, CountingVertices.countVertices(graph, c));
        assertEquals(4, CountingVertices.countVertices(graph, d));
    }

    /**
     * Tests the following graph:
     *         0
     *    1        2
     *  3   4    5    6
     */
    @Test
    void testBinaryTree() {
        Graph graph = new Graph(0);
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);
        Vertex e = new Vertex(5);
        Vertex f = new Vertex(6);
        Vertex g = new Vertex(7);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addEdge(a, c);
        graph.addEdge(a, b);
        graph.addEdge(b, d);
        graph.addEdge(b, e);
        graph.addEdge(c, f);
        graph.addEdge(c, g);
        assertEquals(7, CountingVertices.countVertices(graph, a));
        assertEquals(7, CountingVertices.countVertices(graph, b));
        assertEquals(7, CountingVertices.countVertices(graph, c));
        assertEquals(7, CountingVertices.countVertices(graph, d));
        assertEquals(7, CountingVertices.countVertices(graph, e));
        assertEquals(7, CountingVertices.countVertices(graph, f));
        assertEquals(7, CountingVertices.countVertices(graph, g));
    }

    /**
     * Tests the following disconnected graph:
     * 1  ---  2 ------ 5 --- 6
     * |       |         \   /
     * |       |           7
     * 3 ----  4
     */
    @Test
    void testTwoCycles() {
        Graph graph = new Graph(0);
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);
        Vertex e = new Vertex(5);
        Vertex f = new Vertex(6);
        Vertex g = new Vertex(7);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addEdge(a, b);
        graph.addEdge(b, d);
        graph.addEdge(c, d);
        graph.addEdge(a, c);
        graph.addEdge(e, f);
        graph.addEdge(f, g);
        graph.addEdge(e, g);
        graph.addEdge(b, e);
        assertEquals(7, CountingVertices.countVertices(graph, a));
        assertEquals(7, CountingVertices.countVertices(graph, b));
        assertEquals(7, CountingVertices.countVertices(graph, c));
        assertEquals(7, CountingVertices.countVertices(graph, d));
        assertEquals(7, CountingVertices.countVertices(graph, e));
        assertEquals(7, CountingVertices.countVertices(graph, f));
        assertEquals(7, CountingVertices.countVertices(graph, g));
    }


    /**
     * Tests the following disconnected graph:
     * 1  ---  2        5 --- 6
     * |       |         \   /
     * |       |           7
     * 3 ----  4
     */
    @Test
    void testDisconnectedGraph() {
        Graph graph = new Graph(0);
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);
        Vertex e = new Vertex(5);
        Vertex f = new Vertex(6);
        Vertex g = new Vertex(7);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addEdge(a, b);
        graph.addEdge(b, d);
        graph.addEdge(c, d);
        graph.addEdge(a, c);
        graph.addEdge(e, f);
        graph.addEdge(f, g);
        graph.addEdge(e, g);
        assertEquals(4, CountingVertices.countVertices(graph, a));
        assertEquals(4, CountingVertices.countVertices(graph, b));
        assertEquals(4, CountingVertices.countVertices(graph, c));
        assertEquals(4, CountingVertices.countVertices(graph, d));
        assertEquals(3, CountingVertices.countVertices(graph, e));
        assertEquals(3, CountingVertices.countVertices(graph, f));
        assertEquals(3, CountingVertices.countVertices(graph, g));
    }

    /**
     * Tests the following graph:
     * 1  ---  2
     *      /  |
     *    /    |
     * 3       4
     */
    @Test
    public void testFourTree() {
        Graph g = new Graph(0);
        Vertex v = new Vertex(1);
        Vertex w = new Vertex(2);
        Vertex x = new Vertex(3);
        Vertex y = new Vertex(4);
        g.addVertex(v);
        g.addVertex(w);
        g.addVertex(x);
        g.addVertex(y);
        g.addEdge(v, w);
        g.addEdge(w, y);
        g.addEdge(x, w);
        assertEquals(4, CountingVertices.countVertices(g, v));
        assertEquals(4, CountingVertices.countVertices(g, w));
        assertEquals(4, CountingVertices.countVertices(g, x));
        assertEquals(4, CountingVertices.countVertices(g, y));
    }

    /**
     * Tests the following graph
     *  1 --- 2
     */
    @Test
    public void testSingleLine() {
        Graph g = new Graph(0);
        Vertex v = new Vertex(1);
        Vertex w = new Vertex(2);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        assertEquals(2, CountingVertices.countVertices(g, v));
        assertEquals(2, CountingVertices.countVertices(g, w));
    }

    /**
     * Tests the following graph
     * 1 - 2 - 3
     */
    @Test
    public void testThreeLine() {
        Graph g = new Graph(0);
        Vertex v = new Vertex(1);
        Vertex w = new Vertex(2);
        Vertex x = new Vertex(3);
        g.addVertex(v);
        g.addVertex(w);
        g.addVertex(x);
        g.addEdge(v, w);
        g.addEdge(w, x);
        assertEquals(3, CountingVertices.countVertices(g, v));
        assertEquals(3, CountingVertices.countVertices(g, w));
        assertEquals(3, CountingVertices.countVertices(g, x));
    }

    /**
     * Tests the following graph
     * 1 - 2 - 3 - 4
     */
    @Test
    public void testFourLine() {
        Graph g = new Graph(0);
        Vertex v = new Vertex(1);
        Vertex w = new Vertex(2);
        Vertex x = new Vertex(3);
        Vertex z = new Vertex(4);
        g.addVertex(v);
        g.addVertex(w);
        g.addVertex(x);
        g.addVertex(z);
        g.addEdge(v, w);
        g.addEdge(w, x);
        g.addEdge(x, z);
        assertEquals(4, CountingVertices.countVertices(g, v));
        assertEquals(4, CountingVertices.countVertices(g, w));
        assertEquals(4, CountingVertices.countVertices(g, x));
        assertEquals(4, CountingVertices.countVertices(g, z));
    }

    /**
     * Tests the following graph:
     * 1  ---  2
     * |       |
     * |       |
     * 3 ----  4
     */
    @Test
    public void testCycle() {
        Graph g = new Graph(0);
        Vertex v = new Vertex(1);
        Vertex w = new Vertex(2);
        Vertex x = new Vertex(3);
        Vertex y = new Vertex(4);
        g.addVertex(v);
        g.addVertex(w);
        g.addVertex(x);
        g.addVertex(y);
        g.addEdge(v, w);
        g.addEdge(w, y);
        g.addEdge(x, v);
        g.addEdge(x, y);
        assertEquals(4, CountingVertices.countVertices(g, v));
        assertEquals(4, CountingVertices.countVertices(g, w));
        assertEquals(4, CountingVertices.countVertices(g, x));
        assertEquals(4, CountingVertices.countVertices(g, y));
    }

    /**
     * Tests the following graph:
     * 1  ---  2
     *         |
     *         |
     * 3       4
     */
    @Test
    public void testTree() {
        Graph g = new Graph(0);
        Vertex v = new Vertex(1);
        Vertex w = new Vertex(2);
        Vertex x = new Vertex(3);
        Vertex y = new Vertex(4);
        g.addVertex(v);
        g.addVertex(w);
        g.addVertex(x);
        g.addVertex(y);
        g.addEdge(v, w);
        g.addEdge(w, y);
        assertEquals(3, CountingVertices.countVertices(g, v));
        assertEquals(3, CountingVertices.countVertices(g, w));
        assertEquals(3, CountingVertices.countVertices(g, y));
        assertEquals(1, CountingVertices.countVertices(g, x));
    }

        /**
         * Tests the following graph
         * 0 - 1 - 2
         */
        @Test
        public void testLine() {
            Graph g = new Graph(4);
            g.addEdge(0, 1);
            g.addEdge(1, 2);
            // Path from 0 to 1 is reachable
            assertTrue(BFSPathBetween.solve(g.getVertex(0), g.getVertex(1)));
            // Path from 1 to 2 is reachable
            assertTrue(BFSPathBetween.solve(g.getVertex(1), g.getVertex(2)));
            // Path from 0 to 2 is reachable
            assertTrue(BFSPathBetween.solve(g.getVertex(0), g.getVertex(2)));
            // Path from 2 to 0 is reachable
            assertTrue(BFSPathBetween.solve(g.getVertex(2), g.getVertex(0)));
        }

        /**
         * Tests the following graph:
         * 0 - 1 - 3
         * |    \  |
         * |     \ |
         * 2  ---  4    (5)
         */
        @Test
        public void testWeighted() {
            Graph g = new Graph(6);
            g.addEdge(0, 1);
            g.addEdge(1, 3);
            g.addEdge(3, 4);
            g.addEdge(1, 4);
            g.addEdge(0, 2);
            g.addEdge(2, 4);
            // Path is 0-1-4
            assertTrue(BFSPathBetween.solve(g.getVertex(0), g.getVertex(4)));
            // Path is 0-1-4-3
//            assertTrue(BFSPathBetween.solve(g.getVertex(0), g.getVertex(3)));
//            // Path is 2-4
//            assertTrue(BFSPathBetween.solve(g.getVertex(2), g.getVertex(4)));
//            // Path is 2-4-1-0
//            assertTrue(BFSPathBetween.solve(g.getVertex(2), g.getVertex(0)));
//            // No path
//            assertFalse(BFSPathBetween.solve(g.getVertex(0), g.getVertex(5)));
//            assertFalse(BFSPathBetween.solve(g.getVertex(1), g.getVertex(5)));
//            assertFalse(BFSPathBetween.solve(g.getVertex(2), g.getVertex(5)));
//            assertFalse(BFSPathBetween.solve(g.getVertex(3), g.getVertex(5)));
//            assertFalse(BFSPathBetween.solve(g.getVertex(4), g.getVertex(5)));
        }

    }
