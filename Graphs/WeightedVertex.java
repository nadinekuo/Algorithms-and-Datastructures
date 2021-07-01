import java.util.*;

class WeightedVertex implements Comparable<WeightedVertex> {

    private int id;

    private Set<VertexNumPair> neighbours;    // for EACH neighbour, this vertex stores the neighbour Vertex + a Num (current D[v] e.g.)

    public WeightedVertex(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void addNeighbour(WeightedVertex v, int weight) {
        neighbours.add(new VertexNumPair(v, weight));
    }

    @Override
    public String toString() {
        return "<vertex: " + id + ">";
    }

    public Collection<VertexNumPair> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public int compareTo(WeightedVertex o) {
        return this.getId() - o.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof WeightedVertex && ((WeightedVertex) o).getId() == this.getId();
    }
}