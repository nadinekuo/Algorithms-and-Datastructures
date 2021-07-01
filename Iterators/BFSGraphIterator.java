import java.util.*;


/** GIVES PATH WITH LEAST AMOUNT OF EDGES
 * Implements a BFS traversal of the Graph starting at a certain vertex v. It
 * should return nodes at most once.
 */
class BFSGraphIterator implements Iterator<Vertex> {

    private Graph g;
    private Vertex v;
    private LinkedList<Vertex> queue;
    private Set<Integer> colored;

    public BFSGraphIterator(Graph g, Vertex v) {
        this.g = g;
        this.v = v;
        this.reset();
    }

    public void reset() {
        this.queue = new LinkedList<>();
        this.colored = new HashSet<>();
        if (v != null && g != null) {
            this.queue.add(v);
            this.colored.add(v.getId());
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Vertex next() {
        if (this.queue.isEmpty()) {
            return null;
        }
        Vertex u = queue.poll();
        for (Vertex n : g.getNeighbours(u)) {
            if (!colored.contains(n.getId())) {
                colored.add(n.getId());
                queue.add(n);
            }
        }
        return u;
    }

    @Override
    public void remove() {
        // Can be ignored
    }

}