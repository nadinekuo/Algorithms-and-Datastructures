import java.util.ArrayList;
import java.util.List;

class GraphNode {

    List<GraphNode> outgoingEdges;
    int id;

    public GraphNode(int id) {
        this.outgoingEdges = new ArrayList<>();
        this.id = id;
    }

    public List<GraphNode> getOutgoingEdges() {
        return outgoingEdges;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return Integer.toString(id);
    }

    @Override
    public int hashCode() {
        return id;
    }


}
