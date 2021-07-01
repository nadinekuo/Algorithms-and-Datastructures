import java.util.*;
import java.util.Stack;


// v.getID
// g.getNeighbours(Vertex v)
// g.getAllVertices();

/** LAZY iterator
 * NON-RECURSIVE DEPTH FIRST SEARCH USING STACK.
 * Implements a Depth first traversal of the UNDIRECTED Graph, starting at constructor vertex v. It
 * should return NODES at most ONCE. If there is a choice between multiple next nodes,
 * always pick the LOWEST id node. --> so PUSH HIGHEST ID ONTO STACK FIRST.
 * only iterates over vertices CONNECTED to starting vertex! GRAPHSIZE IS NOT EQUAL TO amount of vertices to visit.
 */
class LazyDFSIteratorG implements Iterator<Vertex> {

    private Graph g;
    private Vertex v;
    private Stack<Vertex> stack;           // remember previous parent vertex: record path found
    private Set<Vertex> colored;          // maintain visited vertices
    private int graphSize;

    public LazyDFSIteratorG(Graph g, Vertex v) {
        this.g = g;
        this.v = v;
        this.reset();
    }

    public void reset() {
        this.stack = new Stack<>();
        this.colored = new TreeSet<>();                    // stores the elements in a height-balanced search tree
        if (g != null && v != null) {
            graphSize = g.getAllVertices().size();           // all vertices (incl. disconnected sub-graphs)
            this.stack.add(v);                              // starting vertex
        }
    }

    @Override
    public boolean hasNext() {
        return (!stack.isEmpty() && colored.size() != graphSize);
    }


    // If there is a choice between multiple nodes, always pick the one with the lowest id.
    // THE FIRST VERTEX HAS ALREADY BEEN ADDED TO STACK AND COLORED (constructor).
    @Override
    public Vertex next() {
        if (!hasNext()) return null;

        Vertex current = stack.pop();
        colored.add(current);

        // visit vertex neighbour with lowest id and not colored yet
        List<Vertex> neighbours = g.getNeighbours(current);
//        if (neighbours.size() == 0) return current;
        Collections.reverse(neighbours);                    // eturns vertices in order of ID! (No sorting needed...)
        for (Vertex v : neighbours) {
            if (!colored.contains(v)) {
                stack.push(v);
            }
        }
        return current;
    }

//        List<Vertex> unvisited = new ArrayList<>();
//        for (Vertex v : neighbours) {
//            if (!colored.contains(v)) {
//                unvisited.add(v);
//            }
//        }
//        if (unvisited.isEmpty()) return current;          // no neighbours to visit, this will be the last vertex.
//
//        // "Selection Sort" --> Keep on pushing vertex with HIGHEST ID on stack and remove from list.
//        while (!unvisited.isEmpty()) {
//            Vertex highest = unvisited.get(0);
//            for (Vertex v : unvisited) {
//                if (v.getId() > highest.getId()) {
//                    highest = v;
//                }
//            }
//            stack.push(highest);
//            unvisited.remove(highest);
//        }

// OR: USING QUICK SORT...
//        Vertex[] arr = new Vertex[unvisited.size()];
//        for (int i = 0; i < unvisited.size(); i++) {
//            arr[i] = unvisited.get(i);
//        }
//        sortByLowestID(arr, 0, arr.length-1);
//        List<Vertex> sorted = Arrays.asList(arr);
//        Collections.reverse(sorted);                    // reverse, so sorted by highest id.
//
//        // Push the vertex with highest ID first!!!
//        for (int i = 0; i < sorted.size(); i++) {
//            stack.push(sorted.get(i));
//                colored.add(sorted.get(i));
//        }
//        return current;
//    }


//
//    public void sortByLowestID(Vertex[] uncolored, int a, int b) {
//
//        if (a >= b) return;
//
//        // pick last as pivot and partition
//        int leftidx = a;
//        int rightidx = b-1;
//        Vertex pivot = uncolored[b];
//
//        // 2. Partition array into 2, larger/smaller than pivot
//        while (leftidx <= rightidx) {
//            while (leftidx <= rightidx && uncolored[leftidx].getId() < pivot.getId()) leftidx++;
//            // scans array from L to R, looking for el > pivot
//            while (leftidx <= rightidx && uncolored[rightidx].getId() > pivot.getId()) rightidx--;
//            // scans array from R to L, looking for el < pivot
//
//            // both have stopped moving and have not strictly crossed yet
//            if (leftidx <= rightidx) {
//                swap(uncolored, leftidx, rightidx);    // swap and shrink range
//                leftidx++;
//                rightidx--;
//            }
//        }
//        // swap pivot with left
//        swap(uncolored, leftidx, b);
//
//        // 3. Recur on 2 partitions
//        // 4. Merge small, pivot, large
//        sortByLowestID(uncolored, a, leftidx-1); // excluding pivot! (left is now index of pivot)
//        sortByLowestID(uncolored, leftidx+1, b);
//
//    }
//
//
//    public static void swap(Vertex[] elements, int i, int j) {
//        Vertex temp = elements[i];
//        elements[i] = elements[j];
//        elements[j] = temp;
//    }

    public String toString() {
        return this.stack.toString();
    }


}

    