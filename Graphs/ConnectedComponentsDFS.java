import java.util.*;

public class ConnectedComponentsDFS {

    // no. of connected components = no. of DFS searches done
    // NOTE: You cannot iterate over the elements from unexplored with a for loop,
    // i.e. for (Vertex v: unexplored) will not work, since you need to be able to remove elements from unexplored.
    // THIS CREATES AN ITERATOR, WHICH MAY BE LAZY (COPY CREATED), SO YOU CAN'T CHANGE THE ORIGINAL COLLECTION!
    // Normally you'd  call iter.remove(), but this implementation doesn't have remove().


    /**
     * Number of connected components
     * @param g the unconnected graph to count components in
     * @return the int
     * 2 ITERATORS:
     *      - 1 Iterator() over the "unexplored" collection
     *      - 1 DFS Iterator, which removes vertices from "unexplored" (method below)
     */
    public static int numberOfConnectedComponents(Graph g) {

        if (g == null || g.getAllVertices().size() == 0) return 0;
        if (g.getAllVertices().size() == 1) return 1;

        Collection<Vertex> unexplored = g.getAllVertices();
        Vertex start = unexplored.iterator().next();
     // 1st DFS at vertex start (will modify unexplored)
        DFS(g, start, unexplored);
        int num = 1;                            // 1st DFS ALREADY DONE.

        // if next is in unexplored, start new DFS so num++
        while (unexplored.iterator().hasNext()) {
            Vertex other = unexplored.iterator().next();
            num++;
            DFS(g, other, unexplored);     // unexplored will be modified again
        }
        return num;
    }

    public static void DFS (Graph g, Vertex v, Collection<Vertex> unexplored) {
        LazyDFSIteratorG DFSiterator = new LazyDFSIteratorG(g, v);          // 1 DFS search per connected component!
        while (DFSiterator.hasNext()) {
            Vertex next = DFSiterator.next();
            unexplored.remove(next);                // remove all vertices visited in THIS particular DFS. (1 connected component)
        }
    }

//    public static int numberOfConnectedComponents(Graph g) {
//        Collection<Vertex> unexplored = g.getAllVertices();
//        if (unexplored.isEmpty()) return 0;
//        int result = 0;
//        while(unexplored.size() > 0) {
//            Iterator<Vertex> iter = new GraphIterator(g, unexplored.iterator().next());
//            while (iter.hasNext()) {
//                unexplored.remove(iter.next());
//            }
//            result++;
//        }
//        return result;
//    }

//    public static void DFS(Graph g, Vertex v, Collection<Vertex> unexplored) {
//
//        Set<Vertex> known = new HashSet<>();
//        known.add(v);
//        for (Vertex neighbour : g.getNeighbours(v)) {
//            if (!known.contains(neighbour)) {
//                DFS(g, neighbour, unexplored);
//            }
//        }
//    }

}
