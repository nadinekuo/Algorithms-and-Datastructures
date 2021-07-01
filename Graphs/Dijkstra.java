import java.sql.SQLOutput;
import java.util.*;

public class Dijkstra {


    /** DIJKSTRA  --> Adaptable PQ
     * Key: CURRENT WEIGHT D[v]
     * Value: VERTEX
     * Returns the LIST OF VERTICES (in order) along the SHORTEST PATH BETWEEN vertex a and b in graph g.
     * @param g Graph to consider.
     * @param a Vertex to start from.
     * @param b Vertex to go to.
     * @return The list of vertices along the shortest path between a and b, or null if no such path exists.
     * ID of vertex is between 0, (n-1) <-- n = no. of vertices in graph
     * g.getNeighbours() returns neighbour vertices in order of ID. (WeightedGraph)
     *       Datastructures:
     *      *  int[ ] Distance    <--- current minimal SUM OF WEIGHTS       (Prim-Jarnik: current minimum weight of 1 edge)
     *      * boolean [] visited  <-- INDEX: Vertex id, VALUE: true/false
     *      * Vertex[] parents    <-- You could also use a HashMap, but that essentially creates an array! Both O(1). But HashMap allows other keys than ints.
     *      * Adaptable PQ <KEY: D[v], VALUE: Vertex>
     * ---------  RemoveMin() gives a NEW VertexNumPair with current D[v] as Num!! -----------------------
     */
    public static List<WeightedVertex> shortestPath(WeightedGraph g, WeightedVertex a, WeightedVertex b) {

        if (g == null || !g.getAllVertices().contains(a) || !g.getAllVertices().contains(b)) return null;

        int size = g.getAllVertices().size();
        List<WeightedVertex> path = new ArrayList<>();
        if (a.equals(b)) {
            path.add(a);
            return path;
        }

        AdaptablePQ pq = new AdaptablePQ();
        Map<WeightedVertex, WeightedVertex> predecessors = new TreeMap<>();     // keep track of parent (to get path)
        int[] Dist = new int[size];                                               // keep track of current Dist[v], best distance (sum of edge weights) so far.
        boolean[] visited = new boolean[size];                                  // index: vertex ID

        for (int i = 0; i < size; i++) {                    // initialize Dist[v] = INT_MAX
            Dist[i] = Integer.MAX_VALUE;
        }
        Dist[a.getId()] = 0;                       // Dist[s] = 0

        // ACTUALLY YOU DON'T HAVE TO INSERT ALL, BUT CAN JUST INSERT NEIGHBOURS ONLY. (Int_MAX keys are not visited until they're neighbours anyways)
        for (WeightedVertex v : g.getAllVertices()) {
            pq.insertOrReplace(v, Dist[v.getId()]);             // insert all vertices in PQ (Key: Dist[u], Value: Vertex)
        }


        // Repeat until PQ is empty
        // removeMin returns VNP: Vertex: Vertex (VALUE), Num: Dist[u] (KEY) <---- CURRENT WEIGHT TO BE ADDED TO EDGE WEIGHT
        // Start: vnp a removed (Vertex a, num = 0)
        while (!pq.isEmpty()) {
            VertexNumPair currentpair = pq.removeMin();    // removeMin (least Dist[u], WHICH IS THE Num of vnp returned) --> mark visited
            WeightedVertex current = currentpair.getVertex();
                                        System.out.println("\nRemoved from PQ:   " + current + "  with Dist[v] = " + Dist[current.getId()]);
            visited[current.getId()] = true;

            // Relax all unvisited neighbours
            for (VertexNumPair neighbourpair : current.getNeighbours()) {     // Vertex: neighbour, Num: edge weight between the 2
                WeightedVertex neighbour = neighbourpair.getVertex();
                                        System.out.println("Neighbour:   " + neighbour);
                if (!visited[neighbour.getId()]) {
                    // if current Dist[u] + edge weight < Dist[v]   ----> replaceKey + update Dist[v] + add/update parent
                    // else, keep current Dist[v]
                    int newDist = currentpair.getNum() + neighbourpair.getNum();
                    if (newDist < Dist[neighbour.getId()] && newDist > 0) {             // Graph disconnected? Don't add. Check if newDist != -INT_MAX! If you start at a vertex which has D[u] = INT_MAX, it will do: INT_MAX + weight = INT_MIN!!
                                        System.out.println("Update Dist[v] nb: " + Dist[neighbour.getId()] + " --> " + newDist);
                        Dist[neighbour.getId()] = newDist;                            // update Dist[v]
                        pq.insertOrReplace(neighbour, newDist);                    // replace key Dist[v] of neighbour vertex
                        predecessors.put(neighbour, current);                 // put current as parent of neighbour (or update if it had another parent before)
                                            System.out.println("Added to/replaced in Map: parent (Value) " + current + " with child (Key) " + neighbour);
                    }
                }
            }
        }

        // use predecessors Map to (iterate backwards) add all parents to path + reverse
        if (predecessors.containsKey(b)) {      // if vertex b is added to the Map (with its parent)!
            path.add(b);
            WeightedVertex current = b;
            while (!current.equals(a)) {        // see equals method: id's are compared
                current = predecessors.get(current);
                path.add(current);
            }
            Collections.reverse(path);
                                System.out.println("Reversed result path: " + path + "\n");
            for (int i = 0; i < Dist.length; i++) {
                                System.out.println("Vertex id " + i + " has Dist[v] " + Dist[i]);
            }
        } else {      // CHECK IF b is EVER REACHED! (no path between a and b?)
                                System.out.println("Predecessors map does not contain Key " + b);
            return null;
        }
        return path;
    }

    /** D[] STORES THE SHORTEST PATH TO STARTING VERTEX. --> return D[b]
     * Returns the LENGTH of the shortest path between vertex a and b in graph g.
     * @param g Graph to consider.
     * @param a Vertex to start from.
     * @param b Vertex to go to.
     * @return The length of the shortest path between a and b, or -1 IF NO SUCH PATH EXISTS!
     */
    public static int shortestPathLength(WeightedGraph g, WeightedVertex a, WeightedVertex b) {

        if (g == null || !g.getAllVertices().contains(a) || !g.getAllVertices().contains(b)) return -1;
        if (a.equals(b)) return 0;

        int size = g.getAllVertices().size();

        AdaptablePQ pq = new AdaptablePQ();
        Map<WeightedVertex, WeightedVertex> predecessors = new TreeMap<>();     // keep track of parent (to get path)
        int[] Dist = new int[size];                                               // keep track of current Dist[v], best distance (sum of edge weights) so far.
        boolean[] visited = new boolean[size];                                  // index: vertex ID

        for (int i = 0; i < size; i++) {                    // initialize Dist[v] = INT_MAX
            Dist[i] = Integer.MAX_VALUE;
        }
        Dist[a.getId()] = 0;                       // Dist[s] = 0

        // ACTUALLY YOU DON'T HAVE TO INSERT ALL, BUT CAN JUST INSERT NEIGHBOURS ONLY. (Int_MAX keys are not visited until they're neighbours anyways)
        for (WeightedVertex v : g.getAllVertices()) {
            pq.insertOrReplace(v, Dist[v.getId()]);             // insert all vertices in PQ (Key: Dist[u], Value: Vertex)
        }


        // Repeat until PQ is empty
        // removeMin returns VNP: Vertex: Vertex (VALUE), Num: Dist[u] (KEY) <---- CURRENT WEIGHT TO BE ADDED TO EDGE WEIGHT
        // Start: vnp a removed (Vertex a, num = 0)
        while (!pq.isEmpty()) {
            VertexNumPair currentpair = pq.removeMin();    // removeMin (least Dist[u], WHICH IS THE Num of vnp returned) --> mark visited
            WeightedVertex current = currentpair.getVertex();
            System.out.println("\nRemoved from PQ:   " + current + "  with Dist[v] = " + Dist[current.getId()]);
            visited[current.getId()] = true;

            // Relax all unvisited neighbours
            for (VertexNumPair neighbourpair : current.getNeighbours()) {     // Vertex: neighbour, Num: edge weight between the 2
                WeightedVertex neighbour = neighbourpair.getVertex();
                System.out.println("Neighbour:   " + neighbour);
                if (!visited[neighbour.getId()]) {
                    // if current Dist[u] + edge weight < Dist[v]   ----> replaceKey + update Dist[v] + add/update parent
                    // else, keep current Dist[v]
                    int newDist = currentpair.getNum() + neighbourpair.getNum();
                    if (newDist < Dist[neighbour.getId()] && newDist > 0) {             // Graph disconnected? Don't add. Check if newDist != -INT_MAX! If you start at a vertex which has D[u] = INT_MAX, it will do: INT_MAX + weight = INT_MIN!!
                        System.out.println("Update Dist[v] nb: " + Dist[neighbour.getId()] + " --> " + newDist);
                        Dist[neighbour.getId()] = newDist;                            // update Dist[v]
                        pq.insertOrReplace(neighbour, newDist);                    // replace key Dist[v] of neighbour vertex
                        predecessors.put(neighbour, current);                 // put current as parent of neighbour (or update if it had another parent before)
                        System.out.println("Added to/replaced in Map: parent (Value) " + current + " with child (Key) " + neighbour);
                    }
                }
            }
        }

        // use predecessors Map to (iterate backwards) add all parents to path + reverse
        if (predecessors.containsKey(b)) {      // if vertex b is added to the Map (with its parent)!
            int pathlength = Dist[b.getId()];     // Dist[] stores shortest path to parent
            System.out.println("\nShortest path from " + b + " to " + a + " = " + pathlength);
            return pathlength;
        } else {      // CHECK IF b is EVER REACHED! (no path between a and b?)
            System.out.println("Predecessors map does not contain Key " + b);
            return -1;
        }
    }


    }





    // ----------------------- VERSION WITHOUT SYSTEM.OUT PRINTS -------------------------------------------//



//    public static List<WeightedVertex> shortestPath(WeightedGraph g, WeightedVertex a, WeightedVertex b) {
//
//        if (g == null || !g.getAllVertices().contains(a) || !g.getAllVertices().contains(b)) return null;
//
//        int size = g.getAllVertices().size();
//        List<WeightedVertex> path = new ArrayList<>();
//        if (a.equals(b)) {
//            path.add(a);
//            return path;
//        }
//
//        AdaptablePQ pq = new AdaptablePQ();
//        Map<WeightedVertex, WeightedVertex> predecessors = new TreeMap<>();     // keep track of parent (to get path)
//        int[] Dist = new int[size];                                               // keep track of current Dist[v], best distance (sum of edge weights) so far.
//        boolean[] visited = new boolean[size];                                  // index: vertex ID
//
//        for (int i = 0; i < size; i++) {                    // initialize Dist[v] = INT_MAX
//            Dist[i] = Integer.MAX_VALUE;
//        }
//        Dist[a.getId()] = 0;                       // Dist[s] = 0
//
//        for (WeightedVertex v : g.getAllVertices()) {
//            pq.insertOrReplace(v, Dist[v.getId()]);             // insert all vertices in PQ (Key: Dist[u], Value: Vertex)
//        }
//
//
//        // Repeat until PQ is empty
//        // removeMin returns VNP: Vertex: Vertex (VALUE), Num: Dist[u] (KEY) <---- CURRENT WEIGHT TO BE ADDED TO EDGE WEIGHT
//        // Start: vnp a removed (Vertex a, num = 0)
//        while (!pq.isEmpty()) {
//            VertexNumPair currentpair = pq.removeMin();    // removeMin (least Dist[u], WHICH IS THE Num of vnp returned) --> mark visited
//            WeightedVertex current = currentpair.getVertex();
//            visited[current.getId()] = true;
//
//            // Relax all unvisited neighbours
//            for (VertexNumPair neighbourpair : current.getNeighbours()) {     // Vertex: neighbour, Num: edge weight between the 2
//                WeightedVertex neighbour = neighbourpair.getVertex();
//                if (!visited[neighbour.getId()]) {
//                    // if current Dist[u] + edge weight < Dist[v]   ----> replaceKey + update Dist[v] + add/update parent
//                    // else, keep current Dist[v]
//                    int newDist = currentpair.getNum() + neighbourpair.getNum();
//                    if (newDist < Dist[neighbour.getId()] && newDist > 0) {             // Graph disconnected? Don't add. Check if newDist != -INT_MAX! If you start at a vertex which has D[u] = INT_MAX, it will do: INT_MAX + weight = INT_MIN!!
//                        Dist[neighbour.getId()] = newDist;                            // update Dist[v]
//                        pq.insertOrReplace(neighbour, newDist);                    // replace key Dist[v] of neighbour vertex
//                        predecessors.put(neighbour, current);                 // put current as parent of neighbour (or update if it had another parent before)
//                    }
//                }
//            }
//        }
//
//        // use predecessors Map to add all parents to path + reverse
//        if (predecessors.containsKey(b)) {      // if vertex b is added to the Map (with its parent)!
//            path.add(b);
//            WeightedVertex current = b;
//            while (!current.equals(a)) {        // see equals method: id's are compared
//                current = predecessors.get(current);
//                path.add(current);
//            }
//            Collections.reverse(path);
//        } else {      // CHECK IF b is EVER REACHED! (no path between a and b?)
//            return null;
//        }
//        return path;
//    }





