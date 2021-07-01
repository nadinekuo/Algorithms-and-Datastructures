import java.util.*;

public class CountingVertices {

    /**
     * Counts the number of vertices IN THE SAME CONNECTED COMPONENT as v in graph g.
     * This is done using DEPTH FIRST SEARCH (see BFS version below)!
     * Returns 0 if the graph or vertex is null
     * @param g
     *     The graph to count vertices in.
     * @param v
     *     The vertex to start counting at.
     * @return the number of vertices in the same connected component. --> WE ONLY DO 1 DFS!
     * KNOWN.SIZE() <--- amount of vertices visited  in THIS component!
     */
    public static int countVertices(Graph g, Vertex v) {

        if (g == null || v == null) return 0;
//        if (!g.getAllVertices().contains(v) || g.getAllVertices().isEmpty()) return 0; <---- for some reason this doesn't pass all spec tests.. (g.getAllVertices() may cause NullPointerException?)

        Set<Vertex> known = new HashSet<>();
//        return DFSCounter(g, v, known);
        return BFSCounter(g, v, known);
    }


    /**
     * Counts the number of vertices in the same connected component as v in graph g.
     * This is done using DEPTH first search.
     */
    public static int DFSCounter(Graph g, Vertex v, Set<Vertex> known) {
        known.add(v);
        for (Vertex neighbour : g.getNeighbours(v)) {
            if (!known.contains(neighbour)) {
                System.out.println("Neighbour added: ");
                DFSCounter(g, neighbour, known);
            }
        }
        return known.size();
    }

    /**
     * Counts the number of vertices in the same connected component as v in graph g.
     * This is done using BREADTH first search.
     */
    public static int BFSCounter(Graph g, Vertex v, Set<Vertex> known) {

        LinkedList<Vertex> queue = new LinkedList<>();
        known.add(v);
        queue.add(v);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.println("Vertex dequeued: " + current);
            for (Vertex neighbour : g.getNeighbours(current)) {
                if (!known.contains(neighbour)) {
                    queue.add(neighbour);
                    known.add(neighbour);       // if you'd add to known after polling, same vertex could be added 2x! (all vertices connected)
                    System.out.println("Neighbour enqueued: " + neighbour);
                }
            }
        }
        System.out.println("Size of known: " + known.size());
        return known.size();
    }





    /**
     * @param g - The UNDIRECTED graph to search in.
     * @param v
     *     The vertex to start searching from.
     * @param n
     *     The number of edges n that can be traversed from v.
     * @return The number of vertices that are REACHABLE from v (including v), USING AT MOST N EDGES.
     * BFS --> GIVES THE PATH USING THE LEAST AMOUNT OF EDGES.
     * #vertices = known.size()
     * O(n+m)
     *         // BREADTH-FIRST SEARCH --> TRAVERSAL IN LEVELS!
     */
    static int countReachableVertices(Graph g, Vertex v, int n) {

        Set<Vertex> known = new HashSet<>();
        LinkedList<Vertex> queue = new LinkedList<>(g.getNeighbours(v));        // add all neighbours (level 1)!!! (not v itself)
        known.add(v);

        int thislevel = queue.size();              // amount of vertices in THIS level

        while (!queue.isEmpty()) {

            if (thislevel == 0) {                  // if ALL VERTICES IN THIS LEVEL visited, move to next level.
                thislevel = queue.size();          // next level was enqueued in prev loop
                n--;                                // decrement amount of edges/levels we can use still
            }
            if (n <= 0) break;

            Vertex current = queue.poll();
            thislevel--;                           // decrement no. of vertices in THIS level
            known.add(current);
//            g.getNeighbours(queue.remove()).stream().filter(x -> !known.contains(x)).forEach(queue::add);
            for (Vertex neighbour : g.getNeighbours(current)) {
                if (!known.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
        return known.size();
    }







}
