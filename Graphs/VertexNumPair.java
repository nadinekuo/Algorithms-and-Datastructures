/**
 * Container class used to store a Vertex and an int.
 * Prim-Jarnik: current minimum weight of 1 edge
 * Dijkstra: current sum of minimum weight (of all edges to this vertex)
 */
class VertexNumPair {

    private WeightedVertex vertex;

    private int num;

    public VertexNumPair(WeightedVertex vertex, int num) {
        this.vertex = vertex;
        this.num = num;
    }

    public WeightedVertex getVertex() {
        return vertex;
    }

    public int getNum() {
        return num;
    }

}