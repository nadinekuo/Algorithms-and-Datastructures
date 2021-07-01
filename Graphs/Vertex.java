import java.util.*;

class Vertex {

    private int id;

    private Set<Vertex> neighbours;

    public Vertex(int id) {
        this.id = id;
        neighbours = new HashSet<>();   // for each vertex, we hold adjacent VERTICES (not edges)
    }

    // "ADJACENCY LIST": each Vertex holds an ArrayList of neghbours/"outgoingEdges"! (but no edges here)
    // DFS/BFS: O(n+m)

    public int getId() {
        return id;
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<Vertex: " + id + ">";
    }


    public Collection<Vertex> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }


    public int compareTo(Vertex o) {
        return this.getId() - o.getId();
    }


    public int hashCode() {
        return this.getId();
    }


    @Override
    public boolean equals(Object o) {
        return o instanceof Vertex && ((Vertex) o).getId() == this.getId();
    }
}