import java.util.*;

class Graph {

    // "ADJACENCY LIST": each Vertex holds an ArrayList of neighbours/"outgoingEdges"! (but no edges here)
    // DFS/BFS: O(n+m)

    private Map<Integer, Vertex> vertices = new HashMap<>();    // each id maps to a vertex in graph

    /**
     * Creates a new graph with n vertices.
     * @param n Amount of vertices in the graph.
     */
    public Graph(int n) {
        for (int i = 0; i < n; i++) vertices.put(i, new Vertex(i));
    }



    /**
     * Returns the vertex with the given ID.
     * @param id The ID for the vertex to get.
     * @return The vertex with the given ID.
     * @throws IllegalArgumentException if no vertex with the given ID is in the graph.
     */
    public Vertex getVertex(int id) throws IllegalArgumentException {
        if (!vertices.containsKey(id))
            throw new IllegalArgumentException("Vertex not in graph");
        return vertices.get(id);
    }


    public Collection<Vertex> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    /**
     * Adds an edge between vertex u and v with the given weight.
     *
     * @param u First vertex.
     * @param v Second vertex.
     *          //     * @param weight Weight of the edge between a and b.
     */
    public void addEdge(Vertex u, Vertex v) {
        u.addNeighbour(v);
        v.addNeighbour(u);
    }

    /**
     * Adds an edge between the vertices with IDs u and v with the given weight.
     *
     * @param u ID of the first vertex.
     * @param v ID of the second vertex.
     *          //     * @param weight Weight of the edge between a and b.
     * @throws IllegalArgumentException if no vertex with the given ID is in the graph.
     */
    public void addEdge(int u, int v) throws IllegalArgumentException {
        addEdge(getVertex(u), getVertex(v));
    }

    /**
     *
     * @param v - Vertex to get neighbours of
     * @return all neighbour vertices of V (all opposite vertices)
     * (GraphImpl and WeightedGraph use collections.sort to order by ID)
     */
    public List<Vertex> getNeighbours(Vertex v) {
        return new ArrayList<>(v.getNeighbours());
    }

    // ----------------------------------- ADDED METHODS ------------------------------ //

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v : getAllVertices()) {
            sb.append("Vertex " + v.getId() + " ");
        }
        return sb.toString();
    }

    // existing keys in HashMap will be overwritten
    public void addVertex(Vertex v) {
        int id = v.getId();
        vertices.put(id, v);
    }

}