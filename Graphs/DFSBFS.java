import java.util.*;

public class DFSBFS {


    /**
     * Depth First Search --> recursive!
     * @param g the graph to explore.
     * @param v the starting Vertex.
     *          Adjacency List/Map: O(n+m)
     *          Edge List:          O(n*m)
     *          Adjacency Matrix:   O(n^2 * m)
     */
    public static void DFS(Graph g, Vertex v) {

        Set<Vertex> known = new HashSet<>();
        known.add(v);
        for (Vertex neighbour : g.getNeighbours(v)) {
            if (!known.contains(neighbour)) {
                DFS(g, neighbour);
            }
        }
    }

    /**
     * Breadth First Search --> Queues!
     * @param g the graph to explore.
     * @param v the starting Vertex.
     *          Adjacency List/Map: O(n+m)
     *          Edge List:          O(n*m)
     *          Adjacency Matrix:   O(n^2 * m)
     */
    public static void BFS (Graph g, Vertex v) {

        Set<Vertex> known = new HashSet<>();
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.add(v);
        known.add(v);                              // holds path of visited vertices

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();      // dequeue first, current is constantly updated
            System.out.println("Dequeued vertex: " + current);
            for (Vertex neighbour : current.getNeighbours()) {
                if (!known.contains(neighbour)) {
                    queue.add(neighbour);
                    known.add(neighbour);
                }
            }
        }
    }


    /**
     * BFS --> GIVES THE PATH USING THE LEAST AMOUNT OF EDGES.
     * #vertices = known.size()
     * O(n+m)
     *         // BREADTH-FIRST SEARCH --> TRAVERSAL IN LEVELS!
     */
    public static void BFSLevels(Graph g, Vertex v) {

        Set<Vertex> known = new HashSet<>();
        LinkedList<Vertex> level = new LinkedList<>();
        level.add(v);                                // first level only contains starting vertex
        known.add(v);                              // holds path of visited vertices

        while (!level.isEmpty()) {
            LinkedList<Vertex> nextLevel = new LinkedList<>();

            Vertex current = level.poll();               // dequeue first, current is constantly updated
            System.out.println("Dequeued vertex: " + current);
            for (Vertex neighbour : g.getNeighbours(current)) {
                if (!known.contains(neighbour)) {
                    nextLevel.add(neighbour);           // add neighbours of THIS level to NEXT level
                    known.add(neighbour);
                }
            }
            level = nextLevel;
        }
    }

}
