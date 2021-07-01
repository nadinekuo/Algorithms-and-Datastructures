import java.util.*;

public class MSTKruskal {

    //The UnionFind(int n) constructor will create a structure to hold n different disjoint sets,
    // each holding a single element labelled from 0 to n - 1.

    // The operation boolean union(int i, int j) will merge the sets containing element i and j.
    // It returns true if i and j belonged to different sets, and false if they were already part of the same set.

    // The method int find(int u) returns the ID of the set that contains element u.

    // Edge implements the Comparable interface so that you can sort them increasingly on their cost.
    // PQ<Edge> will always return edge with smallest cost :)

    /**
     * Builds a Minimum Spanning Tree (MST) using <--- lowest weight edges
     * Kruskal's Algorithm (as learned in class).
     * Nodes are numbered from 0 to n - 1.
     * @param n the amount of nodes in the graph
     * @param edges the edges that comprise the graph
     * @return the LIST OF EDGES that should be included in the MST
     * KEEP TRACK OF DIFFERENT CLUSTERS: Union-Find class (data-structure) <-- maintain disjoint sets (whether 2 vertices are connected)
     * DONT MODIFY edges LIST.
     * n = no. of vertices!!!
     */
    public static List<Edge> buildMST(int n, List<Edge> edges) {

        if (edges == null) return null;

        List<Edge> resultMST = new ArrayList<>();
        if (n == 0 || edges.isEmpty()) return resultMST;

        // Start: each vertex forms a single cluster
        // Union-Find: n disjoint sets each containing 1 element, labelled from 0 - (n-1)!!!
        UnionFind partitions = new UnionFind(n);

        // add all edges to PQ --> removeMin gives smallest weight (cost) (see compareTo())
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);        // inserts all at once

        // Repeat until 1 cluster formed of ALL VERTICES:
        while (!pq.isEmpty()) {                         // Pick edge(u,v) with smallest weight (cost) NOT part of MST yet <-- removeMin
            Edge smallest = pq.remove();
            // union() merges 2 clusters (using each vertex' ID)
            if (partitions.union(smallest.getFrom(), smallest.getTo())) {  // If clusters of u, v are different: merge
                resultMST.add(smallest);                                   // Else, don't include edge in MST.
            }
        }
        return resultMST;
    }

}
