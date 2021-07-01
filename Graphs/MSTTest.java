import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MSTTest {


    /**
            * Helper method to make creating set easier.
   * @param elements Elements to put into the set
   * @return A new set with the given elements.
   */
    private Set<Integer> setOf(Integer... elements) {
        return Arrays.stream(elements).collect(Collectors.toSet());
    }

    @Test
    public void emptyVillage() {
        Set<Road> solution = KruskalCoatis.regroupTheCoatis(new ArrayList<>(), new HashSet<>());
        assertTrue(solution.isEmpty(), "An empty village requires no roads to be cleared of traps");
    }

    @Test
    public void disconnectedVillage() {
        List<Map<Integer, Integer>> input = new ArrayList<>();
        input.add(new HashMap<>());     // no neighbours (Keys)
        input.add(new HashMap<>());
        assertNull(KruskalCoatis.regroupTheCoatis(input, setOf(0, 1)), "A disconnected village should give no solution");
    }

    /**
     * Village: https://i.imgur.com/BdvaXpV.png
     * Expected roads used: https://i.imgur.com/RS9poLa.png
     * ALL MAPS HOLD ADJACENT VERTICES with HIGHER id. So 3 holds 4, 5 - 4 hold 5 - but 5 holds none!
     * (not overlapping adjacent edges like in the book)
     */
    @Test
    public void completeGraph() {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int x = 0; x < 6; x++) graph.add(new HashMap<>());
        graph.get(0).put(1, 1);
        graph.get(0).put(2, 1);
        graph.get(1).put(2, 2);
        graph.get(1).put(3, 3);
        graph.get(3).put(4, 2);
        graph.get(3).put(5, 1);
        graph.get(4).put(5, 1);
        Set<Road> solution = new HashSet<>();   // result MST: containing all Houses in the set passed.
        solution.add(new Road(0, 1, 1));
        solution.add(new Road(0, 2, 1));
        solution.add(new Road(1, 3, 3));
        solution.add(new Road(3, 5, 1));
        solution.add(new Road(4, 5, 1));
        assertEquals(solution, KruskalCoatis.regroupTheCoatis(graph, setOf(0, 1, 2, 3, 4, 5))); // thus all vertices may be considered
    }

    /**
     * Same village as above, but house 5 is no longer a coati house
     * MST ONLY CONTAINS HOUSES 0, 1, 2, 3, 4 here!! (5 IS FORBIDDEN)
     */
    @Test
    public void completeGraphForbidden() {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int x = 0; x < 6; x++) graph.add(new HashMap<>());
        graph.get(0).put(1, 1);
        graph.get(0).put(2, 1);
        graph.get(1).put(2, 2);
        graph.get(1).put(3, 3);
        graph.get(3).put(4, 2);
        graph.get(3).put(5, 1);
        graph.get(4).put(5, 1);
        Set<Road> solution = new HashSet<>();
        solution.add(new Road(0, 1, 1));
        solution.add(new Road(0, 2, 1));
        solution.add(new Road(1, 3, 3));
        solution.add(new Road(3, 4, 2));
        assertEquals(solution, KruskalCoatis.regroupTheCoatis(graph, setOf(0, 1, 2, 3, 4)));
    }

    /**
     * Same village as above, but:
     * MST ONLY CONTAINS HOUSES 0, 1 here!! (REST IS FORBIDDEN)
     * If Set only contains House ID 1, the MST contains NO ROADS!
     */
    @Test
    public void GraphManyForbidden() {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int x = 0; x < 6; x++) graph.add(new HashMap<>());
        graph.get(0).put(1, 1);
        graph.get(0).put(2, 1);
        graph.get(1).put(2, 2);
        graph.get(1).put(3, 3);
        graph.get(3).put(4, 2);
        graph.get(3).put(5, 1);
        graph.get(4).put(5, 1);
        Set<Road> solution = new HashSet<>();
        solution.add(new Road(0, 1, 1));
        assertEquals(solution, KruskalCoatis.regroupTheCoatis(graph, setOf(0, 1)));
        Set<Road> output = KruskalCoatis.regroupTheCoatis(graph, setOf(0));
        assertTrue(output.isEmpty());
    }

    /**
     * Same village as above, but:
     * MST ONLY CONTAINS HOUSES 0, 1, 2 here!! (REST IS FORBIDDEN)
     */
    @Test
    public void MSTTwoRandomRoads() {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int x = 0; x < 6; x++) graph.add(new HashMap<>());
        graph.get(0).put(1, 1);
        graph.get(0).put(2, 1);
        graph.get(1).put(2, 2);
        graph.get(1).put(3, 3);
        graph.get(3).put(4, 2);
        graph.get(3).put(5, 1);
        graph.get(4).put(5, 1);
        Set<Road> solution = new HashSet<>();
        solution.add(new Road(3, 5, 1));
        solution.add(new Road(5, 4, 1));
//        solution.add(new Road(4, 5, 1));      // both possible: see equals method Road!
        assertEquals(solution, KruskalCoatis.regroupTheCoatis(graph, setOf(3, 4, 5)));
    }

    /**
     * Same village as above, but:
     * MST is null, since the set contains 2 Houses/Vertices that CANNOT be connected without traversing other houses.
     * OR: only SOME houses are part of the MST, but not all in the set!
     */
    @Test
    public void TestImpossibleMST() {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int x = 0; x < 6; x++) graph.add(new HashMap<>());
        graph.get(0).put(1, 1);
        graph.get(0).put(2, 1);
        graph.get(1).put(2, 2);
        graph.get(1).put(3, 3);
        graph.get(3).put(4, 2);
        graph.get(3).put(5, 1);
        graph.get(4).put(5, 1);
        Set<Road> solution = new HashSet<>();
        solution.add(new Road(3, 5, 1));
        assertEquals(null, KruskalCoatis.regroupTheCoatis(graph, setOf(3, 0)));
        assertEquals(null, KruskalCoatis.regroupTheCoatis(graph, setOf(0, 3, 5)));
        assertEquals(null, KruskalCoatis.regroupTheCoatis(graph, setOf(2, 3)));
    }

    /**
     * Same village as above, but:
     * Only houses 1, 3, 5 are in the set!! ("in the midst of the village/graph")
     */
    @Test
    public void TestSingleLineMST() {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int x = 0; x < 6; x++) graph.add(new HashMap<>());
        graph.get(0).put(1, 1);
        graph.get(0).put(2, 1);
        graph.get(1).put(2, 2);
        graph.get(1).put(3, 3);
        graph.get(3).put(4, 2);
        graph.get(3).put(5, 1);
        graph.get(4).put(5, 1);
        Set<Road> solution = new HashSet<>();
        solution.add(new Road(1, 3, 3));
        solution.add(new Road(3, 5, 1));
        assertEquals(solution, KruskalCoatis.regroupTheCoatis(graph, setOf(1, 3, 5)));

        assertEquals(null, KruskalCoatis.regroupTheCoatis(graph, setOf(1, 5)));
        Set<Road> expected = KruskalCoatis.regroupTheCoatis(graph, new HashSet<>());
        assertTrue(expected.isEmpty());
    }



    // --------------------------------------------------------------------------------------


    /**
     * Tests if solution works for the given input.
     * Important because there might be different possible MST's for the same graph.
     *
     * @param mst_cost the real cost of a MST on that graph
     * @param edges the edges that comprise of the graph whose MST we are creating
     * @param n the amount of nodes in the graph that the MST should reach
     */
    void assertMST(int mst_cost, List<Edge> edges, int n) {
        // Run solution (& verify that input was not modified)
        List<Edge> original_edges = new ArrayList<>(edges);
        List<Edge> solution = MSTKruskal.buildMST(n, edges);
        assertEquals(original_edges, edges, "You should not modify the original input!");

        // Test if it even is a spanning tree
        UnionFind uf = new UnionFind(n);
        // Do we have n - 1 edges?
        assertEquals(n - 1, solution.size(),
                "A spanning tree would have " + (n - 1) + " edges instead of " + solution.size() + "!");
        // Are they all useful? (Do they connect different clusters?)
        for (Edge e : solution)
            assertTrue(uf.union(e.getFrom(), e.getTo()));

        // Test if it is a minimum spanning tree
        int result_cost = solution.stream().mapToInt(Edge::getCost).sum();
        assertEquals(mst_cost, result_cost);
    }

    List<Edge> buildEdges(int[] info, int m) {
        List<Edge> solution = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int start = i * 3;
            solution.add(new Edge(info[start], info[start + 1], info[start + 2]));
        }
        return solution;
    }

    @Test
    public void emptyGraphTest() {
        List<Edge> solution = MSTKruskal.buildMST(0, new ArrayList<>());
        assertTrue(solution.isEmpty(), "An empty graph should have an empty MST.");
    }

    /**
     * Makes sure they don't just add the smallest cost edge.
     * Makes sure they don't skip necessary edges (most costly edge is necessary)
     * TO - FROM - COST
     * Graph: https://i.imgur.com/BdvaXpV.png
     * MST: https://i.imgur.com/RS9poLa.png
     */
    @Test
    public void completeGraphTest() {
        int[] info = new int[] {
                0, 1, 1,
                0, 2, 1,
                1, 2, 2,
                1, 3, 3,
                3, 4, 2,
                3, 5, 1,
                4, 5, 1
        };

        List<Edge> input = buildEdges(info, 7);
        assertMST(7, input, 6);
    }


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
        System.out.println(g);
        WeightedGraph mst = new WeightedGraph(3);
        mst.addEdge(mst.getVertex(0),mst.getVertex(1),1);
        mst.addEdge(mst.getVertex(1),mst.getVertex(2),1);
        System.out.println(mst);
        assertEquals(mst, MSTPrimJarnik.primJarnik(g));
    }

    // Only connected part of vertex 0 is traversed!!
    @Test
    public void disconnectedGraph() {
        WeightedGraph g = new WeightedGraph(5);
        g.addEdge(g.getVertex(0),g.getVertex(1),1);
        g.addEdge(g.getVertex(0),g.getVertex(2),2);
        g.addEdge(g.getVertex(1),g.getVertex(2),1);
        g.addEdge(g.getVertex(3), g.getVertex(4), 7);
        System.out.println(MSTPrimJarnik.primJarnik(g));
    }

}