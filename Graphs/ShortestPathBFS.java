import java.util.*;

// vertex.getId()
// g.getAllVertices()
// g.getNeighbours()  <-- adjacent vertices ordered by ID

// Give path with LEAST AMOUNT OF EDGES (not lowest weight...)

public class ShortestPathBFS {

    /**
     * Find the shortest path between v and u in the graph g.
     * LEAST NO. OF EDGES between Vertex V and U. --> BFS!
     * @param g - graph to search in.
     * @param v - node to start from.
     * @param u - node to reach.
     * @return the nodes you that form the shortest path, INCLUDING v and u. An
     * empty list iff there is no path between v and u.
     *         // To remember node v was discovered from node w, you call predecessors.put(v, w)
     *         // To check whether node v was already discovered, you call predecessors.containsKey(v)
     *         //  To access the predecessor of node v, you call predecessors.get(v).
     */
    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {

        if (g == null || v == null || u == null) return null;

        // Maintain discovered edges (Key: vertex, Value: parent)
        Map<Vertex, Vertex> predecessors = new TreeMap<>();             // stores the keys of a map in a height-balanced search tree
        List<Vertex> path = new ArrayList<>();

        if (v == u) {       // if no edge
            path.add(v);
            return path;
        }

        // if no path between v and u, return empty list
        if (!g.getAllVertices().contains(v) || !g.getAllVertices().contains(u)) {
            return path;
        }

        // iterates over neighbour vertices in increasing order of id
        BFSGraphIterator BFSiterator = new BFSGraphIterator(g, v);

        while (BFSiterator.hasNext()) {
            Vertex next = BFSiterator.next();
            for (Vertex neighbour : g.getNeighbours(next)) {
                if (!predecessors.containsKey(neighbour)) {
                    predecessors.put(neighbour, next);        // add next as parent of neighbour to MAP
                }
            }
            if (next == u) break;         // stop BFS when Vertex u reached
        }

        // We have put ALL vertices in the Map, but the result list should only contain the path from v --> u!
        // use predecessors to add vertices to result list (get()) --> from end u to front v (so reverse)
        if (predecessors.containsKey(u)) {
            path.add(u);
            Vertex current = u;
            while (current != v) {
                current = predecessors.get(current);        // update current vertex and add to result
                path.add(current);
            }
            Collections.reverse(path);
            return path;
        } else {
            return new ArrayList<>();
        }
        // if no path, so vertex U never reached (not in map!), return empty list.
    }



}
