public class MSTPrimJarnik {


    /**
     * Prim jarnik: Minimum Spanning Tree
     * @param g the old input graph
     * @return the weighted graph as Minimum Spanning Tree (must contain all vertices)
     *  Each vertex has a collection of VertexNumPairs
     *  for all adjacent vertices: Vertex + Num (edge weight between them)
     *               Datastructures:
     *    int[ ] Distance    <--- current minimal weight of 1 edge!! (in MST) (Dijksta: current minimal sum of weights)
     *    boolean [] visited  <-- INDEX: Vertex id, VALUE: true/false
     *    Vertex[] parents    <-- You could also use a HashMap, but that essentially creates an array! Both O(1). But HashMap allows other keys than ints.
     *    Adaptable PQ <KEY: D[v], VALUE: Vertex>
     *            // Only connected part of vertex 0 is traversed!!
     */
    public static WeightedGraph primJarnik(WeightedGraph g) {

        // if g == null, return null

        // 1. Select a random vertex
        WeightedVertex start = g.getVertex(0);
        int size = g.getAllVertices().size();
        WeightedGraph result = new WeightedGraph(size);     // includes ALL vertices! But not all edges.

        // 2. Store D[v] for every vertex (start 0, other V's INTMAX)
        int[] D = new int[size];
        D[0] = 0;
        for (int i = 1; i < size; i++) {
            D[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[size];
        visited[0] = true;
        WeightedVertex[] parents = new WeightedVertex[size];                // store previous vertices (to add edges to result MST)
        AdaptablePQ pq = new AdaptablePQ();                                 // We only insert neighbours of start into PQ + their edge weight D[v]
        // ITS NOT REALLY NEEDED TO INSERT ALL VERTICES (with INT_MAX), we only need neighbours! (O(n log(n), but that is the algo anyways) (same goes for Dijkstra)
        for (VertexNumPair startneigh : start.getNeighbours()) {    // returns collection of VertexNumPairs
            // Look at all neighbours of START and update D[v]
            D[startneigh.getVertex().getId()] = startneigh.getNum();
            pq.insertOrReplace(startneigh.getVertex(), startneigh.getNum());    // K = edge weight (Num), V = Vertex (see method)
            parents[startneigh.getVertex().getId()] = start;            // Add start as first parent.
        }
        // We could also take these steps in the while loop, but you don't wanna add edge for start! (no parent) So you'd have to check if it's first.

        while(!pq.isEmpty()) {
            // Find minimum edge adjacent to that vertex <-- removeMin()
            VertexNumPair vnp = pq.removeMin();
                    System.out.println("Removed from PQ: " + vnp.getVertex() + " with edge weight D[v] = " + D[vnp.getVertex().getId()]);
            visited[vnp.getVertex().getId()] = true;

            // Add Vertex and its min edge to result graph (PARENT - CHILD)
            // you NEED TO PASS vertex id to addEdge() to NEW GRAPH!! Not Vertex object! You don't wanna pass Vertices from the OLD GRAPH!
            int newVertexId = vnp.getVertex().getId();
            int parentId = parents[newVertexId].getId();
            int edgeWeight = vnp.getNum();                                 // you could also use D[newVertexId]
            result.addEdge(newVertexId, parentId, edgeWeight);

            // Look at all neighbours and update D[v] <-- replaceKey()
            for (VertexNumPair vnp2 : vnp.getVertex().getNeighbours()) {
                int neighbourId = vnp2.getVertex().getId();
                int newWeight = vnp2.getNum();
                if (visited[neighbourId] == false) {
                    // replace Key in PQ, if this edge weight is lower than previous
                    if (newWeight < D[neighbourId]) {    // newDist < old Dist?
                        D[neighbourId] = newWeight;           // update Distance
                        pq.insertOrReplace(vnp2.getVertex(), newWeight);
                        parents[neighbourId] = vnp.getVertex();
                    }
                }
            }
        }
        return result;
    }

}
